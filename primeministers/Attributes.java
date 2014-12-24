package primeministers;

import java.util.ArrayList;

/**
 * 属性群：総理大臣の情報テーブルを入出力する際の属性情報を記憶。
 */
public class Attributes extends Object
{
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */
	//属性リストのキー群を記憶するフィールド。
	private ArrayList<String> keys;
	//属性リストの名前群を記憶するフィールド。
	private ArrayList<String> names;
	//入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。
	public Attributes(String aString){
		keys = new ArrayList<String>();
		names = new ArrayList<String>();


		if(aString == "input")
		{
		String[] aCollection = new String[]
			{
				"No", "Order", "Names", "Kana", "Period","School",
				"Party", "Birth", "Image", "Thumbnail"
			};
			for(String key : aCollection){
				keys.add(key);
			}

		}
		else{
		String[] aCollection = new String[]
			{
				"No", "Order", "Names", "Kana", "Period","PeriodDays", "School",
				"Party","Place","Image"
			};
			for(String key : aCollection){
				keys.add(key);
			}
		}
	}
	//指定されたインデックスに対応する名前を応答する。名前が無いときはキーを応答する。
	protected String at(int index){
		String name = nameAt(index);
		
		if(name == null){
			String key = keyAt(index);
			return key;
		}
				
		return name;
	}
	//指定されたキー文字列のインデックスを応答する。
	private int indexOf(String aString){
		int s = keys.indexOf(aString);
		return s;	
	}
	//在位日数のインデックスを応答する。
	public int indexOfDays(){
		int s = keys.indexOf("Days");
		return s;	
	}
	//画像のインデックスを応答する。
	public int indexOfImage(){
		int s = keys.indexOf("Image");
		return s;
	}
	//ふりがなのインデックスを応答する。
	public int indexOfKana(){
		int s = keys.indexOf("Kana");
		return s;
	}
	//氏名のインデックスを応答する
	public int indexOfName(){
		int s = keys.indexOf("Names");
		return s;
	}
	//番号のインデックスを応答する。
	public int indexOfNo(){
		int s = keys.indexOf("No");
		return s;
	}
	//代のインデックスを応答する。
	public int indexOfOrder(){
		int s = keys.indexOf("Order");
		return s;
	}
	//政党のインデックスを応答する。
	public int indexOfParty(){
		int s = keys.indexOf("Party");
		return s;
	}
	//在位期間のインデックスを応答する。
	public int indexOfPeriod(){
		int s = keys.indexOf("Period");
		return s;
	}
	//出身地のインデックスを応答する。
	public int indexOfPlace(){
		int s = keys.indexOf("Place");
		return s;
	}
	//出身校のインデックスを応答する。
	public int indexOfSchool(){
		int s = keys.indexOf("School");
		return s;
	}
	//サムネイル画像のインデックスを応答する。
	public int indexOfThumbnail(){
		int s = keys.indexOf("Thumbnail");
		return s;
	}
	//指定されたインデックスに対応するキーを応答する。
	protected String keyAt(int index){
		String key = keys.get(index);
		return key;
	}
	//キー群を応答する。
	public ArrayList<String> keys(){
		return keys;
	}
	//指定されたインデックスに対応する名前を応答する。
	protected String nameAt(int index){
		String name = names.get(index);
		return name;
	}
	//名前群を応答する。
	public ArrayList<String> names(){
		return names;
	}
	//名前群を設定する。
	public void names(ArrayList<String> aCollection){
		names = aCollection;
		return;
	}
	//属性リストの長さを応答する。
	public int size(){
		int size = keys.size();
		return size;
	}
	//自分自身を文字列にして、それを応答する。
	public String toString(){
		StringBuffer aBuffer = new StringBuffer();
		Class aClass = this.getClass();
		aBuffer.append("[keys=");
		aBuffer.append(keys);
		aBuffer.append("]");
		return aBuffer.toString();
	}
}
