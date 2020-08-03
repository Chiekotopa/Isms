
package iSMS.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import iSMS.business.interfaces.ISenderIDServices;
import iSMS.jpa.entities.Client;
import iSMS.jpa.entities.SenderID;
import iSMS.jpa.interfaces.ISenderIDDAO;

@Stateless(name = "SenderIDEJB", mappedName = "SenderIDServicesBus")
public class SenderIDServices implements ISenderIDServices {
	
	@EJB
	private ISenderIDDAO senderIDDao;

	@Override
	public void creerSenderID(SenderID senderID) {
		
		senderIDDao.create(senderID);
		
	}
	
	@Override
	public void modifierSenderID(SenderID senderID) {
		
		senderIDDao.edit(senderID);
		
	}
	
	@Override
	public void supprimerSenderID(SenderID senderID) {
		
		senderIDDao.remove(senderID);
		
	}
	
	@Override
	public List<SenderID> listeSenderIDs() {
		
		return senderIDDao.findAll();
	}
	
	@Override
	public List<SenderID> senderIDsClient(Client client) {
		
		return senderIDDao.findByClient(client);
	}

	
}
