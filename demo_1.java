package text1;
import javax.swing.*;
import java.awt.*;
public class demo_1 extends JFrame {
JSplitPane jsp;
JList jList;
JLabel jll;
public static void main(String[] args){
	demo_1 demo_1=new demo_1();
}
public demo_1()
{
	String[] words={"djfow","2","3"};
	jList=new JList(words);
	jll=new JLabel(new ImageIcon("images/talk.jpg"));
	jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jList,jll);
	this.add(jsp);
	this.setSize(400,300);
	this.setLocation(200,200);
	this.setVisible(true);
	
}
	
}
