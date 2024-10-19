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
	
    map[6][1] = '#';
    map[8][1] = '#';
    map[10][1] = '#';
    map[12][1] = '#';
    map[2][2] = '#';
    map[4][2] = '#';
    map[6][2] = '#';
    map[7][2] = '#';
    map[8][2] = '#';
    map[10][2] = '#';
    map[11][2] = '#';
    map[12][2] = '#';
    map[14][2] = '#';
    map[15][2] = '#';
    map[16][2] = '#';
    map[2][3] = '#';
    map[14][3] = '#';
    map[4][4] = '#';
    map[5][4] = '#';
    map[6][4] = '#';
    map[7][4] = '#';
    map[8][4] = '#';
    map[10][4] = '#';
    map[11][4] = '#';
    map[12][4] = '#';
    map[16][4] = '#';
    map[2][5] = '#';
    map[6][5] = '#';
    map[14][5] = '#';
    map[16][5] = '#';
    map[2][6] = '#';
    map[3][6] = '#';
    map[8][6] = '#';
    map[9][6] = '#';
    map[10][6] = '#';
    map[14][6] = '#';
    map[5][7] = '#';
    map[8][7] = '#';
    map[10][7] = '#';
    map[12][7] = '#';
    map[16][7] = '#';
    map[1][8] = '#';
    map[2][8] = '#';
    map[3][8] = '#';
    map[5][8] = '#';
    map[6][8] = '#';
    map[10][8] = '#';
    map[12][8] = '#';
    map[13][8] = '#';
    map[15][8] = '#';
    map[16][8] = '#';
    map[5][9] = '#';
    map[8][9] = '#';
    map[10][9] = '#';
    map[12][9] = '#';
    map[16][9] = '#';
    map[2][10] = '#';
    map[3][10] = '#';
    map[8][10] = '#';
    map[9][10] = '#';
    map[10][10] = '#';
    map[14][10] = '#';
    map[2][11] = '#';
    map[6][11] = '#';
    map[14][11] = '#';
    map[16][11] = '#';
    map[4][12] = '#';
    map[5][12] = '#';
    map[6][12] = '#';
    map[7][12] = '#';
    map[8][12] = '#';
    map[10][12] = '#';
    map[11][12] = '#';
    map[12][12] = '#';
    map[16][12] = '#';
    map[2][13] = '#';
    map[14][13] = '#';
    map[2][14] = '#';
    map[4][14] = '#';
    map[6][14] = '#';
    map[7][14] = '#';
    map[8][14] = '#';
    map[10][14] = '#';
    map[11][14] = '#';
    map[12][14] = '#';
    map[14][14] = '#';
    map[15][14] = '#';
    map[16][14] = '#';
    map[6][15] = '#';
    map[8][15] = '#';
    map[10][15] = '#';
    map[12][15] = '#';
    map[7][0] = ' ';
    map[9][0] = ' ';
    map[11][0] = ' ';
    map[7][16] = ' ';
    map[9][16] = ' ';
    map[11][16] = ' ';

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


void goRight(int* x, int* y, char ghost)
{
	if(*x + 1 == COLS ){
	    map[*y][*x] = map[*y][0];
	    *x = 0;
	    map[*y][*x] = ghost;
	}else{
	    if(map[*y][*x + 1] != '#'){
	        map[*y][*x] = map[*y][*x + 1];
	        map[*y][*x += 1] = ghost;
	    }
	}
}

void goLeft(int* x, int* y, char ghost)
{
	if(*x == 0){
	        
	    map[*y][*x] = map[*y][COLS - 1];
	    *x = COLS - 1;
	    map[*y][*x] = ghost;
	}else {
	if(map[*y][*x - 1] != '#'){
    	map[*y][*x] = map[*y][*x - 1];
	    map[*y][*x -= 1 ] = ghost;
	}
}

}

void redMove()
{
	odds = rand() % (4 - 0 + 1);
	switch(odds)
	{
		case 1:
			if(map[cp_yRed - 1][cp_xRed] != '#' && map[cp_yRed - 1][cp_xRed] != 'C' && map[cp_yRed - 1][cp_xRed] != 'P' && map[cp_yRed - 1][cp_xRed] != 'B' && map[cp_yRed - 1][cp_xRed] != 'O')
			{
				goUp(&cp_xRed, &cp_yRed, 'R');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 3:
			if(map[cp_yRed + 1 ][cp_xRed] != '#' && map[cp_yRed + 1 ][cp_xRed] != 'C' && map[cp_yRed + 1 ][cp_xRed] != 'P' && map[cp_yRed + 1 ][cp_xRed] != 'B' && map[cp_yRed + 1 ][cp_xRed] != 'O' )
			{
				goDown(&cp_xRed, &cp_yRed, 'R');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;

		case 2:		
			if(map[cp_yRed][cp_xRed - 1] != 'C' && map[cp_yRed][cp_xRed - 1] != 'P' && map[cp_yRed][cp_xRed - 1] != 'B' && map[cp_yRed][cp_xRed - 1] != 'O' )
			{
				goLeft(&cp_xRed, &cp_yRed, 'R');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
				
		default:
			if(map[cp_yRed][cp_xRed + 1] != 'C' && map[cp_yRed][cp_xRed + 1] != 'P' && map[cp_yRed][cp_xRed + 1] != 'B' && map[cp_yRed][cp_xRed + 1] != 'O')
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
	odds = rand() % (4 - 0 + 1);
		
	switch(odds)
	{
		case 2:
			if(map[cp_yPink - 1][cp_xPink] != '#' && map[cp_yPink - 1][cp_xPink] != 'C' && map[cp_yPink - 1][cp_xPink] != 'R' && map[cp_yPink - 1][cp_xPink] != 'B' && map[cp_yPink - 1][cp_xPink] != 'O')
			{
				goUp(&cp_xPink, &cp_yPink, 'P');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 4:
			if(map[cp_yPink + 1 ][cp_xPink] != '#' && map[cp_yPink + 1 ][cp_xPink] != 'C' && map[cp_yPink + 1 ][cp_xPink] != 'R' && map[cp_yPink + 1 ][cp_xPink] != 'B' && map[cp_yPink + 1 ][cp_xPink] != 'O' )
			{
				goDown(&cp_xPink, &cp_yPink, 'P');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 1:		
			if(map[cp_yPink][cp_xPink + 1] != 'C' && map[cp_yPink][cp_xPink + 1] != 'R' && map[cp_yPink][cp_xPink + 1] != 'B' && map[cp_yPink][cp_xPink + 1] != 'O')
			{
				goRight(&cp_xPink, &cp_yPink, 'P');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
				
		default:
			if(map[cp_yPink][cp_xPink - 1] != 'C' && map[cp_yPink][cp_xPink - 1] != 'R' && map[cp_yPink][cp_xPink - 1] != 'B' && map[cp_yPink][cp_xPink - 1] != 'O')
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
	odds = rand() % (4 - 0 + 1);
		
	switch(odds)
	{
		case 1:
			if(map[cp_yBlue + 1][cp_xBlue] != '#' && map[cp_yBlue + 1][cp_xBlue] != 'C' && map[cp_yBlue + 1][cp_xBlue] != 'R' && map[cp_yBlue + 1][cp_xBlue] != 'P' && map[cp_yBlue + 1][cp_xBlue] != 'O' )
			{
				goDown(&cp_xBlue, &cp_yBlue, 'B');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 4:
			if(map[cp_yBlue][cp_xBlue - 1] != 'C' && map[cp_yBlue][cp_xBlue - 1] != 'R' && map[cp_yBlue][cp_xBlue - 1] != 'P' && map[cp_yBlue][cp_xBlue - 1] != 'O')
			{
				goLeft(&cp_xBlue, &cp_yBlue, 'B');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 2:		
			if(map[cp_yBlue][cp_xBlue + 1] != 'C' && map[cp_yBlue][cp_xBlue + 1] != 'R' && map[cp_yBlue][cp_xBlue + 1] != 'P' && map[cp_yBlue][cp_xBlue + 1] != 'O')
			{
				goRight(&cp_xBlue, &cp_yBlue, 'B');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
				
		default:
			if(map[cp_yBlue - 1][cp_xBlue] != '#' &&  map[cp_yBlue - 1][cp_xBlue] != 'C' && map[cp_yBlue - 1][cp_xBlue] != 'R' && map[cp_yBlue - 1][cp_xBlue] != 'P' && map[cp_yBlue - 1][cp_xBlue] != 'O')
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
	odds = rand() % (4 - 0 + 1);
		
	switch(odds)
	{
		case 1:
			if( (map[cp_yOrange - 1][cp_xOrange] != '#' ) && (map[cp_yOrange - 1][cp_xOrange] != 'C') && (map[cp_yOrange - 1][cp_xOrange] != 'R') && (map[cp_yOrange - 1][cp_xOrange] != 'P') && (map[cp_yOrange - 1][cp_xOrange] != 'B'))
			{
				goUp(&cp_xOrange, &cp_yOrange, 'O');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 4:
			if((map[cp_yOrange][cp_xOrange - 1] != 'C') && (map[cp_yOrange][cp_xOrange - 1] != 'R') && (map[cp_yOrange][cp_xOrange - 1] != 'P') && (map[cp_yOrange][cp_xOrange - 1] != 'B'))
			{
				goLeft(&cp_xOrange, &cp_yOrange, 'O');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 3:		
			if( (map[cp_yOrange][cp_xOrange + 1] != 'C') && (map[cp_yOrange][cp_xOrange + 1] != 'R') && (map[cp_yOrange][cp_xOrange + 1] != 'P') && (map[cp_yOrange][cp_xOrange + 1] != 'B'))
			{
				goRight(&cp_xOrange, &cp_yOrange, 'O');
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
				
		default:
			if( (map[cp_yOrange + 1][cp_xOrange] != '#')  &&  (map[cp_yOrange + 1][cp_xOrange] != 'C') && (map[cp_yOrange + 1][cp_xOrange] != 'R') && (map[cp_yOrange + 1][cp_xOrange] != 'P') && (map[cp_yOrange + 1][cp_xOrange] != 'B') )
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
	if( cp_x - 1 != 0 - 1){
	    if(map[cp_y][cp_x - 1] != '#'){
		    map[cp_y][cp_x] = ' ';
		    map[cp_y][cp_x -= 1] = 'C';
	    }
	}else{
	    map[cp_y][0] = ' ';
		cp_x = COLS - 1;
		map[cp_y][cp_x] = 'C';
	}
}

void right()
{
	if( cp_x + 1 != COLS){
	    if(map[cp_y][cp_x + 1] != '#'){
		    map[cp_y][cp_x] = ' ';
		    map[cp_y][cp_x += 1] = 'C';
	    }
	}else{
	    map[cp_y][COLS  - 1] = ' ';
		cp_x = 0;
		map[cp_y][cp_x] = 'C';
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
