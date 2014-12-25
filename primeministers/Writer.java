package primeministers;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

/**
 * ライタ：総理大臣の情報のテーブルをHTMLページとして書き出す。
 */
public class Writer extends IO{
	/**
	 * ライタのコンストラクタ。
	 */
	public Writer(){
		
	}
	/**
	 * 属性リストを応答する
	 * @return
	 */
	public Attributes attributes(){
		return this.table.attributes();
	}
	/**
	 * ローカルなHTMLのインデックスファイル(index.html)を応答するクラスメソッド。
	 * @return
	 */
	public static File filenameOfHTML(){
		Fire aReply = IO.directoryOfPages();
		File aFile = new File(aDirectory.getPath() + File.separator + "intdex.html");
		 return aFile;
	}
	/**
	 * HTMLページを基にするテーブルを受け取って、インデックスファイル(index.html)に書き出す。
	 * @param aTable
	 * @return
	 */
	public Table table(Table aTable){
		Table resultTable = new Table("output");
		return resultTable;
	}
	/**
	 * タプル群を応答する
	 * @return
	 */
	public ArrayList<Tuple> tuples(){
		ArrayList<Tuple> tuples = new ArrayList<Tuple>();
		return tuples;
	}
	/**
	 * 属性リストを書き出す。
	 * @param outputWriter
	 */
	public void writeAttributesOn(BufferedWriter outputWriter){
		
	}
	/**
	 * フッタを書き出す。
	 * @param outputWriter
	 */
	public void writeFooterOn(BufferedWriter outputWriter){
		
	}
	/**
	 * ヘッダを書き出す。
	 * @param outputWriter
	 */
	public void writeHeaderOn(BufferedWriter outputWriter){
		try{
			outputWriter.writer("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html lang=\"ja\">\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n<meta http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<meta http-equiv=\"Content-Script-Type\" content=\"text/javascript\">\n<meta name=\"keywords\" content=\"Smalltalk,Oriented,Programming\">\n<meta name=\"description\" content=\"Prime Ministers\">\n<meta name=\"author\" content=\"AOKI Atsushi\">\n<link rev=\"made\" href=\"http://www.cc.kyoto-su.ac.jp/~atsushi/\">\n<link rel=\"index\" href=\"index.html\">\n<style type=\"text/css\">\n<!--\nbody {\n\tbackground-color : #ffffff;\n\tmargin : 20px;\n\tpadding : 10px;\n\tfont-family : serif;\n\tfont-size : 10pt;\n}\na {\n\ttext-decoration : underline;\n\tcolor : #000000;\n}\na:link {\n\tbackground-color : #ffddbb;\n}\na:visited {\n\tbackground-color : #ccffcc;\n}\na:hover {\n\tbackground-color : #dddddd;\n}\na:active {\n\tbackground-color : #dddddd;\n}\ndiv.belt {\n\tbackground-color : #eeeeee;\n\tpadding : 0px 4px;\n}\ndiv.right-small {\n\ttext-align : right;\n\tfont-size : 8pt;\n}\nimg.borderless {\n\tborder-width : 0px;\n\tvertical-align : middle;\n}\ntable.belt {\n\tborder-style : solid;\n\tborder-width : 0px;\n\tborder-color : #000000;\n\tbackground-color : #ffffff;\n\tpadding : 0px 0px;\n\twidth : 100%;\n}\ntable.content {\n\tborder-style : solid;\n\tborder-width : 0px;\n\tborder-color : #000000;\n\tpadding : 2px 2px;\n}\ntd.center-blue {\n\tpadding : 2px 2px;\n\ttext-align : center;\n\tbackground-color : #ddeeff;\n}\ntd.center-pink {\n\tpadding : 2px 2px;\n\ttext-align : center;\n\tbackground-color : #ffddee;\n}\ntd.center-yellow {\n\tpadding : 2px 2px;\n\ttext-align : center;\n\tbackground-color : #ffffcc;\n}\n-->\n</style>\n<title>Prime Ministers</title>\n</head>\n<body>\n<div class=\"belt\">\n<h2>Prime Ministers</h2>\n</div>\n<table class=\"belt\" summary=\"table\">\n\t<tbody>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<table class=\"content\" summary=\"table\">\n\t\t\t\t\t<tbody>\n");
			
		}catch(IOException e){
			e.printStackTrace();
		}

	}
	/**
	 * ボディを書き出す。
	 * @param outputWriter
	 */
	public void writeTableBodyOn(BufferedWriter outputWriter){
		this.attributes(outputWriter);
		this.writeTuplesOn(outputWriter);
	}
	/**
	 * タプル群を書き出す。
	 * @param outputWriter
	 */
	public void writeTuplesOn(BufferedWriter outputWriter){
		
	}
}
