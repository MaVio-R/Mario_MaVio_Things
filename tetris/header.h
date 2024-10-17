#ifndef MYHEADER_H
#define MYHEADER_H




#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <time.h>
#include <conio.h>
#include <stdbool.h>


#define riemp 15

int i=0,j=0;
#define nmax 100
char mappa[riemp][riemp];

bool quadratone = false;
bool linea = false;
bool tigrossa = false;
bool lello = false;

struct posizione{
	int x;
	int y;	
};

struct posizione blocco[nmax];

void generazione_mappa();

void stampa();

void prova();

void down();

void left();

void right();

void quadrato();

void elle ();

void ti();

void rettangolo();

void controllo_fondo();

void ricrea();

bool controllo_riga( );

#endif // MYHEADER_H

