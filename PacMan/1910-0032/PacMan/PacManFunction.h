/*
		THESE ARE THE FUNCTION THAT HAVE THE CONTROL OF THE MAP
*/

// define the dimension of the game pitch	
	#define ROWS 19 // Y coordinates
	#define COLS 17 // X coordinates


// configure the map at the initial condition
	void initMap(); 
	
// check if the map is correctly constructed
	void integrityCheck();

// show the current state of the map
	void displayMap();

// array containing the map itself
	char map[ROWS][COLS];

/*
		THESE ARE THE FUNCTION THAT HAVE THE CONTROL OF PACMAN
*/

/* setting the current position (cp) of PacMan
   in particular these are the starting position */
	int cp_x = 8;
	int cp_y = 14;

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
		
/*
		THESE ARE THE FUNCTION THAT HAVE THE CONTROL OF THE GHOSTS
*/

//movement of the ghost
	
	/*  it needs for the swap of "object that are in the
	 	way of the ghosts, because the ghosts do not eat
		"objects" like PacMan" */
		//char tmp;  
	
	/*  it needs for the "AI" of the ghosts.
	 	It is a random number picked in a pool that goes from 1 to 6 
		that "decide" in which direction the ghosts will go */
		int odds;

	/* 	these function are the move set of the ghosts
	    each one of those checks if is possible to 
	    move in their specified direction and swap
	    the "object" that occupies that space with the ghost itself */
		void goUp(int** x, int** y, char ghost);
		void goDown(int** x, int** y, char ghost);
		void goLeft(int** x, int** y, char ghost);
		void goRight(int** x, int** y, char ghost);

//red
	/*  setting the current position (cp) of the "RED" ghost
   		in particular these are the starting position */
		int cp_xRed = 8;
		int cp_yRed = 7;

//pink
	/*  setting the current position (cp) of "PINK" ghost
   		in particular these are the starting position */
		int cp_xPink = 8;
		int cp_yPink = 9;

//blue
	/*  setting the current position (cp) of "BLUE" ghost
   		in particular these are the starting position */
		int cp_xBlue = 7;
		int cp_yBlue = 9;
		
//orange
	/*  setting the current position (cp) of "ORANGE" ghost
   		in particular these are the starting position */
		int cp_xOrange = 9;
		int cp_yOrange = 9;
		
	/* 	They are the implementation of the previus seen function
		and they contain the "AI" of the ghosts */
	    void MoveGhosts(int* x, int* y, char ghost);
		
