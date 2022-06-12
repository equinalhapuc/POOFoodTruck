package br.edu.pucpr.poo.foodtruck;

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
