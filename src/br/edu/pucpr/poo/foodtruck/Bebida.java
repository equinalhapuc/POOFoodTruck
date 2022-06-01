package br.edu.pucpr.poo.foodtruck;

import java.util.Formatter;

public class Bebida extends Item {

	private static final long serialVersionUID = 1L;
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

	@Override
	public String toString() {
		Formatter fmt = new Formatter();
		fmt.format("%4s. %-30s R$ %.2f\n", this.getCodigo(), this.getNome() + " " + this.getTamanho(),
				this.getPreco());
		String output = fmt.toString();
		fmt.close();
		return output;
	}
}
