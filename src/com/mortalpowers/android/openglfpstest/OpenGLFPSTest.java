package com.mortalpowers.android.openglfpstest;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class OpenGLFPSTest extends Activity {

	public final Handler mHandler = new Handler();

	// Create runnable for posting
	public final ToastRunnable mUpdateResults = new ToastRunnable();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GLSurfaceView drawSurface = new GLSurfaceView(this);
		drawSurface.setRenderer(new ImageRenderer(this));
		setContentView(drawSurface);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_select_alternate:
			
			return true;
		case R.id.menu_quit:
			finish();
			return true;
		}
		return false;
	}

}