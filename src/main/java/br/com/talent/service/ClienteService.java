package br.com.talent.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.talent.domain.Cliente;
import br.com.talent.domain.dto.ClienteDTO;
import br.com.talent.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	private ModelMapper mapper;

	public static final String ENTITY_NAME = Cliente.class.getSimpleName();

	@Autowired
	public ClienteService(ClienteRepository artigoRepository, ModelMapper mapper) {
		this.clienteRepository = artigoRepository;
		this.mapper = mapper;
	}

	public ResponseEntity<Cliente> findById(Long id) {
		Cliente retorno = clienteRepository.findById(id).orElse(null);
		return ResponseEntity.status(retorno == null ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(retorno);
	}
	
	public ResponseEntity<Cliente> findByCpf(String cpf) {
		Cliente retorno = clienteRepository.findByCpf(cpf);
		
		
		return ResponseEntity.status(retorno == null ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(retorno);
	}

	public Page<Cliente> findAll(int page, int size) {
		
        PageRequest pageRequest = PageRequest.of(page, size, 
                Sort.Direction.ASC,
                "id");
        
		return clienteRepository.findAll(pageRequest);
		
	}
	
	public Page<Cliente> findByNomeContaining(String nome, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size, 
                Sort.Direction.ASC,
                "id");
        
		return clienteRepository.findByNomeContaining(nome, pageRequest);
	}
	
	public Page<Cliente> findByEnderecoContaining(String endereco, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size, 
                Sort.Direction.ASC,
                "id");
        
		return clienteRepository.findByEnderecoContaining(endereco, pageRequest);
	}
	
	

	public ResponseEntity<Long> deleteById(Long id) {
		Cliente retorno = clienteRepository.findById(id).orElse(null);
		if (retorno != null) {
			clienteRepository.deleteById(id);
		}
		return ResponseEntity.status(retorno == null ? HttpStatus.NOT_FOUND : HttpStatus.OK).build();
		
	}

	public ResponseEntity<String> deleteByCpf(String cpf) {
		Cliente retorno = clienteRepository.findByCpf(cpf);
		if (retorno != null) {
			clienteRepository.deleteByCpf(cpf);
		}
		return ResponseEntity.status(retorno == null ? HttpStatus.NOT_FOUND : HttpStatus.OK).build();
	}

	public ResponseEntity<String> save(ClienteDTO clienteDTO) {
		try {

			if (clienteRepository.jaExisteCpf(clienteDTO.getCpf()) != 0) {
				String mensagem = "-> " + clienteDTO.getCpf() + " - CPF ja existente em CLIENTE . . .";
				log.error(mensagem);
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(mensagem);
			}

			Cliente ct = clienteRepository.save(mapper.map(clienteDTO, Cliente.class));
			String mensagem = "-> " + ct.getCpf() + " - Inserido com sucesso . . .";
			log.info(mensagem);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		} catch (Exception e) {
			String mensagem = e.getMessage();
			log.info(mensagem);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagem);
		}

	}
	
	public ResponseEntity<String> update(ClienteDTO clienteDTO) {
		try {
			
			if (clienteDTO.getCpf() == null || clienteDTO.getId() == null) {
				String mensagem = "-> ID e SCPF são obrigatórios, não é possivel alterar . . .";
				log.error(mensagem);
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(mensagem);
			} else if (clienteRepository.jaExisteCpf(clienteDTO.getCpf()) == 0) {
				String mensagem = "-> " + clienteDTO.getCpf() + " - CPF NÃO existente em CLIENTE, não é possivel alterar . . .";
				log.error(mensagem);
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(mensagem);
			} else if (clienteRepository.findById(clienteDTO.getId()) == null) {
				String mensagem = "-> " + clienteDTO.getId() + " - ID NÃO existente em CLIENTE, não é possivel alterar . . .";
				log.error(mensagem);
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(mensagem);
			}			

			clienteRepository.deleteById(clienteDTO.getId());
			Cliente ct = clienteRepository.save(mapper.map(clienteDTO, Cliente.class));
			String mensagem = "-> " + ct.getCpf() + " - Alterado com sucesso . . .";
			log.info(mensagem);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		} catch (Exception e) {
			String mensagem = e.getMessage();
			log.info(mensagem);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagem);
		}

	}	


}
