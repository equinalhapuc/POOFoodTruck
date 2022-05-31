package br.edu.pucpr.poo.foodtruck;

public class Acompanhamento extends Item {

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

}
