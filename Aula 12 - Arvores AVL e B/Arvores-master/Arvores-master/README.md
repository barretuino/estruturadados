# Árvores
![img](https://github.com/AlekOliveira/Arvores/blob/master/exemploAvre.png)

### O que são e quais suas funções?

Árvore, no contexto da programação, engenharia de software e ciência da computação, é uma das mais importantes estruturas de dados não lineares. Herda as características das topologia em árvore. Conceitualmente diferente das listas, em que os dados se encontram numa sequência, nas árvores os dados estão dispostos de forma hierárquica, seus elementos se encontram "acima" ou "abaixo" de outros elementos da árvore.

São estruturas eficientes e simples em relação ao tratamento computacional, diferentemente dos grafos. Há inúmeros problemas no mundo real que podem ser modelados e resolvidos através das árvores. Estruturas de pastas de um sistema operacional, interfaces gráficas, bancos de dados, auto-complete de textos e sites da internet são exemplos de aplicações de árvores.

Uma árvore é formada por um conjunto de elementos que armazenam informações chamados nodos (ou nós). Toda a árvore possui o elemento chamado raiz, que possui ligações para outros elementos denominados ramos ou filhos. Estes ramos podem estar ligados a outros elementos que também podem possuir outros ramos. O elemento que não possui ramos é conhecido como nó folha, nó terminal ou nó externo.

Uma terminologia muito utilizada nas estruturas de árvores tem origem das árvores genealógicas. O relacionamento entre nodos é descrito com os termos "pai" (ou "mãe") para os antecessores diretos de um nodo, "filhos" (ou "filhas") para os descendentes diretos e "irmãos" (ou "irmãs") para todos os nodos com mesmo pai.

# Árvores implementadas neste projeto

## Btree

Árvores B são uma generalização das árvores binária de busca, pois cada nó de uma árvore binária armazena uma única chave de busca, enquanto as árvores B armazenam um número maior do que um de chaves de busca em cada nó, ou no termo mais usual para essa árvore, em cada página. Como a ideia principal das árvores B é trabalhar com dispositivos de memória secundária, quanto menos acessos a disco a estrutura de dados proporcionar, melhor será o desempenho do sistema na operação de busca sobre os dados manipulados.

As árvores B são organizadas por nós, tais como os das árvores binárias de busca, mas estes apresentam um conjunto de chaves maior do que um e são usualmente chamados de páginas. As chaves em cada página são, no momento da inserção, ordenadas de forma crescente e para cada chave há dois endereços para páginas filhas, sendo que, o endereço à esquerda é para uma página filha com um conjunto de chaves menor e o à direita para uma página filha com um conjunto de chaves maior.

![img](https://github.com/AlekOliveira/Arvores/blob/master/exemploBtree.png)

Exemplo de uma árvore B de ordem = 2.

## Btree+

A árvore B+ aparentemente foi proposta por Knuth e grande parte da literatura sobre essa estrutura é encontrada em forma de artigos ao invés de livros. Com ela foi possível organizar um arquivo de maneira que o processamento sequencial (característica até então pouco eficiente para árvores B) e aleatório de chaves fossem eficientes.
A idéia inicial desta variação da árvore B é manter todas as chaves de busca em seus nós folha de maneira que o acesso sequencial ordenado das chaves de busca seja um processo mais eficiente do que em árvores B. 

![img](https://github.com/AlekOliveira/Arvores/blob/master/exemploBplus.png)

Exemplo de uma árvore B+, pode se notar que as folhas possuem todas as chaves.


## N-area
  Uma árvore N-ária (também conhecida como k-ária ou k-way) é uma árvore enraizada na qual cada nó não tem mais que **N** filhos. Uma árvore binária é o caso especial em que **N = 2**, e uma árvore ternária é outro caso com **N = 3** que limita seus filhos a três.

![img](https://github.com/AlekOliveira/Arvores/blob/master/exemploNarea.png)

Exemplo de uma N-area com **N = 5**



## Patricia
  A árvore PATRICIA é uma representação compacta de uma Trie onde os nós que teriam apenas um filho são agrupados nos seus antecessores. É comum que as árvores Trie possuam um grupo disperso de chaves, desse modo, muitos nós possuem apenas um descendente. Isto faz com que as Trie tenham um custo grande de espaço. 

Concebido por Donald Morrison, PATRICIA é um algoritmo para realização de buscas em árvores com as chaves dos nós representadas em binário, sem armazenar as chaves nos nós. O nome é um acrônimo de “Practical Algorithm To Retrieve Information Coded In Alphanumeric”, e o método é particularmente útil para tratamento de chaves de tamanho variável extremamente longas, tais como títulos e frases. No caso de pesquisas analíticas, os dados podem tirar proveito deste método desde que as informações sejam armazenadas como cadeias de texto. Você pode saber mais sobre Árvores Patricia [clicando aqui](https://pt.wikipedia.org/wiki/Árvore_Patricia). 

![img](https://github.com/AlekOliveira/Arvores/blob/master/exemploPatricia.png)

