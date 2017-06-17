package br.com.tgolopes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tgolopes.exception.NenhumCaracterUnicoEncontrado;
import br.com.tgolopes.service.StreamService;
import br.com.tgolopes.stream.Stream;
import br.com.tgolopes.stream.StreamImp;

/**
 * Classe que representa o serviço REST pela anotação @RestController que irá controlar a aplicação pelas chamadas do browser.
 * A anotação @RequestMapping mapea a url e a captura quando  mesma for digitada no browser.
 * 
 * @author Thiago Oliveira Lopes
 *
 */

@RestController
@RequestMapping("v1/stream")
public class StreamController {

	//Atributo que representa a injeção de dependência 
	@Autowired
	StreamService streamService;

	/**
	 * Método responsável por processar uma Stream via GET, retornando um objeto JSON.
	 * @param texto
	 * @return
	 * @throws NenhumCaracterUnicoEncontrado
	 */
    @RequestMapping(value = "/{texto}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Character getPorId(@PathVariable String texto) throws NenhumCaracterUnicoEncontrado{
    	Stream stream = new StreamImp(texto);
    	return streamService.processarStream(stream);    	
    }
}