package application;

import java.util.Locale;
import java.util.Scanner;

import entities.ContaCorrente;
import entities.ContaPoupanca;
import entities.exceptions.BankException;

public class Program {

	public static void main(String[] args) {
		ContaCorrente cc;
		ContaPoupanca cp;
	
		Locale.setDefault(Locale.US);
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("###### Criação da conta ######");
			System.out.print("Digite o seu nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Digite o número da conta: ");
			Integer numeroacc = sc.nextInt();
			
			System.out.print("Será feito um depósito inicial? (s/n) ");
			char carac = sc.next().charAt(0);
			
			
			if (carac == 's') {
				System.out.print("Digite valor do depósito inicial: ");
				double valdeposit = sc.nextDouble();
				
				cc = new ContaCorrente(nome, numeroacc, valdeposit);
				cp = new ContaPoupanca(nome, numeroacc);
			}
			else {
				cc = new ContaCorrente(nome, numeroacc);
				cp = new ContaPoupanca(nome, numeroacc);
			}
			
			System.out.println("################################\n");
			
			int num = 0;
			while(num != 5) {
				System.out.println("Qual procedimento você deseja realizar: ");
				System.out.println("1. Aplicação de valores na conta poupança. ");
				System.out.println("2. Resgate de valores da conta poupança para corrente. ");
				System.out.println("3. Deposito. (Inválido a operação de depositar diretamente na conta poupança.)");
				System.out.println("4. Saque. ");
				System.out.println("5. Sair. ");
				System.out.print("=>> ");
				num = sc.nextInt();
				
				ContaPoupanca cother = new ContaPoupanca("Lucas", 2323);
				
				switch(num) {
					case 1:
						System.out.print("Quanto você deseja aplicar? ");
						double valaplicacao = sc.nextDouble();
						cc.aplicar(valaplicacao, cother);
						break;
					case 2:
						System.out.print("Quanto você deseja resgatar? ");
						double valresgate = sc.nextDouble();
						cp.resgatar(valresgate, cc);
						break;
					case 3:
						System.out.print("Quanto você deseja depositar? ");
						double valdeposit = sc.nextDouble();
						cc.deposito(valdeposit);
						break;
					case 4:
						System.out.println("Quanto você deseja sacar? ");
						double valsaque = sc.nextDouble();
						cc.saque(valsaque);
						break;
					case 5:
						break;
				}
			}
			
			
			System.out.println("Detalhes das contas: ");
			System.out.println(cc.saldoTotalString(cp));
			sc.close();
		}
		catch (BankException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}