package com.mortalpowers.android.openglfpstest;

import android.app.Activity;
import android.widget.Toast;

public class ToastRunnable implements Runnable {
	public String msg = "";
	public Activity context = null;
	public void setMsg(String s) {
		msg = s;
	}
	public void setContext(Activity a) {
		context = a;
	}
	

	public void run() {
		Toast toast = Toast.makeText(context.getApplicationContext(), msg,
				Toast.LENGTH_LONG);
		toast.show();
	}
}
