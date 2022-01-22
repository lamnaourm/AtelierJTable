
public class Article {

	private int code;
	private String lib;
	private double prix;
	
	public Article() {
		
	}
	
	public Article(int code, String lib, double prix) {
		super();
		this.code = code;
		this.lib = lib;
		this.prix = prix;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	} 
	
	
	
}
