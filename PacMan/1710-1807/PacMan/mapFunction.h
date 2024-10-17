/*
		THESE ARE THE FUNCTION THAT HAVE THE CONTROL OF THE MAP
*/

// define the dimension of the game pitch	
	#define ROWS 19 // Y coordinates
	#define COLS 18 // X coordinates

// configure the map at the initial condition
	void initMap(); 
	
// check if the map is correctly constructed
	void integrityCheck();

// show the current state of the map
	void displayMap();

// array containing the map itself
	char map[ROWS][COLS];
