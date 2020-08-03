
package iSMS.jpa.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Utilisateur;

@Remote
public interface IUtilisateurDAO {

	void create(Utilisateur obj);

	void edit(Utilisateur obj);

	void remove(Utilisateur obj);

	Utilisateur find(Object id);

	List<Utilisateur> findRange(int[] range);

	int count();

	List<Utilisateur> findAll();

	public List<Utilisateur> findByNoms(String noms);

	public List<Utilisateur> findByPrenoms(String prenoms);

	public List<Utilisateur> findByEmail(String email);

	public List<Utilisateur> findByTelephone(String telephone);

	public List<Utilisateur> findByLogin(String login);

	public List<Utilisateur> findByPassword(String password);

	public List<Utilisateur> findByAdmin(Boolean admin);
}
