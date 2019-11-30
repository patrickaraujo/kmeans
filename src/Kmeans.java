/**
 * 
 */
package kmeans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author arauj
 *
 */
public class Kmeans {
	private ArrayList <Data> dados;
	private ArrayList <Data> iris_setosa;
	private ArrayList <Data> iris_versicolor;
	private ArrayList <Data> iris_virginica;
	
	
	public Kmeans() {
        dados = new ArrayList<Data>();
    }
	
	public Kmeans(String file)throws IOException {
		dados = new ArrayList<Data>();
		BufferedReader entrada = new BufferedReader(new FileReader(file));
		
		int i = 0;
        
		while (entrada.readLine() != null)
            i++;

		entrada.close();
	}

	public void transfer(String file)throws IOException {
		BufferedReader entrada = new BufferedReader(new FileReader(file));
		String linha = entrada.readLine();;
		
		while (linha != null) {
			String vetorStr[] = linha.split(",");
			if(vetorStr.length == 4) {
				Float var1 = Float.parseFloat(vetorStr[0]);
				Float var2 = Float.parseFloat(vetorStr[1]);
				Float var3 = Float.parseFloat(vetorStr[2]);
				Float var4 = Float.parseFloat(vetorStr[3]);
				String classe = vetorStr[4];
				dados.add(new Data(var1, var2, var3, var4, classe));
				if(classe.equals("Iris-setosa"))
					iris_setosa.add(new Data(var1, var2, var3, var4, classe));
				else if(classe.equals("Iris-versicolor"))
					iris_versicolor.add(new Data(var1, var2, var3, var4, classe));
				else if(classe.equals("Iris-virginica"))
					iris_virginica.add(new Data(var1, var2, var3, var4, classe));
			}
		}
		
		entrada.close();
	}
	
	
}
