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
		String textoMenu = "1- Lançar novo pedido\n" + "2- Visualizar pedido\n" + "3- Alterar status de um pedido\n"
				+ "4- Visualizar cardápio\n" + "5- Inserir novo item no cardápio\n" + "6- Remover um item do cardápio\n"
				+ "7- Sair";
		String entrada;
		int opt = 0;

		do {
			entrada = JOptionPane.showInputDialog(textoMenu + "\n\n");
			opt = this.retornaInteiro(entrada);

			switch (opt) {
			case 1:
				int confirma = 1; // yes=0; no=1; cancel=2;
				int continua = 0; // yes=0; no=1; cancel=2;
				Item itemDigitado = null;

				do {
					// Para a confirmação de item
					while (confirma != 0) {

						// Validação do item do cardápio (deve ser um item existente)
						while (itemDigitado == null) {
							entrada = JOptionPane.showInputDialog(cardapio.toString() + "\n\nCódigo do item\n\n");

							// Validação do tipo da entrada
							while (!this.intValido(entrada)) {
								entrada = JOptionPane.showInputDialog(null,
										"Valor incorreto!\n\nDigite um número inteiro");
							}
							int codigo = Integer.parseInt(entrada);

							// Tenta localizar o item correspondente ao código no cardápio
							for (Item item : cardapio.getItens()) {
								if (item.getCodigo() == codigo)
									itemDigitado = item;
							}

							// Se não encontrar, apresenta uma mensagem
							if (itemDigitado == null) {
								JOptionPane.showMessageDialog(null, "alerta", "Item não encontrado!",
										JOptionPane.ERROR_MESSAGE);
							}
						}

						// Validação do tipo da entrada
						entrada = null;

						while (!this.intValido(entrada)) {
							entrada = JOptionPane
									.showInputDialog(itemDigitado.toString() + "\n\n" + "Digite a quantidade:\n\n");
						}
						int qtde = Integer.parseInt(entrada);

						entrada = JOptionPane.showInputDialog("Observação:\n\n");
						String obs = entrada;

						// Tela de confirmação

						String textoDoPedido = itemDigitado.getNome() + " (" + qtde + ") " + " (" + obs + ")";

						confirma = JOptionPane.showConfirmDialog(null,
								"Confira o pedido.\n\n" + textoDoPedido + "\n\nConfirma?\n\n", "Confirmação",
								JOptionPane.YES_NO_OPTION);
					}
					
					// Inserir mais itens
					continua = JOptionPane.showConfirmDialog(null, "Deseja inserir mais algum item?\n\n", "Confirmação",
							JOptionPane.YES_NO_OPTION);
					
					// Reseta as variáveis para o próximo item
					confirma = 1;
					entrada = null;
					itemDigitado = null;

				} while (continua == 0);

				// Lança o pedido
				if (confirma == 0) {
					// Pedido pedido = new Pedido();
					JOptionPane.showMessageDialog(null, "Pedido Numero <> Lançado", "Pedido Lançado",
							JOptionPane.INFORMATION_MESSAGE);
				}

				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				entrada = JOptionPane.showInputDialog(cardapio.toString() + "\n\n");
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

		} while (opt != 7);
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
			Integer.parseInt(s); // Método estático, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // Nãoo conseguiu tranformar em inteiro e gera erro
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
