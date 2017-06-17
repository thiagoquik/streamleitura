package br.com.tgolopes.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;



import br.com.tgolopes.LeituraStreamApplicationTests;
import br.com.tgolopes.exception.NenhumCaracterUnicoEncontrado;
import br.com.tgolopes.service.StreamService;
import br.com.tgolopes.stream.Stream;
import br.com.tgolopes.stream.StreamImp;

/**
 * Clase que representam os testes da aplicação
 * 
 * @author Thiago OLiveira Lopes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LeituraStreamApplicationTests.class)
@WebAppConfiguration
public class StreamControllerTest {

	private StreamService streamService = new StreamService();
	
	/**
	 * Testar se há proximo caracter com espaço.
	 */
    @Test
    public void testarHasNextTextoComEspaco() throws Exception {
		Stream stream = new StreamImp("aAbBA Bacafe");
		Assert.isTrue(stream.hasNext());
    }
    
    /**
	 * Testar se há proximo caracter.
	 */
    @Test
    public void testarHasNext() throws Exception {
		Stream stream = new StreamImp("aAbBABacafe");
		Assert.isTrue(stream.hasNext());
    }
    
    /**
	 * Testar se está pegando corretamente cada caracter da stream.
	 */
	@Test
	public void testarGetNex() throws Exception{
		Stream stream = new StreamImp("aAbBABacafe");
		Assert.isTrue(stream.getNext() == 'a');
		Assert.isTrue(stream.getNext() == 'A');
		Assert.isTrue(stream.getNext() == 'b');
		Assert.isTrue(stream.getNext() == 'B');
		Assert.isTrue(stream.getNext() == 'A');
		Assert.isTrue(stream.getNext() == 'B');
		Assert.isTrue(stream.getNext() == 'a');
		Assert.isTrue(stream.getNext() == 'c');
		Assert.isTrue(stream.getNext() == 'a');
		Assert.isTrue(stream.getNext() == 'f');
		Assert.isTrue(stream.getNext() == 'e');
		Assert.isTrue(!stream.hasNext());
	}
	
	/**
	 * Testar se nenhum caracter elegível foi encontrado.
	 */
	@Test(expected = NenhumCaracterUnicoEncontrado.class)
    public void validarSemCaracterValido() throws Exception{
		Stream stream = new StreamImp("aAbBABacafee");
        streamService.processarStream(stream);                		
    }
	
	/**
	 * Testar se há caracter elegível e sem repetição.
	 */
	@Test
    public void validarUmCaracterSemRepeticao() throws Exception{
        Stream stream = new StreamImp("aAbBABacafe");
        Assert.isTrue(streamService.processarStream(stream) =='e');                		
    }
	
	/**
	 * Testar se há caracteres elegíveis e mostrar o primeiro.
	 */
	@Test
    public void validarMaisDeUmCaracterSemRepeticao() throws Exception{
        Stream stream = new StreamImp("aAbBABacafeAbo");
        Assert.isTrue(streamService.processarStream(stream) =='e');                		
    }
	
	/**
	 * Processar strem mesmo sendo digitado um caracter especial e mostrar o caracter elegível.
	 */
	@Test
    public void validarComCaracterEspecial() throws Exception{
        Stream stream = new StreamImp("aAbBABacaf*eAbo");
        Assert.isTrue(streamService.processarStream(stream) =='o');                		
    }
	
	/**
	 * Testar se há caracteres elegíveis maiúsculos e mostrar o primeiro.
	 */
	@Test
    public void validarMaisDeUmCaracterSemRepeticaoMaiusculo() throws Exception{
        Stream stream = new StreamImp("aAbBABacafEAbo");
        Assert.isTrue(streamService.processarStream(stream) =='E');                		
    }
	
	/**
	 * Processar strem mesmo sendo digitado um caracter especial e mostrar o caracter elegível maiúsculo.
	 */
	@Test
    public void validarComCaracterEspecialMaiusculo() throws Exception{
        Stream stream = new StreamImp("aAbBABacaf*eAbO");
        Assert.isTrue(streamService.processarStream(stream) =='O');                		
    }
	
	/**
	 * Processar strem mesmo sendo digitado um espaço e mostrar o caracter elegível.
	 */
	@Test
    public void validarComEspacos() throws Exception{
        Stream stream = new StreamImp("aAbBABa ca feAbo");
        Assert.isTrue(streamService.processarStream(stream) =='o');                		
    }
	
	/**
	 * Testar se há caractere elegível no início da stream.
	 */
	@Test
    public void validarPrimeiroCaracterSemRepeticaoNoInicio() throws Exception{
        Stream stream = new StreamImp("afeaAbBABaAbo");
        Assert.isTrue(streamService.processarStream(stream) =='e');                		
    }
	
	/**
	 * Testar se a stream for vazia.
	 */
	@Test(expected = NenhumCaracterUnicoEncontrado.class)
    public void validarCampoStreamVazio() throws Exception{
		Stream stream = new StreamImp("");
        streamService.processarStream(stream);            		
    }
}
