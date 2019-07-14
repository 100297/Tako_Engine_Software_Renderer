package CommentReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class CommentReader {
	ArrayList<String> keep;
	public static void main(String[] args) {
		CommentReader a = new CommentReader();
		a.activate();}
	//TODO
	void activate() {
		scan();
		keep = new ArrayList<String>();
		for (int i = 0; i < keep.size(); i++) {
			try {
				FileWriter fw = new FileWriter("src/CommentReader/Comment.txt");

				fw.write(keep.get(i));

				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	void scan() {

		System.out.println("Did Scan");
		File TakoEngine = new File("src/CommentReader");
		File[] directoryListing = TakoEngine.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(child));

					String line = br.readLine();
					while (line != null) {
						line.trim();
						if (line.length() > 2) {
							System.out.println(line);
							//TODO make sure it scans words right
							if (line.substring(0, 3).equals("sca")) {
								if(line != null) {
								keep.add(line);
								}
							System.out.println("YAAYY");
							}
						
							line = br.readLine();
						}
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
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}

	}
}
