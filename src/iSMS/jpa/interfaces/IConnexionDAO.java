
package iSMS.jpa.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Connexion;
import iSMS.jpa.entities.Utilisateur;

@Remote
public interface IConnexionDAO {

	void create(Connexion obj);

	void edit(Connexion obj);

	void remove(Connexion obj);

	Connexion find(Object id);

	List<Connexion> findRange(int[] range);

	int count();

	List<Connexion> findAll();

	public List<Connexion> findByEtatConnexion(String etatConnexion);

	public List<Connexion> findByDateConnexion(String dateConnexion);

	List<Connexion> findByUtilisateur(Utilisateur utilisateur);

	List<Connexion> findByClient(Client client);
}
