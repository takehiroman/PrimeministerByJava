package primeministers;

import java.io.File;
import java.util.ArrayList;
import java.net.URL;
/**
 * ライタ：総理大臣の情報のテーブルをHTMLページとして書き出す。
 */
public class Writer extends IO
{
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */
	//テーブルを記録するメソッド
	public Writer()
	{
		super();
		return;
	}
	/*
	public Attributes attributes()
	{
		return this.table.attributes();
	}
	*/
	
	/**
	 * ローカルなHTMLのインデックスファイル(index.html)を応答するクラスメソッド。
	 */
	public File filenameOfHTML()
	{
		File aFile = IO.directoryOfPages();
		aFile = new File(aFile.getPath() + File.separator + "index.html");
		return aFile;
	}
	
	/**
	 * HTMLページを基にするテーブルを受け取って、インデックスファイル(index.html)に書き出す。
	 */
	/*
	public Table table(Table aTable)
	{
	}

	public ArrayList<Tuple> tuples()
	{
	}
	
	public void writeAttributesOn(BufferedWriter outputWriter)
	{
	}
	
	public void writeFooterOn(BufferedWriter outputWriter)
	{
	}
	
	public void writeHeaderOn(BufferedWriter outputWriter)
	{
		}
	
	public void writeTableBodyOn(BufferedWriter outputWriter)
	{
	}

	
	public void writeTuplesOn(BufferedWriter outputWriter)
	{
	}
	
	*/
	
}
