package com.mycompany.projectmahoa.model.chuyendichdong;



public class TranspositionCipher {
    
    // sử dụng danh sách liên kết 
    // mã hoá
    private int indexMin(int[] arr){// ham trả về vị trí index của phần tử nhỏ nhất nhỏ nhất
        int min = arr[0];
        int index=0;
        for(int i=1;i<arr.length;i++)
            if(arr[i]<min)
                {
                    min=arr[i];
                    index=i;
                }
        return index;
    }
    private itemArr[] BubbleSort(char[] arr){
        itemArr[] resuil = new itemArr[arr.length];
        for(int i=0;i<resuil.length;i++){
            resuil[i] = new itemArr(arr[i]);//khoi tao với giá trị data là arr[i]
            resuil[i].index=i;
        }
        // resuil đang lưu giá trị và vị trí của từng kí tự trong chuỗi key
        for(int i=0;i<resuil.length-1;i++){
            boolean swapped = false;// check xem có phần tử nào đc hoán đổi vị trí không
            for(int j=0;j<resuil.length-i-1;j++){
                //hoanvi
                if((int)resuil[j].data>(int)resuil[j+1].data){
                itemArr temp = resuil[j];
                resuil[j] = resuil[j+1];
                resuil[j+1] = temp;
                swapped=true;
            }
            }
            if(!swapped)
                break;
        }
        //resuil đã được xắp xếp

        return resuil;
    }
    // mã hoá
    public String encryption (String document, String key) {
        if(document == null || document.isEmpty())
            return "";
        StringBuilder plantText = new StringBuilder(document);
        
        //thuật toán mã hoá
        // nếu plant text không chia hết cho key thì số dòng của mảng 2 chiều sẻ là plant text / key + 1
        char[][] arrCipher= new char[plantText.length()%key.length()==0?(plantText.length()/key.length()):(plantText.length()/key.length()+1)][key.length()];
        int index=0;
        // cú pháp duyệt qua mảng 2 chiều 
        for(int i=0;i<arrCipher.length;i++)
            for(int j=0;j<arrCipher[i].length;j++){
                if(index<plantText.length())
                    arrCipher[i][j]=plantText.charAt(index++);
                else
                    arrCipher[i][j]='_';// các kí tự cuối cùng sẻ là "_"
            }
        // xử lý key
        int[] keyConvert =new int[key.length()];//convert lai key từ kí tự thành mã ascii
        for(int i=0;i<keyConvert.length;i++){
            keyConvert[i]=(int)key.charAt(i);
        }
        //xử lý vị trí duyệt
        int[] order = new int[keyConvert.length];//lưu thứ tự duyệt
        int indexOrder =0;
        int indexKeyConver=0;
        while (indexKeyConver<keyConvert.length) {// đảm bảo mảng còn phần tử
            order[indexOrder] = this.indexMin(keyConvert);          
            keyConvert[order[indexOrder++]]=256;// giá trị tối đa của bảng mã ascii là 255 
            // nên các kí tự trong key đều sẻ không lớn hơn 256
            indexKeyConver++;
        }
        // lúc này đang có đủ các điều kiện để mã hoá
        // arr order : lưu thứ tự đọc để mã hoá
        // mangr 2  chieu arrCipher: là lưới mã hoá
        StringBuilder cipherText = new StringBuilder();
        int row;
        for(int i=0;i<order.length;i++){
            row=order[i];
            for(int j=0;j<arrCipher.length;j++)
                cipherText.append(arrCipher[j][row]);
        }
        return cipherText.toString();
    }
    //giải mã
    public String Decryption(String cipherText, String key){
        if(cipherText == null || cipherText.isEmpty())
            return "";
        char[][] arrCipher= new char[cipherText.length()/key.length()][key.length()];
        int index=0;
        for(int col=0;col<arrCipher.length;col++)
            for(int row=0;row<arrCipher[col].length;row++){
                arrCipher[row][col] = cipherText.charAt(index++);
            }
        // convert key
        // biến tất cả key về thành chữ in để đảm bảo cho vc so sánh ra kết quả chính xác
        key=key.toUpperCase();
        char[] keyConvert =new char[key.length()];//convert lai key từ kí tự thành mã ascii
        for(int i=0;i<keyConvert.length;i++){
            keyConvert[i]=key.charAt(i);
        }
        //xử lý vị trí duyệt

        itemArr[] order = new itemArr[key.length()];//lưu thứ tự duyệt
        order=this.BubbleSort(keyConvert);

        // xử lý đưa về plant text
        char[][] arrPlantText = new char[arrCipher.length][arrCipher[0].length];
        for(int i=0;i<order.length;i++)
        {
            int col = order[i].index;
            for(int row=0;row<arrPlantText[i].length;row++){
                arrPlantText[row][col]=arrCipher[row][i];
            }
        }
        StringBuilder document = new StringBuilder();
        for(int i=0;i<arrPlantText.length;i++)
            for(int j=0;j<arrPlantText[i].length;j++)
                document.append(arrPlantText[i][j]);
        return document.toString();
    }
}
