package firstApps;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MouseDemo {
	public static void main(String[] args) {
		MouseListenerDemo ml = new MouseListenerDemo();
	}
}

class MouseListenerDemo extends JFrame {
	
	public MouseListenerDemo() {
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + " " + e.getY());
			}
		});
		
		
		setLayout(new FlowLayout()); 
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}