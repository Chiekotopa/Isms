
package iSMS.business.interfaces;

import java.util.List;

import javax.ejb.Remote;

import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.SenderID;

@Remote
public interface ISenderIDServices {
	
	public void creerSenderID(SenderID senderID);
	
	public void modifierSenderID(SenderID senderID);
	
	public void supprimerSenderID(SenderID senderID);
	
	public List<SenderID> listeSenderIDs();
	
	public List<SenderID> senderIDsClient(Client client);
}
