package GL;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Level1 {
	

	
	ObjectDynamics[] objectDynamics = new ObjectDynamics[300];
	ObjectStatic[] objectStatic = new ObjectStatic[5];
	Player player;
	Game1 game1;
	
	
	public Level1(Game1 game1) {
		
		this.game1 = game1;
		
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
		long inicio = System.currentTimeMillis();
		float speedUP = 0;
		
		
		for(int i = 0; i< objectDynamics.length; i++)
		{
			objectDynamics[i].Update(gameTime);
			objectDynamics[i].CollisionObjStatic();
			objectDynamics[i].CollisionPlayer();
		}
		
		CODinamics();
		
		player.Update(gameTime);
		player.CollisionObjStatic();
		
		
		long fim = System.currentTimeMillis();
		speedUP = 1.0f/ (float)(fim - inicio);
		System.out.println("SpeedUP: " + speedUP);
		
		if(Form.instance.keyboard.Return_Esc())
		{
			Form.instance.ClearGrapphics(Form.instance.window.getGraphics(), new Color(100,100,100));
			game1.scene = SCENE_MANAGER.MENU;
			
		}
		
		
		
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
