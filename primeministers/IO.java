package primeministers;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.net.URL;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;



/**
 * 入出力：リーダ・ダウンローダ・ライタを抽象する。
 */
public abstract class IO extends Object
{
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */
	
	//テーブル（表：スプレッドシート）を記憶するフィールド。
	protected Table table;
	//入出力のコンストラクタ。
	public IO(){
		return;
	}
	//ファイルやディレクトリを削除するクラスメソッド。
	public static void deleteFileOrDirectory(File aFile){
	if(aFile.exists())
		{
			aFile.delete();
		}
		return;

	}
	
	//総理大臣ページのためのディレクトリ（存在しなければ作成して）を応答するクラスメソッド。
	public static File directoryOfPages(){
		File aFile = new File(System.getProperty("user.home")+"/Desktop/SouriDaijin");
		if(aFile.exists() == false)
		{
			aFile.mkdir();
		}
		return aFile;
	}
	
	//入出力する際の文字コードを応答するクラスメソッド。
	public static String encodingSymbol(){
		return "UTF-8";
	}
	
	//指定されたファイルからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	public static ArrayList<String> readTextFromFile(File aFile){
			ArrayList<String> aCollection = new ArrayList<String>();
		
		try
		{
			FileInputStream inputStream = new FileInputStream(aFile);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, IO.encodingSymbol());
			BufferedReader inputReader = new BufferedReader(inputStreamReader);
			
			String aString = null;
			while ((aString = inputReader.readLine()) != null)
			{
				aCollection.add(aString);
			}
			
			inputReader.close();
		}
		catch (FileNotFoundException anException) { anException.printStackTrace(); }
		catch (UnsupportedEncodingException anException) { anException.printStackTrace(); }
		catch (IOException anException) { anException.printStackTrace(); }
		
		return aCollection;

	}
	
	//指定されたファイル文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	public static ArrayList<String> readTextFromFile(String fileString){
		File aFile = new File(fileString);
		ArrayList<String> aCollection = IO.readTextFromFile(aFile);
		return aCollection;
	}
	
	//指定されたURL文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	public static ArrayList<String> readTextFromURL(String urlString){
		URL aURL = null;
		try { aURL = new URL(urlString); }
		catch (MalformedURLException anException) { anException.printStackTrace(); }
		ArrayList<String> aCollection = IO.readTextFromURL(aURL);
		return aCollection;
	}
	
	//指定されたURLからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	public static ArrayList<String> readTextFromURL(URL aURL){
		ArrayList<String> aCollection = new ArrayList<String>();
		
		try
		{
			InputStream inputStream = aURL.openStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, IO.encodingSymbol());
			BufferedReader inputReader = new BufferedReader(inputStreamReader);
			
			String aString = null;
			while ((aString = inputReader.readLine()) != null)
			{
				aCollection.add(aString);
			}
			
			inputReader.close();
		}
		catch (UnsupportedEncodingException anException) {
			anException.printStackTrace(); 
		}
		catch (IOException anException) {
			anException.printStackTrace(); 
		}
		
		return aCollection;

	}
	/*
	//文字列をセパレータで分割したトークン列を応答するクラスメソッド。
	public static ArrayList<String> splitString(String string,String separators){
	}
	//テーブルを応答する。
	public Table table(){
	}
	*/
	//指定された行リストを、指定されたファイルに書き出すクラスメソッド。
	public static void writeText(ArrayList<String> aCollection,File aFile){
		try
		{
			FileOutputStream outputStream = new FileOutputStream(aFile);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, IO.encodingSymbol());
			BufferedWriter outputWriter = new BufferedWriter(outputStreamWriter);
			
			for (String aString : aCollection)
			{
				outputWriter.write(aString + "\n");
			}
			
			outputWriter.close();
		}
		catch (IOException anException) { anException.printStackTrace(); }
		return;

	}
	
	//指定された行リストを、指定されたファイル名のファイルに書き出すクラスメソッド
	public static void writeText(ArrayList<String> aCollection,String fileString){
		File aFile = new File(fileString);
		IO.writeText(aCollection, aFile);
		return;
	}
	
	
}
