package GL;

enum SCENE_MANAGER{
	MENU,
	LEVEL1,
	LEVEL2
}

public class Game1 extends GameLoop {
	
	
	Form form;
	Menu menu;
	Level1 level1;
	Level2 level2;
	SCENE_MANAGER scene;
		
	public void Start() {
		
		form = new Form();
		scene = SCENE_MANAGER.MENU;
		menu = new Menu(form,this);
		level1 = new Level1(this);
		level2 = new Level2(this);
		
	}
	
	public void Update(float gameTime) {
		
		form.Update(gameTime);
		UpdateScene(gameTime);
		
	}
	public void Draw() {
		
		DrawScene();
		
	}
	
	private void UpdateScene(float gameTime) {
		
		switch(scene) {
		case MENU:
			menu.Update(gameTime);
			break;
		case LEVEL1:
			level1.Update(gameTime);
			
			break;
		case LEVEL2:
			level2.Update(gameTime);
			break;
		}
	}
	private void DrawScene() {
		
		switch(scene) {
		case MENU:
			menu.Draw();
			break;
		case LEVEL1:
			level1.Draw();
			form.Draw();
			break;
		case LEVEL2:
			level2.Draw();
			form.Draw();
			break;
		}
	}
}
