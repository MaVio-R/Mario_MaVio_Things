#include <stdio.h>
#include <stdlib.h>

// Mappa 
#define ROWS 58 //WIDTH
#define COLS 55 //lENGTH

char Map[ROWS][COLS];

void startUpMap();
void displayMap();

int main() 
{
	startUpMap();
	displayMap();
	
	return 0;
}

void startUpMap()
{
	int i, j;
	
	//Setting the map
	for( i = 0; i <= ROWS; i++)
	{
		for( j = 0; j <= COLS; j++)
		{
			if( i == 0 || j == 0)
				Map[i][j]= '#';
		}
	}
}

void displayMap()
{
	int i, j;
	
	for( i = 0; i <= ROWS; i++)
	{
		for( j = 0; j <= COLS; j++)
		{
			printf("%c ", Map[i][j]);
		}
		printf("\n");
	}
}
