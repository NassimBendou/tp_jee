package bean;

import annotation.Id;
import annotation.Table;

@Table(name="t_livre")
public class Livre2 {

	@Id
	Integer idLivre = null;
	
	private String auteur = null;
	private String titre = null;
	private Integer annee = null;
	
	public Livre2() {
	}
	
	public Livre2(String titre, String auteur, Integer annee) {
		this.titre = titre;
		this.auteur = auteur;
		this.annee = annee;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public Integer getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Integer idLivre) {
		this.idLivre = idLivre;
	}
	
	// accesseurs (getters / setters)
	
	
	
}
