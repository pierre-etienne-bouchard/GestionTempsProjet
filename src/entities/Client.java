/*
 * Classe décrivant le client
 */
package entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class Client {
    
    private String nomClient;
    private String entreprise;
    
    private Employe employe;
    
    // Liste des projets d'un client
    Set<Projet> listeProjet= new HashSet();
    

    public Client(String entreprise) {
        this.entreprise = entreprise;
    }
        
    public Client(String nomClient, String entreprise, Employe employe) {
        this.nomClient = nomClient;
        this.entreprise = entreprise;
        this.employe = employe;
    }
    
    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
        
    public void afficher(){
        System.out.println( "Nom du client: " + nomClient + ", Entreprise: "+ entreprise);
    }
    
    public void ajouterProjet(Projet projet){
        Collections.addAll(listeProjet, projet);
    }
}
