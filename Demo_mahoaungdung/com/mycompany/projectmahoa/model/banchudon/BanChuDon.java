package com.mycompany.projectmahoa.model.banchudon;

import java.util.HashMap;
public class BanChuDon
{
    // khởi tạo lưu trữ bảng mã hóa
    public static HashMap<Character, Character> BangMaHoa = new HashMap<>();
    public static  HashMap<Character, Character> BangGiaiMa = new HashMap<>();
    //Phương thức kiểm tra tính hợp lệ của khóa
    public static void TaoKhoa(String khoa)
    {
        for (int i = 0; i < 26; i++) 
        {
            char KTgoc = (char) ('a' + i);// cộng thứ tự i vào a=61 ;
            char KyTuKhoa = khoa.charAt(i);
            BanChuDon.BangMaHoa.put(KTgoc, KyTuKhoa);
            BanChuDon.BangGiaiMa.put(KyTuKhoa,KTgoc);
        }
    }
    public static boolean ktra(String khoa) 
    {
        if (khoa.length() != 26) 
        {
            return false; // đừng nhập quá 26 chữ  
        }
        // kiểm tra hợp lệ của khóa nè !
        boolean[] Cp = new boolean[26];
        for (char c : khoa.toCharArray())
        // từng vòng lập chuỗi khóa sẽ chuyển sang mảng ký tự 
         {
            if (c < 'a' || c > 'z')
            {
                return false; //  chỉ từ a tới z thôi 
            }
            if (Cp[c - 'a']) //( cp[c-'a'] xác định vị trí trong mảng)
            {
                return false; // Ký tự trùng lặp
            }
            Cp[c - 'a'] = true; // Đánh dấu ký tự đã có
        }
        return true;
    }
    // Phương thức mã hóa
    public static String MaHoa(String x, String key) {
        if (!ktra(key)) 
        {
            throw new IllegalArgumentException("Khóa không hợp lệ");
        }
        TaoKhoa(key); // Tạo bảng mã hóa từ khóa
        StringBuilder Kq = new StringBuilder(); // Chuỗi kết quả mã hóa
        for (char c : x.toCharArray()) { // Duyệt qua từng ký tự
            char lowerChar = Character.toLowerCase(c); // Chuyển ký tự thành chữ thường
            if (BangMaHoa.containsKey(lowerChar)) {
                char dinhdang = BangMaHoa.get(lowerChar); // Mã hóa ký tự
                Kq.append(Character.isUpperCase(c) ? Character.toUpperCase(dinhdang) : dinhdang); // Giữ nguyên kiểu chữ
            } else {
                Kq.append(c); // Giữ nguyên ký tự không phải chữ cái
            }
        }
        return Kq.toString(); // Trả về chuỗi đã mã hóa
    }

    public static String GiaiMa(String x, String key) {
        StringBuilder Kq = new StringBuilder();
        for (char c : x.toCharArray()) {
            char lowerChar = Character.toLowerCase(c);
            if (BanChuDon.BangGiaiMa.containsKey(lowerChar)) {
                char KTTW = BanChuDon.BangGiaiMa.get(lowerChar);
                Kq.append(Character.isUpperCase(c) ? Character.toUpperCase(KTTW) : KTTW);
            } else {
                Kq.append(c); // Giữ nguyên ký tự không phải chữ cái
            }
        }
        return Kq.toString();
    }
}