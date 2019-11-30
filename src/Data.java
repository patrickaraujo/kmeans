/**
 * 
 */
package kmeans;

/**
 * @author arauj
 *
 */
public class Data {
	private float var1;
	private float var2;
	private float var3;
	private float var4;
	private String classe;
	
	
	public Data(float var1, float var2, float var3, float var4, String classe) {
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.var4 = var4;
		this.classe = classe;
	}

	
	public float getVar1() {
		return var1;
	}

	public void setVar1(float var1) {
		this.var1 = var1;
	}

	public float getVar2() {
		return var2;
	}

	public void setVar2(float var2) {
		this.var2 = var2;
	}

	public float getVar3() {
		return var3;
	}

	public void setVar3(float var3) {
		this.var3 = var3;
	}

	public float getVar4() {
		return var4;
	}

	public void setVar4(float var4) {
		this.var4 = var4;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
}
