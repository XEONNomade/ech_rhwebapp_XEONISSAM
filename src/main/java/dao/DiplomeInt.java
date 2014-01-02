package dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Diplome;

@Transactional
public interface DiplomeInt {
	
	/*
	 * interface   qui contient les différents fonctions 
	 * qu'on peut appliquer sur  l'objet mappée de la base de donnée Diplome
	 */
	public void addDiplome(Diplome diplome);
	public void updateDiplome(Diplome diplome);
	public void deletDiplome(Diplome diplome);
	public Diplome getDiplome(Integer id);
	public List<Diplome> getListDiplome();
	public void deletDiplomeM(Integer diplome);
	

}
