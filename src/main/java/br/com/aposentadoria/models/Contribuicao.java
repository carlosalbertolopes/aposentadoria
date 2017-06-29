package br.com.aposentadoria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contribuicao", schema = "aposentadoria")
@SuppressWarnings("serial")
public class Contribuicao extends BaseEntity<Integer>{
	@Id
	@Column(name = "seq_contribuicao")
	@GeneratedValue
	private Integer id;
	@Column(name = "mes")
	private String mes;
	@Column(name = "ano")
	private String ano;
	@Column(name = "contribuicao_x")
	private Double x;
	@Column(name = "contribuicao_y")
	private Double y;
	@Column(name = "total_contribuicao_anual")
	private Double totalAnual;
	@Column(name = "total_contribuicao_mes")
	private Double acumuladoMes;
	@Column(name = "salario_mes")
	private Double salario;
	@ManyToOne
	@JoinColumn(name = "seq_pessoa")
	private Pessoa pessoa;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public Double getTotalAnual() {
		return totalAnual;
	}
	public void setTotalAnual(Double totalAnual) {
		this.totalAnual = totalAnual;
	}
	public Double getAcumuladoMes() {
		return acumuladoMes;
	}
	public void setAcumuladoMes(Double acumuladoMes) {
		this.acumuladoMes = acumuladoMes;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
	public String toString() {
		return "Contribuicao [mes=" + mes + ", ano=" + ano + ", x=" + x + ", y=" + y + "]\n";
	}
}