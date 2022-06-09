package br.edu.pucpr.poo.foodtruck;

import java.util.ArrayList;

public class Pedido {
	private int codigo;
	private String status;
	ArrayList<Item> itens;

	public Pedido(int codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}

	public void insereItem(Item item){
		itens.add(item);
	}
	
}
