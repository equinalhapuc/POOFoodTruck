package br.edu.pucpr.poo.foodtruck;

public enum StatusPedido {
	LANCADO(1), PREPARANDO(2), PRONTO(3), ENTREGUE(4);
	private int status;

	private StatusPedido(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
	
}
