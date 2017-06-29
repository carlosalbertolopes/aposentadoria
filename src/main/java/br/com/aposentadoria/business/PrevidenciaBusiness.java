package br.com.aposentadoria.business;

import java.util.Date;

import br.com.aposentadoria.utils.SistemaUtil;

public class PrevidenciaBusiness implements Regras{
	
	public Double calculaReajusteAnualSalario(Double salario) {
		return SistemaUtil.formatDouble(salario + (salario * PC_ANUAL_SALARIO / 100));
	}
	
	public Date getTempoMinimo(Date inicioPlano){
		return SistemaUtil.calcularPrazoAnos(inicioPlano, CARENCIA_MINIMA);
	}
	public Date getTempoMaximo(Date inicioPlano){
		return SistemaUtil.calcularPrazoAnos(inicioPlano, CARENCIA_MAXIMA);
	}
}
