package test2;

import java.awt.*;  
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;  
import javax.swing.event.*;  
  
  
public class MainFrame
{   
	Date now = new Date();
	JTextField[] jt=new JTextField[100];
	String[] strarr=new String[100];
	JLabel[] jb2 =new JLabel[100];
    public static int cuowu=0;
    int zheng1=0,cuo1=0;
    public MainFrame(int n)  
    {   
    	JMenuBar jmb=new JMenuBar();  //菜单栏
        JFrame jf=new JFrame();       //窗口
        JPanel jp =new JPanel();
        jp.setLayout(new GridLayout(n+1,3));
        jf.setSize(400, 400);  
        jf.setTitle("四则运算");
        JMenu jm=new JMenu("Language");    //菜单
        JMenuItem mi1=new JMenuItem("中文简体");  //菜单项
        JMenuItem mi2=new JMenuItem("中文繁体"); 
        JMenuItem mi3=new JMenuItem("英文"); 
        jm.add(mi1);
        jm.add(mi2);
        jm.add(mi3);          
        jmb.add(jm);
        jf.setJMenuBar(jmb);  
        jf.setVisible(true); 
        
        for(int i=0;i<n;i++)
        {
        	jt[i]=new JTextField();
        	jt[i].getText();
        	Random rand = new Random();
        	JLabel jbi=new JLabel();
        	int ra=rand.nextInt(2)+1;
        	zhengshu zsi=new zhengshu();
        	fenshu fsi=new fenshu();
        	fsi.main(null);
        	zsi.main(null);
        	if(ra==1)
        	{
        	jbi.setText(zsi.suanshi);
        	strarr[3*i]=zsi.suanshi;
        	strarr[3*i+1]=jt[i].getText();
        	strarr[3*i+2]=zsi.z;
        	}
        	else
        	{
        	jbi.setText(fsi.suanshi);
        	strarr[3*i]=fsi.suanshi;
        	strarr[3*i+1]=jt[i].getText();
        	strarr[3*i+2]=fsi.z;
        	}
        	JLabel jb=new JLabel();
        	jb.setText("    ");
        	jp.add(jbi);
        	jp.add(jt[i]);
        	jp.add(jb);    	
        }
        
        JLabel lbl = new JLabel();

        now.setHours(0);
		now.setMinutes(0);
		now.setSeconds(0);
        final Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date now2 = new Date(now.getTime() + 1000);
				now = now2;
				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
				lbl.setText(formatter.format(now));
			}
		});
        timer.start();
        
        
        
        JButton jb=new JButton("提交");
        JPanel jp1=new JPanel();
        
        mi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jb.setText("提交");          
            }
        });
        mi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jb.setText("提交");              
            }
        });
        mi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jb.setText("commit");          
            }
        });
        
        jp1.add(jb);
        jp.add(jp1);
        jp.add(lbl);
        jf.add(jp);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	for(int i=0;i<n;i++)
            	{
            		strarr[3*i+1]=jt[i].getText();
            	}
            	timer.stop();
            	JMenuBar jmb=new JMenuBar();  //菜单栏
                JFrame jf=new JFrame();       //窗口
                JPanel jp =new JPanel();
                jp.setLayout(new GridLayout(n+1,2));
                jf.setSize(400, 400);  
                jf.setTitle("四则运算");
                JMenu jm=new JMenu("Language");    //菜单
                JMenuItem mi1=new JMenuItem("中文简体");  //菜单项
                JMenuItem mi2=new JMenuItem("中文繁体"); 
                JMenuItem mi3=new JMenuItem("英文"); 
                jm.add(mi1);
                jm.add(mi2);
                jm.add(mi3);          
                jmb.add(jm);
                jf.setJMenuBar(jmb);  
                jf.setVisible(true); 
                JButton jbt=new JButton("记录");
                jbt.addActionListener(new ActionListener() {
                @Override
                 public void actionPerformed(ActionEvent e) {
                     File file = new File("D:/newfile.txt");
                     String line =null;
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                         try {
                             while((line = br.readLine()) != null){
                                 String[] num = line.split("#");
                                 zheng1=Integer.parseInt(num[1]);
                                 cuo1=Integer.parseInt(num[3]);
                             }} catch (IOException ex) {
                             Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    } catch (FileNotFoundException ex) {
                        keep();
                    }
                     keep();
                 }
                        private void keep() {
                              FileOutputStream fop = null;
                              File file;
                              String content = "正确#"+(n-MainFrame.cuowu+zheng1)+"#错误#"+(MainFrame.cuowu+cuo1)+"#";
                              try {
                               file = new File("D:/result.txt");
                               fop = new FileOutputStream(file);
                               if (!file.exists()) {
                                file.createNewFile();
                               }
                               byte[] contentInBytes = content.getBytes();
                               fop.write(contentInBytes);
                               fop.flush();
                               fop.close();
                              } catch (IOException e) {
                               e.printStackTrace();
                              } finally {
                               try {
                                if (fop != null) {
                                 fop.close();
                                }
                               } catch (IOException e) {
                                e.printStackTrace();
                               }
                              }
                        }
                 });
                for(int i=0;i<n;i++)
                {

                	JLabel jb=new JLabel();               	
                	jb2[i]=new JLabel();
                	
                	jb.setText(strarr[3*i]+strarr[3*i+1]);
                	if(strarr[3*i+1].equals(strarr[3*i+2]))
                	{
                		jb2[i].setText("正确");
                		mi1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                            	for(int i=0;i<n;i++)
                            	{
                            	if(jb2[i].getText().equals("正确")||jb2[i].getText().equals("正確")||jb2[i].getText().equals("right"))
                            		jb2[i].setText("正确");
                            	else
                            		jb2[i].setText("错误，答案是："+strarr[3*i+2]);
                            	}
                            }
                        });
                        mi2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                            	for(int i=0;i<n;i++)
                            	{
                            	if(jb2[i].getText().equals("正确")||jb2[i].getText().equals("正確")||jb2[i].getText().equals("right"))
                            		jb2[i].setText("正確");
                            	else
                            		jb2[i].setText("錯誤，答案是"+strarr[3*i+2]);
                            	}
                            }
                        });
                        mi3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                            	for(int i=0;i<n;i++)
                            	{
                            	if(jb2[i].getText().equals("正确")||jb2[i].getText().equals("正確")||jb2[i].getText().equals("right"))
                            		jb2[i].setText("right");
                            	else
                            		jb2[i].setText("wrong，the answer is :"+strarr[3*i+2]);
                            	
                            	}
                            }
                        });
                	}
                	else
                	{
                		jb2[i].setText("错误，答案是："+strarr[3*i+2]);
                                cuowu+=1;
                		
                	}
                	jp.add(jb);
                	jp.add(jb2[i]);
                }
              
                JPanel jp1=new JPanel();
                
                mi1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	jbt.setText("记录");
                    }
                });
                mi2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	jbt.setText("記錄");
                    }
                });
                mi3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	jbt.setText("record");
                    }
                });
                jp1.add(jbt);
                jp.add(jp1);
                JLabel lbl1 = new JLabel();
                lbl1.setText("用时  :"+lbl.getText());
                mi1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	lbl1.setText("用时："+lbl.getText());
                    }
                });
                mi2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	lbl1.setText("用時:"+lbl.getText());
                    }
                });
                mi3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	lbl1.setText("time :"+lbl.getText());
                    }
                });
                jp.add(lbl1);
                jf.add(jp);
            }
        });
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {              
            }
        });
    }  
    public static void main(String args[]) {  
            new Main();   
    }  
}  