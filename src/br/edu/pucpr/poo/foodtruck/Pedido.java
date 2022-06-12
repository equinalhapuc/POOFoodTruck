package br.edu.pucpr.poo.foodtruck;

import java.util.List;

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

	public void setStatus(StatusPedido status) {
		this.status = status;
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
