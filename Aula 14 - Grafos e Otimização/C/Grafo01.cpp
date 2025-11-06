#include <stdio.h>
#include <string.h>
#include <conio.h>
#include <alloc.h>

#define MAXNO 50
#define MAXARC 10
#define auxnul (struct auxlist *)NULL
#define vetApnul (struct varDin *)NULL

//prototipos de funcoes
int leitura();
int obtemIndice (char no[30]);
void lerPares (char no1[30], char no2[30]);
int existenoVetor (char no[30]);
void inserenoVetor (char no[30]);
void insereVardin (char no1[30], char no2[30]);
void impListaAdj();
void impVetor();
void impMatriz();
void impVardin();
void insereMatriz (int linha, int coluna);
void remover();
void plotarGrafo();
//prototipo dos caminhamentos
void AmpMat();
void AmpLista();
void AmpVar();
void ProfMat();
void ProfLista();
void ProfVar();

struct vetor {
	char descricao[30];
	int visita; //marca de "j  visitado - booleano: 1->visitado; 0->nao vis.
};

struct pilha {
	char descricao[MAXNO+1][30]; //MAXNO+1 para evitar de causar overflow
	int topo;
};

struct fila {
	char descricao[MAXNO+1][30]; //MAXNO+1 para evitar de causar overflow
	int inicio, final, qtos;
};

struct lista {
	char no[30];
	int qtdearcos;
	struct auxlist *prox;
};

struct auxlist {	//estrutura auxiliar para a lista de adjacencia
	char no[30];
	struct auxlist *prox;
} *auxl, *ultimo[MAXNO], *p1, *p2;

struct vetorApoio {
	char no[30];
	struct varDin *pont;
};

struct varDin {
	char no[30];
	int visitado;
	struct varDin *pont[MAXARC];
} *newbox1, *newbox2;

//vari veis globais:
int matadj[MAXNO][MAXNO];
struct vetor vetor[MAXNO];
struct pilha pilha;
struct fila fila;
struct lista lista[MAXNO];
struct vetorApoio vetAp[MAXNO];
int indiceVetor;
int controle=0; //controle das op‡oes de leitura (teclado ou arquivo-texto)
FILE *nomes;

void inicializaGrafo()
{
int i, j;
for (i=0; i<MAXNO; i++)
{
	for (j=0; j<MAXNO; j++)
		matadj[i][j] = 0;
	strcpy(vetor[i].descricao, "");
	vetor[i].visita = 0;
	strcpy(lista[i].no, "");
	lista[i].qtdearcos = 0;
	free(lista[i].prox);
	lista[i].prox = auxnul;
	free(ultimo[i]);
	ultimo[i] = auxnul;
	free(vetAp[i].pont);
	vetAp[i].pont = vetApnul;
	strcpy(vetAp[i].no, "");
}
free(auxl);
p1 = p2 = auxl = auxnul;
free(newbox1);
newbox1 = vetApnul;
free(newbox2);
newbox2 = vetApnul;
indiceVetor = -1;
fila.inicio = fila.qtos = 0;
pilha.topo = fila.final = -1;
rewind(nomes);
controle = 0;
} //inicializaGrafo()

int menu()
{
int opt;
clrscr();
puts("GRAFOS - MENU");
puts("1 - Ler pares de n¢s");
puts("2 - Caminhamento em Amplitude");
puts("3 - Caminhamento em Profundidade");
puts("4 - Plotar o Grafo");
puts("5 - Imprimir algum tipo de estrutura");
puts("6 - Remover algum n¢");
puts("9 - Come‡ar tudo de novo (inicializar tudo)");
puts("0 - Sair");
printf("=> ");
scanf("%d", &opt);
return(opt);
} //menu()

void main()
{
char no1[30], no2[30];
int opt, op2, op=-1, i, linha, coluna, no1exist, no2exist, naoinsere;
int exist1, exist2; //variaveis auxiliares para inserir pelo arquivo-texto na matriz
nomes = fopen("arcos.txt", "r");
inicializaGrafo();
while (op!=0)
{
	op = menu();
	switch(op)
	{
		case 1: {
			if (controle == 0)
				op2 = leitura();
			if ((op2 == 1) && (controle == 1))
			{
				lerPares(no1, no2);
				no1exist = 0;
				no2exist = 0;
				for (i=0; i<MAXNO; i++)
				{
					if (strcmp(vetor[i].descricao, no1)==0)
					{
						no1exist = 1;
						break;
					}
				}//for
				for (i=0; i<MAXNO; i++)
				{
					if (strcmp(vetor[i].descricao, no2)==0)
					{
						no2exist = 1;
						break;
					}
				}//for
				if ((indiceVetor == (MAXNO-1)) && ((no1exist == 0) || (no2exist == 0)))
					naoinsere = 1;
				else
					naoinsere = 0;
				if (naoinsere != 1)
				{
					for (i=0; i<MAXNO; i++)
						if (strcmp(lista[i].no, no1)==0)
							break;
					if (lista[i].qtdearcos >= MAXARC)
					{
						printf("\nO n£mero de arcos que saem desse n¢ j  atingiu o limite m ximo.");
						getch();
						break;
					}
					//inser‡ao na matriz de adjacencia
					linha = obtemIndice(no1);
					coluna = obtemIndice(no2);
					insereMatriz (linha, coluna);
					//inser‡ao na lista de adjacencia
					auxl = (struct auxlist *) malloc (sizeof (struct auxlist));
					auxl->prox = auxnul;
					strcpy (auxl->no, no2);
					if (lista[i].prox == auxnul)
						lista[i].prox = auxl;
					else
						ultimo[i]->prox = auxl;
					ultimo[i] = auxl;
					lista[i].qtdearcos++;
					//inser‡ao nas vari veis dinƒmicas
					insereVardin(no1, no2);
				} //if
				else
				{
					printf("\nO n£mero m ximo de n¢s permitido j  atingiu o limite.");
					getch();
				}
			} //if
			else if ((op2 == 2) && (controle == 1))
			{
				while (!feof(nomes))
				{
					int tam1, tam2;
					fgets(no1, 30, nomes);
					fgets(no2, 30, nomes);
					tam1 = strlen(no1);
					tam2 = strlen(no2);
					if (((tam1>=2) || (tam2>=2)) && !feof(nomes))
					{
						printf("%s", no1);
						printf("%s", no2);
						no1[tam1-1] = '\0';
						no2[tam2-1] = '\0';
						printf("%s", no1);
						printf("%s\n", no2);
						//inser‡ao na matriz de adjacencia
						exist1 = existenoVetor(no1);
						exist2 = existenoVetor(no2);
						if (!exist1)
							inserenoVetor(no1);
						if (!exist2)
							inserenoVetor(no2);
						linha = obtemIndice(no1);
						coluna = obtemIndice(no2);
						insereMatriz (linha, coluna);
						//inser‡ao na lista de adjacencia
						for (i=0; i<MAXNO; i++)
							if (strcmp(lista[i].no, no1)==0)
								break;
						auxl = (struct auxlist *) malloc (sizeof (struct auxlist));
						auxl->prox = auxnul;
						strcpy (auxl->no, no2);
						if (lista[i].prox == auxnul)
							lista[i].prox = auxl;
						else
							ultimo[i]->prox = auxl;
						ultimo[i] = auxl;
						lista[i].qtdearcos++;
						//inser‡ao nas vari veis dinƒmicas
						insereVardin(no1, no2);
						//getch();
					} //if
				}
				controle = 2;
			}
			else if (controle == 2)
			{
				printf("\nA leitura pelo arquivo-texto jah foi realizada.");
				getch();
			}
		} break;
		case 2: {
			clrscr();
			puts("Em qual dessas estruturas desejas fazer o caminhamento em amplitude?");
			puts("1 - Matriz de Adjacˆncia");
			puts("2 - Lista de Adjacencia");
			puts("3 - Conjunto de Vari veis Dinƒmicas");
			printf("=> ");
			scanf("%d", &opt);
			switch(opt)
			{
				case 1: AmpMat(); break;
				case 2: AmpLista(); break;
				case 3: AmpVar(); break;
			} //switch
		} break; //case 2
		case 3: {
			clrscr();
			puts("Em qual dessas estruturas desejas fazer o caminhamento em profundidade?");
			puts("1 - Matriz de Adjacˆncia");
			puts("2 - Lista de Adjacencia");
			puts("3 - Conjunto de Vari veis Dinƒmicas");
			printf("=> ");
			scanf("%d", &opt);
			switch(opt)
			{
				case 1: ProfMat(); break;
				case 2: ProfLista(); break;
				case 3: ProfVar(); break;
			} //switch
		} break; //case 3
		case 4: plotarGrafo(); break;
		case 5: {
			clrscr();
			puts("Qual estrutura desejas imprimir?");
			puts("1 - Imprimir Matriz de Adjacˆncia");
			puts("2 - Imprimir Vetor");
			puts("3 - Imprimir Lista de Adjacencia");
			puts("4 - Imprimir Conjunto de Vari veis Dinƒmicas");
			printf("=> ");
			scanf("%d", &opt);
			switch(opt)
			{
				case 1: impMatriz(); break;
				case 2: impVetor(); break;
				case 3: impListaAdj(); break;
				case 4: impVardin(); break;
			} //switch
		} break; //case 5
		case 6: remover(); break;
		case 9: inicializaGrafo(); break;
	} //switch
} //while
fclose(nomes);
} //main()

int leitura()
{
int op2;
puts("");
puts("Como ‚ a primeira vez, escolha uma das duas op‡oes abaixo:");
puts("1 - Inserir pares de n¢s manualmente (a partir do teclado)");
puts("2 - Obter pares de n¢s a partir do arquivo texto ARCOS.TXT");
printf("=> ");
scanf("%d", &op2);
controle = 1;
return(op2);
} //leitura

int obtemIndice (char no[30])
{
int i, indice;
for (i=0; i<MAXNO; i++)
{
	if (strcmp(vetor[i].descricao, no)==0)
		indice = i;
}
return (indice);
} //obtemIndice()

void lerPares (char no1[30], char no2[30])
{
int i, entrou=0, existe1, existe2;
printf("\nDigite a descricao do primeiro n¢: "); getchar();
gets(no1);
printf("Digite a descricao do segundo n¢: ");
gets(no2);
for (i=0; i<MAXNO; i++)
	if (strcmp(lista[i].no, no1)==0)
	{
		entrou = 1;
		break;
	}

if ((entrou == 1) && (lista[i].qtdearcos >= MAXARC))
	return;

existe1 = existenoVetor(no1);
existe2 = existenoVetor(no2);
if (!existe1)
	inserenoVetor(no1);
if (!existe2)
	inserenoVetor(no2);
} //lerPares()

int existenoVetor (char no[30])
{
int i=0;
if (indiceVetor == -1)
	return 0;
while ((i < MAXNO) && (strcmp (no, vetor[i].descricao)!=0))
	i++;
if (i == MAXNO)
	return 0;
else
	return 1;
} //existenoVetor()

void inserenoVetor (char no[30])
{
if (indiceVetor != (MAXNO-1))
{
strcpy (vetor[++indiceVetor].descricao, no);
strcpy (lista[indiceVetor].no, no);
strcpy (vetAp[indiceVetor].no, no);
} //if
} //inserenoVetor()

void insereVardin (char no1[30], char no2[30])
{
//inser‡ao nas vari veis dinƒmicas
int i, j;
for (i=0; i<MAXNO; i++)
	if (strcmp(vetAp[i].no, no1)==0)
		break;
if (vetAp[i].pont == vetApnul)
{
	newbox1 = (struct varDin *) malloc (sizeof (struct varDin));
	for (j=0; j<MAXARC; j++)
		newbox1->pont[j] = vetApnul;
	newbox1->visitado = 0;
	strcpy (newbox1->no, no1);
	vetAp[i].pont = newbox1;
}
else
	newbox1 = vetAp[i].pont;
for (i=0; i<MAXNO; i++)
	if (strcmp(vetAp[i].no, no2)==0)
		break;
if (vetAp[i].pont == vetApnul)
{
	newbox2 = (struct varDin *) malloc (sizeof (struct varDin));
	for (j=0; j<MAXARC; j++)
		newbox2->pont[j] = vetApnul;
	newbox2->visitado = 0;
	strcpy (newbox2->no, no2);
	vetAp[i].pont = newbox2;
}
else
	newbox2 = vetAp[i].pont;
j=0;
while (newbox1->pont[j] != vetApnul)
	j++;
newbox1->pont[j] = newbox2;
} //insereVardin()

void impVetor()
{
int i=0;
if (indiceVetor == -1)
	puts("Erro: vetor vazio!");
else
{
	while (i <= indiceVetor)
	{
		printf("%s ", vetor[i].descricao);
		i++;
	}
} //else
getch();
} //impVetor()

void impMatriz()
{
int l, c, i, x, y;
int tam = 0;
if (indiceVetor == -1)
	puts("Erro: matriz vazia!");
else
{
	clrscr();
	//impresao dos cabe‡alhos das colunas
	for (i=0; i<MAXNO; i++)
	{
		if (tam < strlen(vetor[i].descricao))
			tam = strlen(vetor[i].descricao);
	}
	for (i=0; i<tam; i++)
		printf(" ");
	printf(" ");
	x = wherex();
	for (c=0; c<MAXNO; c++)
		printf("%s ", vetor[c].descricao);
	printf("\n");
	for (l=0; l<=indiceVetor; l++)
	{
		printf("%s ", vetor[l].descricao);
		y = wherey();
		gotoxy(x, y);
		for (c=0; c<=indiceVetor; c++)
		{
			tam = strlen(vetor[c].descricao);
			for (i=0; i<tam/2; i++)
				printf(" ");
			printf("%d", matadj[l][c]);
			tam = strlen(vetor[c].descricao);
			for (i=0; i<tam/2; i++)
				printf(" ");
			if ((tam==1) || (tam==3) || (tam==5) || (tam==7) || (tam==9) || (tam==11) || (tam==13) || (tam==15) || (tam==17) || (tam==19) || (tam==21) || (tam==23) || (tam==25) || (tam==27) || (tam==29))
				printf(" ");
		}
		printf("\n");
	} //for
} //else
getch();
} //impMatriz()

void insereMatriz (int linha, int coluna)
{
	matadj[linha][coluna] = 1;
}

void impListaAdj()
{
int i;
if (indiceVetor == -1)
	puts("Erro: lista vazia!");
else
{
	for (i=0; i<=indiceVetor; i++)
	{
		printf ("\n%s", lista[i].no);
		if (lista[i].prox != auxnul)
		{
			auxl = lista[i].prox;
			while (auxl != auxnul)
			{
				printf(" -> ");
				printf("%s", auxl->no);
				auxl = auxl->prox;
			}
		}
	}
}
getch();
} //impListaAdj()

void impVardin()
{
int i, j;
if (indiceVetor == -1)
	puts("Erro: vari veis vazias!");
else
{
	for (i=0; i<MAXNO; i++)
	{
		if (vetAp[i].pont != vetApnul)
		{
			newbox1 = vetAp[i].pont;
			printf("\n%s", newbox1->no);
			printf(" aponta para: ");
			for (j=0; j<MAXARC; j++)
				if (newbox1->pont[j] != vetApnul)
					printf("%s; ", newbox1->pont[j]->no);
		} //if
	} //for
} //else
getch();
} //impVardin()

void remover()
{
int i, j, k, entrou = 0;
char no[30];
printf("\nQual o n¢ que vocˆ deseja remover? "); getchar();
gets(no);
for (i=0; i<MAXNO; i++)
{
	if (strcmp(vetor[i].descricao, no)==0)
	{
		strcpy (vetor[i].descricao, "");
		j = i;
		entrou = 1;
	}
}
if (entrou == 0)
	puts("\nO n¢ informado nao existe.");
else
{
	//remo‡ao no vetor
	for (i=j; i<MAXNO; i++)
	{
		if (i != (MAXNO-1))
			strcpy (vetor[i].descricao, vetor[i+1].descricao);
		else
			strcpy (vetor[i].descricao, "");
	} //for
	//remo‡ao na matriz de adjacencia
	for (i=0; i<MAXNO; i++)
	{
		matadj[i][j] = 0;
		matadj[j][i] = 0;
	}
	for (i=0; i<MAXNO; i++)
	{
		for (k=j; k<MAXNO; k++)
		{
			if (k!=(MAXNO-1))
				matadj[i][k] = matadj[i][k+1];
			else
				matadj[i][k] = 0;
		} //for
	} //for
	for (i=0; i<MAXNO; i++)
	{
		for (k=j; k<MAXNO; k++)
		{
			if (k!=(MAXNO-1))
				matadj[k][i] = matadj[k+1][i];
			else
				matadj[k][i] = 0;
		} //for
	} //for
	//remo‡ao na lista de adjacencia
	for (i=0; i<MAXNO; i++)
	{
		p2 = lista[i].prox;
		if (p2 != auxnul)
		{
			if (strcmp(p2->no, no)==0)
			{
				lista[i].prox = p2->prox;
				p2->prox = auxnul;
				free(p2);
				lista[i].qtdearcos--;
			}
			else
			{
				p1 = p2;
				p2 = p2->prox;
				while ((p2 != auxnul) && (strcmp(p2->no, no)!=0))
				{
					p1 = p2;
					p2 = p2->prox;
				}
				if (p2 != auxnul)
				{
					p1->prox = p2->prox;
					p2->prox = auxnul;
					free(p2);
					lista[i].qtdearcos--;
					if (p1->prox == auxnul)
						ultimo[i] = p1;
				} //if
			} //else
		} //if
	} //for
	p1 = lista[j].prox;
	ultimo[j] = lista[j].prox = auxnul;
	strcpy (lista[j].no, "");
	free(p1);
	lista[j].qtdearcos = 0;
	for (i=j; i<MAXNO; i++)
	{
		if (i!=(MAXNO-1))
		{
			p1 = lista[i+1].prox;
			strcpy (lista[i].no, lista[i+1].no);
			lista[i].qtdearcos = lista[i+1].qtdearcos;
			lista[i].prox = p1;
			ultimo[i] = ultimo[i+1];
		}
		else
		{
			lista[i].qtdearcos = 0;
			strcpy (lista[i].no, "");
			lista[i].prox = ultimo[i] = auxnul;
		}
	} //for
	//remo‡ao no conjunto de vari veis dinƒmicas
	for (i=0; i<MAXNO; i++)
	{
		j = 0;
		newbox1 = vetAp[i].pont;
		while ((j!=MAXARC) && (newbox1->pont[j] != vetApnul))
		{
			if (strcmp (newbox1->pont[j]->no, no)==0)
			{
				newbox1->pont[j] = vetApnul;
				for (k=j; k<MAXARC; k++)
				{
					if (k!=(MAXARC-1))
						newbox1->pont[k] = newbox1->pont[k+1];
					else
						newbox1->pont[k] = vetApnul;
				} //for
			} //if
			j++;
		} //while
	} //for
	for (i=0; i<MAXNO; i++)
		if (strcmp (vetAp[i].no, no)==0)
			break;
	for (j=0; j<MAXARC; j++)
		vetAp[i].pont->pont[j] = vetApnul;
	newbox1 = vetAp[i].pont;
	vetAp[i].pont = vetApnul;
	free(newbox1);
	strcpy (vetAp[i].no, "");
	for (k=i; k<MAXNO; k++)
	{
		if (k != (MAXNO-1))
		{
			strcpy (vetAp[k].no, vetAp[k+1].no);
			vetAp[k].pont = vetAp[k+1].pont;
		}
		else
		{
			strcpy (vetAp[k].no, "");
			vetAp[k].pont = vetApnul;
		}
	} //for

	indiceVetor--;
	printf("\nO n¢ foi removido com sucesso.");
} //else
getch();
} //remover()

//CAMINHAMENTOS EM AMPLITUDE
//1 - Na Matriz de Adjacˆncia
void AmpMat()
{
char noInicio[30];
int OK=0, i, j, k;
printf("\nQual o n¢ a come‡ar o caminhamento? "); getchar();
gets(noInicio);
for (i=0; i<MAXNO; i++)
{
	if (strcmp (noInicio, vetor[i].descricao)==0)
	{
		OK = 1;
		break;
	}
}
if (OK==0)
	printf("\nO n¢ informado nao existe.");
else
{
	printf("\n%s ", noInicio);
	vetor[i].visita = 1;
	for (j=0; j<MAXNO; j++)
	{
		if ((matadj[i][j] == 1) && (vetor[j].visita != 1))
		{
			strcpy (fila.descricao[++fila.final], vetor[j].descricao);
			fila.qtos++;
			printf("%s ", vetor[j].descricao);
			vetor[j].visita = 1;
		} //if
	} //for
	while (fila.inicio <= fila.final)
	{
		for (k=fila.inicio; k<fila.qtos; k++)
		{
			for (i=0; i<MAXNO; i++)
				if (strcmp (fila.descricao[k], vetor[i].descricao)==0)
					break;
			for (j=0; j<MAXNO; j++)
			{
				if ((matadj[i][j] == 1) && (vetor[j].visita != 1))
				{
					strcpy (fila.descricao[++fila.final], vetor[j].descricao);
					fila.qtos++;
					printf("%s ", vetor[j].descricao);
					vetor[j].visita = 1;
				} //if
			} //for
			fila.inicio++;
		} //for
	} //while
	for (i=0; i<MAXNO; i++)
		vetor[i].visita = 0;
	fila.inicio = fila.qtos = 0;
	fila.final = -1;
} //else
getch();
} //AmpMat()

//2 - Na Lista de Adjacˆncia
void AmpLista()
{
char noInicio[30];
int OK=0, i, j;
printf("\nQual o n¢ a come‡ar o caminhamento? "); getchar();
gets(noInicio);
for (i=0; i<MAXNO; i++)
{
	if (strcmp (noInicio, lista[i].no)==0)
	{
		OK = 1;
		break;
	}
}
if (OK==0)
	printf("\nO n¢ informado nao existe.");
else
{
	printf("\n%s ", noInicio);
	vetor[i].visita = 1;
	auxl = lista[i].prox;
	while (auxl != auxnul)
	{
		for (i=0; i<MAXNO; i++)
			if (strcmp (auxl->no, vetor[i].descricao)==0)
				break;
		if (vetor[i].visita != 1)
		{
			strcpy (fila.descricao[++fila.final], auxl->no);
			fila.qtos++;
			printf("%s ", auxl->no);
			for (i=0; i<MAXNO; i++)
				if (strcmp (auxl->no, vetor[i].descricao)==0)
					break;
			vetor[i].visita = 1;
		} //if
		auxl = auxl->prox;
	} //while
	while (fila.inicio <= fila.final)
	{
		for (j=fila.inicio; j<fila.qtos; j++)
		{
			for (i=0; i<MAXNO; i++)
				if (strcmp (fila.descricao[j], lista[i].no)==0)
					break;
			auxl = lista[i].prox;
			while (auxl != auxnul)
			{
				for (i=0; i<MAXNO; i++)
					if (strcmp (auxl->no, vetor[i].descricao)==0)
						break;
				if (vetor[i].visita != 1)
				{
					strcpy (fila.descricao[++fila.final], auxl->no);
					fila.qtos++;
					printf("%s ", auxl->no);
					vetor[i].visita = 1;
				} //if
				auxl = auxl->prox;
			} //while
			fila.inicio++;
		} //for
	} //while
	for (i=0; i<MAXNO; i++)
		vetor[i].visita = 0;
	fila.inicio = fila.qtos = 0;
	fila.final = -1;
} //else
getch();
} //AmpLista()

//3 - No Conjunto de Vari veis Dinƒmicas
void AmpVar()
{
char noInicio[30];
int OK=0, i, j;
printf("\nQual o n¢ a come‡ar o caminhamento? "); getchar();
gets(noInicio);
for (i=0; i<MAXNO; i++)
{
	if (strcmp (noInicio, vetAp[i].no)==0)
	{
		OK = 1;
		break;
	}
}
if (OK==0)
	printf("\nO n¢ informado nao existe.");
else
{
	printf("\n%s ", noInicio);
	newbox1 = vetAp[i].pont;
	newbox1->visitado = 1;
	for (i=0; i<MAXARC; i++)
	{
		if ((newbox1->pont[i] != vetApnul) && (newbox1->pont[i]->visitado != 1))
		{
			strcpy (fila.descricao[++fila.final], newbox1->pont[i]->no);
			fila.qtos++;
			printf("%s ", newbox1->pont[i]->no);
			newbox1->pont[i]->visitado = 1;
		} //if
	} //for
	while (fila.inicio <= fila.final)
	{
		for (j=fila.inicio; j<fila.qtos; j++)
		{
			for (i=0; i<MAXNO; i++)
				if (strcmp (fila.descricao[j], vetAp[i].no)==0)
					break;
			newbox1 = vetAp[i].pont;
			for (i=0; i<MAXARC; i++)
			{
				if ((newbox1->pont[i] != vetApnul) && (newbox1->pont[i]->visitado != 1))
				{
					strcpy (fila.descricao[++fila.final], newbox1->pont[i]->no);
					fila.qtos++;
					printf("%s ", newbox1->pont[i]->no);
					newbox1->pont[i]->visitado = 1;
				} //if
			} //for
			fila.inicio++;
		} //for
	} //while
	for (i=0; i<MAXNO; i++)
		vetAp[i].pont->visitado = 0;
	fila.inicio = fila.qtos = 0;
	fila.final = -1;
} //else
getch();
} //AmpVar()

//CAMINHAMENTOS EM PROFUNDIDADE
//1 - Na Matriz de Adjacˆncia
void ProfMat()
{
char noInicio[30];
int OK=0, i, j, aindatemno=0;
printf("\nQual o n¢ a come‡ar o caminhamento? "); getchar();
gets(noInicio);
for (i=0; i<MAXNO; i++)
{
	if (strcmp (noInicio, vetor[i].descricao)==0)
	{
		OK = 1;
		break;
	}
}
if (OK==0)
	printf("\nO n¢ informado nao existe.");
else
{
	printf("\n%s ", noInicio);
	vetor[i].visita = 1;
	strcpy (pilha.descricao[++pilha.topo], noInicio);
	while (pilha.topo >= 0)
	{
		for (j=0; j<MAXNO; j++)
		{
			if ((matadj[i][j] == 1) && (vetor[j].visita != 1))
			{
				strcpy (pilha.descricao[++pilha.topo], vetor[j].descricao);
				printf("%s ", pilha.descricao[pilha.topo]);
				vetor[j].visita = 1;
				break;
			}
		}
		for (i=0; i<MAXNO; i++)
			if (strcmp (vetor[i].descricao, pilha.descricao[pilha.topo])==0)
				break;
		for (j=0; j<MAXNO; j++)
		{
			if ((matadj[i][j] == 1) && (vetor[j].visita != 1))
			{
				aindatemno = 1;
				break;
			}
		}
		if (aindatemno != 1)
			pilha.topo--;
		aindatemno = 0;
	} //while
	for (i=0; i<MAXNO; i++)
		vetor[i].visita = 0;
	pilha.topo = -1;
} //else
getch();
} //ProfMat()

//2 - Na Lista de Adjacˆncia
void ProfLista()
{
char noInicio[30];
int OK=0, i, aindatemno=0;
printf("\nQual o n¢ a come‡ar o caminhamento? "); getchar();
gets(noInicio);
for (i=0; i<MAXNO; i++)
{
	if (strcmp (noInicio, lista[i].no)==0)
	{
		OK = 1;
		break;
	}
}
if (OK==0)
	printf("\nO n¢ informado nao existe.");
else
{
	printf("\n%s ", noInicio);
	vetor[i].visita = 1;
	auxl = lista[i].prox;
	strcpy (pilha.descricao[++pilha.topo], noInicio);
	while (pilha.topo >= 0)
	{
		for (i=0; i<MAXNO; i++)
			if (strcmp (auxl->no, vetor[i].descricao)==0)
				break;
		if ((auxl != auxnul) && (vetor[i].visita != 1))
		{
			strcpy (pilha.descricao[++pilha.topo], auxl->no);
			printf("%s ", pilha.descricao[pilha.topo]);
			vetor[i].visita = 1;
			for (i=0; i<MAXNO; i++)
				if (strcmp (pilha.descricao[pilha.topo], lista[i].no)==0)
					break;
			auxl = lista[i].prox;
		} //if
		for (i=0; i<MAXNO; i++)
			if (strcmp (auxl->no, vetor[i].descricao)==0)
				break;
		while ((auxl != auxnul) && (vetor[i].visita == 1))
		{
			auxl = auxl->prox;
			for (i=0; i<MAXNO; i++)
				if (strcmp (auxl->no, vetor[i].descricao)==0)
					break;
		} //while
		if (auxl != auxnul)
		{
			for (i=0; i<MAXNO; i++)
				if (strcmp (auxl->no, vetor[i].descricao)==0)
					break;
		} //if
		if ((auxl != auxnul) && (vetor[i].visita != 1))
			aindatemno = 1;
		if (aindatemno != 1)
		{
			pilha.topo--;
			for (i=0; i<MAXNO; i++)
				if (strcmp (pilha.descricao[pilha.topo], lista[i].no)==0)
					break;
			auxl = lista[i].prox;
		} //if
		aindatemno = 0;
	} //while
	for (i=0; i<MAXNO; i++)
		vetor[i].visita = 0;
	pilha.topo = -1;
} //else
getch();
} //AmpLista()

//3 - No Conjunto de Vari veis Dinƒmicas
void ProfVar()
{
char noInicio[30];
int OK=0, i, aindatemno=0;
printf("\nQual o n¢ a come‡ar o caminhamento? "); getchar();
gets(noInicio);
for (i=0; i<MAXNO; i++)
{
	if (strcmp (noInicio, vetAp[i].no)==0)
	{
		OK = 1;
		break;
	}
}
if (OK==0)
	printf("\nO n¢ informado nao existe.");
else
{
	printf("\n%s ", noInicio);
	newbox1 = vetAp[i].pont;
	newbox1->visitado = 1;
	strcpy (pilha.descricao[++pilha.topo], noInicio);
	while (pilha.topo >= 0)
	{
		for (i=0; i<MAXARC; i++)
		{
			if ((newbox1->pont[i] != vetApnul) && (newbox1->pont[i]->visitado != 1))
			{
				strcpy (pilha.descricao[++pilha.topo], newbox1->pont[i]->no);
				printf("%s ", newbox1->pont[i]->no);
				newbox1->pont[i]->visitado = 1;
				break;
			} //if
		} //for
		for (i=0; i<MAXNO; i++)
			if (strcmp (vetAp[i].no, pilha.descricao[pilha.topo])==0)
				break;
		newbox1 = vetAp[i].pont;
		for (i=0; i<MAXARC; i++)
		{
			if ((newbox1->pont[i] != vetApnul) && (newbox1->pont[i]->visitado != 1))
			{
				aindatemno = 1;
				break;
			}
		} //for
		if (aindatemno != 1)
		{
			pilha.topo--;
			for (i=0; i<MAXNO; i++)
				if (strcmp (pilha.descricao[pilha.topo], vetAp[i].no)==0)
					break;
			newbox1 = vetAp[i].pont;
		} //if
		aindatemno = 0;
	} //while
	for (i=0; i<MAXNO; i++)
		vetAp[i].pont->visitado = 0;
	pilha.topo = -1;
} //else
getch();
} //AmpVar()

//PLOTAGEM DO GRAFO
void plotarGrafo()
{
printf("\nFun‡ao ainda nao implementada.");
getch();
} //plotarGrafo()
