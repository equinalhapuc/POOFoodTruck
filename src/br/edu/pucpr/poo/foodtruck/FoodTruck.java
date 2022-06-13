package br.edu.pucpr.poo.foodtruck;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FoodTruck {

	private Cardapio cardapio = new Cardapio();
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	/**
	 * Contrutor da classe FoodTruck
	 * Utilizado para inicializar o cardápio
	 */
	public FoodTruck() {
		cardapio.recupera();
		cardapio.resetaCodigoItem();
	}

	/**
	 * Classe main
	 * @param args
	 */
	public static void main(String[] args) {

		FoodTruck meuFoodTruck = new FoodTruck();
		meuFoodTruck.menuPrincipal();

	}

	/**
	 * Exibe o menu principal do sistema
	 */
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

			// Ao pressionar CANCEL, gera um valor null
			if (entrada == null)
				entrada = "7";

			opt = this.retornaInteiro(entrada);

			// Avalia a entrada escolhida
			switch (opt) {

			case 1: // 1- Lançar novo pedido
				this.novoPedido();
				break;

			case 2: // 2- Visualizar pedido
				this.visualizaPedido();
				break;

			case 3: // 3- Alterar o Status de um pedido
				this.alteraStatusDoPedido();
				break;

			case 4: // 4- Exibe o cardápio
				JOptionPane.showMessageDialog(null, cardapio.toString() + "\n\n", "Cardápio",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			case 5: // 5- Inserir um novo item no cardápio
				this.insereItemNoCardapio();
				break;
			
			case 6: // 6- Remover item do cardápio
				this.removeItemDoCardapio();
				break;
				
			case 7: // 7- Sair
				break;

			case 99: // Opção escondida que permite recuperar o cardápio original do sistema
				cardapio.recuperaOriginal();
				cardapio.grava();
				break;
				
			default:
				break;
			}

		} while (opt != 7);
	}

	/**
	 * Apresenta uma sequencia de telas para capturar dados e inserir um novo item no cardápio
	 */
	public void insereItemNoCardapio() {
		
		boolean sair = false;
		
		// Cria um vetor com as opções possíves de se escolher na próxima tela
		String[] tipo = { "Lanche", "Bebida", "Acompanhamento" };

		// Exibe uma tela para a seleção do tipo do item
		Object novoItem = JOptionPane.showInputDialog(null, "Tipo do item:", "Inserir novo item",
				JOptionPane.INFORMATION_MESSAGE, null, tipo, tipo[0]);

		if (novoItem == null)
			return;

		// Inicializa as variáveis
		String nome = "";
		String descricao = "";
		double preco = 0;
		int tamanho = 0;

		// Reseta a variável de entrada do usuário
		String entrada = null;

		// Avalia a opção escolhida
		switch (novoItem.toString()) {
		case "Lanche":
			// Nome
			nome = JOptionPane.showInputDialog("Nome do lanche:\n\n");
			if (nome == null) {
				sair = true;
				break;
			}
			// Descrição
			descricao = JOptionPane.showInputDialog("Descrição:\n\n");
			if (descricao == null) {
				sair = true;
				break;
			}
			// Preço
			while (!doubleValido(entrada)) {
				entrada = JOptionPane.showInputDialog("Preço: R$\n\n");
				if (doubleValido(entrada)) {
					preco = Double.parseDouble(entrada);
				} else if (nome == null) {
					sair = true;
					break;
				}
			}
			if (sair)
				break;
			// Cria um novo lanche com os dados fornecidos
			Lanche lanche = new Lanche(nome, preco, descricao);

			// Adiciona no cardápio
			cardapio.inserirItem(lanche);

			// Salva o cardápio no arquivo
			cardapio.grava();

			break;
		case "Bebida":
			// Nome
			nome = JOptionPane.showInputDialog("Nome da bebida:\n\n");

			// Tamanho
			while (!intValido(entrada)) {
				entrada = JOptionPane.showInputDialog("Tamanho em mL:\n\n");
				if (intValido(entrada)) {
					tamanho = Integer.parseInt(entrada);
				}
			}
			entrada = null;
			// Preço
			while (!doubleValido(entrada)) {
				entrada = JOptionPane.showInputDialog("Preço: R$\n\n");
				if (doubleValido(entrada)) {
					preco = Double.parseDouble(entrada);
				}
			}

			// Cria uma nova bebida com os dados fornecidos
			Bebida bebida = new Bebida(nome, preco, tamanho);

			// Adiciona no cardápio
			cardapio.inserirItem(bebida);

			// Salva o cardápio no arquivo
			cardapio.grava();
			break;
			
		case "Acompanhamento":
			entrada = null;
			// Nome
			nome = JOptionPane.showInputDialog("Nome do acompanhamento:\n\n");
			// Descrição
			descricao = JOptionPane.showInputDialog("Descrição:\n\n");
			// Preço
			while (!doubleValido(entrada)) {
				entrada = JOptionPane.showInputDialog("Preço: R$\n\n");
				if (doubleValido(entrada)) {
					preco = Double.parseDouble(entrada);
				}
			}

			// Cria um novo Acompanhamento com os dados fornecidos
			Acompanhamento acompanhamento = new Acompanhamento(nome, preco, descricao);

			// Adiciona no cardápio
			cardapio.inserirItem(acompanhamento);

			// Salva o cardápio no arquivo
			cardapio.grava();
			break;
			
		default:
			break;
		}
	}

	/**
	 * Remove um item do cardápio
	 */
	public void removeItemDoCardapio() {
		
		// Reseta as variáveis
		String entrada = null;
		int codigoDigitado = -1;
		Item itemRemover = null;

		// Escolha o item
		while (!intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(cardapio.toString() + "\n\nQual item deseja remover?:\n\n");
			if (intValido(entrada)) {
				codigoDigitado = Integer.parseInt(entrada);
			}
			// Se for pressionado CANCELAR a entrada é null
			if (entrada == null)
				break;
		}

		// Localiza o item no cardápio
		for (Item item : cardapio.getItens()) {
			if (item.getCodigo() == codigoDigitado)
				itemRemover = item;
		}

		// Tenta remover o item do cardápio
		try {
			int confirma = JOptionPane.showConfirmDialog(null,
					"O item abaixo será removido:\n\n" + itemRemover.toString() + "\n\nConfirma?", "Escolha um",
					JOptionPane.YES_NO_OPTION);
			if (confirma == 0) {
				cardapio.removerItem(itemRemover.getCodigo());
				cardapio.grava();
				JOptionPane.showMessageDialog(null, "Item removido com sucesso!", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "O item não foi removido", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		// Caso não localize o item, exibe uma mensagem
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Item não encontrado!", "alerta", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 * Exibe o cardápio
	 */
	public void visualizarCardapio() {
		System.out.println(cardapio);
	}

	
	/**
	 * Lança um novo pedido no sistema
	 */
	public void novoPedido() {
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
		String entrada = null;

		// Lista que armazena os itens solicitados para o pedido
		List<ItemPedido> itensDoPedido = new ArrayList<ItemPedido>();

		// Sair da opção
		boolean sair = false;

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
						else if (entrada == null) {
							sair = true;
							break;
						} else
							JOptionPane.showMessageDialog(null, "Insira um valor válido!", "alerta",
									JOptionPane.ERROR_MESSAGE);
					}

					if (sair)
						break;

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

				if (sair)
					break;

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
			if (sair)
				break;

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

		if (sair)
			return;

		// Utiliza StringBuilder para concatenar dinamicamente os itens do pedido
		StringBuilder resumoPedido = new StringBuilder("");
		int sequencia = 1;

		for (ItemPedido itemPedido : itensDoPedido) {
			resumoPedido.append(sequencia + "- " + itemPedido.getItem().getNome() + " - " + itemPedido.getQtde() + " - "
					+ itemPedido.getObs() + "\n");
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
	}

	/**
	 * Visualiza um pedido
	 */
	public void visualizaPedido() {
		// Esta variável armazena o código digitado pelo operador
		int codigoDigitado = 0;

		// Variáveis de controle
		String entrada = null;
		Pedido pedido = null;
		boolean sair = false;

		// Este looping permanece ativo enquanto o operador não digitar um valor válido
		// para código de pedido
		while (codigoDigitado == 0) {
			entrada = JOptionPane.showInputDialog("Digite o código do pedido\n\n");
			if (this.intValido(entrada))
				codigoDigitado = Integer.parseInt(entrada);

			else if (entrada == null) {
				sair = true;
				break;
			}

			else {
				JOptionPane.showMessageDialog(null, "Insira um valor válido!", "alerta", JOptionPane.ERROR_MESSAGE);
				continue;
			}

			// Tenta localizar o pedido digitado. Caso localize, armazena o pedido na
			// variável pedido
			for (Pedido pesqPedido : pedidos) {
				if (pesqPedido.getCodigo() == codigoDigitado)
					pedido = pesqPedido;
			}
		}
		if (sair)
			return;

		// Tenta acessar o pedido encontrado e exibir o resumo na tela
		try {
			// Utiliza StringBuilder para concatenar dinamicamente os itens do pedido
			StringBuilder resumoPedido = new StringBuilder("");
			int sequencia = 1;

			// Varre os itens do pedido para montar a string com os itens dele
			for (ItemPedido itemPedido : pedido.getItens()) {
				resumoPedido.append(sequencia + "- " + itemPedido.getItem().getNome() + " - " + itemPedido.getQtde()
						+ " - " + itemPedido.getObs() + "\n");
				sequencia++;
			}

			// Adiciona na última linha do resumo, o valor total do pedido
			resumoPedido.append("\n\nTotal: R$ " + pedido.getTotal() + "\n\n");

			// Exibe o Pedido
			JOptionPane.showMessageDialog(null, "\n\nPedido: " + pedido.getCodigo() + ": " + pedido.getStatus() + "\n"
					+ resumoPedido.toString() + "\n\n", "Pedido", JOptionPane.INFORMATION_MESSAGE);

			// Caso o pedido não tenha sido encontrado no sistema, exibe um alerta
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Pedido não encontrado!", "alerta", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Altera status de um pedido
	 */
	public void alteraStatusDoPedido() {
		// Esta variável armazena o código digitado pelo operador
		int codigoDigitado = 0;

		// Variáveis de controle
		String entrada = null;
		Pedido pedido = null;
		boolean sair = false;

		// Este looping permanece ativo enquanto o operador não digitar um valor válido
		// para código de pedido
		while (codigoDigitado == 0) {
			entrada = JOptionPane.showInputDialog("Digite o código do pedido\n\n");
			if (this.intValido(entrada))
				codigoDigitado = Integer.parseInt(entrada);
			else if (entrada == null) {
				sair = true;
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Insira um valor válido!", "alerta", JOptionPane.ERROR_MESSAGE);
				continue;
			}

			// Tenta localizar o pedido digitado. Caso localize, armazena o pedido na
			// variável pedido
			for (Pedido pesqPedido : pedidos) {
				if (pesqPedido.getCodigo() == codigoDigitado)
					pedido = pesqPedido;
			}
		}
		if (sair)
			return;
		
		// Tenta alterar o status do pedido
		try {

			// Cria um vetor com as opções possíveis de status de um pedido
			StatusPedido[] opcoes = { StatusPedido.LANCADO, StatusPedido.PREPARANDO, StatusPedido.PRONTO,
					StatusPedido.ENTREGUE };

			// Exibe uma tela para a seleção do novo status do pedido
			Object novoStatus = JOptionPane.showInputDialog(null,
					"Status do pedido: " + pedido.getStatus() + "\n\nEscolha o novo status", "Status do pedido",
					JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

			// Altera o status do pedido
			pedido.setStatus(novoStatus.toString());

			// Caso não tenha encontrado o pedido, exibe uma mensagem
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Pedido não encontrado!", "alerta", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 * @param s - Uma string originária de uma entrada de usuário
	 * @return true - É um int; false - Não é um int
	 */
	private boolean intValido(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException | NullPointerException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param s - Uma string originária de uma entrada de usuário
	 * @return true - É um double; false - Não é um double
	 */
	private boolean doubleValido(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException | NullPointerException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param s - Uma string originária de uma entrada de usuário
	 * @return inteiro parseado a partir da entrada
	 */
	public int retornaInteiro(String entrada) {

		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro entre 1 e 7");
		}
		return Integer.parseInt(entrada);
	}

}
