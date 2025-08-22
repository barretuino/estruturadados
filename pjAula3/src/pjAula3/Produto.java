package pjAula3;

/**
 * Classe de Modelagem Conceitual
 * Autor: Prof. Ms. Paulo Barreto
 * Data 21/08/2025
 */
public class Produto {
	//Atributos
	int codigo;
	String descricao;
	float preco;
	
	@Override
	public String toString() {
		return "Código " + codigo + " - " + descricao + " R$ " + preco;
	}
}