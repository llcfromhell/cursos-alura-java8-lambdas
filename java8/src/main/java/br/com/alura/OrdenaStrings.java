package br.com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();

		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		System.out.println(palavras);
		
		// java 8 - nova maneira de ordernar
		palavras.sort(new ComparadorDeStringPorTamanho());

		// java 8 - utilizando um comparator anonimo e lambda
		palavras.sort((s1, s2) -> Integer.compare(s1.length() , s2.length()) );
		
		// java 8 - nova maneira de iterar
		// passa uma função para consumir cada elemento
		palavras.forEach(new ConsumidorDeString());

		// criando um consumidor anonimo
		palavras.forEach( new Consumer<String>() {
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		// java 8 - como a interface tem apenas 1 método
		// podemos retirar o construir pois o compilador
		// vai inferir este, assim como o Tipo do
		// do parametro e deixar apenas a chamada da
		// instrução
		palavras.forEach( s -> System.out.println(s) );
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
	}

}

class ConsumidorDeString implements Consumer<String> {
	public void accept(String s) {
		System.out.println(s);
	}
}

class ComparadorDeStringPorTamanho implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}
