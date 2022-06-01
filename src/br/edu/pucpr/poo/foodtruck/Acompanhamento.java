package br.edu.pucpr.poo.foodtruck;

import java.util.Formatter;

public class Acompanhamento extends Item {

	private static final long serialVersionUID = 1L;
	private String descricao;
	private int codigo;

	public Acompanhamento(String nome, double preco, String descricao) {
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
		fmt.format("%4s. %-30s R$ %.2f (%15s)\n", this.getCodigo(), this.getNome(),
				this.getPreco(), this.getDescricao());
		String output = fmt.toString();
		fmt.close();
		return output;
	}
}
