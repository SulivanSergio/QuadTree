package GL;

enum SCENE_MANAGER{
	MENU,
	LEVEL1,
	LEVEL2
}

public class Game1 extends GameLoop {
	
	
	Form form;
	Level1 level1;
	SCENE_MANAGER scene;
		
	public void Start() {
		
		form = new Form();
		scene = SCENE_MANAGER.LEVEL1;
		level1 = new Level1();
		
		
	}
	
	public void Update(float gameTime) {
		
		form.Update(gameTime);
		UpdateScene(gameTime);
		
	}
	public void Draw() {
		
		
		form.Draw();
		DrawScene();
		
	}
	
	private void UpdateScene(float gameTime) {
		
		switch(scene) {
		case LEVEL1:
			level1.Update(gameTime);
			break;
		}
	}
	private void DrawScene() {
		
		switch(scene) {
		case LEVEL1:
			level1.Draw();
			break;
		}
	}
}
