package Classes;

public class Produto {
	
	private String nome;
	private String medida;
	private double valorUnitario;
	private int estoque;
	private int codigo;
	
	
	public Produto() {
		
	}
	public Produto(int codigo, String nome, String medida, double valorUnitario, int estoque) {
		this.nome = nome;
		this.medida = medida;
		this.valorUnitario = valorUnitario;
		this.estoque = estoque;
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
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	//MÉTODO PRA DIMINUIR ESTOQUE
	public void diminuirEstoque(int venda)
	{
		this.estoque -= venda;
	}
	
	
	
	
}

















