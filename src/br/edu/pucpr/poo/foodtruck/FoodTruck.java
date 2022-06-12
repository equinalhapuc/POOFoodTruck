package br.edu.pucpr.poo.foodtruck;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

public class FoodTruck {

	private Cardapio cardapio = new Cardapio();
	private List<Pedido> pedidos = new ArrayList<Pedido>();

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

			// Avalia a entrada
			switch (opt) {

			// 1- Lançar novo pedido
			// ------------------------------------------------------------------------------------
			case 1:
				int confirma = 1; // yes=0; no=1; cancel=2;
				int continua = 0; // yes=0; no=1; cancel=2;
				Item itemDigitado = null;
				int codigo = -1;
				int qtde = 0;
				String obs = null;
				entrada = null;
				List<ItemPedido> itensDoPedido = new ArrayList<ItemPedido>();

				do {
					// Para a confirmação de item
					while (confirma != 0) {

						// Validação do item do cardápio (deve ser um item existente)
						while (itemDigitado == null) {

							// Validação da entrada - Deve ser um número inteiro
							while (!this.intValido(entrada)) {
								entrada = JOptionPane.showInputDialog(cardapio.toString() + "\n\nCódigo do item\n\n");
								if (this.intValido(entrada))
									codigo = Integer.parseInt(entrada);
								else
									JOptionPane.showMessageDialog(null, "Insira um valor válido!", "alerta",
											JOptionPane.ERROR_MESSAGE);

							}

							// Tenta localizar o item correspondente ao código no cardápio
							for (Item item : cardapio.getItens()) {
								if (item.getCodigo() == codigo)
									itemDigitado = item;
							}

							// Se não encontrar, apresenta uma mensagem
							if (itemDigitado == null) {
								JOptionPane.showMessageDialog(null, "Item não encontrado!", "alerta",
										JOptionPane.ERROR_MESSAGE);
								confirma = 1;
								entrada = null;
								itemDigitado = null;
							}
						}

						// Validação do tipo da entrada
						entrada = null;

						while (!this.intValido(entrada)) {
							entrada = JOptionPane
									.showInputDialog(itemDigitado.toString() + "\n\n" + "Digite a quantidade:\n\n");
						}
						qtde = Integer.parseInt(entrada);

						entrada = JOptionPane.showInputDialog("Observação:\n\n");
						obs = entrada;

						// Tela de confirmação
						String textoDoPedido = itemDigitado.getNome() + " (" + qtde + ") " + " (" + obs + ")";

						confirma = JOptionPane.showConfirmDialog(null,
								"Confira o item\n\n" + textoDoPedido + "\n\nConfirma?\n\n", "Confirmação",
								JOptionPane.YES_NO_OPTION);
					}

					// Insere o item do pedido na lista
					ItemPedido itemPedido = new ItemPedido(itemDigitado, qtde, obs);
					itensDoPedido.add(itemPedido);

					// Inserir mais itens
					continua = JOptionPane.showConfirmDialog(null, "Deseja inserir mais algum item?\n\n", "Confirmação",
							JOptionPane.YES_NO_OPTION);

					// Reseta as variáveis para o próximo item
					confirma = 1;
					entrada = null;
					itemDigitado = null;

				} while (continua == 0);

				// Utiliza StringBuilder para concatenar dinamicamente os itens do pedido
				StringBuilder resumoPedido = new StringBuilder("");
				int sequencia = 1;

				for (ItemPedido itemPedido : itensDoPedido) {
					resumoPedido.append(sequencia + "- " + itemPedido.getItem().getNome() + " - " + itemPedido.getQtde()
							+ " - " + itemPedido.getObs() + "\n");
					sequencia++;
				}
				
				// Cria o pedido e insere a lista de itens
				Pedido pedido = new Pedido(itensDoPedido);
				
				resumoPedido.append("\n\nTotal: R$ " + pedido.getTotal() + "\n\n");

				// Exibe o numero do pedido criado e o resumo do mesmo
				JOptionPane.showMessageDialog(null,
						"Pedido Numero " + pedido.getCodigo() + ": Lançado no Sistema\n\n" + resumoPedido.toString(),
						"Pedido Lançado", JOptionPane.INFORMATION_MESSAGE);

				break;

			// 2- Visualizar pedido
			// ------------------------------------------------------------------------------------
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
