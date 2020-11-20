package Classes;

import java.util.Scanner;

public class NotaFiscal extends Produto {
	Scanner leia = new Scanner(System.in);
	private int numero;
	private int data;
	private double valor;
	private int parcela;
	private double valorImposto;
	
	public NotaFiscal(int codigo,String nome, String medida, double valorUnitario, int estoque,  int numero,
			int data, double valor) {
		super(codigo,nome, medida, valorUnitario, estoque);
		this.numero = numero;
		this.data = data;
		this.valor = valor;
	}
	public NotaFiscal() {
		super();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void formaPagamento (double valorTotal,int resposta) {
		double valorDesconto=0, valorJuros=0, valorFinal=0;
		
		
		if (resposta ==1)
		{
			valorDesconto = 0.2*valorTotal;
			valorFinal = valorTotal-valorDesconto;
			 System.out.printf("VALOR TOTAL DA COMPRA: R$%.2f ",valorTotal);
			 System.out.print("\nPAGAMENTO: Á VISTA, NO DINHEIRO OU CHEQUE COM 20% DE DESCONTO");
			 System.out.printf("\nVALOR DO DESCONTO: R$%.2f ",valorDesconto);
			 System.out.printf("\nVALOR DOS JUROS: R$%.2f ", valorJuros);
			 System.out.printf("\nVALOR DOS IMPOSTOS: R$%.2f ", valorFinal*0.09);
			 System.out.printf("\nVALOR FINAL DA COMPRA: R$%.2f ", valorFinal);
			 
			 
		}
		else if (resposta ==2)
		{
			valorDesconto = 0.15*valorTotal;
			valorFinal = valorTotal-valorDesconto;
			System.out.printf("VALOR TOTAL DA COMPRA: R$%.2f ",valorTotal);
			 System.out.print("\nPAGAMENTO: Á VISTA, NO CARTÃO DE CREDITO COM 15% DE DESCONTO");
			 System.out.printf("\nVALOR DO DESCONTO: R$%.2f ",valorDesconto);
			 System.out.printf("\nVALOR DOS JUROS: R$%.2f ", valorJuros);
			 System.out.printf("\nVALOR DOS IMPOSTOS: R$%.2f ", valorFinal*0.09);
			 System.out.printf("\nVALOR FINAL DA COMPRA: R$%.2f ", valorFinal);
		}
		else if (resposta ==3)
		{
			 valorFinal=valorTotal;	
			 System.out.printf("VALOR TOTAL DA COMPRA: R$%.2f ",valorTotal);
			 System.out.print("\nPAGAMENTO PARCELADO EM 2X SEM JUROS");
			 System.out.printf("\nVALOR DO DESCONTO: R$%.2f ",valorDesconto);
			 System.out.printf("\nVALOR DOS JUROS: R$%.2f ", valorJuros);
			 System.out.printf("\nVALOR DOS IMPOSTOS: R$%.2f ", valorFinal*0.09);
			 System.out.printf("\nVALOR FINAL DA COMPRA: R$%.2f ", valorFinal);
			 
			
		}
		else if (resposta ==4)
		{
			valorJuros = valorTotal*0.10;
			valorFinal = valorTotal+valorJuros;
			System.out.printf("VALOR TOTAL DA COMPRA: R$%.2f ",valorTotal);
			 System.out.print("\nPAGAMENTO PARCELADO EM 3X COM ACRESCIMO DE 10 % DE JUROS");
			 System.out.printf("\nVALOR DO DESCONTO: R$%.2f ",valorDesconto);
			 System.out.printf("\nVALOR DOS JUROS: R$%.2f ", valorJuros);
			 System.out.printf("\nVALOR DOS IMPOSTOS: R$%.2f ", valorFinal*0.09);
			 System.out.printf("\nVALOR FINAL DA COMPRA: R$%.2f ", valorFinal);
			 		
		}
	}
	public double valorFinal(double valor)
	{
		return this.valor *= valor;
	}

}
