package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import windowBuilder.view.frame.MainFrame;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class UserManagementApplication {
	
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		};
		
		EventQueue.invokeLater(runnable);
		
	}

}
