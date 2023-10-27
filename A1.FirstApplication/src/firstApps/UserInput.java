package firstApps;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UserInput {
	public static void main(String[] args) {
		RadioDemo rd = new RadioDemo();
	}
}

class RadioDemo extends JFrame{
	JTextField t1;
	JButton b;
	JRadioButton r1, r2;
	JLabel l;
	JCheckBox c1, c2;
	public RadioDemo() {
		t1 = new JTextField(15);
		b = new JButton("OK");
		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");
		l = new JLabel("Greetings");
		c1 = new JCheckBox("Dancing");
		c2 = new JCheckBox("Singing");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		add(t1);
		add(r1);
		add(r2);
		add(c1);
		add(c2);
		add(b);
		add(l);
		
		c1.addItemListener(e -> {
			System.out.println("Dancer");
		});
		
		b.addActionListener(e -> {
			String name = t1.getText();
			if(r1.isSelected()) {
				name = "Mr. "+name;
			} else {
				name = "Ms. "+name;
			}
			if(c1.isSelected()) {
				name += " Dancer";
			}
			if(c2.isSelected()) {
				name += " Singer";
			}
			l.setText(name);
		});
		
		setLayout(new FlowLayout()); 
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
