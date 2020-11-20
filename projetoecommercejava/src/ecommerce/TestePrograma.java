package ecommerce;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Produto;

public class TestePrograma {

	public static void main(String[] args) {
			Scanner leia = new Scanner(System.in);
			int escolhaProduto,quantidade;
			char continuar;
			double valorTotal=0;
			
			Produto alterarProduto = new Produto();
			
			List <String> carrinho = new ArrayList<>();
			List <Produto> produto = new ArrayList<>();
			
			produto.add(new Produto(1," Leite          ","litro  ",3.59,30));
			produto.add(new Produto(2," Biscoito       ","pacote ",1.81,40));
			produto.add(new Produto(3," Veja           ","unidade",4.15,20));
			produto.add(new Produto(4," Revista        ","unidade",5.99,20));
			produto.add(new Produto(5," Cloro          ","litro  ",3.56,30));
			produto.add(new Produto(6," Refrigerante   ","unidade",6.51,60));
			produto.add(new Produto(7," Parafuso       ","pacote ",3.04,40));
			produto.add(new Produto(8," Lâmpada        ","unidade",5.08,50));
			produto.add(new Produto(9," Papel-toalha   ","pacote ",7.85,60));
			produto.add(new Produto(10,"Papel higiênico","pacote ",8.25,80));
			
			//REFERENCIA PRODUTO
			do 
			{
				for (Produto prod: produto)
				{
					System.out.println(prod.getCodigo()+" "+prod.getNome()+"  "+prod.getMedida()+"   "+prod.getValorUnitario()+"\t"+prod.getEstoque());
				}
				
		
				System.out.println("O quê deseja comprar? Entre com o codigo do produto:");
				escolhaProduto=leia.nextInt()-1;
				
				System.out.println(produto.get(escolhaProduto).getNome()+" "+produto.get(escolhaProduto).getMedida()+" "+produto.get(escolhaProduto).getValorUnitario()+" "+produto.get(escolhaProduto).getEstoque());
							
				System.out.println("Entre com a quantidade do produto. ");
				quantidade=leia.nextInt();
				
				carrinho.add(new String(produto.get(escolhaProduto).getNome()+" "+produto.get(escolhaProduto).getMedida()+" "+produto.get(escolhaProduto).getValorUnitario()+" "+quantidade));
				
				int tamanho=carrinho.size();
				
				valorTotal=valorTotal+(quantidade*produto.get(escolhaProduto).getValorUnitario());
				
				System.out.println(valorTotal);

				System.out.println("CARRINHO:");
				for (int x=0;x<tamanho;x++)
				{
				System.out.println(carrinho.get(x));
				}
				produto.get(escolhaProduto).diminuirEstoque(quantidade);
				
				System.out.println("\nDeseja adicionar outro produto? [S/N] ");
				continuar = leia.next().toUpperCase().charAt(0);
				
				
			}while (continuar =='S');
			
			
	
	}
}


