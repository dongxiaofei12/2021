package ks;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

class cj extends JFrame //��ʼ�齱
{
	Vector<String> mz1=new Vector<String>();//������Ϣ
	JTextArea ta=new JTextArea();
	JLabel m1=new JLabel("������");
	JButton ok = new JButton("��ʼ�齱");
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
				String n1="����:"+strLine.substring(12)+" �ֻ���:"+strLine.substring(0,9)+"**";
				num++;
				mz1.add(n1);
			}
			br.close();
		} catch (Exception e1) {
			// TODO �Զ����ɵ� catch ��
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
		pan1.add(sp);//����ı���
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//��closing�¼��Ǳ߽ӹ�
        f.setVisible(true);
		setSize(400,400);
		setResizable(false);// ����Ϊ��С���ɱ��
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
						// TODO �Զ����ɵķ������
						
					}

					@Override
					public void windowClosing(WindowEvent e) {
						try {
							String desFile = "������.txt";
							BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desFile, true)));
							bw.write(ta.getText());
							bw.flush();
							bw.close();
						} catch (IOException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						f.setEnabled(true);//��һ��ʼ�Ĵ��ڿ���ʹ��
						dispose();//�رմ˴���
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO �Զ����ɵķ������
						
					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO �Զ����ɵķ������
						
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO �Զ����ɵķ������
						
					}

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO �Զ����ɵķ������
						
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO �Զ����ɵķ������
						
					}
			
				});
	}
	
	
	public void run1() {
		int k=0;
		int b[]=new int[num];//����Ƿ��Ѿ����й�
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
			ta.setFont(new Font("����",0,14));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			zt1="������:"+zt1;
			ta.setText(zt1);
			ta.append("\n");
			
			ta.append("��ʱ��:");
			ta.append(df.format(new Date()));
			ta.append("\n");
			
			ta.append("һ�Ƚ�����:");
			ta.append("\n");
			
			for (int i =1;i<=a1; i++)
			{
				k=(int) (Math.random() *num); //�����ʾ�ֻ�����
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
			ta.append("���Ƚ�����:");
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
			ta.append("���Ƚ�����:");
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
class md extends JDialog implements ActionListener//������Ϣ
{
	JLabel m1=new JLabel("�ֻ���");	
	JLabel m2=new JLabel("����");
	JLabel m3=new JLabel("������Ϣ");
	JTextArea ta=new JTextArea();
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JButton tj = new JButton("���");
	JButton ok = new JButton("ȷ��");
	JButton cancel = new JButton("ȡ��");
	public void centerWindow(){
		//�����ʾ�����洰�ڵĴ�С
		Toolkit tk=getToolkit();
		Dimension dm=tk.getScreenSize();
		//�ô��ھ�����ʾ
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
		t1.addKeyListener(new KeyListener()//�����ֻ������11λ
		{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO �Զ����ɵķ������
				String s = t1.getText();
				if(s.length() >=11) e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO �Զ����ɵķ������
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
		});
		pan1.add(ok);//ȷ��
		ok.setBounds(40,330,60,50);
		pan1.add(t2);
		t2.setBounds(50,90,150,30);
		pan1.add(cancel);//�˳�
		cancel.setBounds(180,330,60,50);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		JScrollPane sp=new JScrollPane(ta);
		ta.disable();
		ta.setFont(new Font("����",0,16));
		pan1.add(sp);//����ı���
		sp.setBounds(50,140,150,170);
		pan1.add(m3);
		m3.setBounds(0,135,100,30);
		pan1.add(tj);
		tj.setBounds(210,45,60,50);
		tj.addActionListener(this);
		setSize(300,450);
		centerWindow();
		setResizable(false);// ����Ϊ��С���ɱ��
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
				// TODO �Զ����ɵ� catch ��
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
class xl extends JFrame//������ʷ�齱���
{
	JTextArea text=new JTextArea();
	xl(String s)
	{
		super(s);
		try {
			String srcFile = "������.txt";
			BufferedReader br = new BufferedReader(new FileReader(srcFile));
			String line=null;
			while ((line=br.readLine())!=null) {
			text.append(line+"\n");
			}
			br.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		Container c=getContentPane();
		JScrollPane sp=new JScrollPane(text);
		text.setFont(new Font("����",0,14));
		c.add(sp);//����ı���
		setSize(400,400);
		setResizable(false);// ����Ϊ��С���ɱ��
		setVisible(true);
		setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-200, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300);
	}
}
public class Main extends JFrame implements ActionListener {
	 String zt;
	JLabel m1=new JLabel("������");
	JLabel m2=new JLabel("һ�Ƚ�����:");
	JLabel m3=new JLabel("���Ƚ�����:");
	JLabel m4=new JLabel("���Ƚ�����:");
	JButton kaishi = new JButton("ȷ��");
	JButton jieshu = new JButton("�˳�");
	JButton daoru = new JButton("��������");
	JButton ls = new JButton("��ʷ�齱���");
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
		for(int i=0;i<3;i++)//�񽱵ȼ���������
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
		//�����ʾ�����洰�ڵĴ�С
		Toolkit tk=getToolkit();
		Dimension dm=tk.getScreenSize();
		//�ô��ھ�����ʾ
		setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
		}
    
	Main(String s)
	{
		super(s);
		setSize(350, 400);
		temp();
		centerWindow();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
		setEnabled(true);
		
	}
	
        public static void  main(String []args)
        {
        	Main f=new Main("���˹����ֻ������ȡ��");
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
				new cj("�齱",one,two,three,zt,this);
				
			}
			else if(e.getSource()==ls)
			{
				new xl("��ʷ�齱���");
			}
			else if(e.getSource()==jieshu)
			{
				System.exit(0);	
			}
			
		}
}
