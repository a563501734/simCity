package com.dance.simCity;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.*;
import javax.microedition.khronos.opengles.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.assets.*;

public class Main implements ApplicationListener{
	private ShapeRenderer sr;
	private Interface stage;
	static AssetManager r;
	{
		r=new AssetManager();
	}
	int swidth;
	int sheight;
	public void create(){
		sr=new ShapeRenderer();
		Interface.main=this;
		MainLogoStage ms=new MainLogoStage();
		setStage(ms);
	}
	public void render(){
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
		if(stage==null){
			return;
		}
		Camera cam=stage.getCamera();
		if(cam==null){
			return;
		}
		stage.render();
		sr.begin(ShapeRenderer.ShapeType.Line);
		sr.setProjectionMatrix(cam.combined);
		sr.setColor(Color.RED);
		sr.line(0,0,0,999,0,0);
		sr.setColor(Color.BLUE);
		sr.line(0,0,0,0,999,0);
		sr.setColor(Color.GREEN);
		sr.line(0,0,0,0,0,999);
		sr.setColor(Color.WHITE);
		sr.box(0,0,0,1,1,1);
		sr.end();
	}
	public void dispose(){
		sr.dispose();
		//resource销毁
		
	}
	public void resize(int width,int height){
		swidth=width;
		sheight=height;
		Gdx.gl.glViewport(0,0,width,height);
		sr.updateMatrices();
		stage.resize(width,height);
	}
	public void setStage(Interface st){
		if(stage!=null)
			this.stage.dispose();
		this.stage=st;
		st.resize(swidth,sheight);
	}
	public void pause(){
	}
	public void resume(){
	}
}
