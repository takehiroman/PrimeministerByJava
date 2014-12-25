package primeministers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * 入出力：リーダ・ダウンローダ・ライタを抽象する。
 */
public abstract class IO extends Object{

	//private File filename;
	/**
	 * テーブル（表：スプレッドシート）を記憶するフィールド。
	 */
	protected Table table;
	/**
	 * 入出力のコンストラクタ
	 */
	public IO(){
		
		//Table atable = new Table();
	}
	/**
	 * ファイルやディレクトリを削除するクラスメソッド。
	 * @param aFile
	 */
	public static void deleteFileOrDirectory(File aFile){
		if(aFile.exists()){
			aFile.delete();
		}
	}
	/**
	 * 総理大臣ページのためのディレクトリ（存在しなければ作成して）を応答するクラスメソッド。
	 * @return aFile
	 */
	public static File directoryOfPages(){
		File aFile = new File(new File(System.getProperty("user.home"), "Desktop"),"PrimeMinister");
		
		if(aFile.exists()){
			return aFile;
		}else{
			aFile.mkdir();
		}
		return aFile;
		
	}
	/**
	 * 入出力する際の文字コードを応答するメソッド。
	 * @return encoding
	 */
	public static String encodingSymbol(){
		
		return "UTF-8";
		
	}
	/**
	 * 指定されたファイルからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param aFile
	 * @return aList
	 */
	public static ArrayList<String> readTextFromFile(File aFile){
		
		ArrayList<String> aList = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(aFile))){
	
			String str;
			while((str = br.readLine()) != null){
				aList.add(str);
			}
		
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		return aList;
	}
	/**
	 * 指定されたファイル文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param fileString
	 * @return aList
	 */
	public static ArrayList<String> readTextFromFile(String fileString){
		File aFile = new File(fileString);
		return readTextFromFile(aFile);
	}
	/**
	 * 指定されたURL文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param urlString
	 * @return aList
	 */
	public static ArrayList<String> readTextFromURL(String urlString){
		URL aURL = null;
		try {
			aURL = new URL(urlString);
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return readTextFromURL(aURL);
	}
	/**
	 * 指定されたURLからテキストを読み込んで、それを行リストにして応答するクラスメソッド
	 * @param aURL
	 * @return aList
	 */
	public static ArrayList<String> readTextFromURL(URL aURL){
		ArrayList<String> aList = new ArrayList<String>();
		
		URL url = aURL;
		
		try(InputStream in = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in))){
			String str;
			while((str = br.readLine()) != null){
				aList.add(str);
			}

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		
		return aList;
	}
	/**
	 * 文字列をセパレータで分割したトークン列を応答するクラスメソッド
	 * @param string
	 * @param separators
	 * @return aList
	 */
	public static ArrayList<String> splitString(String string,String separators){
		String[] strings = string.split(separators);
		ArrayList<String> aList = new ArrayList<String>(Arrays.asList(strings));
		return aList;
	}
	/**
	 * テーブルを応答する
	 */
	public Table table(){
		return this.table;
	}
	/**
	 * 指定された行リストを、指定されたファイルに書き出すクラスメソッド
	 * @param aCollection
	 * @param aFile
	 */
	public static void writeText(ArrayList<String> aCollection,File aFile){
		
		
		
	}
	/**
	 * 指定された行リストを、指定されたファイル名のファイルに書き出すクラスメソッド
	 * @param aCollection
	 * @param fileString
	 */
	public static void writeText(ArrayList<String> aCollection,String fileString){
		
	}
}
