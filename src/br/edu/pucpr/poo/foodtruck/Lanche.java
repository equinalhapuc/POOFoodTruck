package br.edu.pucpr.poo.foodtruck;

public class Lanche extends Item {
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

}
