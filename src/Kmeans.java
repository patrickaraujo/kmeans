/**
 * 
 */
package kmeans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author arauj
 *
 */
public class Kmeans {
	private ArrayList <Data> dados;
	private ArrayList <Data> iris_setosa;
	private ArrayList <Data> iris_versicolor;
	private ArrayList <Data> iris_virginica;
	ArrayList <NovaData> novo;
	
	public Kmeans() {
        dados = new ArrayList<Data>();
    }
	
	public Kmeans(String file)throws IOException {
		BufferedReader entrada = new BufferedReader(new FileReader(file));
		
		int i = 0;
        
		while (entrada.readLine() != null)
            i++;
		System.out.println("Ok!");
		transfer(file);
		entrada.close();
	}

	public void transfer(String file)throws IOException {
		BufferedReader entrada = new BufferedReader(new FileReader(file));
		String linha = entrada.readLine();
		dados = new ArrayList<Data>();
		iris_setosa = new ArrayList<Data>();
		iris_versicolor = new ArrayList<Data>();
		iris_virginica = new ArrayList<Data>();
		
		while (linha != null) {
			String vetorStr[] = linha.split(",");
			float var[] = new float[vetorStr.length-1];
			if(vetorStr.length == 5) {

				for(int i = 0; i < ((vetorStr.length)-1); i++)
					var[i] = Float.parseFloat(vetorStr[i]);

				String classe = vetorStr[4];
				dados.add(new Data(var, classe));
				if(classe.equals("Iris-setosa"))
					iris_setosa.add(new Data(var, classe));
				else if(classe.equals("Iris-versicolor"))
					iris_versicolor.add(new Data(var, classe));
				else if(classe.equals("Iris-virginica"))
					iris_virginica.add(new Data(var, classe));
			}
			linha = entrada.readLine();
		}
		
		entrada.close();
	}
	
	public void calculo(float centroides[][]) {
		novo = new ArrayList<NovaData>();
		float dist[] = new float[centroides.length];
		
		
		for (Data a: dados) {
			float novoCentroide[] = new float[centroides[0].length];
			float var[] = a.getVar();
			
			for (int i = 0; i < centroides.length; i++) {
				float temp = 0;
				for (int j = 0; j < centroides[0].length; j++)
					temp += (float) Math.pow((centroides[i][j] - var[j]), 2);
				dist[i] = (float) Math.sqrt(temp);
			}
			int menor = indexOfSmallest(dist);
			for (int i = 0; i < novoCentroide.length; i++) {
				float x = var[i];
				float y = centroides[menor][i];
				novoCentroide[i] = ((x+y)/centroides[0].length);
			}
			novo.add(new NovaData(a.getVar(), a.getClasse(), getMinValue(dist), novoCentroide));
		}
	}
	
	public void dumpAll() throws IOException{
        BufferedWriter w = new BufferedWriter(new FileWriter("dumpAll.txt"));
        for (NovaData a: novo) {
        	String linha = (a.getClasse()+"\t"+a.getNovo_cluster()+"\t");
        	for (int i = 0; i < a.getVar().length; i++) {
        		linha += (a.getVar()[i])+"\t";
			}
        	for (int i = 0; i < a.getNovo_centroide().length; i++) {
        		linha += (a.getNovo_centroide()[i])+"\t";
			}
            w.write(linha);
            w.newLine();
        }
        w.flush();
        w.close();
    }
	
	public static int indexOfSmallest(float[] array){

	    // add this
	    if (array.length == 0)
	        return -1;

	    int index = 0;
	    float min = array[index];

	    for (int i = 1; i < array.length; i++){
	        if (array[i] <= min){
	        	min = array[i];
	        	index = i;
	        }
	    }
	    return index;
	}

	
	public static float getMinValue(float[] numbers){
		  float minValue = numbers[0];
		  for(int i = 1; i < numbers.length; i++){
		    if(numbers[i] < minValue){
			  minValue = numbers[i];
			}
		  }
		  return minValue;

	}
}
