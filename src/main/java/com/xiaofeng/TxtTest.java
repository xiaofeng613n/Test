package com.xiaofeng;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiao on 2017/11/30.
 */
public class TxtTest
{
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入文件路径：");
		String filePath = scanner.nextLine();
		File file = new File(filePath);
		if( !file.exists() ){
			System.err.println("文件不存在:" + filePath);
		}

		while (true){
			System.out.println("输入关键字:");
			String keyWord = scanner.nextLine();
			ScanerFile(keyWord,file);
			System.out.println("ok");
		}
	}

	public static void ScanerFile(String word,File file) throws IOException
	{
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String temp = null;
			Pattern pattern = Pattern.compile("[^\\w]" + word + "[a-z]*",Pattern.CASE_INSENSITIVE);
			StringBuffer result = new StringBuffer();
			while ( (temp = reader.readLine())  != null ){
				MatchedWords(temp,pattern,result);
			}
			File resultFile = new File("D:/" + word + ".txt");
			if( (resultFile.exists() && resultFile.delete() || !resultFile.exists()) ){
				resultFile.createNewFile();
				writer = new BufferedWriter(new FileWriter(resultFile));
				System.out.println(result.toString());
				writer.write(result.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			writer.flush();
			writer.close();
			reader.close();
		}
	}

	public static void MatchedWords(String line,Pattern pattern,StringBuffer sb){
		Matcher matcher = pattern.matcher(" " +line);
		boolean matched = false;
		while (matcher.find()){
			matched = true;
			String matchedWord = matcher.group();
			sb.append(" "  + matchedWord);
		}
		if( matched){
			sb.append("\r\n");
		}
	}

}