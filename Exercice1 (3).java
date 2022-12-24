import java.util.*;

public class Exercice1 {
    
    /**
     * Cette fonction prend un tableau de Strings en paramètre et retourne un
     * nouveau tableau contenant les mêmes éléments, avec une case disponible de
     * plus.
     */
    public static String[] agrandirTab(String[] tab) {

        //Le tableau temp[] est un tableau de taille mots plus 1
        String temp[]= new String[tab.length+1];
   
        // La boucle permet d'ajouter les elements du tableau
        for(int i=0;i<tab.length;i++){
             temp[i]=tab[i];
        }

        //tab devient egale temp
        tab=temp;
        return tab;
        
    }

    /**
     * Cette fonction lit des mots sur la ligne de commande et les retourne dans
     * un tableau de Strings. Chaque "mot" est définit comme une ligne complète,
     * du début de la ligne entrée jusqu'au prochain \n.
     */
    public static String[] lireMots() {

        //tableauString est un nouveau tableau de string
        String[] tableauString= new String[0];

        //mot est un string vide
        String mot="";

        //La boucle permet d'ecrire plusieur mot jusqu'a que stop est ecrit
        do{
           Scanner scanner= new Scanner(System.in);

           mot=scanner.nextLine();       

           

           if (mot.equals("stop")){
                         break;}
        else{
            tableauString=agrandirTab(tableauString);
            tableauString[tableauString.length-1]=mot;}
                             }while(mot!="stop");
        
        
        return tableauString;
    }

    /**
     * Cette fonction prend en paramètre un tableau de mots et retourne un
     * nouveau tableau contenant ces mots triés en ordre croissant.
     */
    public static String[] trier(String[] mots) {

        // la boucle permet de voir l'ordre des mots si les mots sont egale 
        // le programme continue si la comparaison des mots est positive donc
        //on rend les mots en ordre

        for (int i=0;i<=mots.length-1;i++){
            for (int j=0;j<=mots.length-1;j++){
                if (mots[j]==mots[i]){
                    continue;
                }
                else if (mots[j].compareTo(mots[i])>0){
                    String temp=mots[j];
                    mots[j]=mots[i];
                    mots[i]=temp;
                }
            
            }
        }
       

        return mots;
    }

    /**
     * Cette fonction prend en paramètre un tableau de mots trié et retourne un
     * nouveau tableau où chaque mot est unique (tous les doublons sont
     * retirés).
     */
    public static String[] retirerDoublons(String[] mots){
        // compteur permet de compter combien de mot on trouve dans le tableau
        int compteur=0;

        // La boucle permet d'identifier le nombre de mot qui sont dans le tableau
        // si il ya deux mots identique le compteur n'incremente pas
        for(int i=0;i<mots.length;i++){
            if (i == mots.length-1){
                compteur+=1;
            }
            for(int j=i+1;j<mots.length;j++){
                if (mots[j].equals(mots[i])){
                    break;
                }
                else if (j == mots.length-1){
                    compteur+=1;
                }
            }
        }
        
        //temp est un tableau ou la longeur du tableau est le nombre de mot
        //du compteur
        String[] temp= new String[compteur];
        int index = 0;

        // La boucle permet de mettre les mots dans le tableau temp sans la 
        //repetition 
        for(int i=0;i<mots.length;i++){
            boolean present = false;
            for(int j=0;j<mots.length;j++){
                for (int k = 0; k<temp.length; k++){
                    if (temp[k] != null && temp[k].equals(mots[i])){
                        present = true;
                    }
                }
                if (index == compteur-1 && compteur!=1){
                    break;
                }
                else if (!mots[j].equals(mots[i]) && i!=j && !present && i!=0){
                    temp[++index]=mots[i];
                }
                if (i==0 && !present){
                    present = true;
                    temp[j] = mots[i];
                }
            }
        }
        return temp;
            
}
    
    

    /**
     * Fonction principale du programme (utilisée pour tester le code).
     */
    public static void main(String[] args) {
        String[] tableau;
        String[] tableauTrier;
        String[] tableauFinal;
        
        //tableau appel lireMots
        tableau=lireMots();
        
        //tableauTrier appel trier
        tableauTrier=trier(tableau);
        
        //tableauFinal appel retirerDoublons
        tableauFinal=retirerDoublons(tableauTrier);

        System.out.println(" ");
        System.out.println("Sortie: ");
        System.out.println("------");

        // La boucle permet d'afficher chaque element seul
        for(int i=0;i<tableauFinal.length;i++){
        System.out.println(tableauFinal[i]);
        }
    }
}