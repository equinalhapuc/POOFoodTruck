package br.edu.pucpr.poo.foodtruck;

/**
 * Classe para normalizar a relação muitos para muitos entre as classes Pedido e Item
 * <p>
 * 
 * @author Eduardo Quinalha, André Augusto Neves, André Yuji Duarte Kunitake
 * @version 1.0
 *
 */

public class ItemPedido {

	private Item item;
	private int qtde;
	private String obs;

	public ItemPedido(Item item, int qtde, String obs) {
		this.item = item;
		this.qtde = qtde;
		this.obs = obs;
	}

	public Item getItem() {
		return item;
	}

	public int getQtde() {
		return qtde;
	}

	public String getObs() {
		return obs;
	}

}
