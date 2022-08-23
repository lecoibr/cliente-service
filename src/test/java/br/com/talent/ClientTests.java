package br.com.talent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.talent.domain.Cliente;
import br.com.talent.domain.dto.ClienteDTO;
import br.com.talent.service.ClienteService;

@FixMethodOrder(MethodSorters.DEFAULT)
@RunWith(SpringRunner.class)
public class ClientTests {

	@Test
	void saveUsuario() throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
	    Date date = formatter.parse("26-09-1989");
	       
		ClienteDTO cliente = new ClienteDTO();
		cliente.setCpf("10293847566");
		cliente.setNome("Usuario de Teste");
		cliente.setDataNascimento(date);
		cliente.setEndereco("QD 210");
		cliente.setSexo('M');
		
		ResponseEntity<String> retorno = new ResponseEntity<String>(HttpStatus.OK);
		ClienteService clienteService = mock(ClienteService.class);
		when(clienteService.save(cliente)).thenReturn(retorno);
		
		ResponseEntity<String> resultado = clienteService.save(cliente);
		
		assertEquals(200, resultado.getStatusCodeValue());
	}
	
	@Test
	void updateUsuario() throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
	    Date date = formatter.parse("26-09-1989");
	       
		ClienteDTO cliente = new ClienteDTO();
		cliente.setCpf("10293847566");
		cliente.setNome("Usuario de Teste");
		cliente.setDataNascimento(date);
		cliente.setEndereco("QD 210");
		cliente.setSexo('M');
		cliente.setId(1L);
		
		ResponseEntity<String> retorno = new ResponseEntity<String>(HttpStatus.OK);
		ClienteService clienteService = mock(ClienteService.class);
		when(clienteService.update(cliente)).thenReturn(retorno);
		
		ResponseEntity<String> resultado = clienteService.update(cliente);
		
		assertEquals(200, resultado.getStatusCodeValue());
	}	
	
	
	@Test
	void findById() throws ParseException {
		Long id = 1L;
		
		ResponseEntity<Cliente> retorno = new ResponseEntity<Cliente>(new Cliente(), HttpStatus.OK);
		retorno.getBody().setId(id);
		ClienteService clienteService = mock(ClienteService.class);
		when(clienteService.findById(id)).thenReturn(retorno);
		
		ResponseEntity<Cliente> resultado = clienteService.findById(id);
		
		assertEquals(id, resultado.getBody().getId());
	}
	
	@Test
	void findByCpf() throws ParseException {
		String cpf = "10293847561";
		
		ResponseEntity<Cliente> retorno = new ResponseEntity<Cliente>(new Cliente(), HttpStatus.OK);
		retorno.getBody().setCpf(cpf);
		ClienteService clienteService = mock(ClienteService.class);
		when(clienteService.findByCpf(cpf)).thenReturn(retorno);
		
		ResponseEntity<Cliente> resultado = clienteService.findByCpf(cpf);
		
		assertEquals(cpf, resultado.getBody().getCpf());
	}	

}
