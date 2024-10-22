#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <ctype.h>

//PacMan
#include "PacManFunction.h"	

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
	
	for( i=0; i<ROWS; i++)
	{
		for( j=0; j<COLS; j++)
		{
			if( i == 0 || i == ROWS -1 || j == 0 || j == COLS - 1)
				map[i][j] = '#';
			else
				map[i][j] = ' ';	
			
			if(i == cp_y && j == cp_x)
				map[i][j] = 'C';
			
			if(i == cp_yRed && j == cp_xRed)
				map[i][j] = 'R';
				
			if(i == cp_yPink && j == cp_xPink)
				map[i][j] = 'P';
				
			if(i == cp_yBlue && j == cp_xBlue)
				map[i][j] = 'B';
				
			if(i == cp_yOrange && j == cp_xOrange)
				map[i][j] = 'O';
		}
	}
	
}

void integrityCheck()
{
	int i, j;
	
	for( i=ROWS; i==ROWS; i++)
	{
		for( j=0; j<=COLS; j++)
		{
			map[i][j] = '#';
		}
	}
	
}

void displayMap()
{
	int i, j;
	
	for( i=0; i<ROWS; i++)
	{
		for( j=0; j<COLS; j++)
		{
			printf("%c ", map[i][j]);
		}
		printf("\n");
	}
	//printf("%c", map[ROWS][2]);
	//integrityCheck();
	fflush(stdout);
}

void goUp(int* x, int* y, char ghost)
{
	map[*y][*x] = map[*y - 1][*x];
	map[*y -= 1 ][*x] = ghost;	
	
}

void goDown(int* x, int* y, char ghost)
{
	map[*y][*x] = map[*y + 1][*x];
	map[*y += 1 ][*x] = ghost;
}

void goLeft(int* x, int* y, char ghost)
{
	map[*y][*x] = map[*y][*x - 1];
	map[*y][*x -= 1 ] = ghost;

}

void goRight(int* x, int* y, char ghost)
{
	map[*y][*x] = map[*y + 1][*x];
	map[*y][*x += 1] = ghost;
}

void redMove()
{
	odds = rand() % (6 - 0 + 1);
		
	switch(odds)
	{
		case 1:
			if(map[cp_yRed - 1][cp_xRed] != '#' || map[cp_yRed - 1][cp_xRed] != 'C' || map[cp_yRed - 1][cp_xRed] != 'P'|| map[cp_yRed - 1][cp_xRed] != 'B' || map[cp_yRed - 1][cp_xRed] != 'O')
			{
				goUp(&cp_xRed, &cp_yRed, 'R');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 3:
			if(map[cp_yRed + 1 ][cp_xRed] != '#' || map[cp_yRed + 1 ][cp_xRed] != 'C' || map[cp_yRed + 1 ][cp_xRed] != 'P' || map[cp_yRed + 1 ][cp_xRed] != 'B' || map[cp_yRed + 1 ][cp_xRed] != 'O')
			{
				goDown(&cp_xRed, &cp_yRed, 'R');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;

		case 5:		
			if(map[cp_yRed][cp_xRed - 1] != '#' || map[cp_yRed][cp_xRed - 1] != 'C' || map[cp_yRed][cp_xRed - 1] != 'P' || map[cp_yRed][cp_xRed - 1] != 'B' || map[cp_yRed][cp_xRed - 1] != 'O' )
			{
				goLeft(&cp_xRed, &cp_yRed, 'R');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
				
		default:
			if(map[cp_yRed][cp_xRed + 1] != '#' || map[cp_yRed][cp_xRed + 1] != 'C' || map[cp_yRed][cp_xRed + 1] != 'P' || map[cp_yRed][cp_xRed + 1] != 'B' || map[cp_yRed][cp_xRed + 1] != 'O')
			{
				goRight(&cp_xRed, &cp_yRed, 'R');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
	}
}

void pinkMove()
{
	odds = rand() % (6 - 0 + 1);
		
	switch(odds)
	{
		case 2:
			if(map[cp_yPink - 1][cp_xPink] != '#' || map[cp_yPink - 1][cp_xPink] != 'C' || map[cp_yPink - 1][cp_xPink] != 'R' || map[cp_yPink - 1][cp_xPink] != 'B' || map[cp_yPink - 1][cp_xPink] != 'O')
			{
				goUp(&cp_xPink, &cp_yPink, 'P');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 4:
			if(map[cp_yPink + 1 ][cp_xPink] != '#' || map[cp_yPink + 1 ][cp_xPink] != 'C' || map[cp_yPink + 1 ][cp_xPink] != 'R' || map[cp_yPink + 1 ][cp_xPink] != 'B' || map[cp_yPink + 1 ][cp_xPink] != 'O')
			{
				goDown(&cp_xPink, &cp_yPink, 'P');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 6:		
			if(map[cp_yPink][cp_xPink + 1] != '#' || map[cp_yPink][cp_xPink + 1] != 'C' || map[cp_yPink][cp_xPink + 1] != 'R' || map[cp_yPink][cp_xPink + 1] != 'B' || map[cp_yPink][cp_xPink + 1] != 'O')
			{
				goRight(&cp_xPink, &cp_yPink, 'P');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
				
		default:
			if(map[cp_yPink][cp_xPink - 1] != '#' || map[cp_yPink][cp_xPink - 1] != 'C' || map[cp_yPink][cp_xPink - 1] != 'R' || map[cp_yPink][cp_xPink - 1] != 'B' || map[cp_yPink][cp_xPink - 1] != 'O')
			{
				goLeft(&cp_xPink, &cp_yPink, 'P');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
	}
}

void blueMove()
{
	odds = rand() % (6 - 0 + 1);
		
	switch(odds)
	{
		case 1:
			if(map[cp_yBlue + 1][cp_xBlue] != '#' || map[cp_yBlue + 1][cp_xBlue] != 'C' || map[cp_yBlue + 1][cp_xBlue] != 'R' || map[cp_yBlue + 1][cp_xBlue] != 'P' || map[cp_yBlue + 1][cp_xBlue] != 'O')
			{
				goDown(&cp_xBlue, &cp_yBlue, 'B');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 4:
			if(map[cp_yBlue][cp_xBlue - 1] != '#' || map[cp_yBlue][cp_xBlue - 1] != 'C' || map[cp_yBlue][cp_xBlue - 1] != 'R' || map[cp_yBlue][cp_xBlue - 1] != 'P' || map[cp_yBlue][cp_xBlue - 1] != 'O')
			{
				goLeft(&cp_xBlue, &cp_yBlue, 'B');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 5:		
			if(map[cp_yBlue][cp_xBlue + 1] != '#' || map[cp_yBlue][cp_xBlue + 1] != 'C' || map[cp_yBlue][cp_xBlue + 1] != 'R' || map[cp_yBlue][cp_xBlue + 1] != 'P' || map[cp_yBlue][cp_xBlue + 1] != 'O')
			{
				goRight(&cp_xBlue, &cp_yBlue, 'B');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
				
		default:
			if(map[cp_yBlue - 1][cp_xBlue] != '#' || map[cp_yBlue - 1][cp_xBlue] != 'C' || map[cp_yBlue - 1][cp_xBlue] != 'R' || map[cp_yBlue - 1][cp_xBlue] != 'P' || map[cp_yBlue - 1][cp_xBlue] != 'O')
			{
				goUp(&cp_xBlue, &cp_yBlue, 'B');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
	}
}

void orangeMove()
{
	odds = rand() % (6 - 0 + 1);
		
	switch(odds)
	{
		case 1:
			if(map[cp_yOrange + 1][cp_xOrange] != '#' || map[cp_yOrange + 1][cp_xOrange] != 'C' || map[cp_yOrange + 1][cp_xOrange] != 'R' || map[cp_yOrange + 1][cp_xOrange] != 'P' || map[cp_yOrange + 1][cp_xOrange] != 'B')
			{
				goDown(&cp_xOrange, &cp_yOrange, 'O');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 4:
			if(map[cp_yOrange][cp_xOrange - 1] != '#' || map[cp_yOrange][cp_xOrange - 1] != 'C' || map[cp_yOrange][cp_xOrange - 1] != 'R' || map[cp_yOrange][cp_xOrange - 1] != 'P' || map[cp_yOrange][cp_xOrange - 1] != 'B')
			{
				goLeft(&cp_xOrange, &cp_yOrange, 'O');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 5:		
			if(map[cp_yOrange][cp_xOrange + 1] != '#' || map[cp_yOrange][cp_xOrange + 1] != 'C' || map[cp_yOrange][cp_xOrange + 1] != 'R' || map[cp_yOrange][cp_xOrange + 1] != 'P' || map[cp_yOrange][cp_xOrange + 1] != 'B')
			{
				goRight(&cp_xOrange, &cp_yOrange, 'O');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
				
		default:
			if(map[cp_yOrange + 1][cp_xOrange] != '#' || map[cp_yOrange + 1][cp_xOrange] != 'C' || map[cp_yOrange + 1][cp_xOrange] != 'R' || map[cp_yOrange + 1][cp_xOrange] != 'P' || map[cp_yOrange + 1][cp_xOrange] != 'B')
			{
				goDown(&cp_xOrange, &cp_yOrange, 'O');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
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

void move()
{
	int click;
	
	while(click != 27)
	{
		click = tolower(getch());
		
		counter++;
		
		if(counter <= 15)
			redMove();
		else if(counter <= 30)
			{
				redMove();
				pinkMove();
			}
			else if (counter<= 45)
				{
					redMove();
					pinkMove();
					blueMove();
				}
				else
				{
					redMove();
					pinkMove();
					blueMove();
					orangeMove();
				}
			
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
