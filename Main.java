package test2;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.event.*;  
  
  
public class Main  
{     
	public static JTextField jtf =new JTextField(5); //文本框
    public Main()  
    {   
    	JMenuBar jmb=new JMenuBar();  //菜单栏
        JFrame jf=new JFrame();       //窗口
    	JLabel jlb =new JLabel();     //标签
    	JButton jb =new JButton();      //按钮
    	JPanel jp =new JPanel();        //容器
    	JPanel jp1 =new JPanel();   	
    	jlb.setText("请输入题目数量，为您生成题目");
    	jtf.getText();
    	jb.setText("go！");       
        jf.setLayout(new BorderLayout());  //布局
        jf.setSize(500, 400);  
        jf.setTitle("四则运算自动出题器");
        JMenu jm=new JMenu("语言");    //菜单
        JMenuItem mi1=new JMenuItem("中文简体");  //菜单项
        JMenuItem mi2=new JMenuItem("中文繁体"); 
        JMenuItem mi3=new JMenuItem("英文"); 
        jm.add(mi1);
        jm.add(mi2);
        jm.add(mi3);          
        jmb.add(jm);
        jp.add(jlb);
        jp.add(jtf);
        jp1.add(jb);
        ImageIcon img = new ImageIcon("src/test2/2PAA~5DRU_W_ZJG]3$R(9LN。png");
        jf.add(jp,BorderLayout.NORTH);
        jf.add(jp1,BorderLayout.CENTER);
        jf.setJMenuBar(jmb);  
        jf.setVisible(true); 
        
        mi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jlb.setText("请输入题目数量，为您生成题目");
            	jtf.getText();
            	jb.setText("go！");                
            }
        });
        mi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jlb.setText("請輸入題目數量，為您生成題目");
            	jtf.getText();
            	jb.setText("go！");                
            }
        });
        mi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jlb.setText("please input the number of questions you want：");
            	jtf.getText();
            	jb.setText("generate tests");                
            }
        });
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	methodjb();                
            }
        });
    }  
    public static void methodjb(){
    	new MainFrame(Integer.parseInt(jtf.getText()));
    }
    public static void main(String args[]) {  
            new Main();   
    }  
}  