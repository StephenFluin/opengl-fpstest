package com.mortalpowers.android.openglfpstest;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;

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

}