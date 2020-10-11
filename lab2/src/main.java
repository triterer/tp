import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class main {
	public static void main(String[] args) {
		Path file = Paths.get("./test.txt");
		Charset charset = Charset.forName("utf-8");
		ArrayList<String[]> table = new ArrayList<>();
		String[] line = new String[5];		
		try (BufferedReader reader = Files.newBufferedReader(file, charset)){	
			while((line = reader.readLine().split(" "))!=null) {
				line[0].replace('-', ' ');
				table.add(line.clone());
			}
		}
		catch (IOException x) {
		    System.err.println(x);
		}
		catch (Exception x) {
			System.err.println(x);
		}

		
		for(int i = 0; i<table.size();i++) {
			System.out.printf(Arrays.toString(table.get(i))+"\n");
		}
		
		
		int sum = 0;
		float sumperc = 0;
		float lowest_perc = Float.parseFloat(table.get(0)[2]);
		float highest_perc = Float.parseFloat(table.get(0)[2]);
		float perc;
		String highest_country = table.get(0)[0];
		String lowest_country = table.get(0)[0];
		double total_people = 0;
		for(int i = 0; i<table.size();i++) {			
			sum+=Integer.parseInt(table.get(i)[1]);
			perc = Float.parseFloat(table.get(i)[2]);
			sumperc+= perc;
			total_people+=Integer.parseInt(table.get(i)[1])/(perc/100);
			if(perc>highest_perc) {
				highest_perc = perc;
				highest_country = table.get(i)[0];
			}
			if(perc<lowest_perc) {
				lowest_perc = perc;
				lowest_country = table.get(i)[0];
			}
		}
		System.out.printf("total emigs: "+ sum+"\n");
		System.out.printf("sum perc emigs: "+ sumperc+"\n");
		System.out.printf("lowest emigs: "+ lowest_perc +"\n"+"country: "+lowest_country+"\n");
		System.out.printf("highest emigs: "+ highest_perc+"\n"+"country: "+highest_country+"\n");
		System.out.printf("total people: "+ total_people+"\n");
		
		int iter = 0;
		String[][] data = table.toArray(new String[0][0]);
		Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[2];
                final String time2 = entry2[2];
                return time1.compareTo(time2);
            }
        });

        for (final String[] s : data) {
            System.out.println(Arrays.toString(table.get(iter++)));
        }
	}
	
	
}