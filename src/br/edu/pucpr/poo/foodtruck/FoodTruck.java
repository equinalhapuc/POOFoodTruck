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
		// Texto do menu principal
		String textoMenu = "1- Lançar novo pedido\n" + "2- Visualizar pedido\n" + "3- Alterar status de um pedido\n"
				+ "4- Visualizar cardápio\n" + "5- Inserir novo item no cardápio\n" + "6- Remover um item do cardápio\n"
				+ "7- Sair";

		// Variável que vai receber a entrada do usuário
		String entrada;

		// Variável que vai receber a opção escolhida no menu
		int opt = 0;

		// Este looping permanece ativo enquanto o usuário não sair do sistema
		do {

			// Exibe o menu principal
			entrada = JOptionPane.showInputDialog(textoMenu + "\n\n");
			opt = this.retornaInteiro(entrada);

			// Avalia a entrada escolhida
			switch (opt) {

			// 1- Lançar novo pedido-------------------------------------
			case 1:
				// Esta variável recebe a confirmação de cada item do pedido, permitindo
				// prosseguir
				int confirma = 1; // yes=0; no=1; cancel=2;

				// Esta variável recebe a intenção de inserir ou não, mais itens no pedido
				int continua = 0; // yes=0; no=1; cancel=2;

				// Esta variável vai armazenar o item selecionado, caso ele exista
				Item itemDigitado = null;

				// Esta variável recebe o código do item desejado, digitado pelo operador
				int codigo = -1;

				// Esta variável recebe a quantidade desejada do item selecionado
				int qtde = 0;

				// Esta variável recebe a observação solicitada pelo cliente
				String obs = null;

				// Variável que armazena o pedido atual
				Pedido pedido;

				// Reseta a variável entrada para permitir que o programa prossiga
				entrada = null;

				// Lista que armazena os itens solicitados para o pedido
				List<ItemPedido> itensDoPedido = new ArrayList<ItemPedido>();

				// Este looping permanece ativo enquanto o operador indicar que há mais itens a
				// serem adicionados ao pedido
				do {
					// Este looping permanece ativo enquanto o perador não confirmar o item atual
					// que está inserindo no pedido
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
								// Reseta as variáveis de controle
								confirma = 1;
								entrada = null;
								itemDigitado = null;
							}
						}

						// Reseta a variável entrada para receber um novo valor
						entrada = null;

						// Valida a quantidade desejada para o item (tem que ser um número inteiro)
						while (!this.intValido(entrada)) {
							entrada = JOptionPane
									.showInputDialog(itemDigitado.toString() + "\n\n" + "Digite a quantidade:\n\n");
						}
						qtde = Integer.parseInt(entrada);

						// Recebe a observação do cliente com relação ao item atual
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
				pedido = new Pedido(itensDoPedido);

				// Adiciona o pedido na lista de pedidos do sistema
				pedidos.add(pedido);

				// Adiciona na última linha do resumo, o valor total do pedido
				resumoPedido.append("\n\nTotal: R$ " + pedido.getTotal() + "\n\n");

				// Exibe o numero do pedido criado e o resumo do mesmo
				JOptionPane.showMessageDialog(null,
						"Pedido Numero " + pedido.getCodigo() + ": Lançado no Sistema\n\n" + resumoPedido.toString(),
						"Pedido Lançado", JOptionPane.INFORMATION_MESSAGE);

				break;
			// Fim do código da opção 1 do menu principal: Lançar novo pedido

			// 2- Visualizar pedido--------------------------------------------
			case 2:

				// Esta variável armazena o código digitado pelo operador
				int codigoDigitado = 0;

				// Reseta as variáveis do sistema
				entrada = null;
				pedido = null;

				// Este looping permanece ativo enquanto o operador não digitar um valor válido
				// para código de pedido
				while (codigoDigitado == 0) {
					entrada = JOptionPane.showInputDialog("Digite o código do pedido\n\n");
					if (this.intValido(entrada))
						codigoDigitado = Integer.parseInt(entrada);
					else {
						JOptionPane.showMessageDialog(null, "Insira um valor válido!", "alerta",
								JOptionPane.ERROR_MESSAGE);
						continue;
					}

					// Tenta localizar o pedido digitado. Caso localize, armazena o pedido na
					// variável pedido
					for (Pedido pesqPedido : pedidos) {
						if (pesqPedido.getCodigo() == codigoDigitado)
							pedido = pesqPedido;
					}
				}

				// Tenta acessar o pedido encontrado e exibir o resumo na tela
				try {
					// Utiliza StringBuilder para concatenar dinamicamente os itens do pedido
					resumoPedido = new StringBuilder("");
					sequencia = 1;

					// Varre os itens do pedido para montar a string com os itens dele
					for (ItemPedido itemPedido : pedido.getItens()) {
						resumoPedido.append(sequencia + "- " + itemPedido.getItem().getNome() + " - "
								+ itemPedido.getQtde() + " - " + itemPedido.getObs() + "\n");
						sequencia++;
					}

					// Adiciona na última linha do resumo, o valor total do pedido
					resumoPedido.append("\n\nTotal: R$ " + pedido.getTotal() + "\n\n");

					// Exibe o Pedido
					JOptionPane.showMessageDialog(null, "\n\nPedido: " + pedido.getCodigo() + ": " + pedido.getStatus()
							+ "\n" + resumoPedido.toString() + "\n\n", "Pedido", JOptionPane.INFORMATION_MESSAGE);

					
				// Caso o pedido não tenha sido encontrado no sistema, exibe um alerta 
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Pedido não encontrado!", "alerta", JOptionPane.ERROR_MESSAGE);
				}

				break;
			// Fim do código da opção 2 do menu principal: Visualizar pedido

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
