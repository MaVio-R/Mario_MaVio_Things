#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <time.h>

/*
	Il seguente file è un esempio di sistema informatico per la gestione di autovelox
	Il programma permette di inserire Autovelox, Auto, Proprietario
	
	Il programma effettua un associamento semiautomatico tra auto e proprietario tramite la targa
	Il programma randomizza il limite di velocità e la velocita di lettura al passaggio
	Il programma effettua 25 iterazioni scegliendo randomicamente Autovelox, Auto e Proprietario
	
	In caso di eccesso di velocità il programma segna suL file "Multe.txt" tutte le violazioni
	emettendo "una Multa"
*/

#define Dim 100
#define Dimt 7
#define Dims 150

//Definizione di un tipo dato astratto "autovelox" attraverso una struttura
typedef struct
{
	short int ID;
	char place[Dims];
	short int velocityLimit;
	short int velocityRead;
	char licensePlateRead[Dimt];
} autovelox;

//Definizione di un tipo dato astratto "macchina" attraverso una struttura
typedef struct
{
	short int ID;
	char licensePlate[Dimt];
	char carBrand[Dims];
	char model[Dims];
	char color[Dims];
	short int userID;
} macchina;

//Definizione di un tipo dato astratto "autista" attraverso una struttura
typedef struct
{
	short int ID;
	char nome[Dims];
	char cognome[Dims];
	char indirizzo[Dims];
	short int carID;
	short int speedTicket;
} autista;

autovelox tutor[Dim];
macchina car[Dim];
autista driver[Dim];

//utilizzo di short int poichè i valori numerici possono essere al massimo 100
short int tutorNum, carNum, userNum;

void menu();

short int setAutovelox();

short int addCar();
short int addDriver();

void viewAutovelox(short int);
void viewCar(short int);
void viewDriver(short int);

void velocityCheck(short int, short int, short int);
void printTicket(short int, short int);

int main()
{
	printf("\t Terminale Multe \n");
		
	FILE *ticket;
	ticket = fopen("Multe.txt", "w");
	fprintf(ticket, "\t SCHEDARIO MULTE \n");
	fclose(ticket);
	
	fflush(stdin);
	
	menu();
	
	fflush(stdin);
	printf(" Ciao! :)");
	
	return 0;
}

void menu()
{
	char Risposta;
	
	do
	{
		fflush(stdin);
		
		printf("\nInserisci il comando che intendi eseguire: \n");
		printf("| - Imposta un Autovelox 		'A'    |\n");
		printf("| - Inserisci Auto 			'B'    |\n");
		printf("| - Inserisci Autista 			'C'    |\n");
		printf("| - Visualizza Autovelox 		'D'    |\n");
		printf("| - Visualizza Auto			'E'    |\n");
		printf("| - Visualizza Autista 			'F'    |\n");
		printf("| - Controllo della velocita 		'G'    |\n");
		printf("| - Esci 				'H'    |\n");
		
		fflush(stdin);
		
		scanf("%c", &Risposta);
		
		Risposta = toupper(Risposta);
		
		switch(Risposta)
		{
			case 'A':
				tutorNum = setAutovelox();
			    break;
			    
			case 'B':
				carNum = addCar();
			    break;
				
			case 'C':
				userNum = addDriver();
			    break;
				
			case 'D':
				viewAutovelox(tutorNum);
			    break;
			    
			case 'E':
				viewCar(carNum);
			    break;	    
		
			case 'F':
				viewDriver(userNum);
			    break;
			    			
			case 'G':
				velocityCheck(userNum, carNum, tutorNum);
			    break;
		}
			
	}while (Risposta != 'H');
}

short int setAutovelox()
{
	int tutorNum;

	fflush(stdin);
	printf("Numero di autovelox da inserire: ");
	scanf("%i", &tutorNum);
	
	tutorNum = tutorNum - 1;
	int velocityLimits;
	fflush(stdin);
	
	for(int i = 0; i<=tutorNum; i++)
	{
		tutor[i].ID = i;
	
		printf("\n Posizione Autovelox: ");
		scanf(" %s", tutor[i].place);
		fflush(stdin);
					
		velocityLimits = rand() % (130 - 30 + 1) + 30;
		tutor[i].velocityLimit = velocityLimits;
			
		fflush(stdin);
	}
	
	return tutorNum;
}

short int addCar()
{
	int carNum;

	printf("\n Numero di auto da inserire: ");
	scanf(" %i", &carNum);
	
	carNum = carNum - 1;
	for(int i = 0; i<=carNum; i++)
	{	
		car[i].ID = i;

		printf("\n Inserire marca: ");
		scanf(" %s", car[i].carBrand);
		
		printf(" Inserire modello: ");
		scanf(" %s", car[i].model);
		
		printf(" Inserire colore: ");
		scanf(" %s", car[i].color);
		
		printf(" Inserire targa: ");
		scanf(" %s", car[i].licensePlate);
	
		fflush(stdin);
	}	
	
	return carNum;
}

short int addDriver()
{
	int userNum;

	printf("\n Numero di autisti da inserire: ");
	scanf("%i", &userNum);
	
	userNum = userNum - 1;
	
	for(int i = 0; i<=userNum; i++)
	{
		fflush(stdin);
		
		driver[i].ID = i;

		printf("\n Inserire nome: ");
		scanf("%s", driver[i].nome);
		
		printf(" Inserire cognome: ");
		scanf("%s", driver[i].cognome);
		
		printf(" Inserire indirizzo: ");
		scanf("%s", driver[i].indirizzo);
		
		char plate[Dimt];
		printf(" Inserire targa: ");
		scanf("%s", plate);
		
		for(int j=0; j <= Dim; j++)
		{
			if(strcmp(plate, car[j].licensePlate) == 0)
			{
				driver[i].carID = car[j].ID;
				car[j].userID = driver[i].ID;
			}
		}
		
		driver[i].speedTicket = 0;
	}	
	
	return userNum;
}

void viewAutovelox(short int tutorNum)
{
	for(int i = 0; i <= tutorNum; i++)
	{
		printf("\n Autovelox ID: %i", tutor[i].ID);
		printf("\n Posto in : %s", tutor[i].place);
		printf("\n Limite: %i", tutor[i].velocityLimit);
		
		fflush(stdin);
	}	
}

void viewCar(short int carNum)
{
	for(int i = 0; i<=carNum; i++)
	{
		fflush(stdin);
		
		printf(" ID: %i \n", car[i].ID);
		printf(" Marca: %s \n", car[i].carBrand);
		printf(" Modello: %s \n", car[i].model);
		printf(" Colore: %s \n", car[i].color);
		printf(" Targa: %s \n", car[i].licensePlate);
		printf(" Di: %s ", driver[car[i].userID].nome);
		printf("%s \n \n", driver[car[i].userID].cognome);
	}
}

void viewDriver(short int userNum)
{
	for(int i = 0; i<=userNum; i++)
	{
		fflush(stdin);
		
		printf(" ID: %i \n", driver[i].ID);
		printf(" Nome: %s \n", driver[i].nome);
		printf(" Cognome: %s \n", driver[i].cognome);
		printf(" Indirizzo: %s \n", driver[i].indirizzo);
		printf(" Proprietario dell'auto targata: %s \n", car[driver[i].carID].licensePlate);
		printf(" Numero di infrazioni: %i ", driver[i].speedTicket);
	}
}

void velocityCheck(short int userNum, short int carNum, short int tutorNum)
{
	FILE *ticket;
	
	ticket = fopen("Multe.txt", "a");
	
	time_t date = time(NULL);
	fprintf(ticket, "\n \t Inizio rilevazione: %s \n", asctime(localtime(&date)));
	fclose(ticket);
	
    for(int i = 0; i<=25; i++)
    {
        int autoveloxIndex, carIndex, velocity;
		autoveloxIndex = rand() % (tutorNum + 1);
		carIndex = rand() % (carNum + 1);
		velocity = rand() % (150 - 15 + 1) + 15;
		tutor[autoveloxIndex].velocityRead = velocity;
		
		if(tutor[autoveloxIndex].velocityRead > tutor[autoveloxIndex].velocityLimit)
			printTicket(autoveloxIndex, carIndex);
    }
}

void printTicket(short int autoveloxIndex, short int carIndex)
{
	FILE *ticket;
	
	ticket = fopen("Multe.txt", "a");
	
	fprintf(ticket, "---------------------------------------------------------");
	
	time_t date = time(NULL);
	fprintf(ticket, "\n \t Eccesso di velocita' in data: %s \n", asctime(localtime(&date)));
	fprintf(ticket, "\n \t Dell'Auto: %s", car[carIndex].carBrand);
	fprintf(ticket, "\n \t Modello: %s", car[carIndex].model);
	fprintf(ticket, "\n \t Colore: %s", car[carIndex].color);
	fprintf(ticket, "\n \t Targata: %s \n", car[carIndex].licensePlate);
	fprintf(ticket, "\n \t Di: %s %s \n", driver[car[carIndex].userID].nome, driver[car[carIndex].userID].cognome);
	fprintf(ticket, "\n \t Residente in: %s", driver[car[carIndex].userID].indirizzo);
	fprintf(ticket, "\n \t Rilevato in: %s ", tutor[autoveloxIndex].place);	
	fprintf(ticket, "\n \t Per aver circolato alla velocita' di km/h %i ", tutor[autoveloxIndex].velocityRead);	
	fprintf(ticket, "\n \t In tratto con limite velocita' di km/h %i \n", tutor[autoveloxIndex].velocityLimit);	
	
	float importo = 564;
	if((tutor[autoveloxIndex].velocityRead - tutor[autoveloxIndex].velocityLimit) < 5)
	{
		importo = importo*0.05;
	}
	else if((tutor[autoveloxIndex].velocityRead - tutor[autoveloxIndex].velocityLimit) < 15)
	{
		importo = importo*0.15;
	}
	else if((tutor[autoveloxIndex].velocityRead - tutor[autoveloxIndex].velocityLimit) < 30)
	{
		importo = importo*0.50;
	}
	fprintf(ticket, "\n \t Importo dovuto: Euro %f \n", importo);
	
	fprintf(ticket, "---------------------------------------------------------");
	
	fclose(ticket);
}
