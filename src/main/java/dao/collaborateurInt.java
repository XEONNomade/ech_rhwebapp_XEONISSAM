package dao;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import model.Collaborateur;
import model.Avoir;
import model.Affecter;

@Transactional
public interface collaborateurInt {
	public void addcollaborateur(Collaborateur collaborateur);	

	public void updatecollaborateur(Collaborateur collaborateur);
	public void deletcollaborateur(Collaborateur collaborateur);
	public Collaborateur getcollaborateur(Integer id);
	//public List<Objectif> getListobjectif(Integer collaborateur);
	
	public List<Collaborateur> getListcollaborateur();
	public void deletcollaborateurM(Integer collaborateur);

	 //void addObjectifToDmdF(Integer objectif,Integer Iddmd);
}