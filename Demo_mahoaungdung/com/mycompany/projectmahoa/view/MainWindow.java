
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

public class MainWindow extends JFrame {
    private final Font font=new Font("Arial", Font.PLAIN, 14);
    private final  JLabel lb_header=new JLabel("CEASER");
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
    private final JTextField textboxtop = new JTextField(3);
    private final JTextField textboxbottom = new JTextField(3);
    // actionlistener
    private final MainController action = new MainController(this);
   



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
        JButton btn_Ceaser = new JButton("Ceaser");
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
        
        JLabel labelInput = new JLabel("Plant text");
        JTextArea areaPlantText = new JTextArea(5,20);
        // Thiết lập tự động xuống dòng khi nội dung quá dài
        areaPlantText.setLineWrap(true); // Cho phép tự động xuống dòng
        areaPlantText.setWrapStyleWord(true); // Xuống dòng tại từ, không cắt từ
        // Thiết lập khoảng cách (padding) giữa văn bản và các cạnh của JTextArea
        areaPlantText.setMargin(new Insets(5, 10, 5, 5)); // Trên, trái, dưới, phải
        // insets la class duoc thiet lap de can chinh khoan cach le

        boxplanttext.add(labelInput);
        boxplanttext.add(areaPlantText);
        this.content.add(boxplanttext);
        
        JPanel boxciphertext = new JPanel();
        boxciphertext.setLayout(new GridLayout(2,1));

        JLabel labelOutput = new JLabel("Ciphertext");
        JTextArea areaCiphertext = new JTextArea(5,20);

        areaCiphertext.setLineWrap(true); 
        areaCiphertext.setWrapStyleWord(true);

        boxciphertext.add(labelOutput);
        boxciphertext.add(areaCiphertext);
        this.content.add(boxciphertext);
        
    }
    //box key
    private void ComponentBoxLeft(){
        this.mainboxleft.setLayout(new GridLayout(2,1,0,50));
        //top
        this.boxtop.setLayout(new GridLayout(2,1));
        
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
       
        JLabel labeltextboxbottom = new JLabel("Key");
        
        JButton btn_Dectyption = new JButton("Dectyption");
        btn_Dectyption.addActionListener(action); // add action
        JPanel boxbntDec = new JPanel();
        boxbntDec.add(btn_Dectyption);
        
        this.boxbottom_labelandkey.add(labeltextboxbottom);
        this.boxbottom_labelandkey.add(this.textboxbottom);
        
        this.boxbuttom.add(this.boxbottom_labelandkey);
        this.boxbuttom.add(boxbntDec);
        
        this.mainboxleft.add(boxbuttom);
        //add vào cữa sổ
    }
    public void handlePlayfair(String key, boolean flag){
        this.lb_header.setText(key);
        if(flag){
            this.boxtop_labelandkey.setLayout(new GridLayout(2,1));
            this.boxbottom_labelandkey.setLayout(new GridLayout(2,1));
        }else{
            this.boxtop_labelandkey.setLayout(new FlowLayout());
            this.boxbottom_labelandkey.setLayout(new FlowLayout());
        }
    }
    //show
    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true); 
    }
}
