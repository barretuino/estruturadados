#include <stdlib.h>
#include <stdio.h>
#include <conio.h>
#include <string.h>

//prototipo das fun‡oes
void zerarVariaveis();
void montarGrafo();
void verificarAdjacencia();
void imprimirMatriz();
void comecarDeNovo();
int retornaIndice(char nome[30]);
void insereNoVetor(char nome[30]);
void caminhamentoAmplitude();
void caminhamentoProfundidade();
int pegaVerticeAdjNaoVisitado(int indice);
void zeraAsVisitas();
void insereNaFila(int indice);
int filaVazia();
int removeDaFila();
void push(int indice);
int pop();
int pilhaVazia();

//defini‡Æo da estrutura de dados e das variaveis globais0
#define MAXNOS 10
#define PARES 5

int matriz[MAXNOS][MAXNOS];
struct no
{
  int visitado;
  char descricao[30];
};
struct no vetor[MAXNOS];
int quantosNos;

struct pilha
{
  int vetor[MAXNOS]; //MAXNOS + 1 para evitar de causar overflow
  int topo;
};
struct pilha p;

struct fila
{
  int vetor[MAXNOS]; //MAXNOS + 1 para evitar de causar overflow
  int inicio, fim, quantos;
};
struct fila f;

void push(int indice)
{
  if (p.topo == MAXNOS)
    puts ("Pau Geral de Overflow na Pilha");
  else
  {
    p.topo++;
    p.vetor[p.topo] = indice;
  }
}//push

int pop()
{
  int indice = -1;
  if (p.topo == -1)
    puts ("Pau Geral de Underflow na Pilha");
  else
  {
    indice = p.vetor[p.topo];
    p.topo--;
  }
  return (indice);
}//pop

int pilhaVazia()
{
  int vazio = 1;
  if (p.topo > -1)
    vazio = 0;
  return vazio;
}

void insereNaFila(int indice)
{
  if (f.quantos == MAXNOS)
    puts ("Pau Geral de Overflow na Fila");
  else
  {
    if (f.fim == (MAXNOS-1))
      f.fim = 0;
    else
      f.fim++;
    f.vetor[f.fim] = indice;
    f.quantos++;
  }
}

int filaVazia()
{
  int vazio = 1;
  if (f.quantos > 0)
    vazio = 0;
  return vazio;
}

int removeDaFila()
{
  int indice = -1;
  if (f.quantos == 0)
    puts ("Pau Geral de Underflow na Fila");
  else
  {
    indice = f.vetor[f.inicio];
    f.quantos--;
    if (f.inicio == (MAXNOS-1))
      f.inicio = 0;
    else
      f.inicio++;
  }
  return (indice);
}

void zerarVariaveis()
{
  int i, j;
  p.topo = -1;
  f.inicio = f.quantos = 0;
  f.fim = -1;
  quantosNos = -1;
  for (i = 0; i < MAXNOS; i++)
  {
    for (j = 0; j < MAXNOS; j++)
      matriz[i][j] = 0;
    vetor[i].visitado = 0;
    strcpy(vetor[i].descricao, " ");
  }
}

int pegaVerticeAdjNaoVisitado(int indice)
{
  int coluna, retorna = -1;
  for (coluna = 0; coluna <= quantosNos; coluna++)
  {
    if ((matriz[indice][coluna]==1) && (vetor[coluna].visitado == 0))
    {
      retorna = coluna;
      break;
    }
  }
  return (retorna);
}

void zeraAsVisitas()
{
  for (int i = 0; i < MAXNOS; i++)
    vetor[i].visitado = 0;
}

int retornaIndice(char nome[30])
{
  int i = 0, indice = -1;
  int achou = 0;

  while ((i <= quantosNos) && (!achou))
  {
    if(strcmp(nome, vetor[i].descricao) == 0)
    {
      achou = 1;
      indice = i;
    }
    else
      i++;
  }
  return indice;
}

void insereNoVetor(char nome[30])
{
  quantosNos++;
  strcpy(vetor[quantosNos].descricao, nome);
}

void montarGrafo()
{
  clrscr();
  puts("\nMontar Grafo");
  int i, indice1, indice2;
  char nome1[30], nome2[30];
  for (i = 0; i < PARES; i++)
  {
    printf("\nEntre com o 1o. nome do %do. par: ", i+1);
    gets(nome1);
    printf("\nEntre com o 2o. nome do %do. par: ", i+1);
    gets(nome2);
    indice1 = retornaIndice(nome1);
    if (indice1 == -1)
    {
      insereNoVetor(nome1);
      indice1 = retornaIndice(nome1);
    }
    indice2 = retornaIndice(nome2);
    if (indice2 == -1)
    {
      insereNoVetor(nome2);
      indice2 = retornaIndice(nome2);
    }
    matriz[indice1][indice2] = 1;
  }
}

void imprimirMatriz()
{
  int l, c;
  clrscr();
  puts("\nImprimir Matriz de Adjacˆncias");
  //imprimir os cabecalhos das colunas da matriz
  printf("   ");
  for (c = 0; c < MAXNOS; c++)
    printf("%3s", vetor[c].descricao);
  printf("\n");

  for (l = 0; l < MAXNOS; l++)
  {
    printf("%3s", vetor[l].descricao); //imprimir titulo da linha da matriz
    for (c = 0; c < MAXNOS; c++)
      printf("%3d", matriz[l][c]);
    printf("\n");
  }
}

void verificarAdjacencia()
{
  clrscr();
  puts("\nVerificar Adjacencia");
  int i, indice1, indice2;
  char nome1[30], nome2[30];
  printf("\nEntre com o 1o nome do par: ");
  gets(nome1);
  printf("\nEntre com o 2o nome do par: ");
  gets(nome2);
  indice1 = retornaIndice(nome1);
  indice2 = retornaIndice(nome2);
  if ((indice1 == -1) || (indice2 == -1))
    puts("NÆo sÆo adjacentes");
  else
  {
    if (matriz[indice1][indice2] == 1)
      puts("SÆo adjacentes");
    else
      puts("NÆo sÆo adjacentes");
  }
}

void caminhamentoAmplitude()
{
  int indice, indiceAdj;
  char nome[30];
  clrscr();
  puts("\nCaminhamento em Amplitude");
  printf("\nEntre com o nome do no inicial: ");
  gets(nome);
  indice = retornaIndice(nome);
  if (indice == -1)
    puts("Este nome nao pertence ao grafo");
  else
  {
    printf("Imprimindo os nos: ");
    printf("%s   ", vetor[indice].descricao);
    vetor[indice].visitado = 1;
    insereNaFila(indice);
    while (!filaVazia())
    {
      indice = removeDaFila();
      indiceAdj = pegaVerticeAdjNaoVisitado(indice);
      while (indiceAdj != -1)
      {
	printf("%s   ", vetor[indiceAdj].descricao);
	vetor[indiceAdj].visitado = 1;
	insereNaFila(indiceAdj);
	indiceAdj = pegaVerticeAdjNaoVisitado(indice);
      }
    }
  }
  printf("\n");
  zeraAsVisitas();
}

void caminhamentoProfundidade()
{
  int indice;
  char nome[30];
  clrscr();
  puts("\nCaminhamento em Profundidade");
  printf("\nEntre com o nome do no inicial: ");
  gets(nome);
  indice = retornaIndice(nome);
  if (indice == -1)
    puts("Este nome nao pertence ao grafo");
  else
  {
    printf("Imprimindo os nos: ");
    printf("%s   ", vetor[indice].descricao);
    vetor[indice].visitado = 1;
    push(indice);
    while (!pilhaVazia())
    {
      indice = pegaVerticeAdjNaoVisitado(p.vetor[p.topo]);
      if (indice == -1)
        pop();
	//indice = pop();
      else
      {
	printf("%s   ", vetor[indice].descricao);
	vetor[indice].visitado = 1;
	push(indice);
      }
    }
  }
  printf("\n");
  zeraAsVisitas();
}//profund()

void comecarDeNovo()
{
  clrscr();
  puts("\nCome‡ar Tudo de Novo");
  zerarVariaveis();
}

int main()
{
  char c, op = '1';
  zerarVariaveis();
  while (op != '0')
  {
    clrscr();
    puts("              Exercicio 1 da 1a Avalia‡Æo de AEDII\n\n");
    puts("1. Montar grafo");
    puts("2. Verificar adjacˆncia");
    puts("3. Imprimir matriz de adjacˆncia");
    puts("4. Caminhamento em Amplitude");
    puts("5. Caminhamento em Profundidade");
    puts("6. Come‡ar de novo");
    puts("0. Sair");
    printf("Entre com sua opcao: ");
    op = getche();
    switch(op)
    {
      case '1': montarGrafo();             break;
      case '2': verificarAdjacencia();     break;
      case '3': imprimirMatriz();          break;
      case '4': caminhamentoAmplitude();   break;
      case '5': caminhamentoProfundidade();break;
      case '6': comecarDeNovo();           break;
      case '0':                            break;
      default : puts("\nOpcao invalida");
    } /* switch */
    puts("\nPressione <ENTER> para continuar");
    while ((c = getchar()) != '\n');
  } /* while */
} /* funcao main () */
