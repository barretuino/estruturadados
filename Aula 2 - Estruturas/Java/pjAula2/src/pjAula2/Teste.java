package pjAula2;

import java.util.HashSet;
import java.util.Set;

public class Teste {
	public static void main(String[] args) {
		//Declarando um novo objeto do tio Aluno
		Aluno voce = new Aluno();
		
		voce.ra = 7536951;
		voce.nome = "Paulo";
		voce.nota = 8.5f;
		
		System.out.println(voce.nota + " " + voce.nome);
		
		//Criando uma coleção do tipo Set
		Set sala = new HashSet();	
		//Adicionando elementos a coleção
		sala.add(voce);
		System.out.println(sala);
	}
}
