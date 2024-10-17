#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <time.h>
#include <conio.h>


int riemp = 20;
int i=0,j=0;
int nmax=100;

struct posizione{
	int x;
	int y;	
};



void generazione_mappa(char [riemp][riemp]);

void stampa(char [riemp] [riemp]);

void prova(struct posizione [], char [riemp][riemp]);

void down(struct posizione [], char [riemp][riemp]);

void left(struct posizione [], char [riemp][riemp]);

void right(struct posizione [], char [riemp][riemp]);

void quadrato(struct posizione [nmax]);

void elle (struct posizione [nmax]);

void ti(struct posizione [nmax]);

void rettangolo(struct posizione [nmax]);

void controllo_fondo(struct posizione [], char [riemp][riemp]);

void ricrea(struct posizione []);



int main(int argc, char *argv[]) {
	
	struct posizione blocco[nmax];
	
	
    srand(time(NULL));
	char mappa[riemp][riemp];
	char tasto;

    int fps,confronto=-1;


    time_t now = time(NULL);
    struct tm *local = localtime(&now);

    fps=local->tm_sec;
    
	generazione_mappa(mappa);
	

	ricrea(blocco);
	prova(blocco, mappa);
	stampa(mappa);

	do{
		time_t now = time(NULL);
    	struct tm *local = localtime(&now);

		if(_kbhit()){
			tasto = _getch();
			system("cls");
			stampa(mappa);
					controllo_fondo(blocco,mappa);
			switch (tasto){
				case 'a':
					left(blocco,mappa);
					break; 
					
				case 's':
					down(blocco,mappa);
					break;
					
				case 'd':
					right(blocco,mappa);
					break;
			}


			system("cls");
			stampa(mappa);		
		}else if(confronto!=fps){
			controllo_fondo(blocco,mappa);

			system("cls");
			stampa(mappa);
			confronto = fps;
			down(blocco,mappa);
		}
    	fps=local->tm_sec;
    	
	}while(tasto!='0');
	
	return 0;
}


void generazione_mappa(char vettore [riemp][riemp]){
	for(i=0;i<riemp;i++){
		for(j=0;j<riemp;j++){
			vettore [i] [j] = '.';
		}
	}	
}

void stampa(char vettore [riemp] [riemp]){
	for(i=0;i<riemp;i++){
		for(j=0;j<riemp;j++){
			printf("%c ",vettore [j] [i]);
		}
		printf("\n");
	}	
	
}

void down(struct posizione blocco[], char mappa[riemp][riemp]){
	
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '.';
	}
	
	for( i = 0; i < 4; i++){
		blocco[i].y += 1;
	}
	
	prova(blocco, mappa);
}


void left(struct posizione blocco[], char mappa[riemp][riemp]){
	
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '.';
	}
	
	for( i = 0; i < 4; i++){
		blocco[i].x -= 1;
	}
	
	prova(blocco, mappa);
}

void right(struct posizione blocco[], char mappa[riemp][riemp]){
	
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '.';
	}
	
	for( i = 0; i < 4; i++){
		blocco[i].x += 1;
	}
	
	prova(blocco, mappa);
}

void quadrato(struct posizione blocco[]){
	
	blocco[0].x = 4;	 
	blocco[0].y = 0;
		 
	blocco[1].x = 5;	 
	blocco[1].y = 0;
	
	blocco[2].x = 4;	 
	blocco[2].y = 1;
		 
	blocco[3].x = 5;	 
	blocco[3].y = 1;
	
}

void elle(struct posizione blocco[]){
	
	blocco[0].x = 3;	 
	blocco[0].y = 0;
		 
	blocco[1].x = 3;	 
	blocco[1].y = 1;
	
	blocco[2].x = 4;	 
	blocco[2].y = 1;
		 
	blocco[3].x = 5;	 
	blocco[3].y = 1;
	
}

void ti(struct posizione blocco[]){
	
	blocco[0].x = 5;	 
	blocco[0].y = 0;
		 
	blocco[1].x = 4;	 
	blocco[1].y = 1;
	
	blocco[2].x = 5;	 
	blocco[2].y = 1;
		 
	blocco[3].x = 6;	 
	blocco[3].y = 1;
	
}

void rettangolo(struct posizione blocco[]){
	
	blocco[0].x = 3;	 
	blocco[0].y = 0;
		 
	blocco[1].x = 4;	 
	blocco[1].y = 0;
	
	blocco[2].x = 5;	 
	blocco[2].y = 0;
		 
	blocco[3].x = 6;	 
	blocco[3].y = 0;
	
}

void prova(struct posizione blocco[], char mappa[riemp][riemp]){

	
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '#';
	}
	
	
	
	
}

void ricrea(struct posizione blocco[]){
	
		int _blocco;
	_blocco = (rand()% 4);
	
	switch (_blocco){
		case 0:
			quadrato(blocco);
			break;
			
		case 1:
			elle(blocco);
			break;
			
		case 2:
			ti(blocco);
			break;
			
		case 3:
			rettangolo(blocco);
			break;
	}	
}

void controllo_fondo(struct posizione blocco[], char mappa[riemp][riemp]){
	
	
	
	for(i = 0; i < 4; i++){
		if( !(blocco[i].y < blocco[i + 1].y) ){
			if(mappa[blocco[i].x][blocco[i].y + 1] == '#'){
				ricrea(blocco);
				prova(blocco, mappa);				
			}else if(blocco[i].y + 1 == riemp){
					ricrea(blocco);
					prova(blocco, mappa);
				}
		}
		
	}
	
	
}





































