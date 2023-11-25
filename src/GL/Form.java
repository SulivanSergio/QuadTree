package GL;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class Form{
	
	public static Form instance;
	
	
	JFrame window;
	JLabel label;
	Rect windowSize;
	Keyboard keyboard;
	float timerClear = 0;
	float timerClearMax = 0.05f;
	
	public Form()
	{
		instance = this;
		windowSize = new Rect(50,65,500,500);
		keyboard = new Keyboard();
		CreateJLabel();
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
		
		label.setText("FPS: "+ String.valueOf(GameLoop.FPS));
	}
	
	private void CreateJFrame()
	{
		window = new JFrame();
		window.setSize((int)windowSize.width + (int)windowSize.x * 2,(int)windowSize.height + (int)windowSize.y *2 - 15);
		window.getContentPane().setBackground(new Color(100,100,100));
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		window.add(label);
		
		window.addKeyListener(keyboard);
		
		
		window.setVisible(true);
	}
	
	public void Paint(Rect rect)
	{
		Graphics g = window.getGraphics();
		g.setColor(Color.black);
		g.drawRect((int)rect.x,(int)rect.y,(int)rect.width,(int)rect.height);
		
		
	}
	
	private void CreateJLabel()
	{
		
		label = new JLabel("Ola Mundo");
		label.setFont(new Font("Calibri",Font.BOLD,20));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setVisible(true);
	}
	
	
	
}
