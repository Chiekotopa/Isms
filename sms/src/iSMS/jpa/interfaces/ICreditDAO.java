
package iSMS.jpa.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Credit;

@Remote
public interface ICreditDAO {
	
	void create(Credit obj);
	
	void edit(Credit obj);
	
	void remove(Credit obj);
	
	Credit find(Object id);
	
	List<Credit> findRange(int[] range);
	
	int count();
	
	List<Credit> findAll();
	
	public List<Credit> findByValeurInitiale(String valeurInitiale);
	
	public List<Credit> findByValeur(String valeur);
	
	public List<Credit> findByValiditeInitiale(String validiteInitiale);
	
	public List<Credit> findByValidite(String validite);
	
	public List<Credit> findByDateAchat(String dateAchat);
	
	public List<Credit> findByClient(Client client);
	
	public List<Credit> findByPeriode(Date start, Date end);
	
	public List<Credit> findByPeriode(Client client, Date start, Date end);
}
