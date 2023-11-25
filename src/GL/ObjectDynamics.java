package GL;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class ObjectDynamics {
	
	Rect rect;
	Random random;
	Point direction = new Point(1,1);
	float speed = 50;
	ObjectStatic[] objectStatic;
	Player player;
	float timerColor = 0;
	float timerColorMax = 0.1f;
	Color color;
	
	public ObjectDynamics(ObjectStatic[] objectStatic,Player player) {
		random = new Random();
		rect = new Rect(random.nextFloat(Form.instance.windowSize.x,Form.instance.windowSize.width - 10),
				        random.nextFloat(Form.instance.windowSize.y,Form.instance.windowSize.height - 10),
				        10,10);
		
		this.objectStatic = objectStatic;
		this.player = player;
		
	}
	
	public void Draw(Graphics g,Color colorAux)
	{
		if(colorAux == Color.red)
		{
			timerColor = 0;
			color = colorAux;
		}
		if(timerColor > timerColorMax)
		{
			color = colorAux;
		}
		g.setColor(color);
		g.fillRect((int)rect.x,(int)rect.y,(int)rect.width,(int)rect.height);
	}
	
	public void Update(float gameTime)
	{
		
		Move(gameTime);
		CollisionObjStatic();
		CollisionPlayer();
		
		timerColor += gameTime;
	}
	private void Move(float gameTime)
	{
		rect.x += direction.x * speed * gameTime ;
		rect.y += direction.y * speed * gameTime ;
		
		if(rect.BorderCollisionX(rect))
		{
			direction.x *= -1;
			rect.x +=  0.5f * direction.x;
		}
		if(rect.BorderCollisionY(rect))
		{
			direction.y *= -1;
			rect.y += 0.5f * direction.y;
		}
		
		
	}
	private void CollisionObjStatic() {
		
		for(int i = 0; i< objectStatic.length; i++)
		{
			if(rect.BoundingCollision(rect,objectStatic[i].rect))
			{
				Draw(Form.instance.window.getGraphics(), Color.red);
				direction.x *= -1;
				direction.y *= -1;
				rect.x +=  0.5f * direction.x;
				rect.y += 0.5f * direction.y;
			}
		}
		
	}
	private void CollisionPlayer() {
		
		
		if(rect.BoundingCollision(rect,player.rect))
		{
			Draw(Form.instance.window.getGraphics(), Color.red);
			direction.x *= -1;
			direction.y *= -1;
			rect.x +=  0.5f * direction.x;
			rect.y += 0.5f * direction.y;
		}
		
		
	}
	

}
