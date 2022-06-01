package br.edu.pucpr.poo.foodtruck;

public class Main {

	public static void main(String[] args) {

		Cardapio cardapio = new Cardapio();

		cardapio.insereNovaBebida(new Bebida("Coca-cola", 10.0, 500));
		cardapio.insereNovaBebida(new Bebida("Sprite", 10.0, 500));
		cardapio.insereNovaBebida(new Bebida("Chopp IPA", 25.0, 700));
		cardapio.insereNovaBebida(new Bebida("Chopp Lager", 20.0, 700));
		cardapio.insereNovaBebida(new Bebida("Chopp Pale Ale", 20.0, 700));

		cardapio.insereNovoLanche(new Lanche("X-burger", 15.0, "Pão francês, queijo mussarela e hambúrger de 200g"));
		cardapio.insereNovoLanche(
				new Lanche("X-salada", 17.0, "Pão francês, queijo mussarela, salada e hambúrger de 200g"));
		cardapio.insereNovoLanche(
				new Lanche("duplo X-burger", 20.0, "Pão francês, queijo mussarela e dois hambúrgeres de 200g"));
		cardapio.insereNovoLanche(new Lanche("Hot Dog", 13.0, "Pão especial, salsicha, molho"));

		cardapio.insereNovoAcompanhamento(new Acompanhamento("Batatas rústicas", 12.0, "Porção de 200g"));
		cardapio.insereNovoAcompanhamento(new Acompanhamento("Onion rings", 18.0, "Porção de 200g"));
		cardapio.insereNovoAcompanhamento(new Acompanhamento("Mini pastéis", 20.0, "10 unidades"));

		System.out.println(cardapio);
		cardapio.grava();
		System.out.println(cardapio.recupera());
	}

}
