package iSMS.jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-11T17:09:32.648+0100")
@StaticMetamodel(Connexion.class)
public class Connexion_ {
	public static volatile SingularAttribute<Connexion, Integer> idConnexion;
	public static volatile SingularAttribute<Connexion, String> dateConnexion;
	public static volatile SingularAttribute<Connexion, Boolean> etatConnexion;
	public static volatile SingularAttribute<Connexion, Client> client;
	public static volatile SingularAttribute<Connexion, Utilisateur> utilisateur;
}
