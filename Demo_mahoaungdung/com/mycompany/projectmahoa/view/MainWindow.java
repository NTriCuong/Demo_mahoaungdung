
package com.mycompany.projectmahoa.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Insets;

import com.mycompany.projectmahoa.controller.MainController;

import phuongthucdichuyen.Move;

public class MainWindow extends JFrame {
    private final Font font=new Font("Arial", Font.PLAIN, 14);
    private final  JLabel lb_header=new JLabel("CEASAR");
    //panel
    private final JPanel header = new JPanel();
    private final JPanel container=new JPanel();
    private final JPanel sidebar=new JPanel();
    private final JPanel content=new JPanel();
    private final JPanel mainboxleft=new JPanel();
    private final JPanel boxtop = new JPanel();
    private final JPanel boxbuttom =new JPanel();
    private final JPanel boxbottom_labelandkey =new JPanel();
    private final JPanel boxtop_labelandkey =new JPanel();

    //JTextField
    //key
    private final JTextField textboxtop = new JTextField(3);
    // private final JTextField textboxbottom = new JTextField(3);
    // actionlistener
    private final MainController action = new MainController(this);
    // JTextarea planttext & ciphertext
    private final JTextArea areaPlantText =new JTextArea(5,20);
    private final JTextArea areaCiphertext = new JTextArea(5,20);
    



    public MainWindow(){
        super();
        this.lb_header.setFont(new Font("Arial",Font.BOLD, 25));
        this.setTitle("Demo Mã Hoá");
        this.setFont(font);
        this.setLayout(new BorderLayout());//flow layout xuat hien tuan tu
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);// cữa sổ xuất hiện ở giữa
        this.ComponentHeader();
        this.ComponentContainer();
    }
    //header
    private void ComponentHeader(){
        this.header.add(lb_header);
        this.add(this.header,BorderLayout.NORTH);
    }
    //container
    private void ComponentContainer(){
        //set layout cho panel container
        this.container.setLayout(new BorderLayout(10,10));
        this.container.add(new JPanel(),BorderLayout.SOUTH);
        
        //sidebar
        this.ComponentSidebar();
        //thêm sidebar vào panel container và điều chỉnh vị trí cua nó ở phía tây(bên trái)
        this.container.add(this.sidebar,BorderLayout.WEST);
        
        //content
        this.ComponentContent();
        this.container.add(this.content,BorderLayout.CENTER);
        
        // left
        this.ComponentBoxLeft();
        this.add(mainboxleft,BorderLayout.EAST);

        // them container vao frame
        this.add(this.container);
    }
    // sidebar
    private void ComponentSidebar(){
         //btn
        JButton btn_Ceaser = new JButton("Ceasar");
        JButton btn_Vegenere = new JButton("Vegenre");
        JButton btn_Bcd = new JButton("Bảng chữ đơn");
        JButton btn_PlayFair = new JButton("Playfair");
        JButton btn_Cdd = new JButton("Chuyển dịch dòng");
        //action
        btn_Ceaser.addActionListener(action);
        btn_Vegenere.addActionListener(action);
        btn_Bcd.addActionListener(action);
        btn_PlayFair.addActionListener(action);
        btn_Cdd.addActionListener(action);
        
        this.sidebar.setLayout(new GridLayout(5,1,10,10));
        this.sidebar.add(btn_Ceaser);
        this.sidebar.add(btn_PlayFair);
        this.sidebar.add(btn_Vegenere);
        this.sidebar.add(btn_Bcd);
        this.sidebar.add(btn_Cdd);
    }
    //content
    private void ComponentContent(){
        this.content.setLayout(new GridLayout(2,1,0,20));

        // cac thanh phan
        
        JPanel boxplanttext = new JPanel();
        boxplanttext.setLayout(new GridLayout(2,1));
        
        JLabel labelInput = new JLabel("Document");
        
        // Thiết lập tự động xuống dòng khi nội dung quá dài
        this.areaPlantText.setLineWrap(true); // Cho phép tự động xuống dòng
        this.areaPlantText.setWrapStyleWord(true); // Xuống dòng tại từ, không cắt từ
        // Thiết lập khoảng cách (padding) giữa văn bản và các cạnh của JTextArea
        this.areaPlantText.setMargin(new Insets(5, 10, 5, 5)); // Trên, trái, dưới, phải
        // insets la class duoc thiet lap de can chinh khoan cach le

        boxplanttext.add(labelInput);
        boxplanttext.add(this.areaPlantText);
        this.content.add(boxplanttext);
        
        JPanel boxciphertext = new JPanel();
        boxciphertext.setLayout(new GridLayout(2,1));
        this.areaCiphertext.setMargin(new Insets(5, 10, 5, 5));
        JLabel labelOutput = new JLabel("Resuil");

        this.areaCiphertext.setLineWrap(true); 
        this.areaCiphertext.setWrapStyleWord(true);

        boxciphertext.add(labelOutput);
        boxciphertext.add(this.areaCiphertext);
        this.content.add(boxciphertext);
        
    }
    //box key
    private void ComponentBoxLeft(){
        this.mainboxleft.setLayout(new GridLayout(2,1,0,50));
        //top
        this.boxtop.setLayout(new GridLayout(3,1));
        
        JLabel labeltextbox = new JLabel("Key");
        
        JButton btn_enctyption = new JButton("Enctyption");
        btn_enctyption.addActionListener(action);
        JPanel boxbtnEnc = new JPanel();
        boxbtnEnc.add(btn_enctyption);
        
        
        this.boxtop_labelandkey.add(labeltextbox);
        this.boxtop_labelandkey.add(this.textboxtop);
        this.boxtop.add(this.boxtop_labelandkey);
        this.boxtop.add(boxbtnEnc);
        
        this.mainboxleft.add(boxtop);
        
       //bottom
        this.boxbuttom.setLayout(new GridLayout(2,1));
       
        // JLabel labeltextboxbottom = new JLabel("Key");
        
        JButton btn_Dectyption = new JButton("Dectyption");
        btn_Dectyption.addActionListener(action); // add action
        JPanel boxbntDec = new JPanel();
        boxbntDec.add(btn_Dectyption);
        
        // this.boxbottom_labelandkey.add(labeltextboxbottom);
        // this.boxbottom_labelandkey.add(this.textboxbottom);
        
        this.boxbuttom.add(this.boxbottom_labelandkey);
        this.boxtop.add(boxbntDec);
        
        this.mainboxleft.add(boxbuttom);
        //add vào cữa sổ
    }
    // nhấn nút ở sidebar
    public void handleBtnSidebar(String key, boolean flag){
        this.lb_header.setText(key);
        if(flag){
            this.boxtop_labelandkey.setLayout(new GridLayout(2,1));
            this.boxbottom_labelandkey.setLayout(new GridLayout(2,1));
        }else{
            this.boxtop_labelandkey.setLayout(new FlowLayout());
            this.boxbottom_labelandkey.setLayout(new FlowLayout());
        }
    }
    // nhấn nút mã hoá/giải mã
    public Move handleEnctytion(){
        return new Move(this.areaPlantText.getText(),this.textboxtop.getText(),this.lb_header.getText());
    }
    public Move handleDecryption(){
        return new Move(this.areaPlantText.getText(),this.areaCiphertext.getText(),this.lb_header.getText());
    
    }
    public void DisplayResuil(String document, boolean flag){
        // flag true là đang mã hoá nên hiển thị ở ô ciphertext và ngược lại
        if(flag)
            areaCiphertext.setText(document);
        else
            areaPlantText.setText(document);
    }
    //show
    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true); 
    }
}
