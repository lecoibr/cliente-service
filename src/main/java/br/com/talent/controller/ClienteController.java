package br.com.talent.controller;

import static br.com.talent.util.Constante.HTTP_400;
import static br.com.talent.util.Constante.HTTP_401;
import static br.com.talent.util.Constante.HTTP_403;
import static br.com.talent.util.Constante.HTTP_404;
import static br.com.talent.util.Constante.HTTP_500;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.talent.domain.Cliente;
import br.com.talent.domain.dto.ClienteDTO;
import br.com.talent.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/*
 * http://localhost/swagger-ui.html
 * http://localhost/v2/api-docs/
 */
@RestController
@RequestMapping("${domain}/cliente")
@Api(tags = { "Manter Cliente" })
@Validated
public class ClienteController {


	@Autowired
	private ClienteService clienteService;
	

	@ApiOperation(value = "Salvar um Cliente.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = HTTP_400), @ApiResponse(code = 401, message = HTTP_401),
			@ApiResponse(code = 403, message = HTTP_403), @ApiResponse(code = 404, message = HTTP_404),
			@ApiResponse(code = 500, message = HTTP_500) })
	@PostMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO) {
		return clienteService.save(clienteDTO);
	}
	
	@ApiOperation(value = "Alterar um Cliente.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = HTTP_400), @ApiResponse(code = 401, message = HTTP_401),
			@ApiResponse(code = 403, message = HTTP_403), @ApiResponse(code = 404, message = HTTP_404),
			@ApiResponse(code = 500, message = HTTP_500) })
	@PutMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> update(@RequestBody ClienteDTO clienteDTO) {
		return clienteService.update(clienteDTO);
	}
	

	@ApiOperation(value = "Deletar um Cliente pelo Id.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = HTTP_400), @ApiResponse(code = 401, message = HTTP_401),
			@ApiResponse(code = 403, message = HTTP_403), @ApiResponse(code = 404, message = HTTP_404),
			@ApiResponse(code = 500, message = HTTP_500) })
	@DeleteMapping(value = "/delete/id", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Long> deleteById(@RequestParam Long id) {
		return clienteService.deleteById(id);
	}
	
	
	@ApiOperation(value = "Deletar um Cliente pelo CPF.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = HTTP_400), @ApiResponse(code = 401, message = HTTP_401),
			@ApiResponse(code = 403, message = HTTP_403), @ApiResponse(code = 404, message = HTTP_404),
			@ApiResponse(code = 500, message = HTTP_500) })
	@DeleteMapping(value = "/delete/cpf", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteByCpf(@RequestParam String cpf) {
		return clienteService.deleteByCpf(cpf);
	}
	
	@ApiOperation(value = "Buscar um Cliente pelo Id.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = HTTP_400), @ApiResponse(code = 401, message = HTTP_401),
			@ApiResponse(code = 403, message = HTTP_403), @ApiResponse(code = 404, message = HTTP_404),
			@ApiResponse(code = 500, message = HTTP_500) })
	@GetMapping(value = "/find/id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> findById(@RequestParam Long id) {
		return clienteService.findById(id);
	}
	
	@ApiOperation(value = "Buscar um Cliente pelo CPF.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = HTTP_400), @ApiResponse(code = 401, message = HTTP_401),
			@ApiResponse(code = 403, message = HTTP_403), @ApiResponse(code = 404, message = HTTP_404),
			@ApiResponse(code = 500, message = HTTP_500) })
	@GetMapping(value = "/find/cpf", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> findByCpf(@RequestParam String cpf) {
		return clienteService.findByCpf(cpf);
	}	
	
	@ApiOperation(value = "Buscar todos os cliente.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = HTTP_400), @ApiResponse(code = 401, message = HTTP_401),
			@ApiResponse(code = 403, message = HTTP_403), @ApiResponse(code = 404, message = HTTP_404),
			@ApiResponse(code = 500, message = HTTP_500) })
	@GetMapping(value = "/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Cliente> findAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		return clienteService.findAll(page, size);
	}
	
	
	@ApiOperation(value = "Buscar todos os clientes que contenham parte do ENDEREÇO iguais.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = HTTP_400), @ApiResponse(code = 401, message = HTTP_401),
			@ApiResponse(code = 403, message = HTTP_403), @ApiResponse(code = 404, message = HTTP_404),
			@ApiResponse(code = 500, message = HTTP_500) })
	@GetMapping(value = "/find/endereco/contain", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Cliente> findByEnderecoContaining(@RequestParam String endereco, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		return clienteService.findByEnderecoContaining(endereco, page, size);
	}	

	@ApiOperation(value = "Buscar todos os clientes que contenham parte do NOME iguais.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = HTTP_400), @ApiResponse(code = 401, message = HTTP_401),
			@ApiResponse(code = 403, message = HTTP_403), @ApiResponse(code = 404, message = HTTP_404),
			@ApiResponse(code = 500, message = HTTP_500) })
	@GetMapping(value = "/find/nome/contain", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Cliente> findByNomeContaining(@RequestParam String nome, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		return clienteService.findByNomeContaining(nome, page, size);
	}	
	
}