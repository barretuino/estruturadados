#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define MAX 5

struct lista
{
       int valor[MAX];
       int tamanho;
       int inicio;
}; 

void inicia(struct lista *l)
{
     l->inicio = l->tamanho = 0;
}

void insere_final(struct lista *l, int x)
{
   if(l->tamanho == MAX)
   {
      printf("\nLista cheia!");
      exit(1);
   }
   else
   {
       l->valor[l->tamanho] = x;
       l->tamanho++;
       printf("Elemento %i inserido com sucesso!",x);
    }
    getch();
}

int remove_final(struct lista *l)
{
   if(l->tamanho == 0)
   {
      printf("\nLista Vazia!");
      exit(1);
   }
   l->tamanho--;
   printf("Elemento %i removido com sucesso!",l->valor[l->tamanho]);
   return l->valor[l->tamanho];
   getche();
}       

void imprime_lista(struct lista *l)
{
   int v;
   int i;
   i = l->inicio;
   while(i != l->tamanho)
   {
      v = l->valor[i];
      printf("\nElemento %i da lista eh: %i",i,v);
      i++;
    }
   getche();
}

void busca(struct lista *l)
{
     bool encontrou;
     int valor_procurado;
     int v;
     int i;
     i = l->inicio;
     printf("Entre com o valor que deseja buscar: ");
     scanf("%i",&valor_procurado);
     
     while(i != l->tamanho)        
     {
        v = l->valor[i];
        if(v == valor_procurado)
        {
           printf("Elemento %i encontrado na posicao %i",l->valor[i],i);
           encontrou = 1;
        }
        i++;
      }
      if(encontrou != 1)
        printf("Elemento %i nao encontrado",valor_procurado);
      getche();
}

main()
{
    
    int op;
    int valor, retorno;
    struct lista l1, l2;
    inicia(&l1);
    inicia(&l2);
   
    while(op != 9)
    {
      system("cls");
      printf("Manipulacao de 2 Listas Estaticas");
      printf("\nDigite 1 para Insercao no Final da Lista l1");
      printf("\nDigite 2 para Insercao no Final da Lista l2");
      printf("\nDigite 3 para Imprimir a Lista l1");
      printf("\nDigite 4 para Imprimir a Lista l2");
      printf("\nDigite 5 para Remover do Final da Lista l1");
      printf("\nDigite 6 para Remover do Final da Lista l2");
      printf("\nDigite 7 para Buscar Elemento na Lista l1");
      printf("\nDigite 8 para Buscar Elemento na Lista l2");
      printf("\nDigite 9 para Sair");
      printf("\nDigite a opcao desejada: ");
      scanf("%i",&op);
    
      switch(op)
      {
         case 1: 
              printf("Digite um valor para a lista l1: ");
              scanf("%i",&valor);
              insere_final(&l1,valor);  
              break;
         case 2:
              printf("Digite um valor para a lista l2: ");
              scanf("%i",&valor);
              insere_final(&l2,valor);  
              break; 
         case 3: 
              printf("\nImpressao da lista l1");
              imprime_lista(&l1); 
              break;
         case 4: 
              printf("\nImpressao da lista l2");
              imprime_lista(&l2); 
              break;
         case 5:
              printf("\nRemocao da lista l1");
              retorno = remove_final(&l1);  
              break;
         case 6:
              printf("\nRemocao da lista l2");
              retorno = remove_final(&l2);  
              break;
         case 7: 
              busca(&l1);         
              break;
         case 8:
              busca(&l2);
              break;
         case 9: exit(1);
         default: printf("\nEntre com uma opcao valida!");
       }
     }
}


     
       
