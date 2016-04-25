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

public class MappaGeniAccNumb {

	private static Map<String, Set<String>> MappaGeni_AccNumb() throws IOException {
		Set<String> Table2 = new HashSet<String>();
		Set<String> setGeni = new HashSet<String>();
		Map<String, Set<String>> geni_AccNumb = new HashMap<String, Set<String>>();
		String line1;
		String line4;
		
		BufferedReader br = new BufferedReader(
				new FileReader(
				"D:\\Chip CTL\\Table2.txt"));
		br.readLine();
		while ((line1 = br.readLine()) != null) {
			Table2.add(line1);
		}
		br.close();
		Iterator<String> it1 = Table2.iterator();
		
		while (it1.hasNext()) {
			line4 = it1.next();
			String[] field = line4.split("\t");
			// System.out.println("*********");
			// String[] field = line5.split("\t");
			//if (goTerms_Candidati.containsKey(field[2])) {
			setGeni = geni_AccNumb.get(field[0]+"\t"+field[1]+"\t"+field[4]);
				if (setGeni==null) {
					Set<String> set = new HashSet<String>();
					set.add(field[2]);
					geni_AccNumb.put(field[0]+"\t"+field[1]+"\t"+field[4], set);
					
				}			
				else {System.out.println("ok");
					setGeni.add(field[2]);
				}
				//System.out.println(setGeni.size());
				
						
		}System.out.println("size della mappa: "+geni_AccNumb.size());
		return geni_AccNumb;
	}

	private static void StampaMappa() throws IOException{
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(
		"D:\\Chip CTL\\Table2mappa.txt"));
		Set<String>valore=new TreeSet<String>();
		Map<String,Set<String>> tmp = MappaGeni_AccNumb();
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
		MappaGeniAccNumb.StampaMappa();
	}

}
