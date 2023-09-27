package GL;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class Form{
	
	public static Form instance;
	
	JFrame janela;
	JLabel label;
	QuadTree quadTree;
	
	public Form()
	{
		instance = this;
		CreateJLabel();
		CreateJFrame();
		
		
		
	}
	
	public void Update(float gameTime)
	{
		
	}
	
	public void Draw()
	{
		
		label.setText("FPS: "+ String.valueOf(GameLoop.FPS));
		Paint(new Rect(10,10,10,10));
		
	}
	
	private void CreateJFrame()
	{
		
		
		
		janela = new JFrame();
		janela.setSize(700,700);
		janela.getContentPane().setBackground(new Color(100,100,100));
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
		
		
	
		janela.add(label);
		
		janela.addKeyListener(new Keyboard());
		
		
		janela.setVisible(true);
		
		
		
	}
	
	public void Paint(Rect rect)
	{
		Graphics g = janela.getGraphics();
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
