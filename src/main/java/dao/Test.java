package dao;
import java.util.Iterator;

import model.Diplome;
import dao.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   diplomeServ s=new diplomeServ();
   Diplome d=new Diplome("bac+5", "etatique");
   s.addDiplome(d);
   
 
//   Diplome dd=s.getDiplome(3);
//   dd.setNiveau("bac+3");
//   dd.setTypeDiplome("prive");
//   s.updateDiplome(dd);
//   System.out.println("diplome : "+dd.getIdDiplome()+" , "+dd.getNiveau()+" , "+dd.getTypeDiplome());
//   //list
//   Iterator<Diplome> diplomes=s.getListDiplome().iterator();
//   while(diplomes.hasNext()){
//	   Diplome p=diplomes.next();
//	   System.out.println("diplome : "+p.getIdDiplome()+" , "+p.getNiveau()+" , "+p.getTypeDiplome());
//   }
   
  // s.deletDiplome(dd);
   
	}

}
