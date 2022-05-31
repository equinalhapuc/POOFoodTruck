package br.edu.pucpr.poo.foodtruck;

public class Item {
	private String nome;
	static private int codigo = 1;
	private double preco;

	public Item(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
		Item.codigo++;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getPreco() {
		return preco;
	}

}
