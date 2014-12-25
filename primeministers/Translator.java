package primeministers;

import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

import java.util.ArrayList;
/**
 * トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。
 */
public class Translator extends Object
{
	/**
	 * CSVに由来するテーブルを記憶するフィールド。
	 */
	private Table inputTable;
	/**
	 * HTMLに由来するテーブルを記憶するフィールド。
	 */
	private Table outputTable;
	
	/**
	 * トランスレータのコンストラクタ。
	 */
	public Translator(){
		Downloader aDownloader = new Downloader();
	}
	/**
	 * 在位日数を計算して、それを文字列にして応答する。
	 * @param periodString
	 * @return
	 */
	public String computeNumberOfDays(String periodString){
		
		String[] period = periodString.split("〜",0);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年 m月 d日");
		LocalDate date1=LocalDate.parse(period[0],dtf).plusDays(1);
		LocalDate date2=LocalDate.parse(period[1],dtf);
		LocalTime time1=LocalTime.of(0,0,0);
		LocalTime time2=LocalTime.of(0,0,0);
		LocalDateTime start = LocalDateTime.of(date1,time1);
		LocalDateTime end;
		if(period[1]!=null){
			end = LocalDateTime.of(date2,time2);
		}else{
			end = LocalDateTime.now();
		}
		Duration duration = Duration.between(start,end);
		return String.valueOf(duration.toDays());//long型で帰ってくる
	}
	/**
	 * サムネイル画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。
	 * @param aString
	 * @param aTuple
	 * @param no
	 * @return
	 */
	//
	public String computeStringOfImage(String aString,Tuple aTuple,int no){
		
		ArrayList<String> values = aTuple.values();
		
		String No = values.get(aTuple.attributes().indexOfNo());
		String Image = values.get(aTuple.attributes().indexOfImage());
		String Thumbnail = values.get(aTuple.attributes().indexOfThumbnail());
		
		String html = "<a name="+No+" href="+Image+"><img class=\"borderless\" src="+Thumbnail+" width=\"25\" height=\"32\" alt="+No+".jpg></a>";
		return html;
		
		/*String resultString="";
		return resultString;*/
	}
	/**
	 * 総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。
	 * @param aTable
	 * @return resultTable;
	 */
	//
	public Table table(Table aTable){
		IO.directoryOfPages();
		Downloader aDownload = new Downloader();
		aDownload.downloadCSV();
		aDownload.downloadImages();
		aDownload.downloadThumbnails();
		System.out.println("success");
		String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
		JOptionPane.showMessageDialog(null, aString, "報告", JOptionPane.PLAIN_MESSAGE);
		/*Table resultTable = new Table("output");
		return resultTable;*/
	}
	/**
	 * 総理大臣のCSVファイルをHTMLページへ変換する。
	 */
	//
	public void perform()
	{
		Table table = new Table();
		table.attributes(new Attributes("output"));
		
		ArrayList<Tuple> tuples = table.tuples();
		
		for (Tuple aTuple : tuples){
			
			Attributes attribute = aTuple.attributes();
			ArrayList<String> output = new ArrayList<String>();
			ArrayList<String> value = aTuple.values();
			
			output.add(value.get(attribute.indexOfNo()));
			output.add(value.get(attribute.indexOfOrder()));
			output.add(value.get(attribute.indexOfName()));
			output.add(value.get(attribute.indexOfKana()));
			output.add(value.get(attribute.indexOfPeriod()));
			output.add(this.computeNumberOfDays(value.get(attribute.indexOfPeriod())));
			output.add(value.get(attribute.indexOfSchool()));
			output.add(value.get(attribute.indexOfParty()));
			output.add(value.get(attribute.indexOfPlace()));
			output.add(this.computeStringOfImage(null, aTuple, Integer.valueOf(value.get(attribute.indexOfNo()))));
			Tuple a_tuple= new Tuple(table.attributes(),output);
			table.add(a_tuple);
		}
		return table;
		//tableが影響それ以外はおk
		//returnの戻り値が違う
		
		/*Downloader aDownloader = new Downloader();
		Table aTable = aDownloader.table();
		
		System.out.println(aTable);
		
		aTable = this.table(aTable);
		Writer aWriter = new Writer();
		aWriter.table(aTable);
		
		System.out.println(aTable);
		
		return;*/
	}
}
