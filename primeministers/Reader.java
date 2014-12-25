package primeministers;

import java.io.File;
import java.util.ArrayList;
/**
 * リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。
 */
public class Reader extends IO{
	/**
	 * 総理大臣の情報を記したCSVファイルを記憶するフィールド。
	 */
	private File filename;
	/**
	 * リーダのコンストラクタ。
	 */
	Reader(){
		this.filename = filename();
	}
	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答するクラスメソッド。
	 * @return
	 */
	public static File filenameOfCSV(){
		File aFile = new File(directoryOfPages(),"/PrimeMinisters.csv");
		
		return aFile;
	}
	/**
	 * ダウンロードしたCSVファイルを応答する。
	 * @return this.filename
	 */
	public File filename(){
		
		return filenameOfCSV();
	}
	/**
	 * ダウンロードしたCSVファイルを読み込んでテーブルを応答する。
	 */
	public Table table(){
		Table aTable = new Table("input");
		ArrayList<String> aList = readTextFromFile(filename);
		Attributes a = new Attributes("input");
		
		for(String s : aList){
			ArrayList<String> column = splitString(s,",");
			Tuple aTuple = new Tuple(a,column);
			aTable.add(aTuple);
		}
		
		return aTable;
		
	}
	
}

