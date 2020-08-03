package iSMS.jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-11T17:09:32.654+0100")
@StaticMetamodel(Credit.class)
public class Credit_ {
	public static volatile SingularAttribute<Credit, Integer> idCredit;
	public static volatile SingularAttribute<Credit, Date> dateAchat;
	public static volatile SingularAttribute<Credit, Integer> valeur;
	public static volatile SingularAttribute<Credit, Integer> valeurInitiale;
	public static volatile SingularAttribute<Credit, Integer> validite;
	public static volatile SingularAttribute<Credit, Integer> validiteInitiale;
	public static volatile SingularAttribute<Credit, Client> client;
}
