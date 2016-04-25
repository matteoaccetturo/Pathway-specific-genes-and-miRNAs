import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class setMiRNACTLs {
public static void setMiRNAs() throws IOException{
	Set<String> setGeni = new TreeSet<String>();
	String line1;
	String line2;
	BufferedReader br = new BufferedReader(
			new FileReader(
			"D:\\Chip CTL\\CTLmiRNAs.txt"));
	br.readLine();
	while ((line1 = br.readLine()) != null) {
		String[] field = line1.split("\t");
		setGeni.add(field[0]+"\t"+field[1]);
	}	System.out.println("numero miRNA: "+setGeni.size());
	br.close();
	BufferedWriter bw2 = new BufferedWriter(new FileWriter(
			"D:\\Chip CTL\\miRNA-miRBaseID.txt"));
	Iterator<String> it1 = setGeni.iterator();
	
	while (it1.hasNext()) {
		line2 = it1.next();
		bw2.write(line2+"\r\n");
		bw2.flush();
	}bw2.close();
}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setMiRNACTLs.setMiRNAs();
	}

}
