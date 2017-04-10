import java.io.*;

public class EncryptDecrypt { 
		public static void encrypt() throws IOException { // Beginning of encrypt method, will throw IOException when needed
			BufferedReader in = new BufferedReader(new FileReader("cryptographyTextFile.txt")); // Place file BufferedReader.
			String line = in.readLine(); // Read only the first line in cyrtographTextFile.txt file.
			int r = 0, c = 0, iterator = 0; // Initialize row, column, iterator.
			char[][] table = new char[6][6]; // Character table of 6 rows & 6 columns.
	
			// Filling of array.
			for(c = 0; c < 6; c++) {  // Goes through the rows.
				for(r = 0; r < 5; r++) { // Goes through the columns.        
					table[r][c] = line.charAt(iterator++); // Fills table based on the rth element.
				}
			}
	
			// Printing of array.
			for(r = 0; r < 6; r++) { // Goes through the rows.
				for(c = 0; c < 5; c++) { // Goes through the columns.
					System.out.print(table[r][c] + " "); // Prints table.
				}
			}	
	
			String file = "encrypt.txt"; // File used to write in encrypted message.
	
			try {
				FileWriter fw = new FileWriter(file, true); // Place file in FileWriter, allows file to appended.
				for(r = 0; r < 6; r++) { // Goes through the rows.
					for(c = 0; c < 5; c++) { // Goes through the columns.
						fw.write(table[r][c] + " "); // Writes filled 2D array in char table.
					}
				}
				fw.close(); // Close file.
			} catch(FileNotFoundException e) { // Exception will be thrown if the file isn't found.
				System.out.println("File not found!"); // Message will print if the file isn't found.
			}
		}

	public static void decrypt() throws IOException { // Beginning of decrypt method, will throw IOException when needed.
		BufferedReader in = new BufferedReader(new FileReader("cryptographyTextFile.txt")); // Place file BufferedReader.
		String line = in.readLine(); // Read first line in cryptographyTextFile.txt file.		
		line = in.readLine(); // Read only the second line in cryptographyTextFile.txt file.
		int r = 0, c = 0, iterator = 0; // Initialize row, column, iterator.
		char[][] table = new char[6][6]; // Character table of 6 rows & 6 columns.

		// Fill array.
		for(r = 0; r < 6; r++) {  // Goes through the rows.
			for(c = 0; c < 6; c++) { // Goes through the columns.
				table[r][c] = line.charAt(iterator++); // Fills table based on the rth element.
			}
		}

		// Printing of array.
		for(c = 0; c < 6; c++) { // Goes through the columns.
			for(r = 0; r < 6; r++) { // Goes through the rows.
				System.out.print(table[r][c] + " "); // Prints table.
			}
		}

		String file = "decrpyt.txt"; // File used to write in decrypted message.

		try {
			FileWriter fw = new FileWriter(file, true); // Place file in FileWriter, true allows file to appended writer.
			for(c = 0; c < 6; c++) { // Goes through the columns.
				for(r = 0; r < 6; r++) { // Goes through the rows.
					fw.write(table[r][c] + " "); // Writes filled 2D array in char table.
				}
			}
			fw.close(); // Close file.
		} catch(FileNotFoundException e) {  // Exception will be thrown if the file isn't found.
			System.out.println("File not found!"); // Message will print if the file isn't found.
		}
	}

	public static void main(String[] args) throws IOException {
		encrypt(); // encrypt method:  doesn't return anything because it's a void.
		decrypt(); // decrypt method:  doesn't return anything because it's a void.
	}
}
