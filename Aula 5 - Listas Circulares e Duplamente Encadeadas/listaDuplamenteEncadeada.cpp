#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>

struct no
{
  char nome[30];
  struct no *anterior, *proximo;
};

void insereNoInicio(struct no **inicio, char nome[])
{
  struct no *novo;
  novo = (struct no *) malloc(sizeof(struct no));
  strcpy(novo->nome, nome);
  novo->proximo = NULL;
  novo->anterior = NULL;
  if(*inicio != NULL)
  {
    novo->proximo = *inicio;
    (*inicio)->anterior = novo;
  }
  *inicio = novo;
}

void insereNoFinal(struct no **inicio, char nome[])
{
  struct no *novo, *aux;
  if (*inicio == NULL)
  {
    insereNoInicio(&*inicio, nome);
  }
  else
  {
    novo = (struct no *) malloc(sizeof(struct no));
    strcpy(novo->nome, nome);
    novo->proximo = NULL;
    novo->anterior = NULL;
    aux = *inicio;
    while(aux->proximo != NULL)
    {
      aux = aux->proximo;
    }
    aux->proximo = novo;
    novo->anterior = aux;
  }
}

void imprime(struct no *inicio)
{
  struct no *aux;
  if (inicio == NULL)
  {
    printf("\nLista Vazia");
  }
  else
  {
    aux = inicio;
    while(aux != NULL)
    {
      printf("\nNome: %s", aux->nome);
      aux = aux->proximo;
    }
  }
  getche();
}

int buscaUm(struct no *inicio, char nome[])
{
  int achou = 0;
  struct no *aux = inicio;
  while((aux != NULL) && (!achou))
  {
    if (strcmp(aux->nome, nome)==0)
    {
      achou = 1;
    }
    else
    {
      aux = aux->proximo;
    }
  }
  return(achou);
}

int buscaTodos(struct no *inicio, char nome[])
{
  int quantos = 0;
  struct no *aux = inicio;
  while(aux != NULL)
  {
    if (strcmp(aux->nome, nome)==0)
    {
      quantos++;
    }
    aux = aux->proximo;
  }
  return(quantos);
}

void removeDoInicio(struct no **inicio)
{
  struct no *aux;
  if(*inicio == NULL)
  {
    printf("\nImpossivel remover do inicio. Lista vazia.");
  }
  else
  {
    aux = *inicio;
    *inicio = (*inicio)->proximo;
    (*inicio)->anterior = NULL;
    printf("\nRemovido o elemento %s do inicio", aux->nome);
    free(aux);
  }
}

void removeDoFinal(struct no **inicio)
{
  struct no *ultimo, *penultimo;
  if(*inicio == NULL)
  {
    printf("\nImpossivel remover do final. Lista vazia.");
  }
  else
  {
    if((*inicio)->proximo == NULL)
    {
      removeDoInicio(&*inicio);
      printf("\nRemovido o unico elemento da lista. Lista vazia.");
    }
    else
    {
      penultimo = *inicio;
      ultimo = (*inicio)->proximo;
      while(ultimo->proximo != NULL)
      {
        penultimo = ultimo;
        ultimo = ultimo->proximo;
      }
      penultimo->proximo = NULL;
      printf("\nRemovido o ultimo elemento %s da lista", ultimo->nome);
      free(ultimo);
    }
  }
}

void removeUm(struct no **inicio, char nome[])
{
  struct no *aux1, *aux2;
  int achou = 0;
  if(*inicio == NULL)
  {
    printf("\nImpossivel remover. Lista vazia.");
  }
  else
  {
    if(strcmp((*inicio)->nome, nome)==0)
    {
      removeDoInicio(&*inicio);
      achou = 1;
    }
    else
    {
      aux1 = *inicio;
      aux2 = aux1->proximo;
      while((aux2 != NULL) && (!achou))
      {
        if(strcmp(aux2->nome, nome)==0)
        {
          achou = 1;
          aux1->proximo = aux2->proximo;
          if(aux2->proximo != NULL)
          {
            aux2->proximo->anterior = NULL;
          }
          printf("\nRemovido o nome %s da lista", nome);
          
          free(aux2);
        }
        else
        {
          aux1 = aux2;
          aux2 = aux2->proximo;
        }
      }
    }
  }
  if(!achou)
  {
    printf("\nImpossivel remover. O nome %s nao existe na lista.", nome);
  }
  getche();
}
void imprimeInvertido(struct no *inicio)
{
  struct no *aux;
  if (inicio == NULL)
  {
    printf("\nLista Vazia");
  }
  else
  {
    aux = inicio;
    while(aux->proximo != NULL)
    {
      aux = aux->proximo;
    }
    while(aux != NULL)
    {
      printf("\nNome: %s", aux->nome);
      aux = aux->anterior;
    }    
  }
  getche();
}

main()
{
  struct no *inicio;
  inicio = NULL;
  char opcao;
  char nome[30];
  int quantos, existe;
  do
  {
    system("cls");
    printf("\n\nExemplos de Operacoes em Listas Lineares Duplamente Encadeadas\n\n");

    printf("1. Insere no Inicio\n");
    printf("2. Insere no Final\n");
    printf("3. Imprimir a lista\n");
    printf("4. Buscar uma ocorrencia\n");
    printf("5. Buscar todas as ocorrencias\n");
    printf("6. Remover do Inicio\n");
    printf("7. Remover do Final\n");
    printf("8. Remover um da Lista \n");
    printf("A. Imprimir a Lista Invertida\n");
    printf("0. Sair\n");
    printf("\nEntre com sua opcao: ");
    scanf("%c", &opcao);
    switch(opcao)
    {
      case '1':
      {
        getc(stdin);
        printf("\nInsercao no Inicio\n");
        printf("\nDigite um nome: ");
        gets(nome);
        insereNoInicio(&inicio, nome);
      }
      break;

      case '2':
      {
        getc(stdin);
        printf("\nInsercao no Final\n");
        printf("\nDigite um nome: ");
        gets(nome);
        insereNoFinal(&inicio, nome);
      }
      break;

      case '3':
      {
        getc(stdin);
        printf("\nImpressao da Lista\n");
        imprime(inicio);
      }
      break;

      case '4':
      {
        getc(stdin);
        printf("\nBuscar uma Ocorrencia\n");
        printf("\nDigite um nome: ");
        gets(nome);
        existe = buscaUm(inicio, nome);
        if(existe == 1)
        {
          printf("\nO nome %s foi encontrado na lista", nome);
        }
        else
        {
          printf("\nO nome %s nao existe na lista", nome);
        }
        getche();
      }
      break;

      case '5':
      {
        getc(stdin);
        printf("\nBuscar todas as Ocorrencias\n");
        printf("\nDigite um nome: ");
        gets(nome);
        quantos = buscaTodos(inicio, nome);
        printf("\nExistem %d ocorrencias do nome %s na lista", quantos, nome);
        getche();
      }
      break;

      case '6':
      {
        getc(stdin);
        printf("\nRemover do Inicio da Lista\n");
        removeDoInicio(&inicio);
      }
      break;

      case '7':
      {
        getc(stdin);
        printf("\nRemover do Final da Lista\n");
        removeDoFinal(&inicio);
      }
      break;

      case '8':
      {
        getc(stdin);
        printf("\nRemover um da Lista\n");
        printf("\nDigite um nome: ");
        gets(nome);
        removeUm(&inicio, nome);
      }
      break;

      case 'A':
      {
        getc(stdin);
        printf("\nImprimir a Lista Invertida\n");
        imprimeInvertido(inicio);
      }
      break;      

      case '0':
      {
        break;
      }

      default : printf("\nOpcao invalida");
    }     /* switch */
  }
  while(opcao != '0');
}
