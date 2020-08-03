
package iSMS.jpa.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.Sms;
import iSMS.web.utils.Pushs;

@Remote
public interface ISmsDAO {
	
	void create(Sms obj);
	
	void edit(Sms obj);
	
	void remove(Sms obj);
	
	Sms find(Object id);
	
	List<Sms> findRange(int[] range);
	
	int count();
	
	List<Sms> findAll();
	
	public List<Sms> findByDestinataire(String destinataire);
	
	public List<Sms> findByContenu(String contenu);
	
	public List<Sms> findByCout(double cout);
	
	public List<Sms> findByEtat(boolean etat);
	
	public List<Sms> findByClient(Client client);
	
	public List<Sms> findByPeriode(Date start, Date end);
	
	public List<Sms> findByPeriode(Client client, Date start, Date end);
	
	public List<Sms> findByDateEnvoi(Date start);
	
	public List<Sms> findByDateEnvoiAndClient(Client client, Date start);
	
	public Pushs findByNumeroPush(Client client, Integer numeroPush);
	
	public List<Sms> findByNumeroPushAndStatus(Client client, Integer numeroPush, String status);
	
	
}
