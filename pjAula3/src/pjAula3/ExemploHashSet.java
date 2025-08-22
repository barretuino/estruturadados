package pjAula3;

import java.util.Collection;
import java.util.TreeSet;

public class ExemploHashSet {
	public static void main(String[] args) {
		Collection lista = new TreeSet();
		
		lista.add("Geovana");
		lista.add("Isa");
		lista.add("Felipe");
		lista.add("Nicolas");
		lista.add("Jadson");
		lista.add("Alexandre");
		lista.add("0");
		lista.add("25");
		lista.add("isa");
		
		System.out.println(lista);
	}
}
