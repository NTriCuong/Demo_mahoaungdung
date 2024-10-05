
package com.mycompany.projectmahoa.view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author nguyentricuong
 */
public class MainWindow extends JFrame {
    private final Font font=new Font("Arial", Font.PLAIN, 14);
    private final  JLabel lb_header=new JLabel("Ceaser");
    //panel
    private final JPanel header = new JPanel();
    private final JPanel container=new JPanel();
    private final JPanel sidebar=new JPanel();
    private final JPanel content=new JPanel();
    private final JPanel mainboxleft=new JPanel();
   



    public MainWindow(){
        super();
        this.setTitle("Demo Mã Hoá");
        this.setFont(font);
        this.setLayout(new BorderLayout());//flow layout xuat hien tuan tu
        this.setSize(700, 300);
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
        JTextArea areaInput = new JTextArea(5,20);
        boxplanttext.add(labelInput);
        boxplanttext.add(areaInput);
        this.content.add(boxplanttext);
        
        JPanel boxciphertext = new JPanel();
        boxciphertext.setLayout(new GridLayout(2,1));

        JLabel labelOutput = new JLabel("Ciphertext");
        JTextArea areaOutput = new JTextArea(5,20);
        boxciphertext.add(labelOutput);
        boxciphertext.add(areaOutput);
        this.content.add(boxciphertext);
        
    }
    //box key
    private void ComponentBoxLeft(){
        this.mainboxleft.setLayout(new GridLayout(2,1,0,50));
        //top
        JPanel boxtop = new JPanel();
        boxtop.setLayout(new GridLayout(2,1));
        
        JLabel labeltextbox = new JLabel("Key");
        
        JTextField textboxtop = new JTextField(3);
        JButton btn_enctyption = new JButton("Enctyption");
        JPanel boxbtnEnc = new JPanel();
        boxbtnEnc.add(btn_enctyption);
        
        JPanel boxtop_labelandkey =new JPanel();
        
        boxtop_labelandkey.add(labeltextbox);
        boxtop_labelandkey.add(textboxtop);
        boxtop.add(boxtop_labelandkey);
        boxtop.add(boxbtnEnc);
        
        mainboxleft.add(boxtop);
        
       //bottom
       JPanel boxbuttom = new JPanel();
       boxbuttom.setLayout(new GridLayout(2,1));
       
       JLabel labeltextboxbottom = new JLabel("Key");
        
        JTextField textboxbottom = new JTextField(3);
        JButton btn_Dectyption = new JButton("Dectyption");
        JPanel boxbntDec = new JPanel();
        boxbntDec.add(btn_Dectyption);
        
        JPanel boxbottom_labelandkey =new JPanel();
        boxbottom_labelandkey.add(labeltextboxbottom);
        boxbottom_labelandkey.add(textboxbottom);
        
        boxbuttom.add(boxbottom_labelandkey);
        boxbuttom.add(boxbntDec);
        
        mainboxleft.add(boxbuttom);
        
        
        //add vào cữa sổ
    }
    //show
    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true); 
    }
}
