import java.io.*;
import java.util.*;

public class ouch {

	public static void main(String[] args) {
		int counter = 0;
		Scanner input = new Scanner(System.in);
		String path = "E:/Eclipse/source code/Tubes/src/asdf/20_newsgroups/"; 									// root path
		
		File folder = new File(path);
		String[] path1 = folder.list(); 																		// list yang ada didalam root
																												// for (String directoryList : path1) {
																												// System.out.println(directoryList);
																												// }
		BufferedReader br = null;

		System.out.println("Masukkan Kata yang ingin di cari ");
		String cari = input.nextLine();
		System.out.println("");
		System.out.println("....................");

		int x = 0;
		for (int i = 0; i < path1.length; i++) {
			File pathpath1 = new File(path + "/" + path1[i]);													 // path
			String[] path2 = pathpath1.list(); 																	 // list yang ada didalam  pathpath1
																													//			 for (String directoryList2 : path2) {
																													//			 System.out.println(path + "/" + path1[i] + "/" + directoryList2);
																													//			 }
																													//			
			for (int j = 0; j < path2.length; j++) {
				try {
					String current;
					br = new BufferedReader(new FileReader(path + "/" + path1[i] + "/" + path2[j]));

					while ((current = br.readLine()) != null) {
						String[] kata = current.split("\\s+");
						for (counter = 0; counter < kata.length; counter++) {
							String finalpath = path + "/" + path1[i] + "/" + path2[j];
							String kataDitemukan = kata[counter];

							if (kataDitemukan.contains(cari)) {
								System.out.println("Found as [" + kataDitemukan + "] at " + finalpath);
								x++;
							}
						}

					}

				} catch (IOException e) {
					System.out.println("file tidak ditemukan.");
				}
			}

		}
		System.out.println("");
		if (x == 0) {
			System.out.println("Kata tidak ditemukan.");
		}else{
			System.out.println("Kata [" + cari + "] ditemukan sebanyak " + x + " kata.");
		}
	}
}
