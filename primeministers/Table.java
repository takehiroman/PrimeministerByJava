package primeministers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * 表：総理大臣の情報テーブル。
 */
public class Table extends Object
{
	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attributes;
	/**
	 * タプル郡を記憶するフィールド。
	 */
	private ArrayList<Tuple> tuples;
	/**
	 * 画像群を記憶するフィールド。
	 */
	private ArrayList<BufferedImage> images;
	/**
	 * サムネイル画像群を記憶するフィールド
	 */
	private ArrayList<BufferedImage> thumbnails;
	/**
	 * テーブルのコンストラクタ。
	 */
	Table(String aString){
		tuples = new ArrayList<Tuple>();
		attributes = new Attributes(aString);
		
		thumbnails = new ArrayList<BufferedImage>();
		images = new ArrayList<BufferedImage>();
		return;
	}
	/**
	 * タプルを追加する。
	 * @param aTuple
	 */
	public void add(Tuple aTuple){
		tuples.add(aTuple);
	}
	/**
	 * 属性リストを応答する。
	 * @return
	 */
	public Attributes attributes(){
		return this.attributes;
	}
	/**
	 * 属性リストを設定する。
	 * @param instanceOfAttributes
	 */
	public void attributes(Attributes instanceOfAttributes){
		attributes = instanceOfAttributes;
	}
	/**
	 * 画像群を応答する。
	 * @return
	 */
	public ArrayList<BufferedImage> images(){
		return this.images;
	}
	/**
	 * 画像またはサムネイル画像の文字列を受け取って当該画像を応答する。
	 * @param aString
	 * @return aImage
	 */
	private BufferedImage picture(String aString){
		BufferedImage readImage = null;
		
		try {
			readImage = ImageIO.read(new File("sample.png"));
		} catch (Exception e) {
			e.printStackTrace();
			readImage = null;
		}
		
		return readImage;
	}
	/**
	 * サムネイル画像群を応答する。
	 * @return
	 */
	public ArrayList<BufferedImage> thumbnails(){
		return this.thumbnails;
	}
	/**
	 * 自分自身を文字列にして、それを応答する。
	 * @Override Object
	 */
	public String toString(){
	
		return toString();
	}
	/**
	 * タプル群を応答する。
	 * @return
	 */
	public ArrayList<Tuple> tuples(){
		return this.tuples;
	}
}
