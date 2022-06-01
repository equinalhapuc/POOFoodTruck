package br.edu.pucpr.poo.foodtruck;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
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
