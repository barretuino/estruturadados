package arvores;

public class Arvore {
	No raiz;

	public void imprimir() {
		raiz.imprimir();
	}
	
	public No buscar(int valor) {
		if(raiz == null) return null;
		return raiz.buscar(valor);
	}

	public void inserir(int valor) {
		No novo = new No(valor);
		if (raiz == null) raiz = novo;
		else raiz.inserir(novo.getDado());
		
		if(raiz.balanceado() != 0) {
			int raizBal = raiz.balanceado();
			if(raizBal == 1)      rotacaoDireitaRaiz();
			else if(raizBal == 2) rotacaoEsquerdaRaiz();
			else if(raizBal == 3) rotacaoDuplaDireitaRaiz();
			else if(raizBal == 4) rotacaoDuplaEsquerdoRaiz();
		}
	}

	private void rotacaoDuplaEsquerdoRaiz() {
		System.out.println("RDE - raiz");
		No tmpRaiz = raiz;
		No tmpRaizDireito = raiz.direito;
		No tmpRaizDireitoEsquerdo = raiz.direito.esquerdo;
		No tmpRaizDireitoEsquerdoEsquerdo = raiz.direito.esquerdo.esquerdo;
		No tmpRaizDireitoEsquerdoDireito = raiz.direito.esquerdo.direito;
		raiz = tmpRaizDireitoEsquerdo;
		raiz.esquerdo = tmpRaiz;
		raiz.direito = tmpRaizDireito;
		raiz.esquerdo.direito = tmpRaizDireitoEsquerdoEsquerdo;
		raiz.direito.esquerdo = tmpRaizDireitoEsquerdoDireito;
		raiz.profundidade ++;
		tmpRaiz.profundidade -= 2;
		tmpRaizDireito.profundidade --;
	}

	private void rotacaoDuplaDireitaRaiz() {
		System.out.println("RDD - raiz");
		No tmpRaiz = raiz;
		No tmpRaizEsquerdo = raiz.esquerdo;
		No tmpRaizEsquerdoDireito = raiz.esquerdo.direito;
		No tmpRaizEsquerdoDireitoEsquerdo = raiz.esquerdo.direito.esquerdo;
		No tmpRaizEsquerdoDireitoDireito = raiz.esquerdo.direito.direito;
		raiz = tmpRaizEsquerdoDireito;
		raiz.esquerdo = tmpRaizEsquerdo;
		raiz.direito = tmpRaiz;
		raiz.esquerdo.direito = tmpRaizEsquerdoDireitoEsquerdo;
		raiz.direito.esquerdo = tmpRaizEsquerdoDireitoDireito;
		raiz.profundidade ++;
		tmpRaiz.profundidade -= 2;
		tmpRaizEsquerdo.profundidade --;
	}

	private void rotacaoEsquerdaRaiz() {
		System.out.println("RE - raiz");
		No tmpRaiz = raiz;
		No tmpRaizDireito = raiz.direito;
		No tmpRaizDireitoEsquerdo = raiz.direito.esquerdo;
		raiz = tmpRaizDireito;
		raiz.esquerdo = tmpRaiz;
		raiz.esquerdo.direito = tmpRaizDireitoEsquerdo;
		tmpRaiz.profundidade -= 2;
	}

	private void rotacaoDireitaRaiz() {
		System.out.println("RD - raiz");
		No tmpRaiz = raiz;
		No tmpRaizEsquerdo = raiz.esquerdo;
		No tmpRaizEsquerdoDireito = raiz.esquerdo.direito;
		raiz = tmpRaizEsquerdo;
		raiz.direito = tmpRaiz;
		raiz.direito.esquerdo = tmpRaizEsquerdoDireito;
		tmpRaiz.profundidade -= 2;
	}

	public int profundidade() {
		if(raiz == null) return 0;
		return raiz.profundidade();
	}
}