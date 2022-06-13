package br.edu.pucpr.poo.foodtruck;

import java.util.List;

/**
 * Classe que representa um pedido
 * <p>
 * 
 * @param List<ItemPedido>
 * @author Eduardo Quinalha, André Augusto Neves, André Yuji Duarte Kunitake
 * @version 1.0
 *
 */
public class Pedido {
	private static int codigo = 0;
	private StatusPedido status;
	List<ItemPedido> itens;

	public Pedido(List<ItemPedido> itens) {
		codigo++;
		this.status = StatusPedido.LANCADO;
		this.itens = itens;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = StatusPedido.valueOf(status);
	}

	public int getCodigo() {
		return codigo;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}
	
	public double getTotal() {
		double total = 0;
		for (ItemPedido itemPedido : itens) {
			total += itemPedido.getItem().getPreco() * itemPedido.getQtde();
		}
		return total;
	}

}
