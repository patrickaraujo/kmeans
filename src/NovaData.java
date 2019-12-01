/**
 * 
 */
package kmeans;

/**
 * @author arauj
 *
 */
public class NovaData extends Data {
	
	private float novo_cluster;
	private float[] novo_centroide;
	
	
	public NovaData(float [] var, String classe, float novo_cluster, float novo_centroide[]) {
		super(var, classe);
		// TODO Auto-generated constructor stub
		this.novo_cluster = novo_cluster;
		this.novo_centroide = novo_centroide;
	}


	public float getNovo_cluster() {
		return novo_cluster;
	}


	public void setNovo_cluster(float novo_cluster) {
		this.novo_cluster = novo_cluster;
	}


	public float[] getNovo_centroide() {
		return novo_centroide;
	}


	public void setNovo_centroide(float[] novo_centroide) {
		this.novo_centroide = novo_centroide;
	}
}
