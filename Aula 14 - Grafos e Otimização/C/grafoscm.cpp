#include<stdio.h>
#include<conio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#include<dos.h>
#include<graphics.h>
#include<process.h>
#include<iostream.h>

#define NO 30
#define LISTA 30
#define PILHA 30
#define TRUE 1
#define FALSE 0

struct arvore
{ int item;
  char marca[30];
  struct arvore *dir, *esq, *ret1, *ret2;
};

struct listad
{ int item_y;
  struct listad *prox;
  char marca[30];
};

struct arvore *atual, *no_principal;
struct listad *ptr[NO];

int x[30], y[30];

int mat[30][30];

void main();
void leitura();
void arvore();
void matriz();
void listad();
void caminh_amp_arvore();
void caminh_prof_arvore();
void caminh_amp_matriz();
void caminh_prof_matriz();
void caminh_amp_listad();
void caminh_prof_listad();

void leitura()
{ int i;
  i=0;
  clrscr();
  cout<<"Leitura dos pares de formacao do grafo\n";
  while(i<30)
  { printf("Digite x[%d]:",i+1);
	 scanf("%d",&x[i]);
	 printf("Digite y[%d]:",i+1);
	 scanf("%d",&y[i]);
	 i++;
  }
}
void arvore()
{ struct arvore *aux, *aux2, *aux3;
  cout<<"Montagem do grafo a partir de uma estrutura semelhante a arvore\n";
  clrscr();


}
void matriz()
{   int i,j,z,w;
    w=0;
    clrscr();
    cout<<"\nMontagem do grafo a partir da matriz de adjacencia";
    for(i=0;i<30;i++)
    { for(j=0;j<30;j++)
       mat[i][j]=0;
    }
    delay(2000);
    cout<<"\nMatriz de adjacencia ja zerada";
    while(w<30)
    { printf("\nx[%d]=%d",w+1,x[w]);
      printf("\ny[%d]=%d",w+1,y[w]);
      getchar();
      i=x[w];
      j=y[w];
      if(i==j)
       printf("\nImpossivel ele fazer adjacencia com ele mesmo" );
      if(mat[i][j]==0)
      {  mat[i][j]=1;
	 printf("%d valor atribuido a adjacencia de mat[%d][%d]",mat[i][j],i,j);
      }
       else
	  printf("\nmat[%d][%d] ja possui 1 indicando adjacencia",i,j);
      w++;
    }
    delay(2000);
    cout<<"\nGrafo a partir da matriz de adjacencia ja montado";
}

void listad()
{ int i,j;
  struct listad *auxiliarno;
  clrscr();
  cout<<"Montagem do grafo a partir de uma lista de adjacencia\n";
  for(i=1;i<=30;i++)
  { for(j=1;j<=30;j++)
    { if(mat[i][j]==1)
	 { auxiliarno= (struct listad *) malloc(sizeof(struct listad));
	   auxiliarno->item_y=j;
	   auxiliarno->prox=(struct listad *)NULL;
	   if(ptr[i]==(struct listad *)NULL)
	    ptr[i]=auxiliarno;
	     else
		{  while(ptr[i]->prox!=(struct listad *)NULL)
		     ptr[i]=ptr[i]->prox;
		   auxiliarno->prox=ptr[i]->prox;
		   ptr[i]->prox=auxiliarno;
		}
	   delay(1000);
	   cout<<"\nElemento inserido";
	 }
       else
	 cout<<"\nNao ha ligacao";
     }
  }
  delay(1000);
  cout<<"\nGrafo a partir da lista de adjacencia ja montado";
}
void caminh_amp_arvore()
{ clrscr();
  cout<<"Caminhamento em amplitude na arvore e impressao do grafo\n";




}
void caminh_prof_arvore()
{ clrscr();
  cout<<"Caminhamento em profundidade na arvore e impressao do grafo\n";





}
void caminh_amp_matriz()
{ cout<<"Caminhamento em amplitude na matriz e impressao do grafo\n";



}
void caminh_prof_matriz()
{ cout<<"Caminhamento em profundidade na matriz e impressao do grafo\n";




}
void caminh_amp_listad()
{ cout<<"Caminhamento em amplitude na lista e impressao do grafo\n";





}
void caminh_prof_listad()
{ cout<<"Caminhamento em profundidade na lista e impressao do grafo\n";



}

void main()
{ char c, op = '1';
  while (op != '0')
  { clrscr();
    gotoxy(2,2);  cout<<"*****************************************************";
    gotoxy(2,3);  cout<<"*          Manipulacao de grafos                    *";
    gotoxy(2,4);  cout<<"* 1.Leitura de pares ordenados                      *";
    gotoxy(2,5);  cout<<"* 2.Montagem do grafo semelhantemente a arvore      *";
    gotoxy(2,6);  cout<<"* 3.Montagem do grafo numa matriz de adjacencia     *";
    gotoxy(2,7);  cout<<"* 4.Montagem do grafo numa lista de adjacencia      *";
    gotoxy(2,8);  cout<<"* 5.Caminhamento em amplitude-impressao da arvore   *";
    gotoxy(2,9);  cout<<"* 6.Caminhamento em profundidade-impressao da arvore*";
    gotoxy(2,10); cout<<"* 7.Caminhamento em amplitude-impressao da matriz   *";
    gotoxy(2,11); cout<<"* 8.Caminhamento em profundidade-impressao da matriz*";
    gotoxy(2,12); cout<<"* A.Caminhamento em amplitude-impressao da lista    *";
    gotoxy(2,13); cout<<"* B.Caminhamento em profundidade-impressao da lista *";
    gotoxy(2,14); cout<<"* 0. Sair                                           *";
    gotoxy(2,15); cout<<"*****************************************************";
    gotoxy(2,16);
    printf("Entre com sua opcao: ");
    op = getche();
    switch(op)
    { case '1' : leitura();            break;
      case '2' : arvore();             break;
      case '3' : matriz();             break;
      case '4' : listad();              break;
      case '5' : caminh_amp_arvore();  break;
      case '6' : caminh_prof_arvore(); break;
      case '7' : caminh_amp_matriz();  break;
      case '8' : caminh_prof_matriz(); break;
      case 'A' : caminh_amp_listad();  break;
      case 'B' : caminh_prof_listad(); break;
      case '0' :                       break;
      default  : cout<<"\nOpcao Invalida!!!";
    }
    printf("\nPressione <ENTER> para continuar");
    while ((c = getchar()) != '\n');
  }
}


