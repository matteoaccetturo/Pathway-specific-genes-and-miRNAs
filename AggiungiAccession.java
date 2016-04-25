import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class AggiungiAccession {

	public static Set<String> SelectHumanAccessions() throws IOException {
		String line1;
		Set<String> humanAccessions = new TreeSet<String>();
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"D:\\Chip CTL\\gene2accession(human)"));
		//bw.write("tax_id"+"\t"+"GeneID"+"\t"+)
		BufferedReader br = new BufferedReader(
				new FileReader(
				"D:\\Chip CTL\\gene2accession"));
		
		bw.write(br.readLine()+"\r\n");
		while ((line1 = br.readLine()) != null) {
			
			String[] field = line1.split("\t");
			if (field[0].toString().equalsIgnoreCase("9606")) {
				humanAccessions.add(line1);
				bw.write(line1+"\r\n");
				bw.flush();
			}
	
		}br.close(); bw.close(); System.out.println("numero accessions umani: "+humanAccessions.size());
		return humanAccessions;
	}
	
	public static void AddAccessionToGeniUnici() throws IOException {
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(
				"D:\\Chip CTL\\CTL_GeniUniciConAccession(ridondanti).txt"));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(
				"D:\\Chip CTL\\CTL_GeniUniciConAccession.txt"));
		String line2;
		String line3;
		Set<String> accessionsUmani = AggiungiAccession.SelectHumanAccessions();
		System.out.println("numero accessions umani: "+accessionsUmani.size());
		String rigaSet;
		Set<String> setFinale = new TreeSet<String>();
			Iterator<String> it = accessionsUmani.iterator(); 
			while (it.hasNext()) {
				rigaSet = it.next(); 
				String[] field1 = rigaSet.split("\t");
				BufferedReader br1 = new BufferedReader(
				new FileReader(
				"D:\\Chip CTL\\CTL_GeniUnici.txt"));
				br1.readLine();
				//System.out.println(field1[1]+"\t"+field1[2]);
				while ((line2 = br1.readLine()) != null) {
					String[] field2 = line2.split("\t");
					//System.out.println(field2[5]);
					if (field1[1].equalsIgnoreCase(field2[5])&& (field1[2].equalsIgnoreCase("REVIEWED")||(field1[2].equalsIgnoreCase("VALIDATED")) )) {
					//System.out.println("ok");
					
					bw1.write(line2+"\t"+field1[3]+"\r\n");
					bw1.flush();
					
				}				
			}br1.close(); 
		} bw1.close();
		BufferedReader br1 = new BufferedReader(
				new FileReader(
				"D:\\Chip CTL\\CTL_GeniUniciConAccession(ridondanti).txt"));
		while ((line3 = br1.readLine()) != null) {
			setFinale.add(line3);
		} br1.close();
		System.out.println("set finale: "+setFinale.size());
		
		for (String riga : setFinale) {
			//System.out.println(riga);
			//System.out.println("trovato");
				bw2.write(riga+"\r\n");
				bw2.flush();
			
		} bw2.close();
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		AggiungiAccession.AddAccessionToGeniUnici();
	}

}
