import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

class FileLoader {

	private String path;
	
	public FileLoader(String file_path) {
	
		path = file_path;
	
	}
	
	public ArrayList<String> loadFile() throws IOException {
		FileReader inStream = new FileReader(path);
		BufferedReader inBuffer = new BufferedReader(inStream);
		//BufferedReader inBuffer = new BufferedReader(new FileReader(path));
		ArrayList<String> allTheLines = new ArrayList<String>();
		String line;
		
		while ((line = inBuffer.readLine()) != null) {
        
			allTheLines.add(line);
			
		}
		
		inBuffer.close();
		return allTheLines;
	
	}

}