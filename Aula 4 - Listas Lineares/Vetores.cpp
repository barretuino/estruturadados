#include <stdio.h>
#include <stdlib.h>

main(){
	//Declarando e inicializando o vetor
	int vetor[5] = {-4, 12, 17, -73, 82};
	
	for(int i=0; i<5; i++){
		printf("Endereco %i valor %i\n", &vetor[i], vetor[i]);
	}
	
	printf("valor %i\n", *(&vetor[0]+3));
	system("PAUSE");
}
