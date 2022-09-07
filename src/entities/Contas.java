package entities;

public abstract class Contas {
	protected Integer numeroacc;
	protected String titular;
	protected Double saldo;
	
	public Contas() {
	}
	
	public Contas( String titular, Integer numeroacc) {
		this.numeroacc = numeroacc;
		this.titular = titular;
	}

	public Contas(String titular, Integer numeroacc, Double saldo) {
		this.numeroacc = numeroacc;
		this.titular = titular;
		this.saldo = saldo;
		System.out.println("Conta criada com sucesso!!");
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	protected Integer getNumeroAcc() {
		return numeroacc;
	}
	
	public abstract void deposito(double valDeposito);
	
	public double saldoTotal(ContaCorrente cc, ContaPoupanca cp) {
		return cc.getSaldo() + cp.getSaldo();
	}
	
	public String saldoTotalString(ContaCorrente cc, ContaPoupanca cp) {
		StringBuilder sb = new StringBuilder();
		sb.append("Número: " + numeroacc);
		sb.append("\nTitular: " + titular);
		sb.append("\nSaldo Total: " + cc.getSaldo() + cp.getSaldo());
		sb.append("\nSaldo Conta Corrente:" + cc.getSaldo());
		sb.append("\nSaldo Conta Poupança: " + cp.getSaldo());
		return sb.toString();
	}
}
