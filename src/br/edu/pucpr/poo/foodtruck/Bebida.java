package br.edu.pucpr.poo.foodtruck;

public class Bebida extends Item {

	int tamanho; // em ml
	int codigo;

	public Bebida(String descricao, double preco, int tamanho) {
		super(descricao, preco);
		this.tamanho = tamanho;
		this.codigo = super.getCodigo();
	}

	public int getCodigo() {
		return codigo;
	}

	public int getTamanho() {
		return tamanho;
	}

}
