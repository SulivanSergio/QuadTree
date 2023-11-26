package GL;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class Form{
	
	public static Form instance;
	
	
	JFrame window;
	
	Rect windowSize;
	Keyboard keyboard;
	float timerClear = 0;
	float timerClearMax = 0.05f;
	
	public Form()
	{
		instance = this;
		windowSize = new Rect(50,65,500,500);
		keyboard = new Keyboard();
		
		CreateJFrame();
		
	}
	
	public void Update(float gameTime)
	{
		timerClear += gameTime;
	}
	
	public void Draw()
	{
		
		
		Graphics g = window.getGraphics();
		if(timerClear > timerClearMax)
		{
			timerClear = 0;
			
			g.clearRect((int)windowSize.x,(int)windowSize.y,(int)windowSize.width,(int)windowSize.height);
			g.setColor(Color.GRAY);
			g.fillRect((int)windowSize.x,(int)windowSize.y,(int)windowSize.width,(int)windowSize.height);
			
		}
		
		
	}
	
	private void CreateJFrame()
	{
		window = new JFrame();
		window.setSize((int)windowSize.width + (int)windowSize.x * 2,(int)windowSize.height + (int)windowSize.y *2 - 15);
		window.getContentPane().setBackground(new Color(100,100,100));
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.addKeyListener(keyboard);
		window.setVisible(true);
	}
	
	
	
	
	public JLabel CreateJLabel(JLabel label,Font font)
	{
		
		label = new JLabel("Ola Mundo");
		//label.setFont(new Font("Calibri",Font.BOLD,20));
		label.setFont(font);
		label.setAlignmentY(-200.0f);
		label.setAlignmentX(200.0f);
		label.setVisible(true);
		window.add(label);
		return label;
	}
	
	
	
}
