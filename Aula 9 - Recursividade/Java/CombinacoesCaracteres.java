import java.util.ArrayList;

public class CombinacaoNCaracteres {

	public static void main(String[] args) {
		String caracteres = "ABC";
		ArrayList<String> lista = new ArrayList<>();

		// Adiciona cada letra em uma posição da lista
		for (int i = 0; i < caracteres.length(); i++) {
			lista.add(Character.toString(caracteres.charAt(i)));
		}

		ArrayList<String> retorno = combinacoes(lista); // Passa a lista e retorna a mesma

		// Imprime combinações
		for (int i = 0; i < retorno.size(); i++) {
			System.out.println(retorno.get(i));
		}
	}

	public static ArrayList<String> combinacoes(ArrayList<String> caracteres) {
		ArrayList<String> retorno = new ArrayList<>();

		if (caracteres.size() == 1) return caracteres;
		for (int i = 0; i < caracteres.size(); i++) {
			String pre = caracteres.get(i); // Salva o prefixo
			caracteres.remove(i); // Remove o prefixo

			ArrayList<String> sufix = combinacoes(caracteres);

			for (int j = 0; j < sufix.size(); j++) {
				retorno.add(pre + sufix.get(j));// Adiciona combinações
			}
			caracteres.add(i, pre); // Adiciona o prefixo onde estava
		}
		return retorno;
	}
}
