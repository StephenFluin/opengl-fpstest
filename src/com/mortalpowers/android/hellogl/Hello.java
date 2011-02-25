package com.mortalpowers.android.hellogl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class Hello extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLSurfaceView drawSurface = new GLSurfaceView(this);
        drawSurface.setRenderer(new HelloRenderer());
        setContentView(drawSurface);
    }
}