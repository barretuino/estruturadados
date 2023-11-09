package arvores;

public class Main {
	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		System.out.println("Arvore:");

		arvore.inserir(27);
		arvore.inserir(10);
		arvore.inserir(49);
		arvore.inserir(8);
		arvore.inserir(15);
		arvore.inserir(67);
		arvore.inserir(59);
		
		System.out.println("---------------");
		arvore.imprimir();
		System.out.println("-----------------");
		System.out.println("profundidade: "+ arvore.profundidade());
	}
}