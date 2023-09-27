package GL;



public class Game1 extends GameLoop {
	
	
	Form form;
	
	
		
	public void Start() {
		
		form = new Form();
		
	}
	public void Input() {
		
	}
	public void Update(float gameTime) {
		
		form.Update(gameTime);
	}
	public void Draw() {
		
		
		form.Draw();
		
		
	}
	
}
