import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MappaGeniMiRNA {
	private static Map<String, Set<String>> MappaGeni_miRNA() throws IOException {
		Set<String> CTLmiRNAs = new HashSet<String>();
		Set<String> setGeni = new HashSet<String>();
		Map<String, Set<String>> geni_miRNA = new HashMap<String, Set<String>>();
		String line1;
		String line4;
		
		BufferedReader br = new BufferedReader(
				new FileReader(
				"D:\\Chip CTL\\CTLmiRNAs.txt"));
		br.readLine();
		while ((line1 = br.readLine()) != null) {
			CTLmiRNAs.add(line1);
		}
		br.close();
		Iterator<String> it1 = CTLmiRNAs.iterator();
		
		while (it1.hasNext()) {
			line4 = it1.next();
			String[] field = line4.split("\t");
			// System.out.println("*********");
			// String[] field = line5.split("\t");
			//if (goTerms_Candidati.containsKey(field[2])) {
			setGeni = geni_miRNA.get(field[3]+"("+field[2]+")"+field[5]);
				if (setGeni==null) {
					Set<String> set = new HashSet<String>();
					set.add(field[1]);
					geni_miRNA.put(field[3]+"("+field[2]+")"+field[5], set);
					
				}			
				else {System.out.println("ok");
					setGeni.add(field[1]);
				}
				//System.out.println(setGeni.size());
				
						
		}System.out.println("size della mappa: "+geni_miRNA.size());
		return geni_miRNA;
	}

	private static void StampaMappa() throws IOException{
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(
		"D:\\Chip CTL\\mappaGeniMiRNAs.txt"));
		Set<String>valore=new TreeSet<String>();
		Map<String,Set<String>> tmp = MappaGeni_miRNA();
		for (String chiave : tmp.keySet()) {
			valore=tmp.get(chiave);
			bw2.write(chiave+valore+"\r\n");
			bw2.flush();
		}
		bw2.close();
		System.out.println("6)ho stampato il file");
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MappaGeniMiRNA.StampaMappa();
	}

}
