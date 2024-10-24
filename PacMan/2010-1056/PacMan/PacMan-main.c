#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <ctype.h>
#include <stdbool.h>

//PacMan
#include "PacManFunction.h"	

int main()
{
	initMap();
	displayMap();
	
	move();
	
	return 0;
}

void setBoundry()
{
	int i, j;
	
	for( i=0; i<ROWS; i++)
	{
		for( j=0; j<COLS; j++)
		{
			if( i == 0 || i == ROWS -1 || j == 0 || j == COLS - 1)
				map[i][j] = '#';
			else
				map[i][j] = '.';	
		}
	}
}

void setPacMan()
{
	//PAC-MAN initial position
	map[cp_y][cp_x] = 'C';
}

void setGhost()
{
	//RED ghost initial position
	map[cp_yRed][cp_xRed] = 'R';
	
	//PINK ghost initial position
	map[cp_yPink][cp_xPink] = 'P';
	
	//BLUE ghost initial position
	map[cp_yBlue][cp_xBlue] = 'B';
	
	//ORANGE ghost initial position
	map[cp_yOrange][cp_xOrange] = 'O';
}

void setWalls()
{
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

void setDot()
{
	map[8][8] = ' ';
    map[9][7] = 'B';
    map[9][8] = 'P';
    map[9][9] = 'O';	
	
	map[7][1] = ' ';
    map[7][5] = ' ';
    map[7][6] = ' ';
    map[7][7] = ' ';	
    map[7][9] = ' ';
    map[7][10] = ' ';
    map[7][11] = ' ';
    map[7][15] = ' ';
    map[8][5] = ' ';	
    map[8][11] = ' ';
    map[9][1] = ' ';
    map[9][2] = ' ';
    map[9][4] = ' ';
    map[9][5] = ' ';	
    map[9][11] = ' ';
    map[9][12] = ' ';	
    map[9][14] = ' ';
    map[9][15] = ' ';
    map[10][5] = ' ';
    map[10][11] = ' ';	
    map[11][1] = ' ';
    map[11][5] = ' ';
    map[11][6] = ' ';
    map[11][7] = ' ';
    map[11][8] = ' ';	
    map[11][9] = ' ';
    map[11][10] = ' ';
    map[11][11] = ' ';
    map[11][15] = ' ';
}

void setEnergizer()
{
	map[3][1] = '_';
	map[3][15] = '_';
	map[15][1] = '_';
	map[15][15] = '_';
}

void setFruit()
{
	map[cp_yFruit][cp_xFruit] = '8';	
}

void initMap()
{	
	setBoundry();	
	setPacMan();
	setGhost();
    setWalls();
    setDot();
    setEnergizer();
    //energizer + 50
    //cherry + 100
}

//Obsolete function
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

void gameOver()
{
	printf("\033[0;33m   SCORE: %d \n\n", score);

	//LEADERBOARD DA IMPLEMENTARE
	
	printf("\033[0;31m\t    GAME \n\t    OVER");
}

void displayMap()
{
	int i, j;
	
	printf("\n \t     \033[0;33mPAC-MAN \n \n");
	
	for( i=0; i<ROWS; i++)
	{
		for( j=0; j<COLS; j++)
		{
			if(map[i][j] == '#')
				printf("\033[0;34m%c ", map[i][j]);
			
			if(map[i][j] == 'C')
				printf("\033[0;33m%c ", map[i][j]);
				
			if(map[i][j] == 'R')
				printf("\033[0;31m%c ", map[i][j]);
			
			if(map[i][j] == 'P')
				printf("\033[0;201m%c ", map[i][j]);
			
			if(map[i][j] == 'B')
				printf("\033[0;36m%c ", map[i][j]);
			
			if(map[i][j] == 'O')
				printf("\033[38;5;202m%c ", map[i][j]);
			
			if(map[i][j] == '.')
				printf("\033[0;11m%c ", map[i][j]);
			
			if(map[i][j] == '8')
				printf("\033[0;31m%c ", map[i][j]);
			
			if(map[i][j] == '_')
				printf("\033[0;31m%c ", map[i][j]);
			
			if(map[i][j] == ' ')
				printf("%c ", map[i][j]);
		}
		printf("\n");
	}
	
	printf("\n \033[0;36m SCORE : %d ", score);
	printf("\n\033[0;36mESC per uscire. Contatore: %i",counter);

	if(click == 27)
		{
			system("cls");
			gameOver();
		}
	
	//integrityCheck();
	fflush(stdout);
}

void goUp(int** x, int** y, char ghost)
{
	if(map[**y - 1][**x] == 'C')
	{
		map[cp_y][cp_x] = ' ';
		cp_x = 8;
		cp_y = 14;
		
		map[cp_y][cp_x] = 'C';
		gameOver();
		sleep(2);
	}
	else
	{
		map[**y][**x] = map[**y - 1][**x];
		map[**y -= 1 ][**x] = ghost;	
	}	
	
}

void goDown(int** x, int** y, char ghost)
{
	if(map[**y + 1][**x] == 'C')
	{
		map[cp_y][cp_x] = ' ';
		cp_x = 8;
		cp_y = 14;
		
		map[cp_y][cp_x] = 'C';
		gameOver();
		sleep(2);
	}	
	else
	{
		if((**x == 8) && ((**y + 1) == 8))
		{
			//mi va benissimo
		} 
		else 
		{
			map[**y][**x] = map[**y + 1][**x];
			map[**y += 1 ][**x] = ghost;		
		}	
	}
}

void goRight(int** x, int** y, char ghost)
{
	if(map[**y][**x + 1] == 'C')
	{
		map[cp_y][cp_x] = ' ';
		cp_x = 8;
		cp_y = 14;
		
		map[cp_y][cp_x] = 'C';
		gameOver();
		sleep(2);
	}	
	else
	{
		if(**x + 1 == COLS )
		{
		    map[**y][**x] = map[**y][0];
		    **x = 0;
		    map[**y][**x] = ghost;
		}
		else
		{
		    if(map[**y][**x + 1] != '#')
			{
		        map[**y][**x] = map[**y][**x + 1];
		        map[**y][**x += 1] = ghost;
		    }
		}
	}
}

void goLeft(int** x, int** y, char ghost)
{	
	if(map[**y][**x - 1] == 'C')
	{
		map[cp_y][cp_x] = ' ';
		cp_x = 8;
		cp_y = 14;
		
		map[cp_y][cp_x] = 'C';
		gameOver();
		sleep(2);
	}
	else
	{
	
		if(**x == 0)
		{    
		    map[**y][**x] = map[**y][COLS - 1];
		    **x = COLS - 1;
		    map[**y][**x] = ghost;
		}
		else 
		{
			if(map[**y][**x - 1] != '#')
			{
	    		map[**y][**x] = map[**y][**x - 1];
		    	map[**y][**x -= 1 ] = ghost;
			}
		}
	}
}

void MoveGhosts(int* x, int* y, char ghost)
{
	odds = rand() % (4 - 0 + 1);
	

	switch(odds)
	{
		case 1:
			if( (map[*y - 1][*x] != '#' ) && (map[*y - 1][*x] != 'R') && (map[*y - 1][*x] != 'P') && (map[*y - 1][*x] != 'B') && (map[*y - 1][*x] != 'O'))
			{
				goUp(&x, &y, ghost);
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 4:
			if((map[*y][*x - 1] != 'R') && (map[*y][*x - 1] != 'P') && (map[*y][*x - 1] != 'B') && (map[*y][*x - 1] != 'O'))
			{
				goLeft(&x, &y, ghost);
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
			
		case 3:		
			if((map[*y][*x + 1] != 'R') && (map[*y][*x + 1] != 'P') && (map[*y][*x + 1] != 'B') && (map[*y][*x + 1] != 'O'))
			{
				goRight(&x, &y, ghost);
				system("cls");
				displayMap();
				break;					
			}
			else
				break;
				
		case 2:
			if( (map[*y + 1][*x] != '#')&& (map[*y + 1][*x] != 'R') && (map[*y + 1][*x] != 'P') && (map[*y + 1][*x] != 'B') && (map[*y + 1][*x] != 'O') )
			{
				goDown(&x, &y, ghost);
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
	if(eatable == true)
	{
		switch(map[cp_y - 1][cp_x])
		{
			case 'R':
				map[cp_yRed][cp_xRed] = ' ';
				cp_xRed = 8;
				cp_yRed = 8;
				map[cp_yRed][cp_xRed] = 'R';
				
				redEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'P':
				map[cp_yPink][cp_xPink] = ' ';
				cp_xPink = 8;
				cp_yPink = 8;
				map[cp_yPink][cp_xPink] = 'P';


				pinkEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'B':
				map[cp_yBlue][cp_xBlue] = ' ';
				cp_xBlue = 8;
				cp_yBlue = 8;
				map[cp_yBlue][cp_xBlue] = 'B';
				
				blueEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'O':
				map[cp_yOrange][cp_xOrange] = ' ';
				cp_xOrange = 8;
				cp_yOrange = 8;
				map[cp_yOrange][cp_xOrange] = 'O';
				orangeEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
		}
	}
		
	if( (map[cp_y - 1][cp_x] == 'R') || (map[cp_y - 1][cp_x] == 'O') || (map[cp_y - 1][cp_x] == 'B') || (map[cp_y - 1][cp_x] == 'P'))
	{
		map[cp_y][cp_x] = ' ';
		cp_x = 8;
		cp_y = 14;
		
		map[cp_y][cp_x] = 'C';
		gameOver();
		sleep(2);
		
		//crea funzione vite e ricaricamento pg
		
	}
	else if(map[cp_y - 1][cp_x] != '#')
		{
			map[cp_y - 1][cp_x] == '.' ? score+= 10 : (score = score);
			map[cp_y - 1][cp_x] == '_' ? eatable = true : (score = score);
			
			if(map[cp_y - 1][cp_x] == '8')
			{
				score+= 100;
				map[cp_yFruit][cp_xFruit] = ' ';
				fruitEaten = true;
			}		
			map[cp_y][cp_x] = ' ';
			map[cp_y -= 1][cp_x] = 'C';
		}

}

void down()
{
	if(eatable == true)
	{
		switch(map[cp_y + 1][cp_x])
		{
			case 'R':
				map[cp_yRed][cp_xRed] = ' ';
				cp_xRed = 8;
				cp_yRed = 8;
				map[cp_yRed][cp_xRed] = 'R';
				
				redEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'P':
				map[cp_yPink][cp_xPink] = ' ';
				cp_xPink = 8;
				cp_yPink = 8;
				map[cp_yPink][cp_xPink] = 'P';


				pinkEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'B':
				map[cp_yBlue][cp_xBlue] = ' ';
				cp_xBlue = 8;
				cp_yBlue = 8;
				map[cp_yBlue][cp_xBlue] = 'B';
				
				blueEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'O':
				map[cp_yOrange][cp_xOrange] = ' ';
				cp_xOrange = 8;
				cp_yOrange = 8;
				map[cp_yOrange][cp_xOrange] = 'O';
				orangeEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
		}
	}
		
	if( (map[cp_y + 1][cp_x] == 'R') || (map[cp_y + 1][cp_x] == 'O') || (map[cp_y + 1][cp_x] == 'B') || (map[cp_y + 1][cp_x] == 'P'))
	{
		map[cp_y][cp_x] = ' ';
		cp_x = 8;
		cp_y = 14;
		
		map[cp_y][cp_x] = 'C';
		gameOver();
		sleep(2);
		//crea funzione vite e ricaricamento pg	
	}
	
	if(map[cp_y + 1][cp_x] != '#')
	{
		map[cp_y + 1][cp_x] == '.' ? score+= 10 : (score = score);
		map[cp_y + 1][cp_x] == '_' ? eatable = true : (score = score);
		
		if(map[cp_y + 1][cp_x] == '8')
		{
			score+= 100;
			map[cp_yFruit][cp_xFruit] = ' ';
			fruitEaten = true;
		}
		
		map[cp_y][cp_x] = ' ';
		map[cp_y += 1][cp_x] = 'C';
	}
}

void left()
{
	if(eatable == true)
	{
		switch(map[cp_y][cp_x - 1])
		{
			case 'R':
				map[cp_yRed][cp_xRed] = ' ';
				cp_xRed = 8;
				cp_yRed = 8;
				map[cp_yRed][cp_xRed] = 'R';
				
				redEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'P':
				map[cp_yPink][cp_xPink] = ' ';
				cp_xPink = 8;
				cp_yPink = 8;
				map[cp_yPink][cp_xPink] = 'P';


				pinkEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'B':
				map[cp_yBlue][cp_xBlue] = ' ';
				cp_xBlue = 8;
				cp_yBlue = 8;
				map[cp_yBlue][cp_xBlue] = 'B';
				
				blueEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'O':
				map[cp_yOrange][cp_xOrange] = ' ';
				cp_xOrange = 8;
				cp_yOrange = 8;
				map[cp_yOrange][cp_xOrange] = 'O';
				orangeEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
		}
	}
		
	if( (map[cp_y][cp_x - 1] == 'R') || (map[cp_y][cp_x - 1] == 'O') || (map[cp_y][cp_x - 1] == 'B') || (map[cp_y][cp_x - 1] == 'P'))
	{
		map[cp_y][cp_x] = ' ';
		cp_x = 8;
		cp_y = 14;
		
		map[cp_y][cp_x] = 'C';
		gameOver();
		sleep(2);	
	}
	
	if( cp_x - 1 != 0 - 1)
	{
	    if(map[cp_y][cp_x - 1] != '#')
		{
			map[cp_y][cp_x - 1] == '.' ? score+= 10 : (score = score);
			map[cp_y][cp_x - 1] == '_' ? eatable = true : (score = score);
			
			if(map[cp_y][cp_x - 1] == '8')
			{
				score+= 100;
				map[cp_yFruit][cp_xFruit] = ' ';
				fruitEaten = true;
			}
			
		    map[cp_y][cp_x] = ' ';
		    map[cp_y][cp_x -= 1] = 'C';
	    }
	}
	else
	{
	    map[cp_y][0] = ' ';
		cp_x = COLS - 1;
		map[cp_y][cp_x] = 'C';
	}
}

void right()
{
	if(eatable == true)
	{
		switch(map[cp_y][cp_x + 1])
		{
			case 'R':
				map[cp_yRed][cp_xRed] = ' ';
				cp_xRed = 8;
				cp_yRed = 8;
				map[cp_yRed][cp_xRed] = 'R';
				
				redEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'P':
				map[cp_yPink][cp_xPink] = ' ';
				cp_xPink = 8;
				cp_yPink = 8;
				map[cp_yPink][cp_xPink] = 'P';


				pinkEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'B':
				map[cp_yBlue][cp_xBlue] = ' ';
				cp_xBlue = 8;
				cp_yBlue = 8;
				map[cp_yBlue][cp_xBlue] = 'B';
				
				blueEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
				
			case 'O':
				map[cp_yOrange][cp_xOrange] = ' ';
				cp_xOrange = 8;
				cp_yOrange = 8;
				map[cp_yOrange][cp_xOrange] = 'O';
				orangeEatable = false;
				
				ghostEated++;
				
				ghostEated != 0 ? score = score + (ghostEated*200) : (score = score);
				break;
		}
	}
		
	if( (map[cp_y][cp_x + 1] == 'R') || (map[cp_y][cp_x + 1] == 'O') || (map[cp_y][cp_x + 1] == 'B') || (map[cp_y][cp_x + 1] == 'P'))
	{
		map[cp_y][cp_x] = ' ';
		cp_x = 8;
		cp_y = 14;
		
		map[cp_y][cp_x] = 'C';
		gameOver();
		sleep(2);	
	}
	
	if( cp_x + 1 != COLS)
	{
	    if(map[cp_y][cp_x + 1] != '#')
		{
			map[cp_y][cp_x + 1] == '.' ? score+= 10 : (score = score);
			map[cp_y][cp_x +1] == '_' ? eatable = true : (score = score);
			
			if(map[cp_y][cp_x + 1] == '8')
			{
				score+= 100;
				map[cp_yFruit][cp_xFruit] = ' ';
				fruitEaten = true;
			}
			
		    map[cp_y][cp_x] = ' ';
		    map[cp_y][cp_x += 1] = 'C';
	    }
	}
	else
	{
	    map[cp_y][COLS  - 1] = ' ';
		cp_x = 0;
		map[cp_y][cp_x] = 'C';
	}
}

void move()
{
	while(click != 27)
	{
		click = tolower(getch());
		counter++;
		
		if(score >= 700 && fruitEaten == false)
		{
			setFruit();
		}
			
		if(eatable == true)
		{
			redEatable = true;
			pinkEatable = true;
			blueEatable = true;
			orangeEatable = true;
			timeToEat++;
			if(timeToEat == 10)
			{
				redEatable = false;
				pinkEatable = false;
				blueEatable = false;
				orangeEatable = false;
				timeToEat = 0;
				eatable=false;
				ghostEated = 0;				
			}
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
		
		if(counter <= 15)
			MoveGhosts(&cp_xRed, &cp_yRed, RED);
		else if(counter <= 30)
			{
				MoveGhosts(&cp_xRed, &cp_yRed, RED);
				MoveGhosts(&cp_xPink, &cp_yPink, PINK);
			}
			else if (counter<= 45)
				{
					MoveGhosts(&cp_xRed, &cp_yRed, RED);
					MoveGhosts(&cp_xPink, &cp_yPink, PINK);
					MoveGhosts(&cp_xBlue, &cp_yBlue, BLUE);
				}
				else
				{
					MoveGhosts(&cp_xRed, &cp_yRed, RED);
					MoveGhosts(&cp_xPink, &cp_yPink, PINK);
					MoveGhosts(&cp_xBlue, &cp_yBlue, BLUE);
					MoveGhosts(&cp_xOrange, &cp_yOrange, ORANGE);
				}
	}
}

