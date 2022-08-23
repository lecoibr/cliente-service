package br.com.talent.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.talent.util.UtilTalent;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cliente", schema = "public")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	@GeneratedValue(generator = "cliente_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cliente_id_seq", sequenceName = "cliente_id_seq", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
    @Column(name="data_nascimento", nullable = false)
    private Date dataNascimento;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column
	private String endereco;
	
    @Column
    private char sexo;
    
    @Transient
    private int idade;
    
    
    public int getIdade() {
    	
    	if (getDataNascimento() != null) {
    		LocalDate bday = UtilTalent.dateToLocalDate(getDataNascimento());
        	LocalDate today = LocalDate.now();
        	
            Period age = Period.between(bday, today);
            int years = age.getYears();
            
            setIdade(years);
    	}
    	
    	
    	return this.idade;
    }

}
