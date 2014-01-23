package br.ufrn.bd.Produto;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import br.ufrn.bd.Produto.ProdutoContract.ProdutoEntry;

public class ProdutoDAO {

	private SQLiteDatabase db;
	private ProdutoBDHelper dbHelper;
	private String[] allcolumns = {
		ProdutoEntry.COLUMN_CODIGO, ProdutoEntry.COLUMN_DESCRICAO,
		ProdutoEntry.COLUMN_NUMERO, ProdutoEntry.COLUMN_QUANTIDADE,
		ProdutoEntry.COLUMN_VALOR
	};
	
	public ProdutoDAO(Context context){
		dbHelper = new ProdutoBDHelper(context);
	}
	
	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	
	public Produto adicionar(Produto produto){
		ContentValues values = new ContentValues();
		
		values.put(ProdutoEntry.COLUMN_CODIGO, produto.getCodigo());
		values.put(ProdutoEntry.COLUMN_DESCRICAO, produto.getDescricao());
		values.put(ProdutoEntry.COLUMN_QUANTIDADE, produto.getQuant());
		values.put(ProdutoEntry.COLUMN_NUMERO, produto.getNumero());
		values.put(ProdutoEntry.COLUMN_VALOR, produto.getValor());
		
		long insertCodigo = db.insert(ProdutoEntry.TABLE_PRODUTO, null, values);
		
		Cursor cursor = db.query(ProdutoEntry.TABLE_PRODUTO, allcolumns, 
				ProdutoEntry.COLUMN_CODIGO + " = " + insertCodigo, null, null, null, null);
		cursor.moveToFirst();
	
		Produto prod = cursorToProduto(cursor);
		
		cursor.close();
		
		return prod;
	}
	
	public void excluir(Produto produto){
		long codigo = produto.getCodigo();
		db.delete(ProdutoEntry.TABLE_PRODUTO, ProdutoEntry.COLUMN_CODIGO + " = " + codigo, null);
	}
	
	public List<Produto> listarTodos(){
		List<Produto> Produtos = new ArrayList<Produto>();
		
		Cursor cursor = db.query(ProdutoContract.ProdutoEntry.TABLE_PRODUTO,
				allcolumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Produto Produto = cursorToProduto(cursor);
			Produtos.add(Produto);
			cursor.moveToNext();
		}
		cursor.close();
		return Produtos;
	}
	
	public Produto cursorToProduto(Cursor cursor){
		Produto produto = new Produto();
		
		produto.setCodigo(cursor.getLong(0));
		produto.setQuant(cursor.getLong(1));
		produto.setNumero(cursor.getLong(2));
		produto.setValor(cursor.getLong(3));
		produto.setDescricao(cursor.getString(4));
		
		return produto;
	}
	}
	
