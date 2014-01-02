package dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Ecole;

@Transactional
public interface EcoleInt {
	/*
	 * interface   qui contient les différents fonctions 
	 * qu'on peut appliquer sur  l'objet mappée de la base de donnée Ecole
	 */
	public void addEcole(Ecole ecole);
	public void updateEcole(Ecole ecole);
	public void deletEcole(Ecole ecole);
	public Ecole getEcole(Integer id);
	public List<Ecole> getListEcole();
	public void deletEcoleM(Integer ecole);
	

}
