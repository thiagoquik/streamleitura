package br.com.tgolopes.stream;

import br.com.tgolopes.exception.NenhumCaracterUnicoEncontrado;

/**
 * Implementação da interface Stream
 * 
 * @author Thiago Oliveira Lopes
 *
 */
public class StreamImp implements Stream{
	
	private int posicao = 0;
	String texto;
	
	/**
	 * Construtor da classe StreamImp
	 * @param texto
	 * @throws NenhumCaracterUnicoEncontrado
	 */
	public StreamImp(String texto) throws NenhumCaracterUnicoEncontrado{
		this.texto = texto;
	}
	
	/**
	 * Método responsável em retornar o próximo elemento.
	 */
	public char getNext() {		
		return this.texto.charAt(posicao++);
	}

	/**
	 * Método responsável em retornar se há ou não proximo elemento.
	 */
	public boolean hasNext() {	
		return texto.length() > posicao;
	}

}