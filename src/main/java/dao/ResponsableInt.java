package dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Responsable;
@Transactional
public interface ResponsableInt {
	public void addResponsable(Responsable responsable);
	public void updateResponsable(Responsable responsable);
	public void deletresponsable(Responsable responsable);
	public Responsable getResponsable(Integer id);
	public List<Responsable> getListResponsable();
	public void deletresponsableId(Integer responsable);
}
