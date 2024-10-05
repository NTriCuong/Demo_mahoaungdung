/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmahoa.controller;

import com.mycompany.projectmahoa.view.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nguyentricuong
 */
// cách khởi kế thừa và khởi tạo hàm ActionListener trong java
public class MainController implements ActionListener {
    private final MainWindow window;//cửa sổ JFrame
    //contructor
    //nhận vào 1 parameters là 1 cửa sổ JFrame chịu sự quản lí của ActionListener
    public MainController(MainWindow window){//
        this.window = window;
    }
    //action perfom nhận vào 1 event
    @Override
    public void actionPerformed(ActionEvent e) { 
        //sử dụng menthod getActionCommand để
        //lấy được tên của nút vừa được nhấn 
        String src = e.getActionCommand();
        System.out.print("::::::::::"+src);
        
    }
    
}
