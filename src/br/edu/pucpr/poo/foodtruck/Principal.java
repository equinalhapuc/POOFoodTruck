package br.edu.pucpr.poo.foodtruck;

import java.util.NoSuchElementException;

public class Principal {

	public static void main(String[] args) {

	}

	public void insereItemNoCardapio(Cardapio cardapio, Item item) {
		cardapio.inserirItem(item);
	}

	public void removeItemDoCardapio(Cardapio cardapio, int codigo) {
		try {
			cardapio.removerItem(codigo);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	public void visualizarCardapio(Cardapio cardapio) {
		System.out.println(cardapio);
	}

	public void novoPedido() {

	}

	public void visualizaPedido(int Numero) {

	}

	public void alteraStatusDoPedido(int Numero) {

	}

}
