package br.com.aposentadoria.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aposentadoria.business.ContribuicaoBusiness;
import br.com.aposentadoria.business.PrevidenciaBusiness;
import br.com.aposentadoria.enums.EnumPorcentagem;
import br.com.aposentadoria.exception.RnException;
import br.com.aposentadoria.models.Contribuicao;
import br.com.aposentadoria.models.Pessoa;
import br.com.aposentadoria.utils.MensagensUtil;

@Named
@RequestScoped
public class PrevidenciaController {

	@Inject
	private PrevidenciaBusiness prevBuss;
	@Inject
	private ContribuicaoBusiness contribuiBuss;
	private Pessoa pessoa = new Pessoa("João Pinheiro da Silva", 5000.00, new Date(), new ArrayList<Contribuicao>());
	private Calendar data;
	private Double valorX;
	private Double valorY;

	static SimpleDateFormat df2 = new SimpleDateFormat("MMMMM", new Locale("pt", "BR"));

	@PostConstruct
	public void init() {
		data = Calendar.getInstance();
		valorX = new Double(0.01);
		valorY = new Double(0);
	}

	public void montarListSimulacao() {
		try {
			
			data.setTime(pessoa.getDataInicioPlano());
			Integer mes = data.get(Calendar.MONTH);

			pessoa.setValorFinalResgate(0.0);
			double totalAnual = 0.0;
			double acumuladoMes = 0.0;

			while (mes <= 11 && data.getTime().before(prevBuss.getTempoMaximo(pessoa.getDataInicioPlano()))) {
				if(mes == 1){
					totalAnual = 0.0;
				}
				Contribuicao c = montaContribuicao();
				acumuladoMes += c.getX() + c.getY();
				verificaFinalCarencia(acumuladoMes, c);
				//incrementa valores por ano
				totalAnual += c.getX() + c.getY();
				pessoa.getContribuicoes().add(c);
				data.add(Calendar.MONTH, 1);
				mes = data.get(Calendar.MONTH);
				incrementarSalarioAnual(mes, totalAnual, c);
				setarUltimoValorAnual(totalAnual, c);
				pessoa.setValorFinalResgate(pessoa.getValorFinalResgate() + c.getX() + c.getY());
			}
		} catch (RnException e) {
			MensagensUtil.addMensagemErro(e.getMessage());
		}
	}

	private Contribuicao montaContribuicao() throws RnException {
		Contribuicao c = new Contribuicao();
		c.setAno(String.valueOf(data.get(Calendar.YEAR)));
		c.setMes(df2.format(data.getTime()));
		c.setSalario(pessoa.getSalario());
		c.setX(contribuiBuss.calculaPorcentagemContribuicaoX(c.getSalario(), getValorX()));
		Double salarioRestante = c.getSalario() - c.getX();
		c.setY(contribuiBuss.calculaPorcentagemContribuicaoY(salarioRestante, getValorY()));
		contribuiBuss.validaContribuicaoX(pessoa.getSalario(), c.getX());
		contribuiBuss.validaContribuicaoY(pessoa.getSalario(), c.getY());
		return c;
	}

	private void verificaFinalCarencia(double acumuladoMes, Contribuicao c) {
		//setar valor apos carencia
		if(data.getTime().after(prevBuss.getTempoMinimo(pessoa.getDataInicioPlano()))){
			c.setAcumuladoMes(acumuladoMes);
		}
	}

	private void setarUltimoValorAnual(double totalAnual, Contribuicao c) {
		if(data.getTime().after(prevBuss.getTempoMaximo(pessoa.getDataInicioPlano()))){
			c.setTotalAnual(totalAnual);
		}
	}

	private void incrementarSalarioAnual(Integer mes, double totalAnual, Contribuicao c) {
		if (mes == 0) {
			c.setTotalAnual(totalAnual);
			pessoa.setSalario(prevBuss.calculaReajusteAnualSalario(pessoa.getSalario()));
		}
	}

	/**
	 * GET e SET
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Double getValorX() {
		return valorX;
	}
	public void setValorX(Double valorX) {
		this.valorX = valorX;
	}
	public Double getValorY() {
		return valorY;
	}
	public void setValorY(Double valorY) {
		this.valorY = valorY;
	}
	public List<EnumPorcentagem> getListPorcentagemX(){
		return EnumPorcentagem.getListPorcentagemX();
	}
	public List<EnumPorcentagem> getListPorcentagemY(){
		return EnumPorcentagem.getListPorcentagemY();
	}
}
