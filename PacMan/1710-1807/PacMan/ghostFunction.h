/*
		THESE ARE THE FUNCTION THAT HAVE THE CONTROL OF THE GHOSTS
*/

//movement of the ghost
	
	/*  it needs for the swap of "object that are in the
	 	way of the ghosts, because the ghosts do not eat
		"objects" like PacMan" */
		char tmp;  
	
	/*  it needs for the "AI" of the ghosts.
	 	It is a random number picked in a pool that goes from 1 to 6 
		that "decide" in which direction the ghosts will go */
		int odds;

	/* 	these function are the move set of the ghosts
	    each one of those checks if is possible to 
	    move in their specified direction and swap
	    the "object" that occupies that space with the ghost itself */
		void goUp();
		void goDown();
		void goLeft();
		void goRight();

//red
	/*  setting the current position (cp) of the "RED" ghost
   		in particular these are the starting position */
		int cp_xRed = 9;
		int cp_yRed = 8;
	
	/* 	They are the implementation of the previus seen function
		and they contain the "AI" of the "RED" ghost */
		void redMove();

//pink
	/*  setting the current position (cp) of "PINK" ghost
   		in particular these are the starting position */
		int cp_xPink = 9;
		int cp_yPink = 10;
	
	/* 	They are the implementation of the previus seen function
		and they contain the "AI" of the "PINK" ghost */
		void pinkMove();

//blue
	/*  setting the current position (cp) of "BLUE" ghost
   		in particular these are the starting position */
		int cp_xBlue = 8;
		int cp_yBlue = 10;
		
	/* 	They are the implementation of the previus seen function
		and they contain the "AI" of the "BLUE" ghost */
		void blueMove();

//orange
	/*  setting the current position (cp) of "ORANGE" ghost
   		in particular these are the starting position */
		int cp_xOrange = 10;
		int cp_yOrange = 10;
		
	/* 	They are the implementation of the previus seen function
		and they contain the "AI" of the "ORANGE" ghost */
		void orangeMove();
