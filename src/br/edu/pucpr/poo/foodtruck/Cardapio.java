package br.edu.pucpr.poo.foodtruck;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;

public class Cardapio {
	// Polimorfismo
	private ArrayList<Item> itens = new ArrayList<>();

	public ArrayList<Item> getItens() {
		return itens;
	}

	/**
	 * Retorna apenas os itens do cardápio que correspondam ao tipo Acompanhamento
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getAcompanhamentos() {
		ArrayList<Item> acompanhamentos = new ArrayList<>();

		for (Item item : itens) {
			if (item instanceof Acompanhamento) {
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
			if (item instanceof Bebida) {
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
			if (item instanceof Lanche) {
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

	public void inserirItem(Item item) {
		this.itens.add(item);		
	}
	
	public void removerItem(int codigo) {
		Item itemRemover = null;
		for (Item item : itens) {
			if(item.getCodigo() == codigo)
				itemRemover = item;
		}
		
		if(itemRemover == null)
			throw new NoSuchElementException("Item não encontrado");
		this.itens.remove(this.itens.indexOf(itemRemover));
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
			System.out.println("Erro: " + e);
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
		} catch (EOFException e) {
			System.out.println();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		return itens;
	}

}
