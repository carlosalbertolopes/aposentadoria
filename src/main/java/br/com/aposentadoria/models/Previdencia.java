package br.com.aposentadoria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "previdencia", schema = "aposentadoria")
@SuppressWarnings("serial")
public class Previdencia extends BaseEntity<Integer>{
	
	@Id
	@Column(name = "seq_previdencia")
	@GeneratedValue
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "saldoAcumulado")
	private Double saldoAcumulado;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSaldoAcumulado() {
		return saldoAcumulado;
	}
	public void setSaldoAcumulado(Double saldoAcumulado) {
		this.saldoAcumulado = saldoAcumulado;
	}
}
