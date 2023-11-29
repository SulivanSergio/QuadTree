package GL;

import java.awt.Color;

public class Level2 {

	

	
	ObjectDynamics[] objectDynamics = new ObjectDynamics[200];
	ObjectStatic[] objectStatic = new ObjectStatic[100];
	Player player;
	Game1 game1;
	
	QuadTree quadTree;
	static Rect rectAux;
	boolean useQuadTree = true;
	
	
	
	public Level2(Game1 game1) {
		
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
		
		if(useQuadTree)
			quadTree = new QuadTree(new Rect(Form.instance.windowSize.x,Form.instance.windowSize.y,Form.instance.windowSize.width,Form.instance.windowSize.height));
		
		
		
		
	}
	public void Update(float gameTime)
	{
		long inicio = System.currentTimeMillis();
		float speedUP = 0;
		
		quadTree.Insert(player.rect);
		for(int i = 0; i< objectStatic.length; i++)
		{
			quadTree.Insert(objectStatic[i].rect);
		}
		for(int i = 0; i< objectDynamics.length; i++)
		{
			quadTree.Insert(objectDynamics[i].rect);
		}
		for(int i = 0; i< objectDynamics.length; i++)
		{
			objectDynamics[i].Update(gameTime);
		}
		
		CODynamicsQuadTree();
		COStaticQuadTree();
		COPlayerQuadTree();
		CollisionStaticAndPlayerQuadTree();
		
		player.Update(gameTime);
		
		quadTree.ClearSubdivide(quadTree);
		

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
		
		if(useQuadTree)
		{
			quadTree.Print(quadTree);
		}
		
		
	}
	
	
	
	
	private void CODynamicsQuadTree() 
	{
		for(int i = 0; i < objectDynamics.length; i++)
		{
			quadTree.Search(quadTree, objectDynamics[i].rect);
			
			for(int j = 0; j < objectDynamics.length; j++)
			{
				
				if(objectDynamics[j].rect.BoundingCollision(objectDynamics[j].rect, rectAux))
				{
					if(objectDynamics[i].rect.BoundingCollision(objectDynamics[i].rect, objectDynamics[j].rect) && objectDynamics[i].rect != objectDynamics[j].rect)
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
	
	private void COStaticQuadTree() 
	{
		for(int i = 0; i < objectDynamics.length; i++)
		{
			quadTree.Search(quadTree, objectDynamics[i].rect);
			
			for(int j = 0; j < objectStatic.length; j++)
			{
				
				if(objectStatic[j].rect.BoundingCollision(objectStatic[j].rect, rectAux))
				{
					if(objectDynamics[i].rect.BoundingCollision(objectDynamics[i].rect, objectStatic[j].rect))
					{
						objectDynamics[i].Draw(Form.instance.window.getGraphics(), Color.red);
						objectDynamics[i].direction.x *= -1;
						objectDynamics[i].direction.y *= -1;
						objectDynamics[i].rect.x +=  0.5f * objectDynamics[i].direction.x;
						objectDynamics[i].rect.y += 0.5f * objectDynamics[i].direction.y;
						
					}
					
					
				}
			
			}
			
		}
	
	}
	private void COPlayerQuadTree() 
	{
		for(int i = 0; i < objectDynamics.length; i++)
		{
			quadTree.Search(quadTree, objectDynamics[i].rect);
			
			if(player.rect.BoundingCollision(player.rect, rectAux))
			{
				if(objectDynamics[i].rect.BoundingCollision(objectDynamics[i].rect, player.rect))
				{
					objectDynamics[i].Draw(Form.instance.window.getGraphics(), Color.red);
					objectDynamics[i].direction.x *= -1;
					objectDynamics[i].direction.y *= -1;
					objectDynamics[i].rect.x +=  0.5f * objectDynamics[i].direction.x;
					objectDynamics[i].rect.y += 0.5f * objectDynamics[i].direction.y;
					
				}
			}
						
		}
	
	}
	public void CollisionStaticAndPlayerQuadTree() {
		
		for(int i = 0; i< objectStatic.length; i++)
		{
			quadTree.Search(quadTree, player.rect);
			
			if(objectStatic[i].rect.BoundingCollision(objectStatic[i].rect, rectAux))
			{
				if(objectStatic[i].rect.BoundingCollision(objectStatic[i].rect, player.rect))
				{
					
					player.direction.x *= -1;
					player.direction.y *= -1;
					player.rect.x += 0.5f * player.direction.x ;
					player.rect.y += 0.5f * player.direction.y ;
				}
			}
		}
		
	}

	
	public static void CollectionObjects(Rect rects) {
		
		
		rectAux = rects;
		
	}
}
