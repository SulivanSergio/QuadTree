package GL;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	
	boolean W = false;
	boolean A = false;
	boolean S = false;
	boolean D = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == e.VK_W)
		{
			W = true;
		}
		if(e.getKeyCode() == e.VK_A)
		{
			A = true;
		}
		if(e.getKeyCode() == e.VK_S)
		{
			S = true;
		}
		if(e.getKeyCode() == e.VK_D)
		{
			D = true;
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == e.VK_W)
		{
			W = false;
		}
		if(e.getKeyCode() == e.VK_A)
		{
			A = false;
		}
		if(e.getKeyCode() == e.VK_S)
		{
			S = false;
		}
		if(e.getKeyCode() == e.VK_D)
		{
			D = false;
		}
		
	}
	
	
	public boolean Return_W() {
		return W;
	}
	public boolean Return_A() {
		return A;
	}
	public boolean Return_S() {
		return S;
	}
	public boolean Return_D() {
		return D;
	}
	
	
}
