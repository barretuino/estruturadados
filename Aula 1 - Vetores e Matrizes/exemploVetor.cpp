#include <stdio.h>
#include <stdlib.h>

main(){
	int notas[5];
	
	printf("Endereco da nota %d\n", &notas);
	
	for(int i=0; i<55; i++){
		printf("Endereço de %d e %d\n", i, &notas[i]);
	}
}
