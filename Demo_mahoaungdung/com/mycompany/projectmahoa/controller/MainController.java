/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmahoa.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.projectmahoa.view.MainWindow;


// cách khởi kế thừa và khởi tạo hàm ActionListener trong java
public class MainController implements ActionListener {
    public MainWindow window;
    //contructor
    public MainController( MainWindow mainWindow){
        this.window = mainWindow;
    }
    //action perfom nhận vào 1 event
    @Override
    public void actionPerformed(ActionEvent e) { 
        //sử dụng menthod getActionCommand để
        //lấy được tên của nút vừa được nhấn 
        String src = e.getActionCommand();
        if (src.equals("Playfair")){
            window.handlePlayfair(src.toUpperCase(),true);
        }else if (src.equals("Ceaser")) {
            window.handlePlayfair(src.toUpperCase(),false);
        }else if (src.equals("Vegenre")) {
            window.handlePlayfair(src.toUpperCase(),true);
        }else if (src.equals("Bảng chữ đơn")) {
            window.handlePlayfair(src.toUpperCase(),true);
        }else if (src.equals("Chuyển dịch dòng")) {
            window.handlePlayfair(src.toUpperCase(),true);
        }

    }
    
}
