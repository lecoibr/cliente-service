package br.com.talent.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.talent.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT coalesce(max(u.id), 0) FROM Cliente u")
	Long getMaxId();

	@Query("SELECT count(*) FROM Cliente t WHERE t.cpf = :#{#cpf}")
	Long jaExisteCpf(@Param("cpf") String cpf);
	
	Cliente findByCpf(String cpf);
	
	Page<Cliente> findByNomeContaining(String nome, Pageable  pageable);
	
	Page<Cliente> findByEnderecoContaining(String endereco, Pageable  pageable);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Cliente t WHERE t.cpf = :#{#cpf}")
	void deleteByCpf(@Param("cpf") String cpf);
	
	
}
