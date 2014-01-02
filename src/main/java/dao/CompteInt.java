package dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Compte;
import model.Responsable;;
@Transactional
public interface CompteInt {
	
		public void addCompte(Compte compte , Responsable p);
		public void updateCompte(Compte compte);
		public void deletcompte(Compte compte);
		public Compte getCompte(Integer id);
		public List<Compte> listCompte();
		public Compte getCompteS(String login);
		public Compte getCompteO(Object object);

	
}
