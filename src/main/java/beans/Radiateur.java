package beans;

public class Radiateur {
    private int id;
    private String nom;
    private double temperatureDesiree;
    private boolean presencePersonne;
    private String heureDebut;
    private String heureFin;
    private double consommationEnergetique;
    private boolean etat;
 
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
 
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
 
    //public double getTemperatureActuelle() { return temperatureActuelle; }
    //public void setTemperatureActuelle(double temperatureActuelle) { this.temperatureActuelle = temperatureActuelle; }
 
    public double getTemperatureDesiree() { return temperatureDesiree; }
    public void setTemperatureDesiree(double temperatureDesiree) { this.temperatureDesiree = temperatureDesiree; }
 
    public boolean isPresencePersonne() { return presencePersonne; }
    public void setPresencePersonne(boolean presencePersonne) { this.presencePersonne = presencePersonne; }
 
    public String getHeureDebut() { return heureDebut; }
    public void setHeureDebut(String heureDebut) { this.heureDebut = heureDebut; }
 
    public String getHeureFin() { return heureFin; }
    public void setHeureFin(String heureFin) { this.heureFin = heureFin; }
 
    public double getConsommationEnergetique() { return consommationEnergetique; }
    public void setConsommationEnergetique(double consommationEnergetique) { this.consommationEnergetique = consommationEnergetique; }
 
    public boolean isEtat() { return etat; }
    public void setEtat(boolean etat) { this.etat = etat; }
}