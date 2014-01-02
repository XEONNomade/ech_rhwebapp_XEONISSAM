package dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Poste;

@Transactional
public interface PosteInt {
	/*
	 * interface   qui contient les différents fonctions 
	 * qu'on peut appliquer sur  l'objet mappée de la base de donnée Poste
	 */
	public void addPoste(Poste poste);
	public void updatePoste(Poste poste);
	public void deletPoste(Poste poste);
	public Poste getPoste(Integer id);
	public List<Poste> getListPoste();
	public void deletPosteM(Integer poste);
	

}
