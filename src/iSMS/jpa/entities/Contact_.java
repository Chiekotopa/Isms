package iSMS.jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-11T17:09:32.651+0100")
@StaticMetamodel(Contact.class)
public class Contact_ {
	public static volatile SingularAttribute<Contact, Integer> idContact;
	public static volatile SingularAttribute<Contact, Date> dateCreation;
	public static volatile SingularAttribute<Contact, String> nom;
	public static volatile SingularAttribute<Contact, String> telephone;
	public static volatile SingularAttribute<Contact, Client> client;
}
