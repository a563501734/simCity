package com.dance.simCity;
import android.content.*;
import android.widget.*;
import java.io.*;

public class ShowLogger extends BroadcastReceiver{
	public void onReceive(Context ctx,Intent data){
		String d=data.getStringExtra(Log.data_key);
		if(d!=null){
			Toast.makeText(ctx,d,Toast.LENGTH_SHORT).show();
		}
	}
}
