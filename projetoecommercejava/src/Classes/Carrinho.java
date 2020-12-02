package Classes;

public class Carrinho {
	
	private int codigo;
	private String nome;
	private String medida;
	private double valorUnitario;
	private int noCarrinho;
	private double valorSub;
	
	public Carrinho(int codigo, String nome, String medida, double valorUnitario, int noCarrinho, double valorSub) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.medida = medida;
		this.valorUnitario = valorUnitario;
		this.noCarrinho = noCarrinho;
		this.valorSub = valorSub;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getNoCarrinho() {
		return noCarrinho;
	}

	public void setNoCarrinho(int noCarrinho) {
		this.noCarrinho = noCarrinho;
	}

	public double getValorSub() {
		return valorSub;
	}

	public void setValorSub(double valorSub) {
		this.valorSub = valorSub;
	}
	
	
	
	
	

}
