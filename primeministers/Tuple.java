package primeministers;

import java.util.ArrayList;

/**
 * タプル：総理大臣の情報テーブルの中の各々のレコード。
 */
public class Tuple extends Object
{
	private Attributes attributes;
	private ArrayList<String> values;
	/**
	 * 属性リストと値リストからタプルを作るコンストラクタ。
	 * @param instanceOfAttributes
	 * @param balueCollection
	 */
	public Tuple(Attributes instanceOfAttributes,ArrayList<String> balueCollection){
		this.attributes=instanceOfAttributes;
		this.values=balueCollection;
	}
	/**
	 * 属性リストを応答する。
	 * @return
	 */
	public Attributes attributes(){
		return this.attributes;
	}
	/**
	 * 自分自身を文字列にして、それを応答する。
	 */
	public String toString(){
		return super.toString();
	}
	/**
	 * 値リストを応答する。
	 * @return
	 */
	public ArrayList<String> values(){
		return this.values;
	}
	
}
