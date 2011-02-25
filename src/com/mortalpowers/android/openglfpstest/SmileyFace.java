package com.mortalpowers.android.openglfpstest;

public class SmileyFace extends Mesh {
	 public SmileyFace(float width, float height, float depth) {
	        width  /= 2;
	        height /= 2;
	        depth  /= 2;
	 
	        float vertices[] = { 
	        		// Left Eye
	        		-width*.1f,.9f*height,-depth, // 0
	        		-width*.2f,.8f*height,-depth, // 1
	        		-width*.3f,.9f*height,-depth, // 2
	        		-width*.2f,height,-depth, // 3
	        		-width*.1f,.9f*height,depth, // 4
	        		-width*.2f,.8f*height,depth, // 5
	        		-width*.3f,.9f*height,depth, // 6
	        		-width*.2f,height,depth, // 7

	        		// Right Eye
	        		width*.1f,.9f*height,-depth, // 8
	        		width*.2f,.8f*height,-depth, // 9
	        		width*.3f,.9f*height,-depth, // 10
	        		width*.2f,height,-depth, // 11
	        		width*.1f,.9f*height,depth, // 12
	        		width*.2f,.8f*height,depth, // 13
	        		width*.3f,.9f*height,depth, // 14
	        		width*.2f,height,depth, // 15

	        		// Mouth
	        		-width,-.7f*height,-depth, //16
	        		-width*.9f,-.75f*height,-depth, //17
	        		-width*.4f,-.9f*height,-depth, //18
	        		width*.4f,-.9f*height,-depth, //19
	        		width*.9f,-.75f*height,-depth, //20
	        		width,-.7f*height,-depth, //21
	        		-width*.6f,-height,-depth, //22
	        		width*.6f,-height,-depth, //23

	        		-width,-.7f*height,depth, //24
	        		-width*.9f,-.75f*height,depth, //25
	        		-width*.4f,-.9f*height,depth, //26
	        		width*.4f,-.9f*height,depth, //27
	        		width*.9f,-.75f*height,depth, //28
	        		width,-.7f*height,depth, //29
	        		width*.6f,-height,depth, //30
	        		-width*.6f,-height,depth, //31
	        };
	 
	        short indices[] = { 0, 4, 5,
	                            0, 5, 1,
	                            1, 5, 6,
	                            1, 6, 2,
	                            2, 6, 7,
	                            2, 7, 3,
	                            3, 7, 4,
	                            3, 4, 0,
	                            4, 7, 6,
	                            4, 6, 5,
	                            3, 0, 1,
	                            3, 1, 2, 
	                            
	        				// Right Eye
	                            8,12,13,
	                            8,13,9,
	                            9,13,14,
	                            9,14,10,
	                            10,14,15,
	                            10,15,11,
	                            11,15,12,
	                            11,12,8,
	                            12,15,14,
	                            12,14,13,
	                            11,8,9,
	                            11,9,10,
	                            
	                            // Mouth front
	                            24,25,26,
	                            25,26,31,
	                            26,27,30,
	                            26,30,31,
	                            27,28,30,
	                            28,29,30
	                            };
	 
	        setIndices(indices);
	        setVertices(vertices);
	    }
}
