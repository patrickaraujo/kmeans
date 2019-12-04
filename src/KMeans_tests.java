package kmeans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class KMeans_tests {

	public static void imprimeMatriz(float m[][]){

        for(int i = 0; i < m.length; i++){
        	System.out.print("Centroide "+(i+1)+":\t[");
            for(int j = 0; j < m[0].length; j++){
                if((j+1) == m[0].length)
                	System.out.println(m[i][j]+"]");
                else
                	System.out.print(m[i][j]+"; ");
            }
        }  

    }
	
	/*
	public static void formatationAndExportation(String file) throws IOException{
		BufferedReader r = new BufferedReader(new FileReader(file));
        
		BufferedWriter w = new BufferedWriter(new FileWriter("export.txt"));
        
        String linha = r.readLine();
        while (linha != null) {
        	String vetorStr[] = linha.split(",");
        	String novaLinha = new String();
        	for (int i = 1; i < vetorStr.length; i++) {
        		novaLinha+= vetorStr[i]+",";
			}
        	novaLinha+= vetorStr[0];
        	w.write(novaLinha);
            w.newLine();
            linha = r.readLine();
        }
        w.flush();
        w.close();
        r.close();
    }
    */
	
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		//	formatationAndExportation("tripadvisor.txt");
		Kmeans x = new Kmeans("tripadvisor.txt");
		        
        System.out.print("Digite 0 para sair\nQual a quantidade de centróides?\nk = ");
        Scanner entrada = new Scanner(System.in);
        int linhas = entrada.nextInt();
        System.out.println();
        int qtd = x.getQtd()-1;
        float centroides[][] = new float[linhas][qtd];
        
        
        for(int i = 0; i < linhas; i++) {
        	for(int j = 0; j < qtd; j++) {
        		System.out.print("Centróide: "+(i+1)+". Entre com a variável "+(j+1)+":\t");
        		centroides[i][j] = entrada.nextInt();
        	}
        }
        System.out.println("\n\nCentróides");
        imprimeMatriz(centroides);
        x.calculo(centroides);
        x.dumpAll();
        
        System.out.println("O processo chegou ao FIM.");
	}

}
