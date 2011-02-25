package com.mortalpowers.android.hellogl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.util.Log;

public class HelloRenderer implements Renderer {

	int curHeight = 0;
	int curWidth = 0;
	double fov = 60f;
	double color = 0f;
	double spin = 0;
	boolean increase = true;
	boolean increaseColor = true;

	Group m;

	@Override
	public void onDrawFrame(GL10 gl) {
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

		/** Write Hello in white */
		gl.glColor4f(1f, 1f, 1f, 1f);
		gl.glTranslatef(-4.0f, 5.0f, -20.0f);
		Letters.H.draw(gl);

		gl.glTranslatef(2.0f, 0.0f, 0.0f);
		Letters.E.draw(gl);

		gl.glTranslatef(1.5f, 0.0f, 0.0f);
		Letters.L.draw(gl);

		gl.glTranslatef(1.5f, 0.0f, 0.0f);
		Letters.L.draw(gl);

		gl.glTranslatef(1.5f, 0.0f, 0.0f);
		Letters.O.draw(gl);

		gl.glTranslatef(-7.0f, -5.0f, 0.0f);
		Letters.W.draw(gl);

		gl.glTranslatef(2.5f, 0.0f, 0.0f);
		Letters.O.draw(gl);

		gl.glTranslatef(2.0f, 0.0f, 0.0f);
		Letters.R.draw(gl);

		gl.glTranslatef(2.0f, 0.0f, 0.0f);
		Letters.L.draw(gl);

		gl.glTranslatef(1.5f, 0.0f, 0.0f);
		Letters.D.draw(gl);

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
		Log.d("render", "value is " + fov);

	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
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
		SmileyFace s = new SmileyFace(2f,2f,.2f);
		s.y = -3f;
		
		
		m.add(c);
		m.add(s);

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub

	}

}
