/*
        creerEmploye();
        creerClient();
        creerProjet();
        creerRole();
 */
package views;

import entities.Client;
import entities.Employe;
import entities.Permanent;
import entities.Projet;
import entities.Role;
import entities.Stagiaire;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import mesExceptions.ErrorClient;
import mesExceptions.ErrorEmploye;
import mesExceptions.ErrorEmployePermanent;
import mesExceptions.ErrorEmployeStagiaire;
import mesExceptions.ErrorInformationsProjet;
import mesExceptions.ErrorInformationsRole;

/**
 *
 * @author Pierre-Etienne Bouchard (1895248@bdeb.qc.ca)
 */
public class ProjectMgr extends javax.swing.JFrame {

    private Client client;
    private Employe employe;
    private Permanent permanent;
    private Projet projet;
    private Role role;
    private Stagiaire stagiaire;
    
    
    /**
     * Creates new form ProjectMgr
     */
    public ProjectMgr() {
        initComponents();
    }
    
    public void creerEmploye(){
        
         // creation Employe
        
        try {
            validerInformationsEmploye();
            
            String nas = jTextFieldNasGstCompte.getText();
            String nom = jTextFieldNomGstCompte.getText();
            String prenom = jTextFieldPrenomGstCompte.getText();
            String telephone = jTextFieldTelephoneGstCompte.getText();
            String dateDebut = jTextFieldDateDebutGstCompte.getText();
            String nomPoste = jTextFieldNomPosteGstCompte.getText();
            
            Calendar cal = Calendar.getInstance();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setTimeZone(cal.getTimeZone());

            Date date = new Date();
            
            date = dateFormat.parse(String.valueOf(dateDebut));
            
            if(jRadioButtonPermanent.isSelected()){
                
                validerInformationsEmployePermanent();
                
                //int nas, String nom, String prenom, String noTelephone, Date dateDebut, String nomPoste
                permanent = new Permanent(Integer.valueOf(nas), nom, prenom, telephone, date, nomPoste);
                
                //System.out.println("Permanent cree: ");
                permanent.afficher();
                
            }else{
                
                validerInformationsEmployeStagiaire();
                
                //int nas, String nom, String prenom, String noTelephone, Date dateDebut,int dureeStage
                stagiaire = new Stagiaire(Integer.valueOf(nas), nom, prenom, telephone, date, Integer.valueOf(jTextFieldDureeStage.getText()));
                
                //System.out.println("Stagiare cree: ");
                stagiaire.afficher() ;
                
            }

        } catch (ErrorEmploye ex) {
            //Logger.getLogger(ProjectMgr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErrorEmployePermanent ex) {
           // Logger.getLogger(ProjectMgr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErrorEmployeStagiaire ex) {
            //Logger.getLogger(ProjectMgr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            //Logger.getLogger(ProjectMgr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex){
            //Logger.getLogger(ProjectMgr.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
   
    public void creerClient(){
        
        try {
            
            validerInformationsClient();
            //String nomClient, String entreprise, Employe employe
            String nomClient = jTextFieldNomClient.getText();
            String entreprise = jTextFieldEntreprise.getText();
            Employe employe;
            if(permanent != null)
                employe = permanent;
            else
                employe = stagiaire;
            
            client = new Client(nomClient, entreprise, employe);
            client.afficher();
            
        } catch (ErrorClient ex) {
            //Logger.getLogger(ProjectMgr.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void creerProjet(){
        try {
            // Creation projet (require Client)
            
            // Client client, String nomProjet, double budget, Date dateDebut, int dureeEnJour

            validerInformationsProjet();
            
            String nomProjet = jTextFieldNomProjet.getText();
            double budget = Double.valueOf(jTextFieldBudget.getText());
            String dateDebut = jTextFieldDateDebut.getText();
            
            int dureeEnJour = Integer.valueOf(jTextFieldDureeEnJour.getText());
            
            Calendar cal = Calendar.getInstance();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setTimeZone(cal.getTimeZone());

            Date date;
            
            // parse string to date
            date = dateFormat.parse(dateDebut);
            
            // format date to string
            // System.out.println("views.ProjectMgr.creerProjet():dateFormatee:"+dateFormat.format(date));
            
            projet = new Projet(client, nomProjet, budget, date, dureeEnJour);
            projet.afficher();
            
        } catch (ErrorInformationsProjet ex) {
            //Logger.getLogger(ProjectMgr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            //Logger.getLogger(ProjectMgr.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void creerRole(){
        try {
            // Creation role (require Projet et Permanent)
            
            // Role(String roleProjet, int nbrHeures,   Projet projet, Permanent permanent)
            
            validerInformationsRole();
        
            String strRole = jTextFieldRoleProjetPermanent.getText();
            int nbrHeure = Integer.valueOf(jTextFieldNomHeurePermanent.getText());    
            
            Role role = new Role(strRole, nbrHeure, projet, permanent);
            role.afficher();
            
        } catch (ErrorInformationsRole ex) {
            Logger.getLogger(ProjectMgr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupEmployeType = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldEntreprise = new javax.swing.JTextField();
        jLabelEntreprise = new javax.swing.JLabel();
        jLabelNomClient = new javax.swing.JLabel();
        jTextFieldNomClient = new javax.swing.JTextField();
        jLabelInformationsClient = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelInformationProjet = new javax.swing.JLabel();
        jLabelNomProjet = new javax.swing.JLabel();
        jLabelBudget = new javax.swing.JLabel();
        jLabelDateDebut = new javax.swing.JLabel();
        jLabelDureeEnJour = new javax.swing.JLabel();
        jTextFieldNomProjet = new javax.swing.JTextField();
        jTextFieldBudget = new javax.swing.JTextField();
        jTextFieldDateDebut = new javax.swing.JTextField();
        jTextFieldDureeEnJour = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldNomPostePermanent = new javax.swing.JTextField();
        jLabelPostPermanent = new javax.swing.JLabel();
        jTextFieldDureeStage = new javax.swing.JTextField();
        jLabelGestionnaireCompteClient = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNom = new javax.swing.JLabel();
        jLabelPrenom = new javax.swing.JLabel();
        jLabelNoTelephone = new javax.swing.JLabel();
        jLabelDateDebutGst = new javax.swing.JLabel();
        jTextFieldNasGstCompte = new javax.swing.JTextField();
        jTextFieldNomGstCompte = new javax.swing.JTextField();
        jTextFieldPrenomGstCompte = new javax.swing.JTextField();
        jTextFieldTelephoneGstCompte = new javax.swing.JTextField();
        jTextFieldDateDebutGstCompte = new javax.swing.JTextField();
        jLabelNomPoste = new javax.swing.JLabel();
        jTextFieldNomPosteGstCompte = new javax.swing.JTextField();
        jRadioButtonPermanent = new javax.swing.JRadioButton();
        jRadioButtonStagiare = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonEffacer = new javax.swing.JButton();
        jButtonAjouter = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelRoleProjet = new javax.swing.JLabel();
        jTextFieldRoleProjetPermanent = new javax.swing.JTextField();
        jLabelNombreHeure = new javax.swing.JLabel();
        jTextFieldNomHeurePermanent = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de projet");

        jTextFieldEntreprise.setText("Tea");

        jLabelEntreprise.setText("Entreprise");

        jLabelNomClient.setText("Nom");

        jTextFieldNomClient.setText("David");

        jLabelInformationsClient.setText("Informations du client");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelInformationsClient)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomClient)
                            .addComponent(jLabelEntreprise))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEntreprise)
                            .addComponent(jTextFieldNomClient, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInformationsClient)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEntreprise)
                    .addComponent(jTextFieldEntreprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabelInformationProjet.setText("Informations du projet");

        jLabelNomProjet.setText("Nom projet");

        jLabelBudget.setText("Budget");

        jLabelDateDebut.setText("Date début");

        jLabelDureeEnJour.setText("Durée en jour");

        jTextFieldNomProjet.setText("Installation capteurs");

        jTextFieldBudget.setText("35000");

        jTextFieldDateDebut.setText("12-07-2018");
        jTextFieldDateDebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateDebutActionPerformed(evt);
            }
        });

        jTextFieldDureeEnJour.setText("240");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomProjet)
                            .addComponent(jLabelBudget)
                            .addComponent(jLabelDateDebut)
                            .addComponent(jLabelDureeEnJour))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDureeEnJour)
                            .addComponent(jTextFieldDateDebut)
                            .addComponent(jTextFieldBudget)
                            .addComponent(jTextFieldNomProjet)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelInformationProjet)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInformationProjet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomProjet)
                    .addComponent(jTextFieldNomProjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBudget)
                    .addComponent(jTextFieldBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDateDebut)
                    .addComponent(jTextFieldDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDureeEnJour)
                    .addComponent(jTextFieldDureeEnJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelPostPermanent.setText("Nom poste");

        jLabelGestionnaireCompteClient.setText("Gestionnaire du compte client");

        jLabel2.setText("NAS");

        jLabelNom.setText("Nom");

        jLabelPrenom.setText("Prénom");

        jLabelNoTelephone.setText("Numéro téléphone");

        jLabelDateDebutGst.setText("Date début");

        jTextFieldNasGstCompte.setText("123456789");
        jTextFieldNasGstCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNasGstCompteActionPerformed(evt);
            }
        });

        jTextFieldNomGstCompte.setText("Bouchard");
        jTextFieldNomGstCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomGstCompteActionPerformed(evt);
            }
        });

        jTextFieldPrenomGstCompte.setText("Pierre");

        jTextFieldTelephoneGstCompte.setText("4381234567");

        jTextFieldDateDebutGstCompte.setText("29-02-2018");
        jTextFieldDateDebutGstCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateDebutGstCompteActionPerformed(evt);
            }
        });

        jLabelNomPoste.setText("Nom poste");

        jTextFieldNomPosteGstCompte.setText("Specialiste IoT");

        buttonGroupEmployeType.add(jRadioButtonPermanent);
        jRadioButtonPermanent.setSelected(true);
        jRadioButtonPermanent.setText("Permanent");
        jRadioButtonPermanent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPermanentActionPerformed(evt);
            }
        });

        buttonGroupEmployeType.add(jRadioButtonStagiare);
        jRadioButtonStagiare.setText("Stagiare");
        jRadioButtonStagiare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStagiareActionPerformed(evt);
            }
        });

        jLabel3.setText("Durée stage");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabelNom)
                            .addComponent(jLabelPrenom))
                        .addGap(96, 96, 96)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomGstCompte, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldPrenomGstCompte)
                            .addComponent(jTextFieldNasGstCompte)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNoTelephone)
                            .addComponent(jLabelDateDebutGst)
                            .addComponent(jLabelNomPoste)
                            .addComponent(jRadioButtonPermanent)
                            .addComponent(jRadioButtonStagiare)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabelPostPermanent))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDateDebutGstCompte)
                            .addComponent(jTextFieldTelephoneGstCompte)
                            .addComponent(jTextFieldNomPosteGstCompte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jTextFieldNomPostePermanent, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldDureeStage, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelGestionnaireCompteClient)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGestionnaireCompteClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNasGstCompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNom)
                    .addComponent(jTextFieldNomGstCompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrenomGstCompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrenom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelephoneGstCompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNoTelephone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDateDebutGstCompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDateDebutGst))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomPoste)
                    .addComponent(jTextFieldNomPosteGstCompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonPermanent)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButtonStagiare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldDureeStage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNomPostePermanent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPostPermanent)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButtonEffacer.setText("Effacer");
        jButtonEffacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEffacerActionPerformed(evt);
            }
        });

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jLabel1.setText("Role");

        jLabelRoleProjet.setText("Role projet");

        jTextFieldRoleProjetPermanent.setText("Specialiste");
        jTextFieldRoleProjetPermanent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRoleProjetPermanentActionPerformed(evt);
            }
        });

        jLabelNombreHeure.setText("Nombre heure");

        jTextFieldNomHeurePermanent.setText("4050");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelNombreHeure)
                        .addGap(49, 49, 49)
                        .addComponent(jTextFieldNomHeurePermanent, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabelRoleProjet)
                            .addGap(72, 72, 72)
                            .addComponent(jTextFieldRoleProjetPermanent, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRoleProjet)
                    .addComponent(jTextFieldRoleProjetPermanent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreHeure)
                    .addComponent(jTextFieldNomHeurePermanent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAjouter)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonEffacer)
                        .addGap(56, 56, 56)
                        .addComponent(jButtonQuitter)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAjouter)
                            .addComponent(jButtonEffacer)
                            .addComponent(jButtonQuitter)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNasGstCompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNasGstCompteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNasGstCompteActionPerformed

    private void jTextFieldNomGstCompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomGstCompteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomGstCompteActionPerformed

    private void jTextFieldDateDebutGstCompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateDebutGstCompteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDateDebutGstCompteActionPerformed

    private void jTextFieldRoleProjetPermanentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRoleProjetPermanentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRoleProjetPermanentActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonEffacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEffacerActionPerformed
        clearRoleForm();
    }//GEN-LAST:event_jButtonEffacerActionPerformed

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
         
        creerEmploye();
        creerClient();
        creerProjet();
        creerRole();
       
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jRadioButtonPermanentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPermanentActionPerformed
       jTextFieldNomPostePermanent.setEditable(true);
        jTextFieldDureeStage.setEditable(false);
    }//GEN-LAST:event_jRadioButtonPermanentActionPerformed

    private void jRadioButtonStagiareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStagiareActionPerformed
        jTextFieldDureeStage.setEditable(true);
        jTextFieldNomPostePermanent.setEditable(false);
    }//GEN-LAST:event_jRadioButtonStagiareActionPerformed

    private void jTextFieldDateDebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateDebutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDateDebutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectMgr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupEmployeType;
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonEffacer;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBudget;
    private javax.swing.JLabel jLabelDateDebut;
    private javax.swing.JLabel jLabelDateDebutGst;
    private javax.swing.JLabel jLabelDureeEnJour;
    private javax.swing.JLabel jLabelEntreprise;
    private javax.swing.JLabel jLabelGestionnaireCompteClient;
    private javax.swing.JLabel jLabelInformationProjet;
    private javax.swing.JLabel jLabelInformationsClient;
    private javax.swing.JLabel jLabelNoTelephone;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelNomClient;
    private javax.swing.JLabel jLabelNomPoste;
    private javax.swing.JLabel jLabelNomProjet;
    private javax.swing.JLabel jLabelNombreHeure;
    private javax.swing.JLabel jLabelPostPermanent;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelRoleProjet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonPermanent;
    private javax.swing.JRadioButton jRadioButtonStagiare;
    private javax.swing.JTextField jTextFieldBudget;
    private javax.swing.JTextField jTextFieldDateDebut;
    private javax.swing.JTextField jTextFieldDateDebutGstCompte;
    private javax.swing.JTextField jTextFieldDureeEnJour;
    private javax.swing.JTextField jTextFieldDureeStage;
    private javax.swing.JTextField jTextFieldEntreprise;
    private javax.swing.JTextField jTextFieldNasGstCompte;
    private javax.swing.JTextField jTextFieldNomClient;
    private javax.swing.JTextField jTextFieldNomGstCompte;
    private javax.swing.JTextField jTextFieldNomHeurePermanent;
    private javax.swing.JTextField jTextFieldNomPosteGstCompte;
    private javax.swing.JTextField jTextFieldNomPostePermanent;
    private javax.swing.JTextField jTextFieldNomProjet;
    private javax.swing.JTextField jTextFieldPrenomGstCompte;
    private javax.swing.JTextField jTextFieldRoleProjetPermanent;
    private javax.swing.JTextField jTextFieldTelephoneGstCompte;
    // End of variables declaration//GEN-END:variables

    private void clearRoleForm() {
        jTextFieldRoleProjetPermanent.setText("");
        jTextFieldNomHeurePermanent.setText("");
    }
    
    private void validerInformationsEmploye() throws ErrorEmploye{
        
        if(jTextFieldNasGstCompte.getText().isEmpty())
            throw new ErrorEmploye("NAS incorrect");
        if(jTextFieldNomGstCompte.getText().isEmpty())
            throw new ErrorEmploye("Nom employe incorrect");
        if( jTextFieldPrenomGstCompte.getText().isEmpty())
            throw new ErrorEmploye("Prenom employe incorrect");
        if(jTextFieldTelephoneGstCompte.getText().isEmpty())
            throw new ErrorEmploye("Telephone employe incorrect");
        if(jTextFieldDateDebutGstCompte.getText().isEmpty())
            throw new ErrorEmploye("Date debut incorrect");
        if(jTextFieldNomPosteGstCompte.getText().isEmpty())
            throw new ErrorEmploye("Nom poste incorrect");
        
    }
    
    private void validerInformationsEmployePermanent() throws ErrorEmployePermanent{
        
        if(jTextFieldNomPostePermanent.getText().isEmpty()){
                throw new ErrorEmployePermanent("Nom poste incorrect");
        }
    }

    private void validerInformationsEmployeStagiaire() throws ErrorEmployeStagiaire{
        
        if(jTextFieldDureeStage.getText().isEmpty()){
                throw new ErrorEmployeStagiaire("Duree incorrecte");
        }
    }
    
    private void validerInformationsRole() throws ErrorInformationsRole{
        
        if(jTextFieldRoleProjetPermanent.getText().isEmpty())
            throw new ErrorInformationsRole("Role incorrect");
        if(jTextFieldNomHeurePermanent.getText().isEmpty())
            throw new ErrorInformationsRole("Nombre d'heure incorrect");
                
        
    }
    
    private void validerInformationsClient() throws ErrorClient{
        
        if(jTextFieldNomClient.getText().isEmpty())
            throw new ErrorClient("Nom du client incorrect");
        
        if( jTextFieldEntreprise.getText().isEmpty())
            throw new ErrorClient("Nom de l'entreprise du client incorrecte");
        
    }
        
    private void validerInformationsProjet() throws ErrorInformationsProjet{
        
        if(jTextFieldNomProjet.getText().isEmpty())
            throw new ErrorInformationsProjet("Nom du projet incorrect");
        if(jTextFieldBudget.getText().isEmpty())
            throw new ErrorInformationsProjet("Budget du projet incorrect");
        if(jTextFieldDateDebut.getText().isEmpty())
            throw new ErrorInformationsProjet("Date debut du projet incorrecte");
        if(jTextFieldDureeEnJour.getText().isEmpty())
            throw new ErrorInformationsProjet("Duree en jour du projet incorrecte");
        
    }
        
}
