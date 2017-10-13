package beans;

public class Tema {
	private String tema;
	private int   idTema;
	public Tema(String tema, int idTema) {
		super();
		this.tema = tema;
		this.idTema = idTema;
	}
	public Tema(String tema) {
		super();
		this.tema = tema;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
}
