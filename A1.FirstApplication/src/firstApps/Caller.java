package firstApps;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Caller {
	public static void main(String[] args) {
		X obj = new X();
	}
}

class X extends JFrame implements ActionListener{
	JProgressBar p;
	JButton b;
	int i;
	public X() {
		b = new JButton("Add Form");
		p = new JProgressBar(0, 20);
		Timer t = new Timer(250, this);
		b.addActionListener(e -> {
			t.start();
		});
		
		add(b);
		add(p);
		
		setLayout(new FlowLayout()); 
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(i == 20) {
			new Addition1();
			dispose();
		}
		i++;
		p.setValue(i);
	}
}
