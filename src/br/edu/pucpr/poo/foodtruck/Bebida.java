package br.edu.pucpr.poo.foodtruck;

import java.util.Formatter;
/**
 * Item de cardápio do tipo Bebida
 * <p>
 * Refrigerantes, cervejas, sucos, etc...
 * @param Nome, preço, tamanho em ml
 * @author Eduardo Quinalha
 * @version 1.0
 *
 */
public class Bebida extends Item {

	private static final long serialVersionUID = 1L;
	int tamanho; // em ml
	int codigo;

	public Bebida(String nome, double preco, int tamanho) {
		super(nome, preco);
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
		fmt.format("%4s. %-30s R$ %.2f\n", this.getCodigo(), this.getNome() + " " + this.getTamanho() + " mL",
				this.getPreco());
		String output = fmt.toString();
		fmt.close();
		return output;
	}
}
