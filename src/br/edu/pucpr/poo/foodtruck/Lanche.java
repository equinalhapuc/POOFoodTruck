package br.edu.pucpr.poo.foodtruck;

import java.util.Formatter;
/**
 * Item de cardápio do tipo Lanche
 * <p>
 * Item principal do cardápio. X-Burgueres, X-saladas, Hot-dog, pizzas, etc...
 * @param Nome, preço, descrição
 * @author Eduardo Quinalha, André Augusto Neves, André Yuji Duarte Kunitake
 * @version 1.0
 *
 */
public class Lanche extends Item {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descricao;

	public Lanche(String nome, double preco, String descricao) {
		super(nome, preco);
		this.codigo = super.getCodigo();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		fmt.format("%4s. %-30s R$ %.2f (%20s)\n", this.getCodigo(), this.getNome(), this.getPreco(),
				this.getDescricao());
		String output = fmt.toString();
		fmt.close();
		return output;
	}
}
