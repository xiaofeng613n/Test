package com.xiaofeng.test;

import lombok.Data;

import java.io.*;

/**
 * Created by xiao on 2018/3/18.
 */
@Data
public class Man implements Serializable{
	private String name;
	private int age;
	private String addr;

	public String toString(){
		String out = "name:" + name + " age:"+ age + " addr:"  + addr;
		System.out.println(out);
		return out;
	}
	public static void main(String[] args) {
		Man man = new Man();
		man.setName("xiaofeng");
		man.setAge(18);
		man.setAddr("CN");
		File file = new File("D:\\a.txt");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(man);
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try{
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Man m = (Man) objectInputStream.readObject();
			m.toString();
			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e){
			e.printStackTrace();
		}

	}
}
