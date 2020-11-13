package ecommerce;

import java.util.Scanner;

public class superbbb {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int quantidade = 1;
		int qnt_total = 0;
		double valorunitario = 0, parcela = 0;
		double valorproduto = 0;
		double valor, total = 0;
		int esc = 0;
		boolean status = true;
		char confirmacao;
		String produtos[] = { "leite         ", "biscoito      ", "Veja          ",
				"revista       ", "cloro         ", "refrigerante  ", "parafuso      ",
				"lâmpada       ","papel-toalha  ", "papel higiênico" };
		String unidadeProdutos[] = { "litro  ", "pacote ", "unidade", "unidade",
				"litro  ", "unidade", "pacote ", "unidade","pacote ", "pacote " };
		double valor1[] = { 3.50, 1.80, 4.00, 5.99, 3.50, 6.50, 3.00, 5.00, 7.00, 14.00 };
		int estoque[] = { 30, 40, 20, 20, 30, 60, 40, 50, 60, 80 };
		int carrinhoQuantidade[] = new int[10];
		String codigo[] = new String[10];
		String produto;
		char pergunta1;
		//int quantidade = 0;
		int contador = 0;
		double precoCompra[] = new double[10], valorCarrinho = 0.0,
				valorAgregado[] = new double[10];
		char proximoCliente;
		double imposto = 0.0;
		
		do
		{
		do {
			
			System.out.println("Bem vindo ao Mercadinho SBB! Veja nossas ofertas do dia!!!");

			for (int x = 0; x < 10; x++) {
				codigo[x] = "SBB-0" + (x + 1);
				System.out.printf("\n"+codigo[x] + "\t" + produtos[x] + "\t\t R$ " + valor1[x] + "\t\t por "
						+ unidadeProdutos[x] + "\t\t em estoque: " + estoque[x]);
				
			}

			// ===========================================================Aqui é a parte do
			// carrinho de compras
			do {

				System.out.println("\nO quê deseja comprar? Entre com o codigo do produto: ");
				produto = leia.next().toUpperCase();

				contador = 0;

				for (int x = 0; x < 10; x++) {
					if (produto.equals(codigo[x])) {
						if (estoque[x] != 0) {
							do {
								System.out.println(codigo[x] + "\t" + produtos[x] + "\t\t R$ " + valor1[x] + "\t\t por "
										+ unidadeProdutos[x] + "\t\t em estoque: " + estoque[x]);
								System.out.println("Quanto(s) " + unidadeProdutos[x]
										+ "(s) você quer comprar? Obs: O minimo de compra é 10 por "
										+ unidadeProdutos[x] + "(s).");
								quantidade = leia.nextInt();

								if (quantidade > estoque[x] || quantidade < 10) {
									System.out.println(
											"ERROR! Quantidade do produto acima do estoque ou abaixo do minimo de compra.");
								}

							} while (quantidade > estoque[x] || quantidade < 10);

							// if(quantidade<=estoque[x] && quantidade>=10)
							// {
							estoque[x] = (estoque[x] - quantidade);
							precoCompra[x] = (quantidade * valor1[x]);
							valorAgregado[x] = (valorAgregado[x] + precoCompra[x]);
							valorCarrinho = (valorCarrinho + precoCompra[x]);
							carrinhoQuantidade[x] = (carrinhoQuantidade[x] + quantidade);
							// }
						} else {
							System.out.println("Produto fora de estoque!");
						}

					} else {
						contador++;
						precoCompra[x] = 0;
					}
					
				}
				if (contador == 10) {
					System.out.println("ERROR!Condigo informado não consta no sistema.");
				}

			} while (contador == 10);

			System.out.println("Seu carrinho de compras: ");
			for (int x = 0; x < 10; x++) {
				if (precoCompra[x] > 0) {
					System.out.println(codigo[x] + "\t" + produtos[x] + "\t\t Quantidade: " + carrinhoQuantidade[x]
							+ "\t\t Valor total : R$" + valorAgregado[x]);
				}
			}

			System.out.println("Valor total do carrinho de compras: R$" + valorCarrinho);

			System.out.println("Deseja comprar mais algum produto?");
			pergunta1 = leia.next().toUpperCase().charAt(0);

		} while (pergunta1 == 'S');
		//aqui vai aquela tela
		System.out.println(" Total: R$ " + valorCarrinho);
		System.out.print("\nDIGITE A FORMA DE PAGAMENTO\n");
		System.out.print("\nDIGITE [1] PARA COMPRAR Á VISTA , NO DINHEIRO OU CHEQUE COM 20% DE DESCONTO");
		System.out.print("\nDIGITE [2] PARA COMPRAR Á VISTA , NO CARTÃO DE CREDITO COM 15% DE DESCONTO");
		System.out.print("\nDIGITE [3] PARA PARCELAR EM 2X SEM JUROS");
		System.out.print("\nDIGITE [4] PARA PARCELAR EM 3X COM ACRESCIMO DE 10 % DE JUROS\n ");
		esc = leia.nextInt();
		if (esc == 1) 
		{
			valorCarrinho = valorCarrinho - (valorCarrinho * 20 / 100)+ (imposto = (valorCarrinho * 0.09));
			System.out.printf("\n PREÇO FINAL: R$%.2f dos quais R$%.2f é imposto\n", valorCarrinho, imposto );
		} 
		else if (esc == 2)
		{
			valorCarrinho = valorCarrinho - (valorCarrinho * 15 / 100)+ (imposto = (valorCarrinho * 0.09));
			System.out.printf("\n PREÇO FINAL: R$%.2f dos quais R$%.2f é imposto\n", valorCarrinho, imposto );
		}
		else if (esc == 3)
		{
			valorCarrinho = valorCarrinho + (imposto = (valorCarrinho * 0.09));
			parcela = valorCarrinho/2;
			System.out.printf("\n PREÇO FINAL: R$%.2f com suaves parcelas de R$%.2f dos quais R$%.2f é imposto\n", valorCarrinho,parcela, imposto);
		} 
		else if (esc == 4) 
		{
			valorCarrinho = valorCarrinho + (valorCarrinho * 0.10)+ (imposto = (valorCarrinho * 0.09));
			parcela = valorCarrinho/3;
			System.out.printf("\n PREÇO FINAL: R$%.2f com suaves parcelas de R$%.2f dos quais R$%.2f é imposto\n", valorCarrinho,parcela, imposto );
		}
		
		valorCarrinho=0;
		System.out.println("Próximo cliente S ou N");
		proximoCliente = leia.next().toUpperCase().charAt(0);
		
	}
	while (proximoCliente == 'S'); 
		System.out.println("FIM DE OPERAÇÃO.");
		
	}

}