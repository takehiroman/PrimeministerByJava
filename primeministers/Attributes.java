package primeministers;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 属性群：総理大臣の情報テーブルを入出力する際の属性情報を記憶。
 */
public class Attributes extends Object
{
	/**
	 * 属性リストのキー群を記憶するフィールド。
	 */
	private ArrayList<String> keys;
	/**
	 * 属性リストの名前群を記憶するフィールド。
	 */
	private ArrayList<String> names;

	/**
	 * 入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。
	 * @param aString
	 */
	Attributes(String aString){
		
		String[] string_keys = null;
		String[] string_names = null;
		
		if(aString.equals("output")){
			string_keys = new String[]{"id","no","name","ruby","util","period","school","party","country","img","thum","link"};
			string_names = new String[]{"人目","代","氏名","ふりがな","在位期間","在位日数","出身校","政党","出身地","画像"};
		}else{
			string_names = new String[]{"人目","代","氏名","ふりがな","在位期間","出身校","政党","出身地","画像","縮小画像"};
			string_keys = new String[]{"id","no","name","ruby","util","school","party","country","img","thum"};
		}
		
		keys = (ArrayList<String>)Arrays.asList(string_keys);
		names = (ArrayList<String>)Arrays.asList(string_names);
		
	}
	
	/**
	 * 指定されたインデックスに対応する名前を応答する。名前が無いときはキーを応答する。
	 * @param index
	 * @return　keys or names
	 */
	protected String at(int index){
		if(keys.get(index) == null){
			return keys.get(index);
		}else{
			return names.get(index);
		}
	}
	/**
	 * 指定されたキー文字列のインデックスを応答する。
	 * @param aString
	 * @return index
	 */
	private int indexOf(String aString){
		return keys.indexOf(aString);
		
	}
	/**
	 * 在位日数のインデックスを応答する。
	 * @return index
	 */
	public int indexOfDays(){
		return keys.indexOf("Days");
	}
	
	/**
	 * 画像のインデックスを応答する。
	 * @return index
	 */
	public int indexOfImage(){
		return keys.indexOf("Image");
	}
	/**
	 * ふりがなのインデックスを応答する。
	 * @return index
	 */
	public int indexOfKana(){
		return names.indexOf("Kana");
	}
	/**
	 * 氏名のインデックスを応答する。
	 * @return index
	 */
	public int indexOfName(){
		return names.indexOf("Name");
	}
	
	/**
	 * 番号のインデックスを応答する。
	 * @return index
	 */
	public int indexOfNo(){
		return keys.indexOf("No");
	}
	
	/**
	 * 代のインデックスを応答する。
	 * @return index
	 */
	public int indexOfOrder(){
		return keys.indexOf("Order");
	}
	
	/**
	 * 政党のインデックスを応答する。
	 * @return index
	 */
	public int indexOfParty(){
		
		return keys.indexOf("Party");

	}
	
	/**
	 * 在位期間のインデックスを応答する。
	 * @return index
	 */
	public int indexOfPeriod(){
		
		return keys.indexOf("Period");

	}
	
	/**
	 * 出身地のインデックスを応答する。
	 * @return index
	 */
	public int indexOfPlace(){
		
		return keys.indexOf("Place");

	}
	
	/**
	 * 出身校のインデックスを応答する。
	 * @return index
	 */
	public int indexOfSchool(){
		
		return keys.indexOf("School");

	}
	
	/**
	 * 画像のインデックスを応答する。
	 * @return index
	 */
	public int indexOfThumbnail(){
		
		return keys.indexOf("Thumbnail");
	}
	
	/**
	 * 指定されたインデックスに対応するキーを応答する。
	 * @param index
	 * @return key
	 */
	protected String keyAt(int index){
		
		return keys.get(index);
	}
	
	/**
	 * キー群を応答する。
	 * @return this.keys
	 */
	public ArrayList<String> keys(){
		return this.keys;
	}
	
	/**
	 * 指定されたインデックスに対応する名前を応答する。
	 * @param index
	 * @return name
	 */
	protected String nameAt(int index){
		String name = names.get(index);
		return name;
	}
	
	/**
	 * 名前群を応答する。
	 * @return this.name
	 */
	public ArrayList<String> names(){
		return this.names;
	}
	
	/**
	 * 名前群を設定する。
	 * @param aCollection
	 */
	public void names(ArrayList<String> aCollection){
		this.names = aCollection;
    }
	
	/**
	 * 属性リストの長さを応答する。
	 * @return length
	 */
	public int size(){
		int length = keys.size();
		return length;
	}
	

	/**
	 * 自分自身を文字列にして、それを応答する。
	 * @return aString
	 */
	public String toString(){
		
		return "a";
	}
}
