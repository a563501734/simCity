package com.dance.simCity;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.g2d.freetype.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Re{
	static Skin skin;
	{
		skin=new Skin(Gdx.files.internal("skin/skin/clean-crispy-ui.json"));
	}
	public static BitmapFont getFont(String chars,int pixelSize){
		FreeTypeFontGenerator ge=new FreeTypeFontGenerator(Gdx.files.internal("fnt/fnt.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter param=new FreeTypeFontGenerator.FreeTypeFontParameter();
		param.size=pixelSize;
		param.characters=chars;
		BitmapFont bf=ge.generateFont(param);
		return bf;
	}
	public static void scaleTo(BitmapFont bf,float targetSize){
		bf.getData().setScale(1);
		float rate=targetSize/bf.getData().lineHeight;
		bf.getData().setScale(rate);
	}
	public static float calcTextWidth(BitmapFont bf,String tex){
		bf.getData();
		return 0;
	}
}
