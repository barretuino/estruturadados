#include<conio.h>
#include<stdlib.h>
#include<stdio.h>

#define NUMNODES 500
int avail;

struct nodetype{
  int info, next;
};
struct nodetype node[NUMNODES];

void inicia()
{
  avail = 0;
  for(int i = 0; i < NUMNODES-1; i++)
    node[i].next = i + 1;
  node[NUMNODES-1].next = -1;
}

int getnode()
{
  int p;
  if(avail == -1)
  {
    printf("estouro\n");
    exit(1);
  }
  p = avail;
  avail = node[avail].next;
  return(p);
}

int freenode(int p)
{
  node[p].next = avail;
  avail = p;
  return avail;
}

void insafter(int p, int x)
{
  int q;
  if(p == -1)
  {
    printf("insercao nula\n");
    return;
  }

  q = getnode();
  node[q].info = x;
  node[q].next = node[p].next;
  node[p].next = q;
  printf("\nElemento %i inserido com sucesso!",x);
  getche();
}

int delafter(int p, int *px)
{
  int q;
  if((p == -1) || (node[p].next == -1))
  {
    printf("remocao nula\n");
    return -1;
  }
  q = node[p].next;
  *px = node[q].info;
  node[p].next = node[q].next;
  freenode(q);
  return *px;

}

main()
{
  int op;
  int valor;
  int retorno;
  inicia();

  while(op != 3)
  {
    system("cls");
    printf("Manipulacao de Lista");
    printf("\nDigite 1 para inserir elemento na lista");
    printf("\nDigite 2 para remover elemento da lista");
    printf("\nDigite 3 para sair");
    printf("\nEntre com a opcao desejada: ");
    scanf("%i",&op);
  
    switch(op)
    {
      case 1:
         printf("Entre com um valor: ");
         scanf("%i",&valor);
         insafter(1, valor); break;
      case 2:
         retorno = delafter(1,&valor);
         printf("O valor de retorno eh: %i",retorno);
         getch();
         break;
      case 3: exit(1);
     }
  }   
} 
