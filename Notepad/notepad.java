import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class notepad extends Frame implements ActionListener
{
	 MenuBar mb=new MenuBar();
	 TextArea t1=new TextArea();
	 TextArea t2=new TextArea();
	 Label l1=new Label("Enter Path : ");

	 notepad()
	 {
	    setSize(500,500);
	    setVisible(true);
	    setMenuBar(mb);
	    setLayout(null);
	    // setFont(t1.getFont().deriveFont(10f));
	    // setFont(t2.getFont().deriveFont(10f));

	    Menu m=new Menu("File");
	    MenuItem m1=new MenuItem("New");
	    MenuItem m2=new MenuItem("Open");
	    MenuItem m3=new MenuItem("Copy");
	    MenuItem m4=new MenuItem("Delete");
	    MenuItem m5=new MenuItem("Save");

	    mb.add(m);
	    m.add(m1);
	    m.add(m2);
	    m.add(m3);
	    m.add(m4);
	    m.add(m5);

	    add(t1);
	    add(t2);
	    add(l1);
	    l1.setBounds(20,60,100,10);
	    t1.setBounds(20,75,460,30);
	    t2.setBounds(10,110,495,390);

	    m1.addActionListener(this);
	    m2.addActionListener(this);
	    m3.addActionListener(this);
	    m4.addActionListener(this);
	    m5.addActionListener(this);
	    
	 }

     public void actionPerformed(ActionEvent E)
     {
        if(E.getActionCommand().equals("Open"))
        {
        	try{
        		String s=t1.getText();
        		String ss="";
        		RandomAccessFile file=new RandomAccessFile(s,"rw");
        		int i;
        		while((i=file.read())!=-1)
        		{
        			ss=ss+((char)i);
        		}
        		
        		t2.setText(ss);
            }catch(IOException i){}
        }
        if(E.getActionCommand().equals("Delete"))
        {
        	t2.setText("");
        }
        
        if(E.getActionCommand().equals("Save"))
        {
         try{
        	String s=t1.getText();
        	RandomAccessFile file=new RandomAccessFile(s,"rw");
        	String s1=t2.getText();
        	byte[]b=s1.getBytes();
        	file.write(b);
          }catch(IOException i){}
        }
        if(E.getActionCommand().equals("New"))
        {
        	try
        	{
        		String s=t1.getText();
        		t2.setText("");
        		File f=new File(s);
        		f.createNewFile();
        	}catch(IOException i){}
        }
     }
	 public static void main(String []args)
	 {
	 	notepad n=new notepad();
	 }
}