package dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Competence;

@Transactional
public interface CompetenceInt {
	public void addCompetence(Competence competence);
	public void updateCompetence(Competence competence);
	public void deletCompetence(Competence competence);
	public Competence getCompetence(Integer id);
	public List<Competence> getListCompetence();
	public void deletCompetenceM(Integer competence);
	

}
