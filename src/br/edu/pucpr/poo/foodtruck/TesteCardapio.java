package br.edu.pucpr.poo.foodtruck;

public class TesteCardapio {

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

		cardapio.inserirItem(new Acompanhamento("Batatas rústicas", 12.0, "Porção de 200g"));
		cardapio.inserirItem(new Acompanhamento("Onion rings", 18.0, "Porção de 200g"));
		cardapio.inserirItem(new Acompanhamento("Mini pastéis", 20.0, "10 unidades"));

		System.out.println(cardapio);
		cardapio.grava();
		System.out.println(cardapio.recupera());
		
		System.out.println();
		
		System.out.println(cardapio);
		
		cardapio.removerItem(3);
		System.out.println(cardapio);
		
		for (Item item : cardapio.getItens()) {
			if(item.getCodigo() == 7) {
				System.out.println(item);
			}
		}
		
		
	}

}
