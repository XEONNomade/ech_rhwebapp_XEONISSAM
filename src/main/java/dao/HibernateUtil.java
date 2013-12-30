package dao;
import model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


@SuppressWarnings("deprecation")
public class HibernateUtil {
        private static SessionFactory factory;
        
        public static Configuration getInitializedConfiguration() {
                AnnotationConfiguration config = new AnnotationConfiguration();
                
                config.addAnnotatedClass(Affecter.class);
                config.addAnnotatedClass(Avoir.class);
                config.addAnnotatedClass(Collaborateur.class);
                config.addAnnotatedClass(Competence.class);
                config.addAnnotatedClass(Compte.class);
                config.addAnnotatedClass(Date.class);
                config.addAnnotatedClass(Diplome.class);
                config.addAnnotatedClass(Ecole.class);
                config.addAnnotatedClass(ManagerRh.class);
                config.addAnnotatedClass(Metriser.class);
                config.addAnnotatedClass(Poste.class);
                config.addAnnotatedClass(Responsable.class);
                config.addAnnotatedClass(Technolgie.class);
              /*  config.addAnnotatedClass(Administratif.class);
                config.addAnnotatedClass(AnimePar.class);
                config.addAnnotatedClass(Assiste.class);
                config.addAnnotatedClass(Cadre.class);
                config.addAnnotatedClass(Compte.class);
                config.addAnnotatedClass(DeleguerAnalyse.class);
                config.addAnnotatedClass(DemandeFormation.class);
                config.addAnnotatedClass(EffectuerEssais.class);
                config.addAnnotatedClass(Emettre.class);
                config.addAnnotatedClass(Evaluation.class);
                config.addAnnotatedClass(EvaluationChaud.class);
                config.addAnnotatedClass(EvaluationFroid.class);
                config.addAnnotatedClass(Date.class);
                config.addAnnotatedClass(Feuille.class);
                config.addAnnotatedClass(Fichier.class);
                config.addAnnotatedClass(Formateur.class);
                config.addAnnotatedClass(model.Ville.class);
                config.addAnnotatedClass(Formation.class);
                config.addAnnotatedClass(Modele.class);
                config.addAnnotatedClass(Modification.class);
                config.addAnnotatedClass(Objectif.class);
                config.addAnnotatedClass(Norme.class);
                config.addAnnotatedClass(NormeEssais.class);
                config.addAnnotatedClass(NormeProduit.class);
                config.addAnnotatedClass(NormeSpecification.class);
                config.addAnnotatedClass(Partie.class);
                config.addAnnotatedClass(Personnel.class);
                config.addAnnotatedClass(Planning.class);
                config.addAnnotatedClass(Qualification.class);
                config.addAnnotatedClass(Question.class);
                config.addAnnotatedClass(Reponse.class);
                config.addAnnotatedClass(Comporter.class);
                config.addAnnotatedClass(Theme.class);
                config.addAnnotatedClass(Technicien.class);
                */
                config.configure();
                return config;
        }
        
        public static Session getSession() {
            if (factory == null) {
            	Configuration config = HibernateUtil.getInitializedConfiguration();
                    factory = config.buildSessionFactory();
            }
            Session hibernateSession = factory.getCurrentSession();
            return hibernateSession;
    }
    
        	
        	
//                if (factory == null) {
//                        Configuration config = HibernateUtil.getInitializedConfiguration();
//                        factory = config.buildSessionFactory();
//                }
               // Session hibernateSession = factory.getCurrentSession();
               
        
        public static void closeSession() {
                HibernateUtil.getSession().close();
        }
        
        public static void recreateDatabase() {
                Configuration config = HibernateUtil.getInitializedConfiguration();
                new SchemaExport(config).create(true,true);
        }
        
        public static Session beginTransaction() {
                Session hibernateSession = HibernateUtil.getSession();
                hibernateSession.beginTransaction();
                return hibernateSession;
        }
        
        public static void commitTransaction() {
                HibernateUtil.getSession().getTransaction().commit();
        }
        
        public static void rollbackTransaction() {
                HibernateUtil.getSession().getTransaction().rollback();
        }
        
        public static void main(String[] args) {
                HibernateUtil.recreateDatabase();
        }
}
