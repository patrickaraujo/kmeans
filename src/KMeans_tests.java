package kmeans;

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
	
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		Kmeans x = new Kmeans("iris.data");
		        
        System.out.print("Digite 0 para sair\nQual a quantidade de centróides?\nk = ");
        Scanner entrada = new Scanner(System.in);
        int qtd = entrada.nextInt();
        System.out.println();
        float centroides[][] = new float[qtd][4];
        
        
        for(int i = 0; i < qtd; i++) {
        	for(int j = 0; j < 4; j++) {
        		System.out.print("Centróide: "+(i+1)+". Entre com a variável "+(j+1)+":\t");
        		centroides[i][j] = entrada.nextInt();
        	}
        }
        imprimeMatriz(centroides);
        x.calculo(centroides);
        x.dumpAll();
        
        System.out.println("O processo chegou ao FIM.");
	}

}
