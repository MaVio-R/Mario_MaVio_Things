#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <ctype.h>

//Mappa
	#define ROWS 19 // Y coordinates
	#define COLS 18 // X coordinates
	
	void initMap();
	void displayMap();
	
	char map[ROWS][COLS];

//PacMan
	int cp_x = 9;
	int cp_y = 13;
	
	void move();
	
	void up();
	void down();
	void left();
	void right();

//ghosts

	//red
	int cp_xRed = 9;
	int cp_yRed = 8;
	void red();
	
	//pink
	int cp_xPink = 9;
	int cp_yPink = 10;
	void pink();
	
	//blue
	int cp_xBlue = 8;
	int cp_yBlue = 10;
	void blue();
	
	//orange
	int cp_xOrange = 10;
	int cp_yOrange = 10;
	void orange();

	//ghost movement
	void ghostMove();

int main()
{
	initMap();
	displayMap();
	
	move();
	return 0;
}

void initMap()
{
	int i, j;
	
	for( i=0; i<=ROWS; i++)
	{
		for( j=0; j<=COLS; j++)
		{
			if( i == 0 || i == ROWS || j == 0 || j == COLS)
				map[i][j] = '#';
			else
				map[i][j] = ' ';	
			
			if(i == cp_y && j == cp_x)
				map[i][j] = 'C';
		}
	}
	
	red();
	pink();
	blue();
	orange();
	
}

void displayMap()
{
	int i, j;
	
	for( i=0; i<=ROWS; i++)
	{
		for( j=0; j<=COLS; j++)
		{
			printf("%c ", map[i][j]);
		}
		printf("\n");
	}
}

void move()
{
	int click;
	
	while(click != 27)
	{
		click = getch();
		
		switch(click)
		{
			case 'w':
				up();
				system("cls");
				displayMap();
				break;
			
			case 's':
				down();
				system("cls");
				displayMap();
				break;		
			
			case 'a':
				left();
				system("cls");
				displayMap();
				break;		
			
			case 'd':
				right();
				system("cls");
				displayMap();
				break;
				
			default:
				system("cls");
				displayMap();
				break;
		}
	}
}

void up()
{
	if(map[cp_y - 1][cp_x] != '#')
	{
		map[cp_y][cp_x] = ' ';
		map[cp_y -= 1][cp_x] = 'C';
	}
}

void down()
{
	if(map[cp_y + 1][cp_x] != '#')
	{
		map[cp_y][cp_x] = ' ';
		map[cp_y += 1][cp_x] = 'C';
	}
}

void left()
{
	if(map[cp_y][cp_x - 1] != '#')
	{
		map[cp_y][cp_x] = ' ';
		map[cp_y][cp_x -= 1] = 'C';
	}
}

void right()
{
	if(map[cp_y][cp_x + 1] != '#')
	{
		map[cp_y][cp_x] = ' ';
		map[cp_y][cp_x += 1] = 'C';
	}	
}

void red()
{
	map[cp_yRed][cp_xRed] = 'D';
}

void pink()
{
	map[cp_yPink][cp_xPink] = 'D';
}

void blue()
{
	map[cp_yBlue][cp_xBlue] = 'D';
}

void orange()
{
	map[cp_yOrange][cp_xOrange] = 'D';
}

void ghostMove()
{
	
}
