package beans;

import java.util.HashMap;

public class Refrigerateur {
	 private static int idCounter = 0;
    private int id;
    private String nom;
    private double temperature;
    private HashMap<String, Integer> produits;
 
    public Refrigerateur() {
        produits = new HashMap<>();
        this.id = ++idCounter;
    }
    
    
 
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
 
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
 
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
 
    public HashMap<String, Integer> getProduits() { return produits; }
   
    public void ajouterProduit(String nomProduit, int quantite) {
        produits.put(nomProduit, produits.getOrDefault(nomProduit, 0) + quantite);
    }

    public void retirerProduit(String nomProduit) {
        produits.remove(nomProduit);
    }
 
    public int getQuantite(String nomProduit) {
        return produits.getOrDefault(nomProduit, 0);
    }
 
    public void diminuerQuantite(String nomProduit, int quantite) {
        produits.put(nomProduit, Math.max(0, produits.getOrDefault(nomProduit, 0) - quantite));
    }
}
