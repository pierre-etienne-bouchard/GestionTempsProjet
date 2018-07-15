/*
 * Classe décrivant un projet
 */
package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class Projet {
    
    //On veut garder l'incrementation entre les appels
    private static Integer nombreId=0;
    
    private int idProjet;
    private String nomProjet;
    private double budget;
    private Date dateDebut;
    private int dureeEnJour;
    private Date dateFin;
    
    // Liste des employes permanent associé au projet
    Set<Permanent> listePermanent = new HashSet();
    
    // Le client de ce projet
    Client client;

    public Projet(Client client, String nomProjet, double budget, Date dateDebut, int dureeEnJour) {
        this.client = client;
        
        this.nomProjet = nomProjet;
        this.budget = budget;
        this.dateDebut = dateDebut;
        this.dureeEnJour = dureeEnJour;
        
        createIdProjet();
        
        calculariserDateFin();
        
        
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDureeEnJour() {
        return dureeEnJour;
    }

    public void setDureeEnJour(int dureeEnJour) {
        this.dureeEnJour = dureeEnJour;
    }
    
    public void afficher(){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        System.out.println( "Id projet: " + idProjet
                +", Nom projet: " + nomProjet
                +", Budget: " + budget
                +", Date debut: " + dateFormat.format(dateDebut)
                +", Duree en jour: " + dureeEnJour
                +", Date fin: " + dateFormat.format(dateFin));
    }

    /**
     * Créer un projet id en prenant l'année courrante et un numéro incrémental.
     *
     */
    private void createIdProjet() {
        
        String id="";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        
        // format date to string
        
        String strDate = dateFormat.format( getDateDebut() );
        
        nombreId++;
            
        id = strDate + nombreId;
        
        this.idProjet =  Integer.valueOf(id);
    }

    /**
     * Calcul la fin de projet sur la base de son debut et de sa duree.
     * 
     */
    private void  calculariserDateFin() {
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        cal.setTime(dateDebut);
        int theYear = cal.get(Calendar.YEAR);
        int theMonth = cal.get(Calendar.MONTH);
        int theDay = cal.get(Calendar.DAY_OF_MONTH);

        // addition des jours
	LocalDate localDate = LocalDate.of(theYear, theMonth, theDay).plusDays(dureeEnJour);
	
        int nextYear = localDate.getYear();
        int nextMonth = localDate.getMonth().getValue();
        int nextDay = localDate.getDayOfMonth();
        
        String nextDate = nextDay +"-"+nextMonth+"-"+nextYear; 
        
        cal.set(nextYear, nextMonth, nextDay);
        dateFin = cal.getTime();

       
    }
    
    public void ajouterPermanent(Permanent permanent){
        Collections.addAll(listePermanent, permanent);
    }

}
