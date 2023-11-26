package GL;

import java.awt.Font;

import javax.swing.JLabel;

public class Menu {
	
	Form form;
	JLabel[] label = new JLabel[5];
	
	public Menu(Form form) {
		this.form = form;
		
		for(int i = 0; i< label.length; i++)
		{
			label[i] = this.form.CreateJLabel(label[i],new Font("Calibri",Font.BOLD,20));
		}
	}
	
	public void Update(float gameTime) {
		for(int i = 0; i< label.length; i++)
		{
			label[i].setText("GameTime: " + gameTime);
		}
		
	}
	public void Draw() {
		
	}
	
}
