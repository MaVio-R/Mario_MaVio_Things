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

	char tmp;
	int odds;
	
	void goUp();
	void goDown();
	void goLeft();
	void goRight();
	
	//red
	int cp_xRed = 9;
	int cp_yRed = 8;
	void red();
	void redMove();
	
	//pink
	int cp_xPink = 9;
	int cp_yPink = 10;
	void pink();
	void pinkMove();
	
	//blue
	int cp_xBlue = 8;
	int cp_yBlue = 10;
	void blue();
	void blueMove();
	
	//orange
	int cp_xOrange = 10;
	int cp_yOrange = 10;
	void orange();
	void orangeMove();

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
			
			if(i == cp_yRed && j == cp_xRed)
				map[i][j] = 'D';
				
			if(i == cp_yPink && j == cp_xPink)
				map[i][j] = 'D';
				
			if(i == cp_yBlue && j == cp_xBlue)
				map[i][j] = 'D';
				
			if(i == cp_yOrange && j == cp_xOrange)
				map[i][j] = 'D';
		}
	}
	
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

void goUp(int* x, int* y)
{
	tmp = map[*y - 1][*x];
	map[*y][x] = tmp;
	map[*y -= 1 ][*x] = 'D';
}

void goDown(int* x, int* y)
{
	tmp = map[*y + 1][*x];
	map[*y][x] = tmp;
	map[*y += 1 ][*x] = 'D';
}

void goLeft(int* x, int* y)
{
	tmp = map[*y][*x - 1];
	map[*y][*x] = tmp;
	map[*y][*x -= 1 ] = 'D';
}

void goRight(int* x, int* y)
{
	tmp = map[*y + 1][*x];
	map[*y][*x] = tmp;
	map[*y][*x += 1] = 'D';
}

void redMove()
{
	odds = rand() % (6 - 0 + 1);
		
	switch(odds)
	{
		case 1:
			if(map[cp_yRed - 1][cp_xRed] != '#')
			{
				goUp(&cp_xRed, &cp_yRed);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
			
		case 3:
			if(map[cp_yRed +1 ][cp_xRed] != '#')
			{
				goDown(&cp_xRed, &cp_yRed);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
			
		case 5:		
			if(map[cp_yRed][cp_xRed - 1] != '#')
			{
				goLeft(&cp_xRed, &cp_yRed);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
		default:
			if(map[cp_yRed][cp_xRed + 1] != '#')
			{
				goRight(&cp_xRed, &cp_yRed);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
	}
}

void pinkMove()
{
	odds = rand() % (6 - 0 + 1);
		
	switch(odds)
	{
		case 2:
			if(map[cp_yPink - 1][cp_xPink] != '#')
			{
				goUp(&cp_xPink, &cp_yPink);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
			
		case 4:
			if(map[cp_yPink +1 ][cp_xPink] != '#')
			{
				goDown(&cp_xPink, &cp_yPink);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
			
		case 6:		
			if(map[cp_yPink][cp_xPink - 1] != '#')
			{
				goRight(&cp_xPink, &cp_yPink);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
		default:
			if(map[cp_yPink][cp_xPink + 1] != '#')
			{
				goLeft(&cp_xPink, &cp_yPink);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
	}
}

void blueMove()
{
	odds = rand() % (6 - 0 + 1);
		
	switch(odds)
	{
		case 1:
			if(map[cp_yBlue - 1][cp_xBlue] != '#')
			{
				goDown(&cp_xBlue, &cp_yBlue);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
			
		case 4:
			if(map[cp_yBlue +1 ][cp_xBlue] != '#')
			{
				goLeft(&cp_xBlue, &cp_yBlue);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
			
		case 5:		
			if(map[cp_yBlue][cp_xBlue - 1] != '#')
			{
				goRight(&cp_xBlue, &cp_yBlue);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
		default:
			if(map[cp_yBlue][cp_xBlue + 1] != '#')
			{
				goUp(&cp_xBlue, &cp_yBlue);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
	}
}

void orangeMove()
{
	odds = rand() % (6 - 0 + 1);
		
	switch(odds)
	{
		case 1:
			if(map[cp_yOrange - 1][cp_xOrange] != '#')
			{
				goDown(&cp_xOrange, &cp_yOrange);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
			
		case 4:
			if(map[cp_yOrange +1 ][cp_xOrange] != '#')
			{
				goLeft(&cp_xOrange, &cp_yOrange);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
			
		case 5:		
			if(map[cp_yOrange][cp_xOrange - 1] != '#')
			{
				goRight(&cp_xOrange, &cp_yOrange);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
		default:
			if(map[cp_yBlue][cp_xBlue + 1] != '#')
			{
				goDown(&cp_xOrange, &cp_yOrange);
				system("cls");
				displayMap();
				break;					
			}
			else
			{
				system("cls");
				displayMap();
				break;
			}
	}
}
