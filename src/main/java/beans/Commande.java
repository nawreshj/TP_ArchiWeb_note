package beans;

public class Commande {
    private int idCommande;
    private String nomProduit;
    private int quantite;
    private String dateCommande;
    private String etatCommande;
 
    // Getters and Setters
    public int getIdCommande() { return idCommande; }
    public void setIdCommande(int idCommande) { this.idCommande = idCommande; }
 
    public String getNomProduit() { return nomProduit; }
    public void setNomProduit(String nomProduit) { this.nomProduit = nomProduit; }
 
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
 
    public String getDateCommande() { return dateCommande; }
    public void setDateCommande(String dateCommande) { this.dateCommande = dateCommande; }
 
    public String getEtatCommande() { return etatCommande; }
    public void setEtatCommande(String etatCommande) { this.etatCommande = etatCommande; }
}
