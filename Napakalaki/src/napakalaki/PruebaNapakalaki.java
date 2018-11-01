
package napakalaki;

/**
 *
 * @author alex
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

        /* CONSULTAS
        
        int opcion;                     // Opcion de menú
        Scanner sc = new Scanner(System.in);
        int size = monstruos.size();    // Nº de monstruos
        
        
        System.out.println("Menú de opciones:\n");
        System.out.println("\t1 -> Ver monstruos.");
        System.out.println("\t2 -> Monstruos con nivel mayor que 10.");
        System.out.println("\t3 -> Monstruos con los que pierdes nivel.");
        System.out.println("\t4 -> Monstruos con los que subes más de 1 nivel.");
        System.out.println("\t5 -> Monstruos con los que pierdes tesoros.");
        System.out.println("\t0 -> Salir.");
            
        do{     
            opcion = sc.nextInt();
           
            switch(opcion){
                case 1:
                
                // Ver cartas de monstruos
                
                    for(int i=0; i<size; i++){
                        System.out.println(monstruos.get(i));
                    }
                break;
                    
                case 2:   
                    
                // Monstruos con nivel mayor a 10
        
                    for(int i=0; i<size; i++){
                        if(monstruos.get(i).getCombatLevel() > 10)
                            System.out.println(monstruos.get(i).getName());
                    }
                break;
        
                case 3:
                    
                // Monstruos con sólo pérdida de niveles
        
                 for(int i=0; i<size; i++){
                    if(monstruos.get(i).bc.getLevels() != 0 && 
                        monstruos.get(i).bc.getnHiddenTreasures() == 0 &&
                        monstruos.get(i).bc.getnVisibleTreasures() == 0)
                            System.out.println(monstruos.get(i).getName());
                    }
                break;
        
                case 4:
                
                // Monstruos con subida de nivel superior a 1

                    for(int i=0; i<size; i++){
                        if(monstruos.get(i).prize.getLevel() > 1)
                            System.out.println(monstruos.get(i).getName());
                    }
                break;    
               
                case 5:
        
                // Monstruos con los que pierdes tesoros
        
                    for(int i=0; i<size; i++){
                        if(monstruos.get(i).bc.getnHiddenTreasures() != 0 
                        || monstruos.get(i).bc.getnVisibleTreasures() != 0)
                            System.out.println(monstruos.get(i).getName());
                    }
                 break;
                }
        }while(opcion != 0);
        */
    }  
}