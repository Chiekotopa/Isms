package iSMS.jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-11T17:09:32.669+0100")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ {
	public static volatile SingularAttribute<Utilisateur, Integer> idUtilisateur;
	public static volatile SingularAttribute<Utilisateur, Boolean> admin;
	public static volatile SingularAttribute<Utilisateur, Date> dateCreation;
	public static volatile SingularAttribute<Utilisateur, String> email;
	public static volatile SingularAttribute<Utilisateur, String> login;
	public static volatile SingularAttribute<Utilisateur, String> noms;
	public static volatile SingularAttribute<Utilisateur, String> password;
	public static volatile SingularAttribute<Utilisateur, String> telephone;
	public static volatile ListAttribute<Utilisateur, Connexion> connexions;
}
