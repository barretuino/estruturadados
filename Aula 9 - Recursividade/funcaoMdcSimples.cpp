#include<stdio.h>
#include<stdlib.h>

int mdc (int p, int q){
	if (q == 0) 
		return p; //caso base
	else 
		return mdc(q, p % q); //passo de redução
}

main(){
	printf("%d \n", mdc(6,4));
}

