#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <time.h>
#include <conio.h>
#include <stdbool.h>


#define riemp 10
#define max riemp * riemp
//dichiarazione dei cicli
int i = 0;
int j = 0;

//random numerico
int ri, rj;

//contatore lunghezza serpente
int lung=-1;

//mappa
char mappa[riemp][riemp];

//coordinate serpente
struct posizione{
	int x;
	int y;
};
struct posizione snake[max];

int x;
int y;
void generazione_mappa();

void stampa();

void up();

void down();

void left();

void right();

void shift();

void mela();

int main(){

    srand(time(NULL));
	char tasto;
	snake[lung].x=0;
	snake[lung].y=0;
	
    int fps,confronto=-1;
    
    time_t now = time(NULL);
    struct tm *local = localtime(&now);

    fps=local->tm_sec;
    
	
	
	
	
	
	
	generazione_mappa();
	    //snake
    mappa[0][0]='1';
    
    //mela
	mela();
	
	stampa();
	
	int o = 0;
	
	do{
		time_t now = time(NULL);
    	struct tm *local = localtime(&now);

		if(_kbhit()){
			tasto = _getch();
			system("cls");
			stampa();
			switch(tasto){
				case 'w':
					up();
					break;
				
				case 'a':
					left();
					break;
					
				case 's':
					down();
					break;
					
				case 'd':
					right();
					break;
			}

			system("cls");
			stampa();		
		}else if(confronto!=fps){
			system("cls");
			stampa();
			confronto = fps;
		}
    	fps=local->tm_sec;
    	
	}while(tasto!='0');
	
	
	return 0;	
}

void generazione_mappa(){
	for(i=0;i<riemp;i++){
		for(j=0;j<riemp;j++){
			mappa [i] [j] = '.';
		}
	}	
}

void stampa(){
	for(i=0;i<riemp;i++){
		for(j=0;j<riemp;j++){
			printf("%c ",mappa [j] [i]);
		}
		printf("\n");
	}	
	
}

void up(){
	
	if(mappa[snake[lung].x][snake[lung].y - 1] == '8')
		mela();
	
		mappa[snake[0].x][snake[0].y]='.';

	if(lung>0){
		shift();
	}

	if( (snake[lung].y-1)<0){
		snake[lung].y=riemp-1;
	}else{
		snake[lung].y--;
	}
	mappa[snake[lung].x][snake[lung].y]='1';
}

void down(){
	
	if(mappa[snake[lung].x][snake[lung].y + 1] == '8')
		mela();
	
		mappa[snake[0].x][snake[0].y]='.';

	if(lung>0){
		shift();
	}	
		
	if( (snake[lung].y + 1) >= riemp){
		snake[lung].y = 0;
	}else{
		snake[lung].y++;
	}
	mappa[snake[lung].x][snake[lung].y]='1';
}

void left(){

	
	if(mappa[snake[lung].x - 1][snake[lung].y] == '8')
		mela();	
	
		mappa[snake[0].x][snake[0].y]='.';
	if(lung>0){
		shift();
	}

	if( (snake[lung].x-1)<0){
		snake[lung].x=riemp-1;
	}else{
		snake[lung].x--;
	}
	mappa[snake[lung].x][snake[lung].y]='1';
}

void right(){

	
	if(mappa[snake[lung].x + 1][snake[lung].y] == '8')
		mela();
	
		mappa[snake[0].x][snake[0].y]='.';
		
	if(lung>0){
		shift();
	}

	if( (snake[lung].x + 1) >= riemp){
		snake[lung].x = 0;
	}else{
		snake[lung].x++;
	}
	mappa[snake[lung].x][snake[lung].y]='1';
}

void shift(){
	
	for(i = 0; i < lung ; i++){
		snake[i].x = snake[i+1].x;
		snake[i].y = snake[i+1].y;
	}
	
}

void mela(){
	lung ++;
	snake[lung].x = snake[lung - 1].x;
	snake[lung].y = snake[lung - 1].y;
	
    do{
		ri=(rand()% riemp);
    	rj=(rand()% riemp);	
	}while( (ri == 0) && (rj == 0) );
	
    mappa [ri] [rj] = '8';	
}






