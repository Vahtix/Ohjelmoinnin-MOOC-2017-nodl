package lentokentta;

import java.util.ArrayList;
import java.util.List;

public class Lentokentta {

	private List<Lentokone> lentokoneet;
	private List<Lento> lennot;
	
	public Lentokentta(){
		this.lentokoneet = new ArrayList<Lentokone>();
		this.lennot = new ArrayList<Lento>();
	}
	
	public void lisaaLentokone(Lentokone lentokone){
		this.lentokoneet.add(lentokone);
	}
	
	public void lisaaLento(Lento lento){
		this.lennot.add(lento);
	}
	
	public void tulostaLentokoneet(){
		for(Lentokone lentokone : this.lentokoneet){
			System.out.println(lentokone);
		}
	}
	
	public void tulostaLennot(){
		for(Lento lento : this.lennot){
			System.out.println(lento);
		}
	}
	
	public boolean tulostaLentokone(String tunnus){
		for(Lentokone lentokone : this.lentokoneet){
			if(lentokone.getTunnus().equals(tunnus)){
				System.out.println(lentokone);
				return true;
			}
		}		
		System.out.println("Lentokonetta ei loydy");
		return false;
	}
	
	public Lentokone haeLentokone(String tunnus){
		for(Lentokone lentokone : this.lentokoneet){
			if(lentokone.getTunnus().equals(tunnus)){
				return lentokone;
			}
		}
		return null;
	}
	
}
