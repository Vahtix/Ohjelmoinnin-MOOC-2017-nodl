
public class Lukutulostin {
	
	StringBuilder muodostin;
	
	public void lukuporras(int luku){
		
		String luvut = "";
		
		for(int i = 0; i < luku; i++){
			luvut += (i+1) + " ";
			System.out.println(luvut);
		}
		
		System.out.println("");
	}
	
	public void jatkuvaLukuporras(int luku){	
        int tulostettavaLuku = 1;
        int porras = 1;
        while (porras <= luku) {
            for (int i = 0; i < porras; i++) {
                System.out.print(tulostettavaLuku + " ");
                tulostettavaLuku++;
            }
 
            porras++;
            System.out.println("");
        }		
        
        System.out.println("");
	}
	
	public void kertokolmio(int luku){
        int porras = 1;
        while (porras <= luku) {
 
            int tulostettavaLuku = 1;
            while (tulostettavaLuku <= porras) {
                System.out.print(tulostettavaLuku * porras + " ");
                tulostettavaLuku++;
            }
 
            porras++;
            System.out.println("");
        }       
        System.out.println("");
	}	
}
