#include "header.h"


int main(int argc, char *argv[]) {
	
	
	
    srand(time(NULL));
	char tasto;

    int fps,confronto=-1;


    time_t now = time(NULL);
    struct tm *local = localtime(&now);

    fps=local->tm_sec;
    
	generazione_mappa();
	

	ricrea();
	prova();
	stampa();

	do{
		time_t now = time(NULL);
    	struct tm *local = localtime(&now);

		if(_kbhit()){
			tasto = _getch();
			system("cls");
			stampa();
			controllo_fondo();
			switch (tasto){
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
			controllo_fondo();

			system("cls");
			stampa();
			confronto = fps;
			down();
		}
    	fps=local->tm_sec;
    	
	}while(tasto!='0');
	
	return 0;
}

