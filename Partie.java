
class Joueur {

    private String prenom, nomFamille, nationalite;
    private int age, nbJoueurs;
   

    public Joueur(String prenom, String nomFamille, int age, String nationalite){
        this.prenom = prenom;
        this.nomFamille = nomFamille;
        this.age = age;
        this.nationalite = nationalite;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getNomFamille(){
        return nomFamille;
    }

    public int getAgeJoueur(){
        return age;
    }

    public int setAge(int a){
        if(a < 0){System.out.println("Impossible : Un âge ne peut être négatif");}
        else if( a > 0 && a < 5){System.out.println("Le joueur aura sûrement du mal à jouer : Aidez-le !");}
        else {this.age = a; System.out.println("L'âge du joueur à été changé");}
        return this.age;
    }

}


public class Partie {
    private int nbJoueurs;
    private final static int MAX_PERSONNES = 5;
    private Joueur [] tabJoueurs = new Joueur[MAX_PERSONNES];

    public Partie(){
        nbJoueurs = 0;
    }

    public void ajoutJoueur(Joueur j1){
        if(nbJoueurs < MAX_PERSONNES){
            for(int i=nbJoueurs; i<tabJoueurs.length-1; i++){
                if(tabJoueurs[i].getPrenom().equals(j1.getPrenom()) && tabJoueurs[i].getNomFamille().equals(j1.getNomFamille())){
                    System.out.println("Les joueurs ne peuvent pas avoir le même nom de famille / prenom");
                }
                else if(i== MAX_PERSONNES && tabJoueurs[i].equals(null)){tabJoueurs[nbJoueurs] = j1; nbJoueurs++; System.out.print("Le joueur à été ajouté(e)");}
                
            }
        }
        else{System.out.println("Le nombre de joueurs est dépassée");}
    }

    public void supprimeJoueur(Joueur j1) throws Exception{
        if(nbJoueurs < 1){throw new Exception("Il n'y a pas assez de joueurs pour pouvoir en supprimer");}
        else{for(int i=nbJoueurs; i<MAX_PERSONNES; i++ )
            {if(tabJoueurs[i].getPrenom().equals(j1.getPrenom()) && tabJoueurs[i].getNomFamille().equals(j1.getNomFamille())){
                tabJoueurs[i] = null;
                nbJoueurs--;
            }else{if(tabJoueurs[i].equals(null) && i < MAX_PERSONNES){i++;}
                    else{System.out.println("Le joueur a supprimer n'est pas dans le tableau Joueur");}}
            }
        }    
    }
    
    public Joueur [] getTabJoueurs(){
        return tabJoueurs;
    }

}



class Main { 
    public static void main(String[] args) {
        Partie partie = new Partie();
        Joueur j1 = new Joueur("Ludovic", "Thérage", 19, "Français");
        partie.ajoutJoueur(j1);
        partie.getTabJoueurs();
    }
}

