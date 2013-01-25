package com.mortalpowers.android.openglfpstest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ImageRenderer implements Renderer {

	int curHeight = 0;
	int curWidth = 0;
	double fov = 60f;
	double color = 0f;
	double spin = 0;
	boolean increase = true;
	boolean increaseColor = true;

	long startTime;
	int ticks;
	OpenGLFPSTest parent;

	Group m;

	public ImageRenderer(OpenGLFPSTest c) {
		parent = c;
	}

	@Override
	public void onDrawFrame(GL10 gl) {

		// Time the events
		ticks += 1;
		if (ticks > 300) {
			long duration = System.nanoTime() - startTime;
			float fps = (float)ticks / ((float)duration/1000000000);
			fps = (float)Math.round(fps);
			startTime = System.nanoTime();
			String msg = fps + " fps";
			parent.mUpdateResults.setMsg(msg);

			parent.mUpdateResults.setContext(parent);
			parent.mHandler.post(parent.mUpdateResults);
			ticks = 0;
		}

		// Reset Drawing Surface
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();

		m.draw(gl);

		Mesh c = m.get(0);

		c.ry = (float) spin;
		c.rx = 13f;

		spin += .3f;
		if (spin > 360f) {
			spin -= 360f;
		}

		if (increaseColor) {
			color += 0.04f;
		} else {
			color -= 0.04f;
		}
		if (color < 0f) {
			increaseColor = true;
		}
		if (color > 1f) {
			increaseColor = false;
		}
		c.setColor(1f, (float) color, 1f, 1f);

		gl.glLoadIdentity();

		/** Write OpenGLFPSTest in white */
		gl.glColor4f(1f, 1f, 1f, 1f);
		gl.glTranslatef(-5.0f, 5.0f, -20.0f);
		Letters.F.draw(gl);

		gl.glTranslatef(1.75f, 0.0f, 0.0f);
		Letters.R.draw(gl);

		gl.glTranslatef(1.75f, 0.0f, 0.0f);
		Letters.A.draw(gl);

		gl.glTranslatef(1.75f, 0.0f, 0.0f);
		Letters.M.draw(gl);

		gl.glTranslatef(2.0f, 0.0f, 0.0f);
		Letters.E.draw(gl);

		gl.glTranslatef(-6.0f, -5.0f, 0.0f);
		Letters.R.draw(gl);

		gl.glTranslatef(2.0f, 0.0f, 0.0f);
		Letters.A.draw(gl);

		gl.glTranslatef(1.75f, 0.0f, 0.0f);
		Letters.T.draw(gl);

		gl.glTranslatef(1.75f, 0.0f, 0.0f);
		Letters.E.draw(gl);

		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();

		if (increase) {
			fov += 0.4f;
		} else {
			fov -= 0.4f;
		}
		if (fov < 10f) {
			increase = true;
		}
		if (fov > 70f) {
			increase = false;
		}

		GLU.gluPerspective(gl, (float) fov, (float) curWidth
				/ (float) curHeight, 0.1f, 100.0f);

	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {

		startTime = System.nanoTime();

		curHeight = height;
		curWidth = width;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 60.0f, (float) width / (float) height, 0.1f,
				100.0f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		m = new Group();

		Cube c = new Cube(2f, 2f, 2f);
		c.rgba = new float[] { .5f, .7f, .7f, .5f };
		gl.glTranslatef(0f, -1.2f, -15f);
		c.y = -1.2f;
		c.z = -15f;
		
		for(int i = 0;i<15;i++) {
			Cube brady = new Cube(1.5f, 1.5f, 1.5f);
			brady.rgba = new float[] {.2f,1f,.2f,.5f};
			gl.glTranslatef((float)Math.random(),(float)Math.random(),(float)Math.random());
			brady.z = -(float)Math.random()*3-7f;
			c.y = -1.5f*(float)Math.random();
			c.x = -5f*(float)Math.random();
			m.add(brady);
		}
		
		
		SmileyFace s = new SmileyFace(2f, 2f, .2f);
		s.y = -3f;

		m.add(c);
		m.add(s);

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub

	}

}
