package br.com.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.dados.DBGenerico;
import br.com.entidade.Carro;

public class CarroCtrl {
	
	public boolean insert (Carro r) {
		return DBGenerico.getInstance().insert(r);
	}
	
	public boolean update (Carro r) {
		return DBGenerico.getInstance().update(r);
	}
	
	public boolean delete(Carro r) {
		Carro receita = new Carro();
		receita=(Carro) DBGenerico.getInstance().select(r.getId(), Carro.class);
		return DBGenerico.getInstance().delete(receita);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public List<Carro> select (String q){
		return (ArrayList) DBGenerico.getInstance().select(q);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public List<Carro> selectTo (String q, Object valor){
		return (ArrayList) DBGenerico.getInstance().selectTo(q,valor);
	}
	
	

}
