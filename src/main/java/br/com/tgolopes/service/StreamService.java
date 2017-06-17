package br.com.tgolopes.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tgolopes.exception.NenhumCaracterUnicoEncontrado;
import br.com.tgolopes.stream.Stream;

/**
 * Classe que representa os serviços para o processamento da stream que será consumido pela classe EnderecoController
 * 
 * @author Thiago Oliveira Lopes
 *
 */
@Service
@Validated
public class StreamService {
	/**
	 * Método responsável por efetuar um algoritmo onde passado uma String por parametro ele processa e retorna qual a primeira vogal que não se repetiu, 
	 * onde ela é posterior de uma consoante e o antecessor desta consoante é uma vogal.
	 * A solução dada foi utulizar 3 listas, uma que contém todas as vogais existentes, uma que irá armazenar as vogais elegíveis de possível retorno e outra que armazena todos os caracteres já processados da stream.
	 * Primeiramente fiz um laço para percorrer os caracteres da stream, caso tenha um próximo registro eu armazeno esse caracter em uma variável.
	 * Verifico se este caracter em evidencia já existe na lista de caracteres sem repetição, se ele existir eu o removo da lista, logo após eu verifico se a lista de processados está vazia, se sim eu adiciono este primeiro caracter.
	 * Após o primeiro caracter ser processado, verefico se o caracter em evidencia é uma consoante e se a stream tem um próximo registo, se isso acontecer verifico se o próximo é uma vogal e se ela já nao foi processado, caso seja verdadeixo eu adiciono ela na lista de sem repetição.
	 * Após a stream ter sido processada, verifico a lista de sem repetição (LinkedHashSet) caso ela esteja vazia, notifico que não foram encontradas vogais elegíveis, caso tenha eu retorno o primeiro caracter sem repetição.
	 * @param texto
	 * @return
	 * @throws NenhumCaracterUnicoEncontrado
	 */
	public Character processarStream(@NotNull Stream texto) throws NenhumCaracterUnicoEncontrado {
		
		List<Character> listaVogais = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
		LinkedHashSet<Character> listaSemRepeticao = new LinkedHashSet<Character>();
		List<Character> listaStream = new ArrayList<Character>();
		Character charProcessado;
		Character primeiroCharSemRepeticao = 'T';
		
		while (texto.hasNext()) {
			charProcessado = texto.getNext();
			if (listaSemRepeticao.contains(charProcessado)) {
				listaSemRepeticao.remove(charProcessado);
			}
			
			if (listaStream.isEmpty()) {
				listaStream.add(charProcessado);
			} else if (!listaVogais.contains(charProcessado) && listaVogais.contains(listaStream.get(listaStream.size() - 1)) && texto.hasNext()) {
				Character charac = texto.getNext();
				if (listaVogais.contains(charac) && !listaStream.contains(charac)) {
					listaSemRepeticao.add(charac);
				} else {
					listaStream.add(charProcessado);
					listaStream.add(charac);
				}
			} else {
				listaStream.add(charProcessado);
			}
		}
		if (listaSemRepeticao.isEmpty()) {
			throw new NenhumCaracterUnicoEncontrado();
		} else {
			for (Character character : listaSemRepeticao) {
				primeiroCharSemRepeticao = character;
				break;
			}
		}
		return primeiroCharSemRepeticao;
	}
}