package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/message.txt"));
			
			String line = br.readLine();
			while(line != null){
				String lyne = crypt(line);
				System.out.println(lyne);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		return s2;
	}
}
