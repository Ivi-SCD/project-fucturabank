## Projeto-FucturaBank

- O projeto terá uma classe para Conta Corrente e uma classe para Conta
Poupança que herdará da classe abstrata Contas;
- A classe Contas deverá ter os atributos: **número da conta, nome do titular,
saldo disponível** e ter *métodos para exibir os dados da conta cadastrada,
fazer depósito, exibir o saldo de cada conta e métodos getters e setters dos
atributos private*;
- A ContaCorrente além dos métodos herdados terá *método para fazer
saques e para aplicação de valores na ContaPoupança*;
- A Conta Poupança além dos métodos herdados terá o *método resgatar
que transfere valores da Poupança para ContaCorrente*;
- Deverá ter **confirmação para cada operação realizada**. Por exemplo:
ao realizar um saque informar que o saque foi feito;
- **O projeto precisa de uma classe que possua o método main. Nesta classe
será feita a criação de objetos, as chamadas aos métodos, atribuição de
valores aos atributos.**

## Observações
* O atributo saldo não deverá ser alterado diretamente, deverá
ser criado um método para manipular o atributo saldo.
* A primeira ação que deverá ser feito é cadastrar a conta. Tem que
ser solicitado ao usuário digitar o seu nome, um número de conta (esse número
é aleatório, somente para a conta ter um número quando for mostrar os dados da conta). Ainda no cadastro deverá ser perguntado se será feito um depósitoinicial. A ContaCorrente poderá ser criada com saldo R$ 0.00 (zero) ou com o
valor de depósito inicial.
* A Poupança não aceitará saques e depósitos diretamente, para depositar ou sacar dinheiro da ContaPoupança será utilizado os métodos *aplicar() e resgatar()* respectivamente.
