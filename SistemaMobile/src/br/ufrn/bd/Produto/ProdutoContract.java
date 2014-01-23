package br.ufrn.bd.Produto;

public class ProdutoContract {

	public ProdutoContract(){
	}
	
	public static abstract class ProdutoEntry {
		public static final String TABLE_PRODUTO = "produto";
		public static final String COLUMN_DESCRICAO = "descricao";
		public static final String COLUMN_QUANTIDADE = "quantidade";
		public static final String COLUMN_NUMERO = "numero";
		public static final String COLUMN_VALOR = "valor";
		public static final String COLUMN_CODIGO = "codigo";
	}

}
