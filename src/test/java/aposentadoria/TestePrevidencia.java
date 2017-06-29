package aposentadoria;

import javax.inject.Inject;

import br.com.aposentadoria.business.ContribuicaoBusiness;
import br.com.aposentadoria.exception.RnException;


public class TestePrevidencia {
	
	@Inject
	private static ContribuicaoBusiness prevBuss;

	public static void main(String[] args) {

	}
	
	private static Double simulaContribuicaoX(Double salario, Double teste) throws RnException {
		while (!prevBuss.validaContribuicaoX(salario, teste)) {
			teste += 50;
		}
		return teste;
	}
	private static Double simulaContribuicaoY(Double salario, Double teste) throws RnException {
		if(prevBuss.validaContribuicaoY(salario, teste)){
			return teste;
		}
		return teste += 50;
	}

}
