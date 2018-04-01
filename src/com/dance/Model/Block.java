package com.dance.Model;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Block{
	//所有方格均为一格大小
	private Body body;
	private TextureRegion tex;
	private TextureRegion sel;
	private boolean selected;
	public void draw(SpriteBatch sb){
		sb.begin();
		sb.draw(selected?sel:tex,body.getPosition().x,body.getPosition().y,1,1);
		sb.end();
	}
}
