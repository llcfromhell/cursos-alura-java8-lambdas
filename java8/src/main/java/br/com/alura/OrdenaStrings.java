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

		// java 8 - nova maneira de ordernar
		palavras.sort(new ComparadorDeStringPorTamanho());
		
		// java 8 - nova maneira de iterar
		// passa uma função para consumir cada elemento
		palavras.forEach(new ConsumidorDeString());
		
		System.out.println(palavras);

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
