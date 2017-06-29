package br.com.aposentadoria.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa", schema = "aposentadoria")
public class Pessoa extends BaseEntity<Integer>{
	@Id
	@Column(name = "seq_pessoa")
	@GeneratedValue
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "salario")
	private Double salario;
	@Column(name = "dat_inicio_plano")
	private Date dataInicioPlano;
	@Column(name = "total_final_plano")
	private Double valorFinalResgate;
	@Column(name = "valor_resgate")
	private Double valorResgateAcumulado;
	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL}, targetEntity=Contribuicao.class)	
	private List<Contribuicao> contribuicoes;
	
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome, Double salario, Date dataInicioPlano, List<Contribuicao> contribuicoes) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.dataInicioPlano = dataInicioPlano;
		this.contribuicoes = contribuicoes;
	}
	
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
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Date getDataInicioPlano() {
		return dataInicioPlano;
	}
	public void setDataInicioPlano(Date dataInicioPlano) {
		this.dataInicioPlano = dataInicioPlano;
	}
	public List<Contribuicao> getContribuicoes() {
		return contribuicoes;
	}
	public void setContribuicoes(List<Contribuicao> contribuicoes) {
		this.contribuicoes = contribuicoes;
	}
	public Double getValorFinalResgate() {
		return valorFinalResgate;
	}
	public void setValorFinalResgate(Double total) {
		this.valorFinalResgate = total;
	}
	public Double getValorResgateAcumulado() {
		return valorResgateAcumulado;
	}
	public void setValorResgateAcumulado(Double valorResgateAcumulado) {
		this.valorResgateAcumulado = valorResgateAcumulado;
	}
}