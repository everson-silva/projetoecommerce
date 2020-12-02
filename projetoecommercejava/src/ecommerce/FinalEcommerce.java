package ecommerce;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Carrinho;
import Classes.NotaFiscal;
import Classes.Produto;
public class FinalEcommerce {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		NotaFiscal nota = new NotaFiscal();
		int escolhaProduto,quantidade, contador=0, contCarrinho=0;
		char continuar;
		double parcela = 0;
		double valorTotal = 0;
		char proximoCliente = 'S';
		String nomeLoja, nomeCliente, cpf;
		
		Produto alterarProduto = new Produto();
		
		List <Carrinho> carrinho = new ArrayList<>();
		List <Produto> produto = new ArrayList<>();
		
		System.out.println("                          _      \r\n"
				+ "                         | |     \r\n"
				+ "   __ _  ___   ___   __ _| | ___ \r\n"
				+ "  / _` |/ _ \\ / _ \\ / _` | |/ _ \\\r\n"
				+ " | (_| | (_) | (_) | (_| | |  __/\r\n"
				+ "  \\__, |\\___/ \\___/ \\__, |_|\\___|\r\n"
				+ "   __/ |             __/ |       \r\n"
				+ "  |___/             |___/        ");
		System.out.println("____________________________________");
		System.out.print("   PESQUISE O NOME DA LOJA: ");
		nomeLoja = leia.next().toUpperCase();
		
		produto.add(new Produto(10,"Leite          ","litro   ",3.59,30));
		produto.add(new Produto(11,"Biscoito       ","pacote  ",1.81,40));
		produto.add(new Produto(12,"Veja           ","unidade ",4.15,20));
		produto.add(new Produto(13,"Revista        ","unidade ",5.99,20));
		produto.add(new Produto(14,"Cloro          ","litro   ",3.56,30));
		produto.add(new Produto(15,"Refrigerante   ","unidade ",6.51,60));
		produto.add(new Produto(16,"Parafuso       ","pacote  ",3.04,40));
		produto.add(new Produto(17,"Lâmpada        ","unidade ",5.08,50));
		produto.add(new Produto(18,"Papel-toalha   ","pacote  ",7.85,60));
		produto.add(new Produto(19,"Papel higiênico","pacote  ",8.25,80));
		
		//REFERENCIA PRODUTO
		do
		{
			System.out.println("  ____                         _           _       \r\n"
					+ " |  _ \\                       (_)         | |      \r\n"
					+ " | |_) | ___ _ __ ___   __   ___ _ __   __| | ___  \r\n"
					+ " |  _ < / _ \\ '_ ` _ \\  \\ \\ / / | '_ \\ / _` |/ _ \\ \r\n"
					+ " | |_) |  __/ | | | | |  \\ V /| | | | | (_| | (_) |\r\n"
					+ " |____/ \\___|_| |_| |_|   \\_/ |_|_| |_|\\__,_|\\___/ \r\n"
					+ "                                                   \r\n"
					+ "                                                   ");
		do
		{	System.out.println("CODIGO      PRODUTO          MEDIDA     VALOR    ESTOQUE");
			System.out.println("--------------------------------------------------------");
			for (Produto prod: produto)
			{
				System.out.println("  "+prod.getCodigo()+"        "+prod.getNome()+"  "+prod.getMedida()+"   "
							+prod.getValorUnitario()+"       "+prod.getEstoque());
			}
			System.out.println("--------------------------------------------------------");
			
			do {
			System.out.println("O que deseja comprar? Entre com o codigo do produto:");
			escolhaProduto=leia.nextInt()-10;
			if(escolhaProduto<0 || escolhaProduto>9) {
				System.err.println("ERROR! CODIGO DE PRODUTO INEXISTENTE!");
			}
			else if(produto.get(escolhaProduto).getEstoque() == 0) {
				System.err.println("ERROR! PRODUTO SEM ESTOQUE!");
			}
			}while(escolhaProduto<0 || escolhaProduto>9 || produto.get(escolhaProduto).getEstoque() == 0);
			System.out.println("CODIGO      PRODUTO          MEDIDA     VALOR    ESTOQUE");
			System.out.println("--------------------------------------------------------");
			System.out.println("  "+produto.get(escolhaProduto).getCodigo()+"        "+produto.get(escolhaProduto).getNome()+"   "
						+produto.get(escolhaProduto).getMedida()+"   "+produto.get(escolhaProduto).getValorUnitario()+
							"       "+produto.get(escolhaProduto).getEstoque());
			do {			
			System.out.println("Entre com a quantidade do produto: ");
			quantidade=leia.nextInt();
			if(quantidade<0 || quantidade>produto.get(escolhaProduto).getEstoque()) {
				System.err.println("ERROR! QUANTIDADE ACIMA DO ESTOQUE!");
			}
			}while(quantidade<0 || quantidade>produto.get(escolhaProduto).getEstoque());
			
			//controle do carrinho
			if(contador==0)
			{
			carrinho.add(new Carrinho(produto.get(escolhaProduto).getCodigo(), produto.get(escolhaProduto).getNome(), produto.get(escolhaProduto)
					.getMedida(), produto.get(escolhaProduto).getValorUnitario(), quantidade, (quantidade*produto.get(escolhaProduto).getValorUnitario())));
			contCarrinho=1;
			}
			else
			{
			int tamanho=carrinho.size();
			int contLaco=0;
			for (int x=0;x<tamanho;x++)
			{
				if ((carrinho.get(x).getCodigo()) == (produto.get(escolhaProduto).getCodigo()))
				{
					//System.out.println("ENTROU");
					carrinho.get(x).setNoCarrinho(quantidade+(carrinho.get(x).getNoCarrinho()));
					carrinho.get(x).setValorSub((carrinho.get(x).getValorSub())+(quantidade*produto.get(escolhaProduto).getValorUnitario()));
					contLaco++;
				}
				
			}
			if(contLaco==0)
			{
				carrinho.add(new Carrinho(produto.get(escolhaProduto).getCodigo(), produto.get(escolhaProduto).getNome(), produto.get(escolhaProduto)
						.getMedida(), produto.get(escolhaProduto).getValorUnitario(), quantidade, (quantidade*produto.get(escolhaProduto).getValorUnitario())));
				contCarrinho=contCarrinho+1;
				//break;
			}
			}
			contador++;
						
			valorTotal=valorTotal+(quantidade*produto.get(escolhaProduto).getValorUnitario());
			
			
			System.out.println("------------------------------SEU CARRINHO------------------------------");
			System.out.println("------------------------------------------------------------------------");
			System.out.println("CODIGO      PRODUTO           MEDIDA     VALOR    COMPRADO   SUB-V.TOTAL");
			System.out.print("------------------------------------------------------------------------");
		
			int tamanho=carrinho.size();
			//System.out.println(tamanho);
			for (int x=0;x<tamanho;x++)
			{
			System.out.printf("\n  "+carrinho.get(x).getCodigo()+"        "+carrinho.get(x).getNome()+"   "	
			+carrinho.get(x).getMedida()+"   "+carrinho.get(x).getValorUnitario()+"       "
						+carrinho.get(x).getNoCarrinho()+"         %.2f",carrinho.get(x).getValorSub());
			}
					
			System.out.print("\n________________________________________________________________________");
			System.out.print("\n************************************************************************");
			System.out.printf("\nValor total da compra: R$ %.2f",valorTotal );
			System.out.print("\n________________________________________________________________________");
			produto.get(escolhaProduto).diminuirEstoque(quantidade);
			
			System.out.println("\nDeseja adicionar outro produto? [S/N] ");
			continuar = leia.next().toUpperCase().charAt(0);
			
			
		}while (continuar =='S');
		
		System.out.println("Digite seu nome: ");
		nomeCliente = leia.next().toUpperCase();
		System.out.println("Digite seu CPF: ");
		cpf = leia.next().toUpperCase();
		
		
		System.out.print("\n-------------------------DIGITE A FORMA DE PAGAMENTO---------------------\n");
		System.out.print("\nDIGITE [1] PARA COMPRAR Á VISTA, NO DINHEIRO OU CHEQUE COM 20% DE DESCONTO");
		System.out.print("\nDIGITE [2] PARA COMPRAR Á VISTA, NO CARTÃO DE CREDITO COM 15% DE DESCONTO");
		System.out.print("\nDIGITE [3] PARA PARCELAR EM 2X SEM JUROS");
		System.out.print("\nDIGITE [4] PARA PARCELAR EM 3X COM ACRESCIMO DE 10 % DE JUROS\n ");	
		int resposta=leia.nextInt();

		System.out.println("############################# - NOTA FISCAL - ###########################");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("LOJA: "+nomeLoja);
		System.out.println("CNPJ 68.554.545/5469-80");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("CLIENTE: "+ nomeCliente);
		System.out.println("CPF: "+cpf);
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("CODIGO      PRODUTO           MEDIDA     VALOR    COMPRADO   SUB-V.TOTAL");
		System.out.print("-------------------------------------------------------------------------");
		int tamanho=carrinho.size();
		for (int x=0;x<tamanho;x++)
		{
		System.out.printf("\n  "+carrinho.get(x).getCodigo()+"        "+carrinho.get(x).getNome()+"   "+carrinho.get(x).getMedida()+"   "+carrinho.get(x).getValorUnitario()+"       "+carrinho.get(x).getNoCarrinho()+"         %.2f",carrinho.get(x).getValorSub());
		}
		System.out.print("\n-------------------------------------------------------------------------\n");
		nota.formaPagamento(valorTotal, resposta);
		System.out.print("\n_________________________________________________________________________");
		System.out.println("\nPróximo cliente? ");
		proximoCliente = leia.next().toUpperCase().charAt(0);
		carrinho.clear ();
		valorTotal=0;
		contador=0;
	}
		while(proximoCliente == 'S');
		System.out.println("FIM DO PROGRAMA!");
		System.out.println("¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶$¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶8____________v$¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶$¶$v_____________________q¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶v___________________________v¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶v_________________________________8¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶$_____________________________________$¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶o_______q¶¶¶¶3_____________$¶¶¶$________q¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶________¶¶¶¶¶¶¶¶o_________$¶¶¶¶¶¶¶$_______o¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶$________v¶¶¶¶¶¶¶¶¶________q¶¶¶$¶¶¶¶¶v_______q¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶$¶_________8¶¶¶¶¶¶¶¶¶________8¶¶¶¶¶¶¶¶¶3________8¶$¶¶¶\r\n"
				+ "¶¶¶¶¶¶___________¶¶¶¶¶¶¶¶¶________v¶¶¶¶¶¶¶¶¶__________¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶___________¶¶¶¶¶¶¶¶__________8¶¶¶¶¶¶¶3__________q¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶____________$¶¶¶¶$____________v¶¶¶¶¶____________o¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶________________________________________________o¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶________________________________________________q¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶___v8¶¶v_________________________________¶¶¶q__v$¶$¶¶\r\n"
				+ "¶¶¶¶¶¶q_____¶3________________________________3¶o____o¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶______q¶q_____________________________¶3_____v$¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶________3¶o______________________o$$_______v$¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶__________$¶¶q_______________$¶$_________v$¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶q____________q$¶¶¶¶¶¶¶¶¶$$q___________vo8¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶_________________________________vvo8¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶$¶$v____________________________vvo8¶¶$¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶q_______________________vvvo3¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶3v______________vvvq88¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶$3qqooqqq8¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶$¶¶¶¶¶¶¶¶¶$¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
	}

}
