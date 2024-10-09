package com.mycompany.projectmahoa.model.playfair;

public class Playfair {
    private char[][] table;// mảng 2 chiều 
    public String preprocess(String a) // tao chuỗi a
    {
        StringBuilder Kq = new StringBuilder(); // tạo StringBD kq
        for (char c : a.toCharArray())  // duyệt từng ký tự của a và lưu vào c ( chuyển chuỗi thanhf mảng )
        {
            if (c >= 'a' && c <= 'z') 
            {
                Kq.append(c);// thỏa điều kiện thì thêm vào kq , kq là một chuối của builder
            }
        }
        String processed = Kq.toString().replace("j", "i");// thay the j = i
        // tạo chuối processed , gáng kq vào pro; 
        Kq.setLength(0); // khởi tạo lại builder
        for (int i = 0; i < processed.length(); i += 2) // xử lý cuối process theo từng cặp 
        {
            if (i + 1 == processed.length()) //nếu ký tự lẽ thì cộng x 
            {
                Kq.append(processed.charAt(i)).append('x');
            } 
            else if (processed.charAt(i) == processed.charAt(i + 1)) // kiểm tra 2 cặp ký tự có giống nhau không thì thêm x ở giữa
            {
                Kq.append(processed.charAt(i)).append('x');
                i--;// giảm 1 để không bỏ sót ký tự 
            } 
            else 
            {
                Kq.append(processed.charAt(i)).append(processed.charAt(i + 1));
            }
        }
        return Kq.toString();
    }

    public String mh (String vb, String key) 
    {
        String vbgm = preprocess(vb);
        StringBuilder mhd = new StringBuilder();
        for (int i = 0; i < vbgm.length(); i += 2) // chạy vòng lập 
        {
            char first = vbgm.charAt(i);//khởi tạo first gáng và kiểm tra từng ký tự của mã vừa nhập 
            char second =(i + 1 < vbgm.length()) ? vbgm.charAt(i + 1) : 'x'; // Thêm 'x' nếu thiếu ký tự// ký tự theo sau 
            int[] firstPos = getPosition(first);// lấy vị trí đâu tiên 
            int[] secondPos = getPosition(second);// thứ 2
                // *quy ước x[0][3]
                //fp(0)=0;hàng
                //fp(1)=3;cột
            if (firstPos[0] == secondPos[0]) // kiểm tra có cùng hàng không 
            {
                mhd.append(table[firstPos[0]][(firstPos[1] + 1) % 5]);
                mhd.append(table[secondPos[0]][(secondPos[1] + 1) % 5]);
                // nếu có thêm ký tự bên phải vào mhd, và hàng cuối cùng nhờ %5 sẽ quay lại 1 vì 5%5=1 dư 0;
            } 
            else if (firstPos[1] == secondPos[1]) // kiểm tra xem có cùng cột không 
            {
                mhd.append(table[(firstPos[0] + 1) % 5][firstPos[1]]);
                mhd.append(table[(secondPos[0] + 1) % 5][secondPos[1]]);
            }
            else 
            {
                mhd.append(table[firstPos[0]][secondPos[1]]);mhd.append(table[secondPos[0]][firstPos[1]]);
            }
        }
        return mhd.toString();
    }
    private int[] getPosition(char c) { // Lấy vị trí của ký tự trong bảng
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (table[i][j] == c) {
                    return new int[]{i, j}; // Trả về hàng và cột
                }
            }
        }
        return null; // Nếu không tìm thấy ký tự
    }
    public String giaiMa(String vb, String key) {
        // Tiền xử lý chuỗi đầu vào
        String vbgm = preprocess(vb);
        StringBuilder ghd = new StringBuilder(); // Chuỗi kết quả giải mã
    
        // Duyệt qua từng cặp ký tự
        for (int i = 0; i < vbgm.length(); i += 2) {
            char first = vbgm.charAt(i); // Ký tự đầu tiên
            char second = (i + 1 < vbgm.length()) ? vbgm.charAt(i + 1) : 'x'; // Ký tự thứ hai hoặc 'x' nếu thiếu
    
            int[] firstPos = getPosition(first); // Lấy vị trí của ký tự đầu
            int[] secondPos = getPosition(second); // Lấy vị trí của ký tự thứ hai
    
            // Kiểm tra nếu cùng hàng
            if (firstPos[0] == secondPos[0]) {
                ghd.append(table[firstPos[0]][(firstPos[1] - 1 + 5) % 5]); // Ký tự bên trái
                ghd.append(table[secondPos[0]][(secondPos[1] - 1 + 5) % 5]); // Ký tự bên trái
            } 
            // Kiểm tra nếu cùng cột
            else if (firstPos[1] == secondPos[1]) {
                ghd.append(table[(firstPos[0] - 1 + 5) % 5][firstPos[1]]); // Ký tự bên trên
                ghd.append(table[(secondPos[0] - 1 + 5) % 5][secondPos[1]]); // Ký tự bên trên
            } 
            // Ký tự ở vị trí khác nhau
            else {
                ghd.append(table[firstPos[0]][secondPos[1]]); // Lấy ký tự theo hàng của ký tự thứ hai
                ghd.append(table[secondPos[0]][firstPos[1]]); // Lấy ký tự theo hàng của ký tự đầu
            }
        }
        return ghd.toString(); // Trả về chuỗi giải mã
    }
}

