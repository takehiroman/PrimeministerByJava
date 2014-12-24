package primeministers;

import javax.swing.JOptionPane;

/**
 * トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。
 */
public class Translator extends Object
{

	private Table inputTable;

	private Table outputTable;

	/**
	 * トランスレータのコンストラクタ。
	 */
	public Translator()
	{
		super();
		this.inputTable = new Table();
		this.outputTable = new Table();
		return;
	}

	/**
	 * 総理大臣のCSVファイルをHTMLページへ変換する。
	 */

	//在位日数を計算してそれを文字列に応答する
	//public String computeNumberOfDays(String periodString){
	//}
	//サムネイル画像から画像に飛ぶためのHTML文字列を生成する
	//public String computeStringOfImage(String aString,Tuple aTuple,int no){
	//}
	//総理大臣のCSVファイルをHTMLに変換する
	public void perform()
	{
		/**
		 * ここを作成してください。
		 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
		 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
		 */
		IO.directoryOfPages();
		Downloader aDownload = new Downloader();
		aDownload.downloadCSV();
		aDownload.downloadImages();
		aDownload.downloadThumbnails();
		System.out.println("success");
		String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
		JOptionPane.showMessageDialog(null, aString, "報告", JOptionPane.PLAIN_MESSAGE);
		return;
	}
	//総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルを変換して、それに応答する
	//public Table table(Table aTable){
	//}
}
