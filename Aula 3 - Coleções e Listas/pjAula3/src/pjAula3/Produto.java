package pjAula3;
/**
 * Classe de Modelagem Conceitual de Produto
 * @autor Prof. Paulo Barreto
 * @data 22/08/2024
 */
public class Produto {
	//Atributos
	int codigo;
	String descricao;
	float quantidade;
	boolean status = true;
	
	//Métodos .... Ações que a classe pode executar
	public String imprimir() {
		String retorno = "Código " + codigo + " Descrição " + descricao;
		return retorno;
	}
	
	@Override
	public String toString() {
		return imprimir();
	}
}
