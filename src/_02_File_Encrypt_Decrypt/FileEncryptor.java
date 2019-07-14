package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.security.CryptoPrimitive;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog(null, "Enter something i dont care");
		String s2 = crypt(s);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/message.txt");
			fw.write("\n" + s2);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String crypt(String s) {
		char[] chars = s.toCharArray();
		ArrayList<Integer> binary = new ArrayList<Integer>();
		for(int i = 0; i < chars.length; i++) {
			int x = chars[i];
			binary.add(x);
		}
		for(int i = 0; i < binary.size(); i++) {
			binary.set(i, binary.get(i) ^ 10110001);
			int x = binary.get(i);
			chars[i] = (char) x;
		}
		String s2 = "";
		for(int i = 0; i < chars.length; i++) {
			s2 += chars[i];
		}
		System.out.println(s2);
		return s2;
	}
}