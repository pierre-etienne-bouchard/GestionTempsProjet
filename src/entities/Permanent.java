/*
 * Classe décrivant un employé permanent
 */
package entities;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class Permanent extends Employe{
    
    private String nomPoste;

    // Liste des projets de cet employe permanent
    Set<Projet> listeProjet = new HashSet();
    

    public Permanent(int nas, String nom, String prenom, String noTelephone, Date dateDebut, String nomPoste) {
        super(nas, nom, prenom, noTelephone, dateDebut);
        this.nomPoste = nomPoste;
    }

   
    public String getNomPoste() {
        return nomPoste;
    }

    public void setNomPoste(String nomPoste) {
        this.nomPoste = nomPoste;
    }
    
    public void afficher(){
        super.afficher();

        System.out.println("Nom poste: "+nomPoste);
    }
    
    public void ajouterProjet(Projet projet){
        Collections.addAll(listeProjet, projet);
    }
}
