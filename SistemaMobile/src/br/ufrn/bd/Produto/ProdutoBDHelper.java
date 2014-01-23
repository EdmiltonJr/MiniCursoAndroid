package br.ufrn.bd.Produto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import br.ufrn.bd.Produto.ProdutoContract.ProdutoEntry;

public class ProdutoBDHelper extends SQLiteOpenHelper {

	public ProdutoBDHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	public ProdutoBDHelper(Context context) {
		// TODO Auto-generated constructor stub
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "sistema_mobile.db";
	
	private static final String TEXT_TYPE = " TEXT";
	private static final String INTEGER_TYPE = " INTEGER";
	private static final String COMMA_SEP = ",";
	
	private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ProdutoEntry.TABLE_PRODUTO + " ( " +
						ProdutoEntry.COLUMN_CODIGO + " " + INTEGER_TYPE +  " PRIMARY KEY " + COMMA_SEP +
								 ProdutoEntry.COLUMN_QUANTIDADE + " " + INTEGER_TYPE + COMMA_SEP + 
								 ProdutoEntry.COLUMN_NUMERO + " " + INTEGER_TYPE + COMMA_SEP + 
								 ProdutoEntry.COLUMN_VALOR + " " + INTEGER_TYPE + COMMA_SEP + 
								 ProdutoEntry.COLUMN_DESCRICAO + " " + TEXT_TYPE + COMMA_SEP + " )";
								  

	private static final String SQL_DELETE_ENTRIES =
			"DROP TABLE IF EXISTS " + ProdutoEntry.TABLE_PRODUTO;

		
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL(SQL_DELETE_ENTRIES);
		onCreate(db);
	}

}
