package br.edu.pucpr.poo.foodtruck;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;

public class Cardapio {
	// Polimorfismo
	ArrayList<Item> itens = new ArrayList<>();

	/**
	 * Retorna apenas os itens do cardápio que correspondam ao tipo Acompanhamento
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getAcompanhamentos() {
		ArrayList<Item> acompanhamentos = new ArrayList<>();

		for (Item item : itens) {
			if (item.getClass().equals(Acompanhamento.class)) {
				acompanhamentos.add(item);
			}
		}

		return acompanhamentos;
	}

	/**
	 * Retorna apenas os itens do cardápio que correspondam ao tipo Bebida
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getBebidas() {
		ArrayList<Item> bebidas = new ArrayList<>();

		for (Item item : itens) {
			if (item.getClass().equals(Bebida.class)) {
				bebidas.add(item);
			}
		}

		return bebidas;
	}

	/**
	 * Retorna apenas os itens do cardápio que correspondam ao tipo Lanche
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getLanches() {
		ArrayList<Item> lanches = new ArrayList<>();

		for (Item item : itens) {
			if (item.getClass().equals(Lanche.class)) {
				lanches.add(item);
			}
		}

		return lanches;
	}

	// Sobrescreve o método toString() da classe Object para formatar o cardápio
	@Override
	public String toString() {

		Formatter fmt = new Formatter();
		fmt.format("\n", "");
		fmt.format("%30s", "Lanches\n\n");
		for (Item item : this.getLanches()) {
			Lanche lanche = (Lanche) item;
			fmt.format("%s", lanche.toString());
		}
		fmt.format("\n", "");
		fmt.format("%30s", "Bebidas\n\n");
		for (Item item : this.getBebidas()) {
			Bebida bebida = (Bebida) item;
			fmt.format("%s", bebida.toString());
		}
		fmt.format("\n", "");
		fmt.format("%30s", "Acompanhamentos\n\n");
		for (Item item : this.getAcompanhamentos()) {
			Acompanhamento acompanhamento = (Acompanhamento) item;
			fmt.format("%s", acompanhamento.toString());
		}

		String cardapio = fmt.toString();
		fmt.close();
		return cardapio;
	}

	/**
	 * Insere um novo acompanhamento no cardápio
	 * @return ArrayList<Item>
	 */
	public void insereNovoAcompanhamento(Acompanhamento acompanhamento) {
		this.itens.add(acompanhamento);
	}

	/**
	 * Insere uma nova bebida no cardápio
	 * @return void
	 */
	public void insereNovaBebida(Bebida bebida) {
		this.itens.add(bebida);
	}

	/**
	 * Insere um novo lanche no cardápio
	 * @return void
	 */
	public void insereNovoLanche(Lanche lanche) {
		this.itens.add(lanche);
	}

	/**
	 * Grava o cardápio no arquivo <i>dados.bin</i>, na pasta raíz do projeto
	 * @return void
	 */
	public void grava() {

		// "Try with resources" disponível a partir do java 1.7. O .close() e o
		// finally() são implícitos
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cardapio.bin"))) {
			for (Item item : itens) {
				oos.writeObject(item);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public ArrayList<Item> recupera(){
		ArrayList<Item> itens = new ArrayList<>();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cardapio.bin"))) {
			Object input = null;
			while ((input = ois.readObject()) != null) {
				if(input instanceof Acompanhamento)
					itens.add((Acompanhamento) input);
				else if (input instanceof Bebida)
					itens.add((Bebida) input);
				else
					itens.add((Lanche) input);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return itens;
	}

}
