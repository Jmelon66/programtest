package com.optionkey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class searchdes {
	public static String search( List<String> label,String word) {
		List<String> wlist=mmcheck(word);
		String temp=null;
		for(int i=0;i<label.size();i++){
			for(int j=0;j<wlist.size();j++) {
				if(label.get(i).indexOf(wlist.get(j))>-1) {
					temp+=label.get(i)+"..";
					break;
				}
			}
		}
		return temp;
		
	}
	public static boolean fcheck(String sample) {
		List<String> l=null;
		try {
			BufferedReader br=null;
			br=new BufferedReader(
					new InputStreamReader(
					new FileInputStream(
							new File("F:/nodejs/http/ciku/30wdict.txt")),"utf-8"));
			String t=null;
			int i=0;
			while((t=br.readLine())!=null){
				if(t.equals(sample))return true;
			}
//			System.out.print(i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static List<String>  mmcheck(String s) {
		int start=0,end=5;
		String c=null;
		List<String> temp=new ArrayList<String>();//词段
		if(s.length()<5)end=s.length();
		while(s.length()>start) {
			c=s.substring(start, end);
//			System.out.print(c+"\n");
			if(fcheck(c)) {
				temp.add(c);
				start=end;
				end=start+5;
				if(s.length()<end)end=s.length();
			}
			else {
				
				end--;
//				System.out.println("s:"+start+"e:"+end);
				 if(end==start&&start==s.length()-1) {
						temp.add(s.substring(start, end+1));
						break;
					}
				else if((end-start)<2) {
					temp.add(s.substring(start, end));
					start++;
					end=start+5;
					if(s.length()<end)end=s.length();
				}
				
			}
		}
		return temp;
	}
	public static String gettime(String time) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		Pattern p=Pattern.compile("[\u4E00-\u9FA5]");
		Matcher mat=p.matcher(time);
		String s1=mat.replaceAll("");
//		System.out.println(s1);
		
		try {
			date=sdf.parse(s1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			date=new Date();	
			e.printStackTrace();
			return sdf.format(date);
		}
		return sdf.format(date);
	}

}
