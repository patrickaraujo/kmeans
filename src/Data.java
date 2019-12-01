/**
 * 
 */
package kmeans;

/**
 * @author arauj
 *
 */
public class Data {
	private float [] var;
	private String classe;
	
	
	public Data(float [] var, String classe) {
		this.var = var;
		this.classe = classe;
	}

	
	public float[] getVar() {
		return var;
	}

	public void setVar(float [] var) {
		this.var = var;
	}
	
	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
}
