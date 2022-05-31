package br.edu.pucpr.poo.foodtruck;

import java.util.ArrayList;
import java.util.Formatter;

public class Cardapio {
	ArrayList<Acompanhamento> acompanhamentos = new ArrayList<>();
	ArrayList<Bebida> bebidas = new ArrayList<>();
	ArrayList<Lanche> lanches = new ArrayList<>();

	public ArrayList<Acompanhamento> getAcompanhamentos() {
		return acompanhamentos;
	}

	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}

	public ArrayList<Lanche> getLanches() {
		return lanches;
	}

	@Override
	public String toString() {

		Formatter fmt = new Formatter();
		fmt.format("\n", "");
		fmt.format("%30s", "Lanches\n\n");
		for (Lanche lanche : lanches) {
			fmt.format("%4s. %-30s R$ %.2f (%20s)\n", lanche.getCodigo(), lanche.getNome(), lanche.getPreco(), lanche.getDescricao());
		}
		fmt.format("\n", "");
		fmt.format("%30s", "Bebidas\n\n");
		for (Bebida bebida : bebidas) {
			fmt.format("%4s. %-30s R$ %.2f\n", bebida.getCodigo(), bebida.getNome() + " " + bebida.getTamanho(), bebida.getPreco());
		}
		fmt.format("\n", "");
		fmt.format("%30s", "Acompanhamentos\n\n");
		for (Acompanhamento acompanhamento : acompanhamentos) {
			fmt.format("%4s. %-30s R$ %.2f (%15s)\n", acompanhamento.getCodigo(), acompanhamento.getNome(), acompanhamento.getPreco(), acompanhamento.getDescricao());
		}

		String cardapio = fmt.toString();
		fmt.close();
		return cardapio;
	}

	public void insereNovoAcompanhamento(Acompanhamento acompanhamento) {
		this.acompanhamentos.add(acompanhamento);
	}

	public void insereNovaBebida(Bebida bebida) {
		this.bebidas.add(bebida);
	}

	public void insereNovoLanche(Lanche lanche) {
		this.lanches.add(lanche);
	}

}

