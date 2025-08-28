#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define MAX 5

void insere_inicio();
void remove_inicio();
void imprime_lista();
void busca();

struct lista
{
  int valor[MAX];
  int inicio, final, tamanho;
}; struct lista l;

 main()
{
    l.inicio = l.tamanho = 0;
    l.final = -1;
    int op;
    while(op != 5)
    {
      system("cls");
      printf("Manipulacao de Lista Estatica");
      printf("\nDigite 1 para Insercao no Inicio");
      printf("\nDigite 2 para Imprimir a Lista");
      printf("\nDigite 3 para Remover do Inicio");
      printf("\nDigite 4 para Buscar Elemento");
      printf("\nDigite 5 para Sair");
      printf("\nDigite a opcao desejada: ");
      scanf("%i",&op);
    
      switch(op)
      {
         case 1: insere_inicio();  break;
         case 2: imprime_lista();  break;
         case 3: remove_inicio();  break;
         case 4: busca();          break;
         case 5: exit(1);
         default: printf("\nEntre com uma opcao valida!");
       }
    }
}

void insere_inicio()
{
   int i, vezes = 0;
   int x;
   if(l.tamanho == MAX)
   {
      printf("\nLista cheia!");
      exit(1);
   }
   else
   {
       printf("\nDigite uma valor: ");
       scanf("%i",&x);
       i = l.final;
       
       while (vezes < l.tamanho)
       {
         l.valor[i+1] = l.valor[i];
         i--;
         vezes++;
       }
       l.final++;
       l.valor[l.inicio] = x;
       l.tamanho++;
    }
    getche();
}

void remove_inicio()
{
   int i, vezes=0;
   if(l.tamanho == 0)
   {
      printf("\nLista Vazia!");
      exit(1);
   }
   i = l.inicio;
   while (vezes < (l.tamanho-1))
   {
     l.valor[i] = l.valor[i+1];
     i++;
     vezes++;
   }
   l.final--;
   l.tamanho--;
   getche();
}       

void imprime_lista()
{
   int v;
   int i;
   i = l.inicio;
   while(i != l.tamanho)
   {
      v = l.valor[i];
      printf("\nElemento %i da lista eh: %i",i,v);
      i++;
    }
   getche();
}

void busca()
{
     bool encontrou;
     int valor_procurado;
     int v;
     int i;
     i = l.inicio;
     printf("Entre com o valor que deseja buscar: ");
     scanf("%i",&valor_procurado);
     
     while(i != l.tamanho)        
     {
        v = l.valor[i];
        if(v == valor_procurado)
        {
           printf("Elemento %i encontrado na posicao %i",l.valor[i],i);
           encontrou = 1;
        }
        i++;
      }
      if(encontrou != 1)
        printf("Elemento %i nao encontrado",valor_procurado);
      getche();
}

       
