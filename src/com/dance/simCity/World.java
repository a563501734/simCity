package com.dance.simCity;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.files.*;

public class World extends Interface{
	Camera cam;
	Stage ui;
	SpriteBatch sb;
	Texture txt;
	Animation<TextureRegion>anim;
	Animation<TextureRegion>left;
	Animation<TextureRegion>up;
	Animation<TextureRegion>down;
	public World(){
		cam=new OrthographicCamera();
		ui=new Stage();
		final Touchpad tp=new Touchpad(200,Re.skin.get(Touchpad.TouchpadStyle.class));
		tp.setWidth(500);
		tp.setDeadzone(50);
		tp.setHeight(500);
		ui.addActor(tp);
		tp.addListener(new ChangeListener(){
			public void changed(ChangeListener.ChangeEvent e,Actor act){
				
			}
		});
		Gdx.input.setInputProcessor(ui);
		sb=new SpriteBatch();
		txt=new Texture("act/move.png");
		TextureRegion[]tr=new TextureRegion[4];
		for(int i=0;i<4;i++){
			tr[i]=new TextureRegion(txt,i*32,0,32,48);
		}
		down=new Animation<>(0.3f,tr);
		down.setPlayMode(Animation.PlayMode.LOOP);
	}
	float l;
	public void render(){
		l+=Gdx.graphics.getDeltaTime();
		TextureRegion t=down.getKeyFrame(l);
		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		sb.draw(t,0,0,0.4f,0.6f);
		sb.end();
		ui.act();
		ui.draw();
	}
	public Camera getCamera(){
		
		return cam;
	}
	public void dispose(){
		
	}
	public void resize(int width,int height){
		ui.getViewport().update(width,height);
		float rate=width*1f/height;
		cam.viewportHeight=10;
		cam.viewportWidth=cam.viewportHeight*rate;
		cam.update();
	}
}
