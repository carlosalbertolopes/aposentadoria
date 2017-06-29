package br.com.aposentadoria.business;

import java.util.List;

import javax.inject.Inject;

import br.com.aposentadoria.daos.PessoaDao;
import br.com.aposentadoria.exception.RnException;
import br.com.aposentadoria.models.Pessoa;

public class PessoaBusiness {
	
	@Inject
	private PessoaDao pessoaDao;
	
	public Pessoa pesquisarPorId(Integer id){
		return pessoaDao.pesquisarPorId(id);
	}
	
	public List<Pessoa> getAll(){
		return pessoaDao.getAll();
	}
	
	public void validarPessoa(Pessoa pessoa) throws RnException{
		if(pessoa == null){
			throw new RnException("Por favor preencha o objeto pessoa");
		}
	}
	
	public Pessoa salvar(Pessoa pessoa) throws RnException{
		validarPessoa(pessoa);
		pessoaDao.persistirEntidade(pessoa);
		return pessoa;
	}
	
	public void excluir(Pessoa pessoa){
		pessoaDao.excluirEntidade(pessoa);
	}
}
