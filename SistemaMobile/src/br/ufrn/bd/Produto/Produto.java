package br.ufrn.bd.Produto;

public class Produto {

	private String descricao;	
	private long quant, numero, valor, codigo;
	
	public Produto(){
		
	}
	
	public Produto(String descricao, long quant, long numero, long valor,
			long codigo) {
		this.descricao = descricao;
		this.quant = quant;
		this.numero = numero;
		this.valor = valor;
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getQuant() {
		return quant;
	}
	public void setQuant(long quant) {
		this.quant = quant;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public long getValor() {
		return valor;
	}
	public void setValor(long valor) {
		this.valor = valor;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public String toString() {
		return descricao + "\n" +
			   "Código: " + codigo + "\n" +
			   "Número: " + numero + "\n" +
			   "Preço: " + valor + "\n" +
			   "Quantidade: " + quant + "\n";
	}
	
	

}
