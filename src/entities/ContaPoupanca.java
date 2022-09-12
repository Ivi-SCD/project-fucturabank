package entities;

import entities.exceptions.BankException;

public class ContaPoupanca extends Contas {
	/*
	 * @author: Ivisson Pereira
	 * Foi feita a criação de exceções para casos irreais de aplicação/resgate/saque/depósito
	 * e para também, invalidar a tentativa de transferência de valores para contas distintas [!]
	 */
	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(String titular, Integer numeroacc) {
		super(titular, numeroacc);
		saldo = 0.0;
	}

	public void resgatar(double val, ContaCorrente acc) {
		if(acc.getTitular() != titular || acc.getNumeroAcc() != numeroacc) {
			throw new BankException("Resgate impossível. Números ou titulares distintos.");
		}
		if (val > saldo) {
			throw new BankException("Resgate impossível. Valor superior ao saldo.");
		}
		else {
			saldo -= val;
			acc.saldo += val;
			System.out.println("Resgatado o valor de $" + val + " para a conta corrente.\n");
		}
	}

	@Override
	public void deposito(double valDeposito) {
		System.out.println("Tentativa inválida de depósito. Para depositar, por favor utilize o método aplicar() da ContaCorrente.");
	}

	public String saldoTotalString(ContaCorrente cc) {
		StringBuilder sb = new StringBuilder();
		sb.append("Número: " + numeroacc);
		sb.append("\nTitular: " + titular);
		sb.append("\nSaldo Total: $" + String.format("%.2f", cc.getSaldo() + saldo));
		sb.append("\nSaldo Conta Corrente: $" + String.format("%.2f", cc.getSaldo()));
		sb.append("\nSaldo Conta Poupança: $" + String.format("%.2f", saldo));
		return sb.toString();
	}
}