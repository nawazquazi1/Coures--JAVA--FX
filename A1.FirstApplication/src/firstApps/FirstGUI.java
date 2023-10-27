package firstApps;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FirstGUI {
	public static void main(String[] args) {
		Abc obj = new Abc();
	}
}
class Abc extends JFrame { // default layout - CardLayout
	public Abc() {
		
		JLabel l1 = new JLabel("Hello World!");
		JLabel l2 = new JLabel("Welcome to JavaCoders");
		add(l1);
		add(l2);
		
		// we have FlowLayout, GridLayout, Null
		setLayout(new FlowLayout()); 
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}