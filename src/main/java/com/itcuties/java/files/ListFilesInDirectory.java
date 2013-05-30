package com.itcuties.java.files;

import java.io.File;

/**
 * This code lists directory contents
 * 
 * @author itcuties
 */
public class ListFilesInDirectory {
	
	// Files and directories statistics
	private static int allElementsCount = 0;
	private static int directoriesCount = 0;
	
	public static void main(String[] args) {
		// Scanned directory
		String directoryPath = "d:/tmp";
		
		// Display directory name
		System.out.println(directoryPath);
		// Go recursively down
		listDirectory(directoryPath);
		
		System.out.println("\n-----------------------------------------------");
		System.out.println("Directory stats");
		System.out.println("-----------------------------------------------");
		System.out.println("Directories: " + directoriesCount);
		System.out.println("Files: " + (allElementsCount - directoriesCount));
	}
	
	/**
	 * Visit each directory recursively, count and display its contents
	 * @param directoryPath
	 */
	public static void listDirectory(String directoryPath) {
		// List all the directory contents
		for (String contents: new File(directoryPath).list()) {
			
			allElementsCount++;
			
			// Directory path for files and directories
			contents = directoryPath+"/"+contents;
			
			// Display full path names
			System.out.println(contents);
			
			// For directories go recursively down
			if (new File(contents).isDirectory()) {
				
				directoriesCount++;
				
				// Go down to next directory
				listDirectory(contents);
			}
		}
	}
	
}
