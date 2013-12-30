package dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Technolgie;

@Transactional
public interface technologieInt {
	public void addTechnolgie(Technolgie technologie);
	public void updateTechnolgie(Technolgie technologie);
	public void deletTechnolgie(Technolgie technologie);
	public Technolgie getTechnolgie(Integer id);
	public List<Technolgie> getListTechnolgie();
	public void deletTechnolgieM(Integer technologie);
	

}
