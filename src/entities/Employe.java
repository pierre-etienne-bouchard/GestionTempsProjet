/*
 * Superclass decrivant les caractéristiques générales des employés.
 */
package entities;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class Employe {
    protected int nas;
    protected String nom;
    protected String prenom;
    protected String noTelephone;
    protected Date dateDebut;
    
    // Liste des clients de cet employe
    Set<Client> listeClient = new HashSet();

    public Employe(int nas, String nom, String prenom, String noTelephone, Date dateDebut) {
        this.nas = nas;
        this.nom = nom;
        this.prenom = prenom;
        this.noTelephone = noTelephone;
        this.dateDebut = dateDebut;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getNas() {
        return nas;
    }

    public void setNas(int nas) {
        this.nas = nas;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNoTelephone() {
        return noTelephone;
    }

    public void setNoTelephone(String noTelephone) {
        this.noTelephone = noTelephone;
    }
    
    public void afficher(){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        System.out.println( "Nas: " + nas
                +", Nom: " + nom
                +", Prenom: " + prenom
                +", Numero Tel: " + noTelephone
                +", Date debut: " + dateFormat.format(dateDebut));
    }
    
    public void ajouterClient(Client client){
        Collections.addAll(listeClient, client);
    }
}
