package GL;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	
	QuadTree quadTree = new QuadTree(new Rect(0,0,700,700));
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == e.VK_ENTER)
		{
			Form.instance.Paint(quadTree.dimension);
			quadTree.Subdivide();
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Soltou");
		
	}

}
