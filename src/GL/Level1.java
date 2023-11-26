package GL;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Level1 {
	

	
	ObjectDynamics[] objectDynamics = new ObjectDynamics[100];
	ObjectStatic[] objectStatic = new ObjectStatic[5];
	Player player;
	
	
	
	public Level1() {
		
		for(int i = 0; i< objectStatic.length; i++)
		{
			objectStatic[i] = new ObjectStatic();
		}
		player = new Player(objectStatic);
		
		for(int i = 0; i< objectDynamics.length; i++)
		{
			objectDynamics[i] = new ObjectDynamics(objectStatic,player);
		}
		
		
		
		
		
	}
	public void Update(float gameTime)
	{
		
		for(int i = 0; i< objectDynamics.length; i++)
		{
			objectDynamics[i].Update(gameTime);
			objectDynamics[i].CollisionObjStatic();
			objectDynamics[i].CollisionPlayer();
		}
		
		CODinamics();
		
		player.Update(gameTime);
		player.CollisionObjStatic();
		
		
		
		
		
		
	}
	
	public void Draw()
	{
		
		for(int i = 0; i< objectDynamics.length; i++)
		{
			objectDynamics[i].Draw(Form.instance.window.getGraphics(), Color.blue);
		}
		
		for(int i = 0; i< objectStatic.length; i++)
		{
			objectStatic[i].Draw(Form.instance.window.getGraphics());	
		}
		
		
		player.Draw(Form.instance.window.getGraphics());
		
		
		
		
	}
	
	private void CODinamics() 
	{
		for(int i = 0; i < objectDynamics.length; i++)
		{
			for(int j = 0; j < objectDynamics.length; j++)
			{
				if(objectDynamics[i].rect.BoundingCollision(objectDynamics[i].rect, objectDynamics[j].rect) && i != j)
				{
					objectDynamics[i].Draw(Form.instance.window.getGraphics(), Color.red);
					objectDynamics[i].direction.x *= -1;
					objectDynamics[i].direction.y *= -1;
					objectDynamics[i].rect.x +=  0.5f * objectDynamics[i].direction.x;
					objectDynamics[i].rect.y += 0.5f * objectDynamics[i].direction.y;
					
					objectDynamics[j].Draw(Form.instance.window.getGraphics(), Color.red);
					objectDynamics[j].direction.x *= -1;
					objectDynamics[j].direction.y *= -1;
					objectDynamics[j].rect.x +=  0.5f * objectDynamics[j].direction.x;
					objectDynamics[j].rect.y += 0.5f * objectDynamics[j].direction.y;
					
					
					
				}
			}
		}
	}
	
	
	
	
	
}
