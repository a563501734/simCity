package com.dance.simCity;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.graphics.g2d.freetype.*;
import com.badlogic.gdx.assets.loaders.*;
public class Game extends Interface{
	Stage stage;
	Game(){
		Gdx.gl.glClearColor(0,0,0,0);
		stage=new Stage();
		Table tab=new Table();
		tab.setDebug(true);
		tab.setFillParent(true);
		TextButton btn=new TextButton("Begin",Re.skin.get(TextButton.TextButtonStyle.class));
		btn.addListener(new ClickListener(){
			public void clicked(InputEvent i,float x,float y){
				main.setStage(new World());
			}
		});
		btn.getStyle().font.getData().scale(3);
		tab.add(btn).spaceBottom(4).size(400,70).row();
		TextField ok=new TextField("开始游戏",Re.skin.get(TextField.TextFieldStyle.class));
		tab.add(ok);
		Touchpad tp=new Touchpad(100,Re.skin.get(Touchpad.TouchpadStyle.class));
		tp.setWidth(300);
		tp.setHeight(300);
		tab.center().addActor(tp);
		stage.addActor(tab);
		Gdx.input.setInputProcessor(stage);
	}
	public void render(){
		/*
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setProjectionMatrix(stage.getCamera().combined);
		sr.setColor(Color.BLUE);
		sr.rect(tab.getX(),40,2,2);
		sr.end();
		*/
		stage.act();
		stage.draw();
	}
	public void dispose(){
		stage.dispose();
	}
	public Camera getCamera(){
		return stage.getCamera();
	}
	//最大高宽比2，大于此高宽比的屏幕将无法正常显示
	public void resize(int width,int height){
		stage.getViewport().update(width,height);
	}
}
