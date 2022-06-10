package br.edu.pucpr.poo.foodtruck;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

public class FoodTruck {
	
	private Cardapio cardapio = new Cardapio();

	public FoodTruck() {
		cardapio.recupera();
	}

	public static void main(String[] args) {
		
		FoodTruck meuFoodTruck = new FoodTruck();
		meuFoodTruck.menuPrincipal();

	}

	public void menuPrincipal() {
		String textoMenu = "1- Lançar novo pedido\n"
						+ "2- Visualizar pedido\n"
						+ "3- Alterar status de um pedido\n"
						+ "4- Visualizar cardápio\n"
						+ "5- Inserir novo item no cardápio\n"
						+ "6- Remover um item do cardápio\n"
						+ "7- Sair";
		String entrada;
		int opt = 0;
		
		do {		
			entrada = JOptionPane.showInputDialog (textoMenu + "\n\n");
			opt = this.retornaInteiro(entrada);
			
			switch(opt) {
			case 1:
				entrada = JOptionPane.showInputDialog (cardapio.toString() + "\n\nCódigo do item\n\n");
				int codigo = this.retornaInteiro(entrada);
				
				Item itemDigitado = null;
				
				for (Item item : cardapio.getItens()) {
					if(item.getCodigo() == codigo)
						itemDigitado = item;
				}
				
				entrada = JOptionPane.showInputDialog (itemDigitado.toString() + "\n\n" + "Digite a quantidade:\n\n");
				int qtde = this.retornaInteiro(entrada);
				
				entrada = JOptionPane.showInputDialog ("Observação:\n\n");
				String obs = entrada;
				
				//Pedido pedido = new Pedido();
				
				entrada = JOptionPane.showInputDialog (itemDigitado.toString() + "x "+ qtde + " - " + obs + "\n\nConfirma?\n\n");
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				entrada = JOptionPane.showInputDialog (cardapio.toString()+"\n\n");
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				break;
			}
			
		} while(opt != 7);
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
	
	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); 				// Método estático, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { 	// Nãoo conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	public int retornaInteiro(String entrada) { // retorna um valor inteiro

		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro entre 1 e 7");
		}
		return Integer.parseInt(entrada);
	}


}
