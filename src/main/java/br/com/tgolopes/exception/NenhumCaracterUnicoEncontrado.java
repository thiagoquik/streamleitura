package br.com.tgolopes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe responsável por lançar uma exceção quando o nenhum caracter único for encontrado.
 * Esta classe é orquestrada pela classe ControllerException
 * 
 * @author Thiago Oliveira Lopes
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nenhum caracter único foi encontrado!")
public class NenhumCaracterUnicoEncontrado extends Exception{
	private static final long serialVersionUID = 8646543L;
}
