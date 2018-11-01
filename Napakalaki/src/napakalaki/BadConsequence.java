
package napakalaki;

import static java.lang.Math.min;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class BadConsequence {
    
    // DECLARACIÓN DE VARIABLES
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    static int MAXTREASURES = 10;
    
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;

    // CONSTRUCTORES

    public BadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
        death = false;
        specificVisibleTreasures = new ArrayList();
        specificHiddenTreasures = new ArrayList();
    }

    public BadConsequence(String text, boolean death) {
        this.text = text;
        levels = 0;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        this.death = death;
        specificVisibleTreasures = new ArrayList();
        specificHiddenTreasures = new ArrayList();
    }

    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden) {
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        death = false;
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
    }


    // GETTERS
    
    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isDeath() {
        return death;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    // MÉTODOS
    
    
    // Devuelve true si no hay mal rollo por cumplir
    
    public boolean isEmpty(){
        return levels==0 && death==false && nVisibleTreasures==0 && nHiddenTreasures==0 &&
               specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
    }
    
    
    // Elimina el tesoro t del mal rollo.
    
    public void substractVisibleTreasure(Treasure t){
        if(!specificVisibleTreasures.isEmpty())
            specificVisibleTreasures.remove(t.getType());
        else if(nVisibleTreasures != 0)
            nVisibleTreasures--;
    }
       
    // Elimina el tesoro t del mal rollo.
    
    public void substractHiddenTreasure(Treasure t){
        if(!specificHiddenTreasures.isEmpty())
            specificHiddenTreasures.remove(t.getType());
        else if(nHiddenTreasures != 0)
            nHiddenTreasures--;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence adjustedBC;
        
        if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
            int adjustedVisible;
            int adjustedHidden;
            
            if(v.size() < nVisibleTreasures)
                adjustedVisible = v.size();
            else
                adjustedVisible = nVisibleTreasures;
            if(h.size() < nHiddenTreasures)
                adjustedHidden = h.size();
            else
                adjustedHidden = nHiddenTreasures;
            
            adjustedBC = new BadConsequence(text, 0, adjustedVisible, adjustedHidden);
        }
        else{
            ArrayList<TreasureKind> adjustedSpecificVisible = new ArrayList();
            ArrayList<TreasureKind> adjustedSpecificHidden = new ArrayList();

            
            for(TreasureKind tKind : TreasureKind.values()) {
                    int min1 = 0, min2 = 0;
                    
                    // Trabajamos con tesoros visibles para cada TreasureKind
                       
                    for(int i=0; i<specificVisibleTreasures.size(); i++){
                        if(specificVisibleTreasures.get(i) == tKind)
                            min1++; 
                    }
                    for(int i=0; i<v.size(); i++){
                        if(v.get(i).getType() == tKind)
                            min2++; 
                    }
                    // Tomamos el mínimo y añadimos ese número de TreasureKind
                    for(int i=0; i < min(min1, min2);  i++){
                        adjustedSpecificVisible.add(tKind); 
                    }
                        
                    //Reseteamos los contadores
                    min1 = min2 = 0; 
                        
                    // Trabajamos con tesoros ocultos. 
                    for(int  i=0; i<specificHiddenTreasures.size(); i++){
                        if(specificHiddenTreasures.get(i) == tKind)
                            min1++; 
                    }
                    for(int i=0; i<h.size(); i++){
                        if(h.get(i).getType() == tKind)
                            min2++; 
                    }
                    // Tomamos el mínimo y añadimos ese número de TreasureKind
                    for(int i = 0; i < min(min1, min2);  i++){
                        adjustedSpecificHidden.add(tKind); 
                    }
            }  
            
            adjustedBC = new BadConsequence(text, 0, adjustedSpecificVisible, adjustedSpecificHidden);         
        }

        return adjustedBC;
    }
    
    // Método to_string
    
    @Override
    public String toString() {
        return  text + ", niveles=" + levels + 
                ", Tesoros Visibles=" + nVisibleTreasures + ", Tesoros Ocultos="
                + nHiddenTreasures + ", Muerte=" + death + ", Tesoros Visibles Espec.="
                + specificVisibleTreasures + ", Tesoros Ocultos Espec.=" + specificHiddenTreasures;
    }
    
}