/*
 * Classe décrivant un rôle
 */
package entities;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class Role {
    private String roleProjet;
    private int nbrHeures;
    
    private Projet projet;
    private Permanent permanent;

    public Role(String roleProjet, int nbrHeures,
            Projet projet, Permanent permanent) {
        this.roleProjet = roleProjet;
        this.nbrHeures = nbrHeures;
    }

    public int getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(int nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public String getRoleProjet() {
        return roleProjet;
    }

    public void setRoleProjet(String roleProjet) {
        this.roleProjet = roleProjet;
    }
    
    public void afficher(){
        System.out.println("Role projet: "+ roleProjet
        + ", Nombre heure" + nbrHeures);
    }
}
