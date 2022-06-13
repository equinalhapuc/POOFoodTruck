package br.edu.pucpr.poo.foodtruck;

/**
 * Classe do tipo ENUM que representa os possíveis estados de um pedido
 * <p>
 * 
 * @author Eduardo Quinalha, André Augusto Neves, André Yuji Duarte Kunitake
 * @version 1.0
 *
 */
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
