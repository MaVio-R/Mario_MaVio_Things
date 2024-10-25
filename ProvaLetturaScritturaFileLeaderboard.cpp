#include <stdio.h>
#include <stdlib.h>

int main()
{
	char nome1[3], nome2[3];
	int punteggio1, punteggio2;
	
	printf("Inserire il nome MAX 3 CARATTERI: ");
	scanf("%s", nome1);
	
	punteggio1 = rand();
	punteggio2 = rand();
		
	//Apri file
	FILE *classifica;
	
	if(classifica == NULL)
	{
		classifica = fopen("AAA.txt", "w");
	}
	else
	{
		classifica = fopen("AAA.txt", "r+");
	}
	
	fprintf(classifica,"%s - %d\n", nome1, punteggio1);
	
	fclose(classifica);
	
	classifica = fopen("AAA.txt", "r+");
	
	fscanf(classifica,"%s - %d\n", &nome1, &punteggio1);
			
	printf("Inserire il nome MAX 3 CARATTERI: ");
	scanf("%s", nome2);
	
	fprintf(classifica,"%s - %d\n", nome2, punteggio2);
	
	fclose(classifica);
	
	//recupera file
	classifica = fopen("AAA.txt", "r");
	
	fscanf(classifica,"%s - %d\n", &nome1, &punteggio1);
	fscanf(classifica,"%s - %d\n", &nome2, &punteggio2);		
	
	printf("%s - %d\n", &nome1, &punteggio1);
	printf("%s - %d\n", &nome2, &punteggio2);
	
	fprintf(classifica,"%s - %d\n", nome2, punteggio2);
	
	fclose(classifica);
	
	//aggiungi voce
	
	//ripeti
	
	//termina esecuzione 
	
	//ripeti il tutto controlliamo che tutto sia ok
	
	return 0;
}
