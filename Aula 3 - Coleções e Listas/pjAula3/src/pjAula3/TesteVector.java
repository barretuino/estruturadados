package pjAula3;

import java.util.Vector;

public class TesteVector {
	public static void main(String[] args) {
		Vector vetor = new Vector(1);
		
		vetor.add("Alice");
		vetor.add("Gustavo");
		vetor.add("Pedro");
		vetor.add("Júlia");
		
		System.out.println(vetor);
		System.out.println("Capacidade " +  vetor.capacity());
		System.out.println("Elementos " +  vetor.size());
		
		vetor.add("Brenno");
		vetor.add("Henrico");
		vetor.add("Ana");
		vetor.add("Pablo");
		vetor.add("João");
		vetor.add("Pietro");
		vetor.add("Silvio");
		
		System.out.println(vetor);
		System.out.println("Capacidade " +  vetor.capacity());
		System.out.println("Elementos " +  vetor.size());
		
		vetor.add("Alice");
		vetor.add("Gustavo");
		vetor.add("Pedro");
		vetor.add("Júlia");
		vetor.add("Brenno");
		vetor.add("Henrico");
		vetor.add("Ana");
		vetor.add("Pablo");
		vetor.add("João");
		vetor.add("Pietro");
		vetor.add("Silvio");
		
		System.out.println(vetor);
		System.out.println("Capacidade " +  vetor.capacity());
		System.out.println("Elementos " +  vetor.size());
		
		vetor.remove("Alice");
		vetor.remove("Gustavo");
		vetor.remove("Pedro");
		vetor.remove("Júlia");
		vetor.remove("Brenno");
		vetor.remove("Henrico");
		vetor.remove("Ana");
		vetor.remove("Pablo");
		vetor.remove("João");
		vetor.remove("Pietro");
		vetor.remove("Silvio");
		
		System.out.println(vetor);
		System.out.println("Capacidade " +  vetor.capacity());
		System.out.println("Elementos " +  vetor.size());
	}
}
