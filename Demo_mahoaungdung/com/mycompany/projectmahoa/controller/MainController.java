/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmahoa.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mycompany.projectmahoa.model.MainModel;
import com.mycompany.projectmahoa.view.MainWindow;

import phuongthucdichuyen.Move;


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
        MainModel model = new MainModel();
        //sử dụng menthod getActionCommand để
        //lấy được tên của nút vừa được nhấn 
        String src = e.getActionCommand();
        if (src.equals("Playfair"))
            window.handleBtnSidebar(src.toUpperCase(),true);
        else if (src.equals("Ceasar")) 
            window.handleBtnSidebar(src.toUpperCase(),false);
        else if (src.equals("Vegenre")) 
            window.handleBtnSidebar(src.toUpperCase(),true);
        else if (src.equals("Bảng chữ đơn")) 
            window.handleBtnSidebar(src.toUpperCase(),true);
        else if (src.equals("Chuyển dịch dòng")) 
            window.handleBtnSidebar(src.toUpperCase(),true);
        //mã hoá
        if(src.equals("Enctyption")){
            // check
            Move move = window.handleEnctytion();
            String cipherText = new String();
            if(move.cipher.equals( "VEGENRE")){
                cipherText = model.EncryptionVinegere(move.document, move.key);
                window.DisplayResuil(cipherText);
            }else if(move.cipher.equals( "CHUYỂN DỊCH DÒNG")){
                cipherText = model.EncryptionTransposition(move.document, move.key);
                window.DisplayResuil(cipherText);
            }else if(move.cipher.equals( "CEASAR")){
                cipherText = model.EncryptionCeaser(move.document, Integer.parseInt(move.key));
                window.DisplayResuil(cipherText);
            }
            else if(move.cipher.equals( "BẢNG CHỮ ĐƠN")){
                cipherText = model.EncryptionChuDon(move.document, move.key);
                window.DisplayResuil(cipherText);
            }else if(move.cipher.equals( "PLAYFAIR")){
                cipherText = model.EncryptionPlayfair(move.document, move.key);
                window.DisplayResuil(cipherText);
            }
        }else if(src.equals("Dectyption"))
        {
            Move move = window.handleEnctytion();
            String plantText = new String();
            if(move.cipher.equals( "VEGENRE")){
                plantText = model.DecryptionVinegere(move.document, move.key);
                window.DisplayResuil(plantText);
            }else if(move.cipher.equals( "CHUYỂN DỊCH DÒNG")){
                plantText = model.DecryptionTransposition(move.document, move.key);
                window.DisplayResuil(plantText);
            }else if(move.cipher.equals( "CEASAR")){
                int key =Integer.parseInt(move.key);
                plantText = model.DecryptionCeaser(move.document,key);
                window.DisplayResuil(plantText);
            }else if(move.cipher.equals( "BẢNG CHỮ ĐƠN")){
                plantText = model.DecryptionChuDon(move.document, move.key);
                window.DisplayResuil(plantText);
            }else if(move.cipher.equals( "PLAYFAIR")){
                plantText = model.DecryptionPlayfair(move.document, move.key);
                window.DisplayResuil(plantText);
            }
        }
    }
    
}
