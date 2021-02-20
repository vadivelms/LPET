package com.compiler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CompileCode {
	static String WIN_PROGRAMFILES = System.getenv("programfiles");
	static String FILE_SEPARATOR = System.getProperty("file.separator");
	static String javacpath = WIN_PROGRAMFILES + FILE_SEPARATOR + "Java" + FILE_SEPARATOR + "jdk1.8.0_91"
			+ FILE_SEPARATOR + "bin" + FILE_SEPARATOR + "javac";
	/*Specify the java compiler (javac) application URL.*/
	static String javapath = WIN_PROGRAMFILES + FILE_SEPARATOR + "Java" + FILE_SEPARATOR + "jdk1.8.0_91"
	/*Specify the java application URL.*/
			+ FILE_SEPARATOR + "bin" + FILE_SEPARATOR + "java";
	static String javafilespath = "D:\\workspace\\LPET\\javacompilerfiles";
	/*Specify the Directory URL to save the user's java source files.*/
	static String inputFile = "D:\\workspace\\LPET\\javacompilerfiles\\input.txt";
	/*Specify the text file name, which is used to save inputs to be given for run the java program*/

	public String compileCode(String filename) {
		String op = "";
		try {
			String line;
			String[] commands = { "cmd.exe", "/c", javacpath, filename };
			Process p = Runtime.getRuntime().exec(commands);
			BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((line = bri.readLine()) != null) {
				
				op += line + "\n";
			}
			bri.close();
			while ((line = bre.readLine()) != null) {
			
				op += line + "\n";
			}
			bre.close();
			p.waitFor();
		
		} catch (Exception err) {
			err.printStackTrace();
		}
		return op;

	}

	public String runCode(String filename, String args) {

		String op = "";
		StringBuilder sb = new StringBuilder(filename);
		sb.delete(sb.length() - 5, sb.length());
		filename = String.valueOf(sb);
		

		try {
			String line;
			String[] commands = { "cmd.exe", "/c", javapath, "-cp", javafilespath, filename, "<", inputFile };		
			Process p = Runtime.getRuntime().exec(commands);
			BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((line = bri.readLine()) != null) {
			
				op += line + "\n";
			}
			bri.close();

			while ((line = bre.readLine()) != null) {
				op += line + "\n";

			}
			bre.close();
			p.waitFor();			
		} catch (Exception err) {
			err.printStackTrace();
		}		
		return op;
	}
}
