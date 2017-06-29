package br.com.aposentadoria.business;

import br.com.aposentadoria.exception.RnException;
import br.com.aposentadoria.utils.SistemaUtil;

public class ContribuicaoBusiness implements Regras {
	
	private Double min, max;
	
	public boolean validaContribuicaoX(Double salario, Double contribuicao) throws RnException {
		validarCampos(salario, contribuicao);
		min = SistemaUtil.calculaPorcentagemSalario(salario, MIN_X);
		max = SistemaUtil.calculaPorcentagemSalario(salario, MAX_X);
		if (contribuicao < min || contribuicao > max) {
			throw new RnException("Valor inválido para contribuição: mínimo R$ "+min+" e máximo R$ "+max);
		}
		return true;
	}

	public boolean validaContribuicaoY(Double salario, Double contribuicao) throws RnException {
		validarCampos(salario, contribuicao);
		salario += EXCEDENTE_SALARIO;
		min = SistemaUtil.calculaPorcentagemSalario(salario, MIN_Y);
		max = SistemaUtil.calculaPorcentagemSalario(salario, MAX_Y);
		if (contribuicao < min || contribuicao > max) {
			throw new RnException("Valor inválido para contribuição: mínimo R$ "+min+" e máximo R$ "+max);
		}
		return true;
	}
	
	public Double calculaPorcentagemContribuicaoX(Double salario, Double porcentagem) {
		return SistemaUtil.formatDouble(salario * porcentagem);
	}
	
	public Double calculaPorcentagemContribuicaoY(Double salario, Double porcentagem) {
		return SistemaUtil.formatDouble((salario-= EXCEDENTE_SALARIO) * porcentagem);
	}
	
	private void validarCampos(Double salario, Double contribuicao) throws RnException {
		if(salario == null){
			throw new RnException("Valor inválido para o salário");
		}
		if(contribuicao == null){
			throw new RnException("Valor inválido para a contribuição");
		}
	}

}
