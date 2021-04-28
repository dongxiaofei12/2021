package ks;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

class cj extends JFrame //开始抽奖
{
	Vector<String> mz1=new Vector<String>();//隐藏信息
	JTextArea ta=new JTextArea();
	JLabel m1=new JLabel("获奖名单");
	JButton ok = new JButton("开始抽奖");
	int num=0;
	int a1=0;
	int a2=0;
	int a3=0;
	String zt1="";
	private void d()
	{
		try {
			String srcFile = "user.txt";
			BufferedReader br = new BufferedReader(new FileReader(srcFile));
			String strLine;
			while (br.ready())
			{
				strLine = br.readLine();
				String n1="姓名:"+strLine.substring(12)+" 手机号:"+strLine.substring(0,9)+"**";
				num++;
				mz1.add(n1);
			}
			br.close();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}
     cj() {
    	 super();
	}

	cj(String s,String one ,String two,String three,String zt,JFrame f)
	{
		super(s);
		d();
		zt1=zt;
		a1=Integer.valueOf(one);
		a2=Integer.valueOf(two);
		a3=Integer.valueOf(three);
		Container c = getContentPane( );
		JScrollPane sp=new JScrollPane(ta);
		JPanel pan1=new JPanel();
        pan1.setLayout(null);
		c.add(pan1);
		pan1.add(sp);//添加文本框
		sp.setBounds(20,60,200,260);
		pan1.add(m1);
		m1.setBounds(90,15,60,60);
		pan1.add(ok);
		ok.setBounds(240,120,100,100);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				run1();
				ok.setEnabled(false);
			}
		}
			);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//由closing事件那边接管
        f.setVisible(true);
		setSize(400,400);
		setResizable(false);// 设置为大小不可变的
		setVisible(true);
		setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-200, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300);
		exitConfirm(f);
	}
	public void exitConfirm(JFrame f)
	{
		addWindowListener(new WindowListener()
				{

					@Override
					public void windowOpened(WindowEvent e) {
						// TODO 自动生成的方法存根
						
					}

					@Override
					public void windowClosing(WindowEvent e) {
						try {
							String desFile = "获奖名单.txt";
							BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desFile, true)));
							bw.write(ta.getText());
							bw.flush();
							bw.close();
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						f.setEnabled(true);//让一开始的窗口可以使用
						dispose();//关闭此窗口
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO 自动生成的方法存根
						
					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO 自动生成的方法存根
						
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO 自动生成的方法存根
						
					}

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO 自动生成的方法存根
						
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO 自动生成的方法存根
						
					}
			
				});
	}
	
	
	public void run1() {
		int k=0;
		int b[]=new int[num];//检查是否已经抽中过
		for(int i=0;i<num;i++)
		{
			b[i]=0;
		}
			int m=(int) (Math.random() * 100) + 50;
			try {
				Thread.sleep(m);
			} catch (Exception e) {
					e.printStackTrace();
			}
			ta.disable();
			ta.setFont(new Font("黑体",0,14));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			zt1="获奖主题:"+zt1;
			ta.setText(zt1);
			ta.append("\n");
			
			ta.append("获奖时间:");
			ta.append(df.format(new Date()));
			ta.append("\n");
			
			ta.append("一等奖名单:");
			ta.append("\n");
			
			for (int i =1;i<=a1; i++)
			{
				k=(int) (Math.random() *num); //随机显示手机号码
				if(b[k]==0)
				{
				ta.append(mz1.get(k)); 
				ta.append("\n");
				b[k]=1;
				}
				else
				{
					i--;
				}
			}
			ta.append("二等奖名单:");
			ta.append("\n");
			for (int i =1;i<=a2; i++)
			{
				k=(int) (Math.random()*num);
				if(b[k]==0)
				{
				ta.append(mz1.get(k)); 
				ta.append("\n");
				b[k]=1;
				}
				else
				{
					i--;
				}
			}
			ta.append("三等奖名单:");
			ta.append("\n");
			for (int i =1;i<=a3; i++)
			{
				k=(int) (Math.random()*num);
				if(b[k]==0)
				{
				ta.append(mz1.get(k));  
				ta.append("\n");
				b[k]=1;
				}
				else
				{
					i--;
				}
			}
			ta.append("\n\n");
	}
}
class md extends JDialog implements ActionListener//导入信息
{
	JLabel m1=new JLabel("手机号");	
	JLabel m2=new JLabel("姓名");
	JLabel m3=new JLabel("导入信息");
	JTextArea ta=new JTextArea();
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JButton tj = new JButton("添加");
	JButton ok = new JButton("确定");
	JButton cancel = new JButton("取消");
	public void centerWindow(){
		//获得显示屏桌面窗口的大小
		Toolkit tk=getToolkit();
		Dimension dm=tk.getScreenSize();
		//让窗口居中显示
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
		}
	md()
	{
		super();
		Container c = getContentPane( );
		JPanel pan1=new JPanel();
        pan1.setLayout(null);
		c.add(pan1);
		pan1.add(m1);
		m1.setBounds(10,30,100,30);
		pan1.add(m2);
		m2.setBounds(20,90,30,30);
		pan1.add(t1);
		t1.setBounds(50,30,150,30);
		t1.addKeyListener(new KeyListener()//设置手机号最大11位
		{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				String s = t1.getText();
				if(s.length() >=11) e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自动生成的方法存根
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
		});
		pan1.add(ok);//确定
		ok.setBounds(40,330,60,50);
		pan1.add(t2);
		t2.setBounds(50,90,150,30);
		pan1.add(cancel);//退出
		cancel.setBounds(180,330,60,50);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		JScrollPane sp=new JScrollPane(ta);
		ta.disable();
		ta.setFont(new Font("黑体",0,16));
		pan1.add(sp);//添加文本框
		sp.setBounds(50,140,150,170);
		pan1.add(m3);
		m3.setBounds(0,135,100,30);
		pan1.add(tj);
		tj.setBounds(210,45,60,50);
		tj.addActionListener(this);
		setSize(300,450);
		centerWindow();
		setResizable(false);// 设置为大小不可变的
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok)
		{
			try {
				String srcFile = "user.txt";
				BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(srcFile,true)));
			    writer.write(ta.getText());
			    writer.flush();
			    writer.close();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			this.dispose();
		}
		else if(e.getSource()==tj)
		{
			String n="";
			n=t1.getText()+" "+t2.getText();
			ta.append(n);
			ta.append("\n");
			t1.setText("");
			t2.setText("");
		}
		else if(e.getSource()==cancel)
		{
			this.dispose();
		}
	}
}
class xl extends JFrame//导出历史抽奖情况
{
	JTextArea text=new JTextArea();
	xl(String s)
	{
		super(s);
		try {
			String srcFile = "获奖名单.txt";
			BufferedReader br = new BufferedReader(new FileReader(srcFile));
			String line=null;
			while ((line=br.readLine())!=null) {
			text.append(line+"\n");
			}
			br.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Container c=getContentPane();
		JScrollPane sp=new JScrollPane(text);
		text.setFont(new Font("黑体",0,14));
		c.add(sp);//添加文本框
		setSize(400,400);
		setResizable(false);// 设置为大小不可变的
		setVisible(true);
		setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-200, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300);
	}
}
public class Main extends JFrame implements ActionListener {
	 String zt;
	JLabel m1=new JLabel("获奖主题");
	JLabel m2=new JLabel("一等奖人数:");
	JLabel m3=new JLabel("二等奖人数:");
	JLabel m4=new JLabel("三等奖人数:");
	JButton kaishi = new JButton("确定");
	JButton jieshu = new JButton("退出");
	JButton daoru = new JButton("导入名单");
	JButton ls = new JButton("历史抽奖情况");
	JTextField t=new JTextField();
	JTextField []text=new JTextField[3];
	private void temp()
	{
		Container c=getContentPane();
		JPanel pan1=new JPanel();
        pan1.setLayout(null);
		c.add(pan1);
		
		pan1.add(m1);
		m1.setBounds(20,0, 100,100);
		pan1.add(t);
		t.setEditable(true);
		t.setBounds(90,38, 100,28);
		
		
		pan1.add(m2);
		m2.setBounds(20,55, 100,100);
		
		
		pan1.add(m3);
		m3.setBounds(20,95, 100,100);
		
		pan1.add(m4);
		m4.setBounds(20,135, 100,100);
		for(int i=0;i<3;i++)//获奖等级人数设置
		{
			text[i] = new JTextField("0");
			pan1.add(text[i]);
			text[i].setBounds(85,90+40*i, 200,30);
		}
		
		pan1.add(kaishi);
		kaishi.setBounds(80,290,60,60);
		kaishi.addActionListener(this);
		pan1.add(jieshu);
		jieshu.setBounds(200,290,60,60);
		jieshu.addActionListener(this);
		
		pan1.add(daoru);
		daoru.setBounds(60,220,90,60);
		daoru.addActionListener(this);
		
		pan1.add(ls);
		ls.setBounds(170,220,120,60);
		ls.addActionListener(this);
	}
	public void centerWindow(){
		//获得显示屏桌面窗口的大小
		Toolkit tk=getToolkit();
		Dimension dm=tk.getScreenSize();
		//让窗口居中显示
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
		}
    
	Main(String s)
	{
		super(s);
		setSize(350, 400);
		temp();
		centerWindow();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体
		setEnabled(true);
		
	}
	
        public static void  main(String []args)
        {
        	Main f=new Main("幸运观众手机号码抽取器");
        	f.setVisible(true);
        	
        }
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==daoru)
			{
				new md();
			}
			else if(e.getSource()==kaishi)
			{
				String one=text[0].getText();
				String two=text[1].getText();
				String three=text[2].getText();
				zt=t.getText();
				setEnabled(false);
				new cj("抽奖",one,two,three,zt,this);
				
			}
			else if(e.getSource()==ls)
			{
				new xl("历史抽奖情况");
			}
			else if(e.getSource()==jieshu)
			{
				System.exit(0);	
			}
			
		}
}
