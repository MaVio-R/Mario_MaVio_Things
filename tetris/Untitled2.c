#include "header.h"
// MAPPA
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


// MOVIMENTI
void down(){
	
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '.';
	}
	
	for( i = 0; i < 4; i++){
		blocco[i].y += 1;
	}
	
	prova();
}

void left(){
	
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '.';
	}
	
	for( i = 0; i < 4; i++){
		blocco[i].x -= 1;
	}
	
	prova();
}

void right(){
	
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '.';
	}
	
	for( i = 0; i < 4; i++){
		blocco[i].x += 1;
	}
	
	prova();
}



// FIGURE
void quadrato(){
	quadratone = true;
	linea = false;
    tigrossa = false;
	lello = false;	
	blocco[0].x = 4;	 
	blocco[0].y = 0;
		 
	blocco[1].x = 5;	 
	blocco[1].y = 0;
	
	blocco[2].x = 4;	 
	blocco[2].y = 1;
		 
	blocco[3].x = 5;	 
	blocco[3].y = 1;
	controllo_fondo();
}

void elle(){
	quadratone = false;
	linea = false;
    tigrossa = false;
	lello = true;	
	blocco[0].x = 3;	 
	blocco[0].y = 0;
		 
	blocco[1].x = 3;	 
	blocco[1].y = 1;
	
	blocco[2].x = 4;	 
	blocco[2].y = 1;
		 
	blocco[3].x = 5;	 
	blocco[3].y = 1;
	controllo_fondo();
}

void ti(){
	quadratone = false;
	linea = false;
    tigrossa = true;
	lello = false;	
	blocco[0].x = 5;	 
	blocco[0].y = 0;
		 
	blocco[1].x = 4;	 
	blocco[1].y = 1;
	
	blocco[2].x = 5;	 
	blocco[2].y = 1;
		 
	blocco[3].x = 6;	 
	blocco[3].y = 1;
	controllo_fondo();
}

void rettangolo(){
	quadratone = false;
	linea = true;
    tigrossa = false;
	lello = false;	
	int cont = 3;
	for( i = 0; i < 4; i++){
		blocco[i].x = cont;	 
		blocco[i].y = 0;
		cont++;		
	}

	controllo_fondo();
}




// GENERATORE FIGURA IN MAPPA
void prova(){
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '#';
	}
}


//SCELTA BLOCCO
void ricrea(){
	if(!controllo_riga( )){
		printf("ti puzza il culo");
		system("pause");
	}
		int _blocco;
	_blocco = (rand()% 4);
	
	switch (_blocco){
		case 0:
			quadrato();
			break;
			
		case 1:
			elle();
			break;
			
		case 2:
			ti();
			break;
			
		case 3:
			rettangolo();
			break;
	}	
}



//CONTROLLO COLLISIONI
void controllo_fondo(){
	i = 0;
	
	if(!quadratone){
	for(i = 0; i < 4; i++){
			if( !(blocco[i].y < blocco[i + 1].y) ){
				if( (mappa[blocco[i].x][blocco[i].y + 1] == '#')  ){
					ricrea();
					prova();
					if(blocco[0].y == 0){
					}
				}else if(blocco[i].y + 1 == riemp){
					ricrea();
					prova();
				}
			}
		}
	}else{
	for(i = 2; i < 4; i++){
			if( !(blocco[i].y < blocco[i + 1].y) ){
				if((mappa[blocco[i].x][blocco[i].y + 1] == '#') ){
					ricrea();
					prova();				
				}else if(blocco[i].y + 1 == riemp){
					ricrea();
					prova();
				}
			}
		}
	}
}

bool controllo_riga( ){
	bool verifica = true;
	for( i = 3 ; i < riemp; i++){
		for( j = 0 ; i < riemp-1; i++){
			if( mappa[j][i] != mappa[j+1][i]){
				verifica = false;
			}
		}
	}
	return verifica;
}




//  (mappa[blocco[i].x][blocco[i].y + 1] == '#') || ( mappa[blocco[3].x + 1][blocco[i].y ] == '#' ) || ( mappa[blocco[0].x - 1][blocco[i].y ] == '#' ) 





























