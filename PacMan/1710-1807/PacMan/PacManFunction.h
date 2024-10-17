/*
		THESE ARE THE FUNCTION THAT HAVE THE CONTROL OF PACMAN
*/

/* setting the current position (cp) of PacMan
   in particular these are the starting position */
	int cp_x = 9;
	int cp_y = 13;

/* this counter is used for the activation of the ghost
   in base of the numper of steps PacMan has done */
	int counter = 0; 
	//POSSIBLE SUBJECT TO TOTAL OVERHAUL

// move is the function that allow the game to be run
	void move();
		
		/* these function are the move set of PacMan
		   each one of those checks if is possible to 
		   move in their specified direction and "eats"
		   the "object" that occupies that space */ 
		void up();
		void down();
		void left();
		void right();
