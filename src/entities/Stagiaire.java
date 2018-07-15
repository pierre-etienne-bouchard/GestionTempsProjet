/*
 * Classe décrivant les caractéristiques d'un stagiaire
 */
package entities;

import java.util.Date;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class Stagiaire extends Employe{
    private int dureeStage;

    public Stagiaire(int nas, String nom, String prenom, String noTelephone, Date dateDebut,int dureeStage) {
        super(nas, nom, prenom, noTelephone, dateDebut);
        this.dureeStage = dureeStage;
    }

    public int getDureeStage() {
        return dureeStage;
    }

    public void setDureeStage(int dureeStage) {
        this.dureeStage = dureeStage;
    }
    
    public void afficher(){
        super.afficher();
        System.out.println("Duree stage: "+dureeStage);
    }
            
}
