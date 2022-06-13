package br.edu.pucpr.poo.foodtruck;

/**
 * Esta classe serve apenas para teste da classe cardápio e gerar o cardápio original do sistema
 * <p>
 * @param Nome, preço, descrição
 * @author Eduardo Quinalha, André Augusto Neves, André Yuji Duarte Kunitake
 * @version 1.0
 *
 */
public class GeraCardapio {

	public static void main(String[] args) {

		Cardapio cardapio = new Cardapio();

		cardapio.inserirItem(new Bebida("Coca-cola", 10.0, 500));
		cardapio.inserirItem(new Bebida("Sprite", 10.0, 500));
		cardapio.inserirItem(new Bebida("Chopp IPA", 25.0, 700));
		cardapio.inserirItem(new Bebida("Chopp Lager", 20.0, 700));
		cardapio.inserirItem(new Bebida("Chopp Pale Ale", 20.0, 700));

		cardapio.inserirItem(new Lanche("X-burger", 15.0, "Pão francês, queijo mussarela e hambúrger de 200g"));
		cardapio.inserirItem(
				new Lanche("X-salada", 17.0, "Pão francês, queijo mussarela, salada e hambúrger de 200g"));
		cardapio.inserirItem(
				new Lanche("duplo X-burger", 20.0, "Pão francês, queijo mussarela e dois hambúrgeres de 200g"));
		cardapio.inserirItem(new Lanche("Hot Dog", 13.0, "Pão especial, salsicha, molho"));
		cardapio.inserirItem(new Lanche("X-montanha", 15.00, "Pão, queijo, presunto, salada, hambúrguer e um pastel dentro"));

		cardapio.inserirItem(new Acompanhamento("Batatas rústicas", 12.0, "Porção de 200g"));
		cardapio.inserirItem(new Acompanhamento("Onion rings", 18.0, "Porção de 200g"));
		cardapio.inserirItem(new Acompanhamento("Mini pastéis", 20.0, "10 unidades"));
		cardapio.inserirItem(new Acompanhamento("Porção de calabresa", 13.0, "Calabresa frita com cebola e condimentos"));
		
		cardapio.gravaOriginal();

		cardapio.recuperaOriginal();
		
		System.out.println(cardapio);
	}

}
