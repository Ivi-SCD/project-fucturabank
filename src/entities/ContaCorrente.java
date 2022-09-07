package entities;

import entities.exceptions.BankException;

public class ContaCorrente extends Contas {
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente( String titular, Integer numeroacc) {
		super(titular, numeroacc);
	}

	public ContaCorrente(String titular, Integer numeroacc, Double saldo) {
		super(titular, numeroacc,saldo);
	}

	public void saque (double valorSaque) {
		if(valorSaque > saldo) {
			throw new BankException("Saque impossível. Saldo disponível inferior que o valor do saque.");
		}
		else {
			saldo -= valorSaque;
			System.out.println("Saque de $" + valorSaque + " realizado.");
			System.out.println();
		}
	}
	
	public void aplicar(double valor, ContaPoupanca cp) {
		if(cp.getTitular() != titular || cp.getNumeroAcc() != numeroacc) {
			throw new BankException("Aplicação impossível. Números ou titulares distintos.");
		}
		else {
			if(cp.saldo == null)
			{
				cp.saldo = 0.0;
				cp.saldo += valor;
				saldo -= valor;
				System.out.println("Aplicado o valor de $" + valor + " na conta poupança.\n");
			}
			else {
				cp.saldo += valor;
				saldo -= valor;
				System.out.println("Aplicado o valor de $" + valor + " na conta poupança.\n");
			}
		}
	}

	@Override
	public void deposito(double valorDeposito) {
		saldo += valorDeposito;
		System.out.println("Depósito de $" + valorDeposito + " realizado.\n");
	}

	public String saldoTotalString(ContaPoupanca cp) {
		StringBuilder sb = new StringBuilder();
		sb.append("Número: " + numeroacc);
		sb.append("\nTitular: " + titular);
		sb.append("\nSaldo Total: " + (saldo + cp.getSaldo()));
		sb.append("\nSaldo Conta Corrente:" + saldo);
		sb.append("\nSaldo Conta Poupança: " + cp.getSaldo());
		return sb.toString();
		
	}
}