import java.io.File;

public class ConteudoPastas {

	public static void main(String[] args) {
		File raiz = new File("/home");
		pastas(raiz);
	}

	public static void pastas(File raiz) {

		for (File file : raiz.listFiles()) {
			if (file.isDirectory()) {
				System.out.println(file);
				pastas(file);
			}
		}
	}
}
