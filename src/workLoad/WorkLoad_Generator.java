import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

class File_Chooser{
	public String ChooseFile(){
		JFileChooser Chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		Chooser.setFileFilter(filter);
		Chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = Chooser.showOpenDialog(Chooser);
		String file_name;
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = Chooser.getSelectedFile();
		    file_name = selectedFile.getAbsolutePath();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    return file_name;
		}
		else return null;
	}
}
class ReadFile {
	private String path;
	
	public ReadFile(String file_path){
		path = file_path;
		System.out.println(path);
	}
	public String[] OpenFile() throws IOException{
		FileReader fr =new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		int i;
		for (i=0;i<numberOfLines;i++){
			textData[i] = textReader.readLine();
			//System.out.println(textData[i]);
		}
		textReader.close();
		return textData;
	}
	int readLines() throws IOException{
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		String aLine;
		int numberOfLines = 0;
		while((aLine = bf.readLine()) != null){
			numberOfLines++;
		}
		bf.close();
		return numberOfLines;
	}
}
public class WorkLoad_Generator extends JFrame{

	public static void main(String[] args){
		System.out.println("Hello");
		File_Chooser SelectFile = new File_Chooser();
		String file_name = SelectFile.ChooseFile();
		try{
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
			int i;
			for (i=0;i<aryLines.length;i++){
				System.out.println(aryLines[i]);
			}
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}