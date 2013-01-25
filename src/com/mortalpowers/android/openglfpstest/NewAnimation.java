package com.mortalpowers.android.openglfpstest;

import android.content.res.Resources;
import android.util.Log;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;


	public class NewAnimation extends RendererActivity {
		private Object3dContainer objModel;

		@Override
		public void initScene() {
			
			Resources res = getResources();
			IParser parser = Parser.createParser(Parser.Type.OBJ,
					res, "com.mortalpowers.android.openglfpstest:raw/monkey_scene_obj", true);
			Log.d("Resources","Stephen Loaded resource: '" + res.toString() + "'");
			parser.parse();
			
			

			objModel = parser.getParsedObject();
			objModel.scale().x = objModel.scale().y = objModel.scale().z = .7f;
			scene.addChild(objModel);
		}

		@Override
		public void updateScene() {
			objModel.rotation().x++;
			objModel.rotation().z++;
		}
}
