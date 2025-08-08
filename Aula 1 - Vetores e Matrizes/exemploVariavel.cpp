#include <stdio.h>
#include <stdlib.h>

//variavel global
int vetor[10];

main(){
	vetor[0] = 10;
	vetor[1] = 15;
	//.....
	vetor[9] = -5;
	
	for(int i=0; i<11; i++){
		printf("Valor %i end %i\n", vetor[i], &vetor[i]);
	}
}
