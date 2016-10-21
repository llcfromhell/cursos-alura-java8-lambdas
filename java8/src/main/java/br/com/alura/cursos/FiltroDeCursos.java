package br.com.alura.cursos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiltroDeCursos {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		cursos.forEach(System.out::println);
		
		// filtra conforme a função (predicado) dada = nro alunos maior que 50
		cursos.stream()
			.filter(c -> (c.getAlunos() > 50))
			.forEach(System.out::println);
		
		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		nomes.forEach(System.out::println);
		
		// old style
//		cursos.stream()
//		   .filter(c -> c.getAlunos() > 50)
//		   .map(c -> c.getAlunos())
//		   .forEach(x -> System.out.println(x));
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .map(Curso::getNome)
		   .forEach(System.out::println);
		
		// filtra e pega o primeiro, se tive, imprime
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst()
		   .ifPresent(System.out::println);
		
		// encontra a média de valores inteiros
		cursos.stream()
			.mapToInt(Curso::getAlunos)
			.average()
			.ifPresent(System.out::println);
		
		// converte para listas
		List<Curso> cursoList = cursos.stream()
				.filter(c -> c.getAlunos() > 50)
				.collect(Collectors.toList());
		
	}
	
}
