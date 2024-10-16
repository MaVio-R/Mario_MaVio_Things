#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <time.h>

#define Dim 100 //dimensione massima array
#define Dims 150 //dimensione massima stringhe

// libri
typedef struct
{
	int ID;				//codice univoco
	char Title[Dims]; 	//titolo libro
	char Author[Dims];	//autore libro
	char ISBN[Dims];	//codice libro
	bool loanFlag;		//se è in archivio o meno
} libro;

// utente
typedef struct
{
	int ID;					//codice univoco
	char Name[Dims]; 		
	char Surname[Dims];		
	char Mobile[Dims];		//numero di telefono
	bool loanFlag;			//se ha in prestito un altro libro
} utente;

libro book[Dim];
utente user[Dim];

int addBook();
int addUser();

void menu();

void viewBook(int);
void viewUser(int);

void bookLoan(int, int);
void printReceipt(int, int);

void viewBookLoan(int);
void viewUserLoan(int);

void searchBookById(int);
void searchUserById(int);

void searchBookByStr(int);
void searchUserByStr(int);

int main() 
{
	printf("\t Benvenuto in Libreria! :) \n ");
	
	int bookTot;
	int userTot;
	
	bookTot = addBook();
	userTot = addUser();
	
	viewBook(bookTot);
	viewUser(userTot);

	bookLoan(bookTot, userTot);
	viewBookLoan(bookTot);
	viewUserLoan(userTot);
	
	searchBookById(bookTot);
	searchUserById(userTot);
	
	searchBookByStr(bookTot);
	searchUserByStr(userTot);
	
	printf("\n\t Ciao! :) ");
	exit(0);
}

/*void menu()
{
	char risposta;
	
	do
	{
		printf("\n Selezionare operazione: ");
		printf("\n --- Aggiungi Libro 			['A'] --- \n");
		printf("\n --- Aggiungi Utente 			['B'] --- \n");
		printf("\n --- Visualizza Libri 		['C'] --- \n");
		printf("\n --- Visualizza Utenti 		['D'] --- \n");
		printf("\n --- Effettua Prestito 		['E'] --- \n");
		printf("\n --- Libri in Prestito 		['F'] --- \n");
		printf("\n --- Utenti con Prestito 		['G'] --- \n");
		printf("\n --- Cerca Libro per Codice 	['H'] --- \n");
		printf("\n --- Cerca Utente per Codice 	['I'] --- \n");
		printf("\n --- Cerca Libro per Testo 	['L'] --- \n");
		printf("\n --- Cerca Utente per Testo 	['M'] --- \n");	
		printf("\n --- ESCI  					['N'] --- \n");	
		
	} while (risposta != );
}*/

int addBook()
{
	int ins = 0;
	char risposta;

	printf(" \n Quanti libri desideri inserire (1, 2, 3, ...): ");
	scanf("%i", &ins);
	
	ins = ins-1;
		
	for(int i = 0; i<= ins; i++)
	{
		fflush(stdin);
		
		book[i].ID = i; //codice univoco
		
		printf("\n Titolo: ");
		scanf("%s", book[i].Title);
		
		printf(" Autore: ");
		scanf("%s", book[i].Author);
		
		printf(" ISBN: ");
		scanf("%s", book[i].ISBN);
		
		book[i].loanFlag = false; //il libro non è in prestito
		
		fflush(stdin);	
	}
	
	return ins;	
}

int addUser()
{
	int ins = 0;

	printf(" \n Quanti utenti desideri inserire (1, 2, 3, ...): ");
	scanf("%i", &ins);
	
	ins = ins-1;
		
	for(int i = 0; i<= ins; i++)
	{
		fflush(stdin);
		
		user[i].ID = i; //codice univoco
		
		printf("\n Nome: ");
		scanf("%s", user[i].Name);
		
		printf(" Cognome: ");
		scanf("%s", user[i].Surname);
		
		printf(" Recapito telefonico: ");
		scanf("%s", user[i].Mobile);
		
		user[i].loanFlag = false; //l'utente non ha in prestito nessun libro
		
		fflush(stdin);	
	}
	
	return ins;
}

void viewBook(int tot)
{
	for(int i=0; i<= tot; i++)
	{
		fflush(stdin);
		
		printf("\n ID: %i\n", book[i].ID);
		printf(" TITOLO: %s\n", book[i].Title);
		printf(" AUTORE: %s\n", book[i].Author);
		printf(" ISBN: %s\n", book[i].ISBN);
		
		if(book[i].loanFlag == false)
			printf(" Libro in magazzino \n");
		else
			printf(" Libro in prestito \n");
		fflush(stdin);
	}	
}

void viewUser(int tot)
{
	for(int i=0; i<= tot; i++)
	{
		fflush(stdin);
		
		printf("\n ID: %i\n", user[i].ID);
		printf(" NOME: %s\n", user[i].Name );
		printf(" COGNOME: %s\n", user[i].Surname);
		printf(" RECAPITO: %s\n", user[i].Mobile);
		
		if(user[i].loanFlag == false)
			printf(" Prestito disponibile \n");
		else
			printf(" Prestito non disponibile \n");
		fflush(stdin);
	}
}

void bookLoan(int bookTot, int userTot)
{
	int userCod = 0;
	int bookCod = 0;
	
	printf("\n Codice utente: ");
	scanf("%i", &userCod);
	
	printf("\n Codice libro: ");
	scanf("%i", &bookCod);
	
	fflush(stdin);
	
	for(int i=0; i<=userTot; i++)
	{
		if(userCod==user[i].ID)
			{
				if(user[i].loanFlag==false)
				{
					printf("\n Utente disponibile per il prestito. \n");
					user[i].loanFlag=true;
					fflush(stdin);
				}
				else
				{
					printf("\n Prestito non disponibile. \n Prestito e' gia' attivo! \n");
					fflush(stdin);
					break;
				}
			}
	}
	
	for(int i=0; i<=bookTot; i++)
	{
		if(bookCod==book[i].ID)
			{
				if(book[i].loanFlag==false)
				{
					printf("\n Il libro e' disponibile al prestito. \n");
					book[i].loanFlag=true;
					fflush(stdin);
				}
				else
				{
					printf("\n Prestito non disponibile. \n Prestito gia' attivo! \n");
					fflush(stdin);
					break;
				}
			}
	}
	
	if(book[bookCod].loanFlag == true && book[userCod].loanFlag == true)
		printReceipt(userCod, bookCod);
}

void viewBookLoan(int bookTot)
{

	for(int i=0; i<= bookTot; i++)
	{
		fflush(stdin);
		
		if(book[i].loanFlag == true)
		{
			printf("\n Libri in prestito: ");
			printf("\n ID: %i\n", book[i].ID);
			printf(" TITOLO: %s\n", book[i].Title);
			printf(" AUTORE: %s\n", book[i].Author);
			printf(" ISBN: %s\n", book[i].ISBN);
		}
		else
			printf(" Nessun libro in prestito \n");
			
		fflush(stdin);
	}	
}

void viewUserLoan(int userTot)
{
	for(int i=0; i<= userTot; i++)
	{
		fflush(stdin);
		
		if(user[i].loanFlag == true)
		{
			printf("\n Utenti con prestito attivo: ");
			printf("\n ID: %i\n", user[i].ID);
			printf(" NOME: %s\n", user[i].Name );
			printf(" COGNOME: %s\n", user[i].Surname);
			printf(" RECAPITO: %s\n", user[i].Mobile);
		}
		else
			printf(" Nessun prestito attivo \n");
			
		fflush(stdin);
	}	
}

void searchBookById(int bookTot)
{	
	int cod;
	bool counter = false;
	
	printf(" \n Inserire il codice del libro da cercare: ");
	scanf("%i", &cod);
	fflush(stdin);
	
	for(int i=0; i<= bookTot; i++)
	{
		fflush(stdin);
		
		if(book[i].ID == cod)
		{
			printf("\n TITOLO: %s\n", book[i].Title);
			printf(" AUTORE: %s\n", book[i].Author);
			printf(" ISBN: %s\n", book[i].ISBN);
			counter = true;
		}
	}
		
	if(counter == false)
	{
		printf("Nessun libro trovato. \n");
	}
}

void searchUserById(int userTot)
{
	int cod;
	bool counter = false;
	
	printf(" \n Inserire il codice dell'utente da cercare: ");
	scanf("%i", &cod);
	fflush(stdin);
	
	for(int i=0; i<= userTot; i++)
	{
		fflush(stdin);
		
		if(user[i].ID == cod)
		{
			printf("\n NOME: %s\n", user[i].Name );
			printf(" COGNOME: %s\n", user[i].Surname);
			printf(" RECAPITO: %s\n", user[i].Mobile);
			counter = true;
		}	
	}	
	
	if(counter == false)
	{
		printf("Nessun utente trovato. \n");
	}
}

void searchBookByStr(int bookTot)
{
	char compare[Dims];
	bool counter = false;
	
	printf(" \n Inserire: titolo, autore o ISBN del libro da cercare: ");
	scanf("%s", compare);
	fflush(stdin);
	
	for(int i=0; i<= bookTot; i++)
	{
		fflush(stdin);
		
		if(strcmp(book[i].Title, compare) == 0 || strcmp(book[i].Author, compare) == 0 || strcmp(book[i].ISBN, compare) == 0)
		{
			printf("\n TITOLO: %s\n", book[i].Title);
			printf(" AUTORE: %s\n", book[i].Author);
			printf(" ISBN: %s\n", book[i].ISBN);
			counter = true;
		}
	}
		
	if(counter == false)
	{
		printf("Nessun libro trovato. \n");
	}
}

void searchUserByStr(int userTot)
{
	char compare[Dims];
	bool counter = false;
	
	printf(" \n Inserire il nome o cognome dell'utente da cercare: ");
	scanf("%s", compare);
	fflush(stdin);
	
	for(int i=0; i<= userTot; i++)
	{
		fflush(stdin);
		
		if(strcmp(user[i].Name, compare) == 0 || strcmp(user[i].Surname, compare) == 0)
		{
			printf("\n NOME: %s\n", user[i].Name );
			printf(" COGNOME: %s\n", user[i].Surname);
			printf(" RECAPITO: %s\n", user[i].Mobile);
			counter = true;
		}
	}
		
	if(counter == false)
	{
		printf("Nessun libro trovato. \n");
	}
}

void printReceipt(int userCod, int bookCod)
{
	FILE *receipt;
	
	receipt = fopen("RicevutaLibreria.txt", "w");
	
	fprintf(receipt, "\t Libreria \n");
	fprintf(receipt, "\t Prestito Libro \n");
		
	fprintf(receipt, " -TITOLO: %s\n", book[bookCod].Title);
	fprintf(receipt, " -AUTORE: %s\n", book[bookCod].Author);
	fprintf(receipt, " -ISBN: %s\n", book[bookCod].ISBN);

	fprintf(receipt, "\t Utente \n");
	
	fprintf(receipt, " -NOME: %s\n", user[userCod].Name );
	fprintf(receipt, " -COGNOME: %s\n", user[userCod].Surname);
	fprintf(receipt, " -RECAPITO: %s\n", user[userCod].Mobile);
	
	time_t date = time(NULL);
	fprintf(receipt, "\n In data: %s", asctime(localtime(&date)));
	
	fclose(receipt);
}
