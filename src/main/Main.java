package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Asteroids");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Hello World!!");
		
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		
		panel.setBackground(Color.black);
		panel.add(label);
		panel.setLayout(new GridBagLayout());
		
		label.setForeground(Color.white);
		label.setFont(new Font("Calibri", Font.BOLD, 120));
		for(Font font : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
			
			System.out.println(font);
			
		}
	}

}
