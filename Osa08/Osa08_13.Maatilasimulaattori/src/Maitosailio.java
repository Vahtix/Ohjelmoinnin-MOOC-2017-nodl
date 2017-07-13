
public class Maitosailio {

	private double maxTilavuus;
	private double saldo;
	
	public Maitosailio(){
		this.maxTilavuus = 2000;
		this.saldo = 0;
	}
	
	public Maitosailio(double tilavuus){
		this.maxTilavuus = tilavuus;
	}
	
	public double getTilavuus(){
		return this.maxTilavuus;
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public double paljonkoTilaaJaljella(){
		return this.maxTilavuus - this.saldo;
	}
	
	public void lisaaSailioon(double maara){
		if(this.saldo + maara <= this.maxTilavuus){
			this.saldo += maara;
		}else{
			this.saldo = this.maxTilavuus;
		}
	}
	
	public double otaSailiosta(double maara){
		if(this.saldo - maara >= 0){
			this.saldo -= maara;
			return maara;
		}else{
			double saldo = this.saldo;
			this.saldo = 0;
			return saldo;
		}
	}
	
	public String toString(){
		return Math.ceil(this.saldo) + "/" + Math.ceil(this.maxTilavuus);
	}
}
