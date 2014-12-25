package primeministers;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import java.io.File;

/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 */
public class Downloader extends IO{
	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL文字列)を記憶するフィールド。
	 */
	private String url;
	private Table table;

	/**
	 * ダウンローダのコンストラクタ。
	 */
	public Downloader(){
		url = url();
		table = new Table("input");
	}
	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードする。
	 */
	public void downloadCSV(){
		URL url = null;
		try {
			url = new URL(this.url);
		} catch (MalformedURLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
		try(InputStream in = url.openStream();
			FileOutputStream fr = new FileOutputStream(new File(directoryOfPages(),"PrimeMinisters.csv"))){
			int str;
			while((str = in.read()) != -1){
				fr.write(str);
			}
			
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}

	}
	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages(){
		int indexOfPicture =  table.attributes().indexOfImage();
		downloadPictures(indexOfPicture);
	}
	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 * @param indexOfPicture
	 */
	private void downloadPictures(int indexOfPicture){
		
		for(Tuple t : super.table.tuples()){
			try {
				URL url = new URL(urlString()+"/"+t.values().get(indexOfPicture));
				BufferedImage image = ImageIO.read(url);
				File infile = new File(directoryOfPages(),t.values().get(indexOfPicture));
				ImageIO.write(image, "JPG", infile);
			}catch(MalformedURLException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
	
		}
		
	}
	
	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadThumbnails(){
		int indexOfPicture =  table.attributes().indexOfThumbnail();
		downloadPictures(indexOfPicture);
	}
	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群をダウロードし、テーブルで応答する。
	 * @return aTable
	 */
	public Table table(){
		
		downloadCSV();
		
		Reader aReader = new Reader();
		
		table = aReader.table();
		
		downloadImages();
		downloadThumbnails();
		
		return table;
	}
	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答する。
	 * @return aUrl
	 */
	public String url(){
		
		return urlStringOfCSV();
	}
	/**
	 * 総理大臣の情報の在処(URL)を文字列で応答するクラスメソッド。
	 * @return
	 */
	public static String urlString(){
		
		return "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters";
	}
	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答するクラスメソッド。
	 * @return aUrl
	 */
	public static String urlStringOfCSV(){
		
		return urlString()+"/PrimeMinisters.csv";
	}
	
}
