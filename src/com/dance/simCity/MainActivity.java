package com.dance.simCity;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import android.content.*;
import android.view.*;
import android.widget.TableLayout.*;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(
			WindowManager.LayoutParams.FLAG_FULLSCREEN
		);
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Intent i=new Intent(this,Log.class);
		startService(i);
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		Main main=new Main();
        View v=initializeForView(main, cfg);
		LayoutParams lp=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		addContentView(v,lp);
    }
	
}
