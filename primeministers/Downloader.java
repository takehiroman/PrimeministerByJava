package primeministers;

import java.util.ArrayList;
import java.io.File;


/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 */
public class Downloader extends IO
{
	private String url;
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */

	//ダウンロードのコンストラクタ
	public Downloader(){
		this.url = this.url();
	}
	//総理大臣のCSVをダウンロードする
	public void downloadCSV(){
		ArrayList<String> aCollection = IO.readTextFromURL(this.url);
		File aFile = new File(IO.directoryOfPages(),"PrimeMinisters.csv");
		IO.writeText(aCollection, aFile);
		return;

	}
	
	//総理大臣の画像をダウンロード
	void downloadImages(){
		ArrayList<String> aCollection = IO.readTextFromURL(this.url);
		File aFile = new File(IO.directoryOfPages(),"images");
		if(aFile.exists() == false)
		{
			aFile.mkdir();
		}
		return;
	}
	/*
	//総理大臣の画像群またはサムネイル画像群をダウンロードする。
	private void downloadPictures(int indexOfPicture){
	}
	*/
	//総理大臣の画像群をダウンロードする
	public void downloadThumbnails(){
			ArrayList<String> aCollection = IO.readTextFromURL(this.url);
		File aFile = new File(IO.directoryOfPages(),"thumbnails");
		if(aFile.exists() == false)
		{
			aFile.mkdir();
		}
		return;
	}
	
	//総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群をダウロードし、テーブルで応答する。
	public Table table(){
		return this.table();
	}
	//総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答する。
	public String url(){
		return this.urlStringOfCSV();
	}
	//総理大臣の情報の在処(URL)を文字列で応答するクラスメソッド。
	public static String urlString(){
		return "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/";
	}
	//総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答するクラスメソッド。
	public static String urlStringOfCSV(){
		return Downloader.urlString() + "PrimeMinisters.csv";
	}
}
