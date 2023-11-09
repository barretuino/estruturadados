package arvores;

public class No {
	private int dado;
	No esquerdo;
	No direito;
	int profundidade=1;
	int balanceado=0;

	public No (int dado) {
		this.dado = dado;
		this.esquerdo = null;
		this.direito = null;
	}

	public void imprimir() {
		System.out.println(getDado());
		if (esquerdo != null) esquerdo.imprimir();
		if (direito != null)  direito.imprimir();
	}
	
	public No buscar (int valor) {
		if (valor == getDado ()) return this;
		if (valor < getDado ()) {
			if (esquerdo == null) return null;
			else return esquerdo.buscar (valor); 
		}
		else {
			if (direito == null) return null;
			else return direito.buscar (valor);
		}
	}
	
	public void inserir (int valor) {
		if (getDado () > valor) {
			if (esquerdo == null) esquerdo = new No (valor);
			else esquerdo.inserir (valor);
		}
		else {
			if (direito == null) direito = new No (valor);
			else direito.inserir (valor);
		}

		//Faz o balanceamento
		if(esquerdo != null && esquerdo.balanceado() != 0) {
			int esqBal = esquerdo.balanceado();
			if(esqBal == 1) 	 rotacaoDireitaFilhoEsquerdo();
			else if(esqBal == 2) rotacaoEsquerdaFilhoEsquerdo();
			else if(esqBal == 3) rotacaoDuplaDireitaFilhoEsquerdo();
			else if(esqBal == 4) rotacaoDuplaEsquerdaFilhoEsquerdo();
		}

		if(direito!= null && direito.balanceado() !=0) {
			int dirBal = direito.balanceado();
			if(dirBal == 1) 	 rotacaoDireitaFilhoDireito();
			else if(dirBal == 2) rotacaoEsquerdaFilhoDireito();
			else if(dirBal == 3) rotacaoDuplaDireitaFilhoDireito();
			else if(dirBal == 4) rotacaoDuplaEsquerdaFilhoDireito();
		}
		
		//Memoriza a profundidade
		if (esquerdo == null) profundidade = direito.profundidade + 1;
		else if (direito == null) profundidade = esquerdo.profundidade + 1;
		else profundidade = Math.max (direito.profundidade, esquerdo.profundidade) + 1;
	}
	
	private void rotacaoEsquerdaFilhoDireito() {
		System.out.println("RE");
		No tmpDireito = direito;
		No tmpDireitoDireito = direito.direito;
		No tmpDireitoDireitoEsquerdo = direito.direito.esquerdo;
		direito = tmpDireitoDireito;
		direito.esquerdo = tmpDireito;
		direito.esquerdo.direito = tmpDireitoDireitoEsquerdo;
		tmpDireito.profundidade -= 2;
	}
	
	private void rotacaoDireitaFilhoDireito() {
		System.out.println("RD");
		No tmpDireito = direito;
		No tmpDireitoEsquerdo = direito.esquerdo;
		No tmpDireitoEsquerdoDireito = direito.esquerdo.direito;
		direito = tmpDireitoEsquerdo;
		direito.direito = tmpDireito;
		direito.direito.esquerdo = tmpDireitoEsquerdoDireito;
		tmpDireito.profundidade -= 2;
	}
	
	private void rotacaoDuplaEsquerdaFilhoDireito() {
		System.out.println("RDE");
		No tmpDireito = direito;
		No tmpDireitoDireito = direito.direito;
		No tmpDireitoDireitoEsquerdo = direito.direito.esquerdo;
		No tmpDireitoDireitoEsquerdoEsquerdo = direito.direito.esquerdo.esquerdo;
		No tmpDireitoDireitoEsquerdoDireito = direito.direito.esquerdo.direito;
		direito = tmpDireitoDireitoEsquerdo;
		direito.esquerdo = tmpDireito;
		direito.direito = tmpDireitoDireito;
		direito.esquerdo.direito = tmpDireitoDireitoEsquerdoEsquerdo;
		direito.direito.esquerdo = tmpDireitoDireitoEsquerdoDireito;
		direito.profundidade ++;
		tmpDireito.profundidade -= 2;
		tmpDireitoDireito.profundidade --;
	}

	private void rotacaoDuplaDireitaFilhoDireito() {
		System.out.println("RDD");
		No tmpDireito = direito;
		No tmpDireitoEsquerdo = direito.esquerdo;
		No tmpDireitoEsquerdoDireito = direito.esquerdo.direito;
		No tmpDireitoEsquerdoDireitoEsquerdo = direito.esquerdo.direito.esquerdo;
		No tmpDireitoEsquerdoDireitoDireito = direito.esquerdo.direito.direito;
		direito = tmpDireitoEsquerdoDireito;
		direito.esquerdo = tmpDireitoEsquerdo;
		direito.direito = tmpDireito;
		direito.esquerdo.direito = tmpDireitoEsquerdoDireitoEsquerdo;
		direito.direito.esquerdo = tmpDireitoEsquerdoDireitoDireito;
		direito.profundidade ++;
		tmpDireito.profundidade -= 2;
		tmpDireitoEsquerdo.profundidade --;
	}

	private void rotacaoEsquerdaFilhoEsquerdo() {
		System.out.println("RE");
		No tmpEsquerdo = esquerdo;
		No tmpEsquerdoDireito = esquerdo.direito;
		No tmpEsquerdoDireitoEsquerdo = esquerdo.direito.esquerdo;
		esquerdo = tmpEsquerdoDireito;
		esquerdo.esquerdo = tmpEsquerdo;
		esquerdo.esquerdo.direito = tmpEsquerdoDireitoEsquerdo;
		tmpEsquerdo.profundidade -= 2;
	}
	
	private void rotacaoDireitaFilhoEsquerdo() {
		System.out.println("RD");
		No tmpEsquerdo = esquerdo;
		No tmpEsquerdoEsquerdo = esquerdo.esquerdo;
		No tmpEsquerdoEsquerdoDireito = esquerdo.esquerdo.direito;
		esquerdo = tmpEsquerdoEsquerdo;
		esquerdo.direito = tmpEsquerdo;
		esquerdo.direito.esquerdo = tmpEsquerdoEsquerdoDireito;
		tmpEsquerdo.profundidade -= 2;
	}
	
	private void rotacaoDuplaEsquerdaFilhoEsquerdo() {
		System.out.println("RDE");
		No tmpEsquerdo = esquerdo;
		No tmpEsquerdoDireito = esquerdo.direito;
		No tmpEsquerdoDireitoEsquerdo = esquerdo.direito.esquerdo;
		No tmpEsquerdoDireitoEsquerdoEsquerdo = esquerdo.direito.esquerdo.esquerdo;
		No tmpEsquerdoDireitoEsquerdoDireito = esquerdo.direito.esquerdo.direito;
		esquerdo = tmpEsquerdoDireitoEsquerdo;
		esquerdo.esquerdo = tmpEsquerdo;
		esquerdo.direito = tmpEsquerdoDireito;
		esquerdo.esquerdo.direito = tmpEsquerdoDireitoEsquerdoEsquerdo;
		esquerdo.direito.esquerdo = tmpEsquerdoDireitoEsquerdoDireito;
		esquerdo.profundidade ++;
		tmpEsquerdo.profundidade -= 2;
		tmpEsquerdoDireito.profundidade --;
		
	}

	private void rotacaoDuplaDireitaFilhoEsquerdo() {
		System.out.println("RDD");
		No tmpEsquerdo = esquerdo;
		No tmpEsquerdoEsquerdo = esquerdo.esquerdo;
		No tmpEsquerdoEsquerdoDireito = esquerdo.esquerdo.direito;
		No tmpEsquerdoEsquerdoDireitoEsquerdo = esquerdo.esquerdo.direito.esquerdo;
		No tmpEsquerdoEsquerdoDireitoDireito = esquerdo.esquerdo.direito.direito;
		esquerdo = tmpEsquerdoEsquerdoDireito;
		esquerdo.esquerdo = tmpEsquerdoEsquerdo;
		esquerdo.direito = tmpEsquerdo;
		esquerdo.esquerdo.direito = tmpEsquerdoEsquerdoDireitoEsquerdo;
		esquerdo.direito.esquerdo = tmpEsquerdoEsquerdoDireitoDireito;
		esquerdo.profundidade ++;
		tmpEsquerdo.profundidade -= 2;
		tmpEsquerdoEsquerdo.profundidade --;
	}

	public int balanceado() {
		if (direito == null && esquerdo == null) balanceado = 0;
		else if (esquerdo == null) balanceado =  0 - direito.profundidade;
		else if (direito == null)  balanceado = esquerdo.profundidade - 0;
		else balanceado = esquerdo.profundidade - direito.profundidade;

		if(balanceado == 2) {
			if(esquerdo.balanceado == 1) return 1;	//rotação a direita
			if(esquerdo.balanceado == -1) return 3;	//rotação dupla a direita
		}
		
		if(balanceado == -2) {
			if(direito.balanceado == -1) return 2;	//rotação a esquerda
			if(direito.balanceado == 1)  return 4;	//rotação dupla a esquerda
		}
		return 0;
	}
	
	public int profundidade () {
		return profundidade;
	}
	
	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}
}