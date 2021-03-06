package br.edu.pucpr.poo.foodtruck;

import java.io.Serializable;

/**
 * Classe abstrata que representa um item de cardápio
 * <p>
 * Qualquer item do cardápio do Food Truck
 * 
 * @param Nome, preço, descrição
 * @author Eduardo Quinalha, André Augusto Neves, André Yuji Duarte Kunitake
 * @version 1.0
 *
 */
public abstract class Item implements Serializable {

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

	@Override
	public boolean equals(Object obj) {

		Item item = (Item) obj;
		return item.getCodigo() == this.getCodigo();

	}

	protected static void setCodigo(int codigo) {
		Item.codigo = codigo;
	}
}
