
public class Lypsyrobotti {

	private Maitosailio sailio;
	
	public Lypsyrobotti(){
		this.sailio = null;
	}
	
	public Maitosailio getMaitosailio(){
		return this.sailio;
	}
	
	public void setMaitosailio(Maitosailio maitosailio){
		this.sailio = maitosailio;
	}
	
	public void lypsa(Lypsava lypsava){
		if(this.sailio != null){
			this.sailio.lisaaSailioon(lypsava.lypsa());
		}else{
			System.out.println("Maidot menevat hukkaan!");
		}
		
	}
}
