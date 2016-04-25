import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class GeniUnici {

	public static Set<String> SetGeniUnici() throws IOException {
		
		String line2;
		List<String> file = new ArrayList<String>();
		
		BufferedReader br1 = new BufferedReader(
				new FileReader(
				"D:\\Chip CTL\\Pathways tot.txt"));
		br1.readLine();
		while ((line2 = br1.readLine()) != null) {
			file.add(line2);
			
		}
		br1.close();
		System.out.println("lista completa: "+file.size());
		
		Set<String> geneIDUnici = new TreeSet<String>();
		for (String string : file) {
			String[] field = string.split("\t");
			geneIDUnici.add(field[5]);
			
		}System.out.println("numero geneIDs: "+geneIDUnici.size());
	
		String rigaFile;
		Set<String> prova = new TreeSet<String>();
		for (String string1 : geneIDUnici) {
			Iterator<String> it = file.iterator(); 
			while (it.hasNext()) {
				rigaFile = it.next(); 
				String[] field1 = rigaFile.split("\t");
				//System.out.println(rigaFile);
				if (field1[5].toString().equalsIgnoreCase(string1)) {
					//System.out.println(string1);
					prova.add(rigaFile);
					break;
				}				
			}
		}
		System.out.println("dimensione di prova: "+prova.size());
		return prova;
	}
	
	private static void stampaGeniUnici() throws IOException{
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(
				"D:\\Chip CTL\\CTL_GeniUnici.txt"));
		bw1.write("Symbol"+"\t"+"Synonym(s)"+"\t"+"Entrez Gene Name"+"\t"+"Location"+"\t"+"Family"+"\t"+"Entrez Gene ID for Human"+"\t"+"Entrez Gene ID for Mouse"+"\t"+"Entrez Gene ID for Rat"+"\t"+"Drugs"+"\r\n");
		
		Set<String> geniUnici=GeniUnici.SetGeniUnici();
		for (String riga : geniUnici) {
			//System.out.println(riga);
			//System.out.println("trovato");
				bw1.write(riga+"\r\n");
				bw1.flush();
			
		} bw1.close();
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GeniUnici.stampaGeniUnici();
	}

}
