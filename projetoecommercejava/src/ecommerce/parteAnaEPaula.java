package ecommerce;
import java.util.Scanner;
public class parteAnaEPaula {

	public static void main(String[] args) {
		
		Scanner  leia = new Scanner (System.in);
		
		
		int quantidade = 1;
		int qnt_total = 0;
		double valorunitario =0;
		double valorproduto = 0;
		double valor , total = 0;
		int esc = 0 ;
		boolean status = true;
		String confirmacao;
		
		while (status == true ){
			
			System.out.println ( "Digite a quantidade do item");
			quantidade = leia.nextInt();
			
		if (quantidade > 0) {
			
			System.out.println ( " Digite o preço Unitario desse ITEM");
			
			valorunitario = leia.nextDouble();
			
			valorproduto = quantidade+valorunitario;
			
			total = total + valorproduto;
			
			qnt_total = qnt_total + quantidade ;
		}
	
				
		else {
			status = false;
		}
			System.out.println ( " o numero de itens comprado foi :"+qnt_total);
		
			System.out.println ( " Total " + total);
									
			System.out.print("\nDIGITE A FORMA DE PAGAMENTO\n");
			
			System.out.print("\nDIGITE Á VISTA , DINHEIRO / CHEQUE");
			System.out.print("\nDIGITE  É VISTA , CARTÃO DE CREDITO");
			System.out.print("\nCREDITO , EM 2X SEM JUROS");
			System.out.print("\nCREDITO , EM 3X COM ACRESCIMO DE 10 %  DE JUROS ");
			esc = leia.nextInt();
			
			if (esc  ==  1) {
			
				System.out.print("\nDIGITE Á VISTA , DINHEIRO / CHEQUE\n" + (total-(total * 20/100)));
			
			}	
			else if  ( esc == 2 ) {
				System.out.print("\nDIGITE  É VISTA , CARTÃO DE CREDITO\n"+(total-(total*15/100)));
				
				
			}
			
						
			if (esc  ==  3) {
				
				System.out.print("\nCREDITO , EM 2X SEM JUROS\n" + total);
			
			}	
			else if  ( esc == 4 ) {
				System.out.print("\nCREDITO , EM 3X COM ACRESCIMO DE 10 %  DE JUROS"+(total-(total*10/100)));
			}
				
				
				System.out.print("Digite se voce deseja a nota fiscal");
				confirmacao = leia.next();
				

				
				if (confirmacao=="sim") {
					
					
					System.out.print("digite sim caso queira sua NF, ou digite nao para sair");
					
				}
				
			
				
				if (confirmacao.equals("sim"))
				{
					
					System.out.print("SUA NOTA FISCAL NUMERO 95845235 NO VALOR DE:"+total);
					
				}	
				else if  ( confirmacao.equals("nao")) {
					System.out.print("OBRIGADO(A) POR COMPRAR NO SUPER BBB");
					
					status = true;
				{
				
				
				}
				
			}
		}
	}
}