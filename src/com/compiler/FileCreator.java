package com.compiler;

/*
 * 
 */
import java.io.FileWriter;

public class FileCreator {
	String workingDir = "D:\\workspace\\LPET\\javacompilerfiles";

	public String createMyFile(String fileName, String code) {

		try {
			workingDir = workingDir + "\\" + fileName;
			FileWriter fw = new FileWriter(workingDir);
			fw.write(code);
			fw.close();
		} catch (Exception e) {
			return e.getMessage();
		}
		return workingDir;
	}

	public static void main(String[] args) {

	}
}
