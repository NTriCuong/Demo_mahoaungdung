package com.mycompany.projectmahoa.model.venegere;

public class Vinegere {
    // mã hoá
    public String encryption (String document, String key) {
        document=document.toUpperCase();
        key=key.toUpperCase();
        //string buider la class xử lý chuỗi trong java không giống như string là bất biến 
        //string buider có thể thay đổi nội dung của chuỗi mà k cần tạo 1 biến mới
        StringBuilder cipherText = new StringBuilder();
        // thuật toán mã hoá
        for(int i=0,j=0;i<document.length();i++){//j là chỉ số index của các kí tự trong key
            // character là biến tam để lưu kí tự đang tính toán của document
            char character = document.charAt(i);
            //chỉ mã hoá kí chữ cái còn lại giữ nguyên
            if(character >= 'A' && character <= 'Z'){
                //resuil cần phải ép kiểu vì khi thực hiện các phép tính sẻ trả về 1 số kiểu int
                char resuil = (char)((character -'A' + key.charAt(j)-'A')%26 + 'A');
                //dùng menthod append để thêm kí tự vừa đc mã hoá vào chuỗi kết quả
                cipherText.append(resuil);
                //đặt điều kiện để lặp lại key nếu số lượng kí tự trong key < số lượng kí tự trong 
                // phép chia lấy phần dư số bị chia bé hơn số chia thì phần dư là chính nó
                j= (j+1)%key.length();
            }
            else
                cipherText.append(character);    
        }
        return cipherText.toString();
    }
    // giải mã
    public String Decryption (String cipherText, String key) {
        cipherText=cipherText.toUpperCase();
        key=key.toUpperCase();
        StringBuilder plantText = new StringBuilder();
        // thuật toán giải mã
        for(int i=0,j=0;i<cipherText.length();i++){
            char character = cipherText.charAt(i);
            if(character >= 'A' && character <= 'Z'){
                // cộng thêm 26 để đảm bảo không bị âm vd 
                // vd phép toán ra -5 thì mod26 -5 chính là 21
                // -5+26=21 % 26 = 21 
                char resuil = (char)((character -'A' - key.charAt(j)-'A'+26 )%26 + 'A');
                plantText.append(resuil);
                j= (j+1)%key.length();
            }
            else
                plantText.append(character);
        }
        return plantText.toString();
    }
}
