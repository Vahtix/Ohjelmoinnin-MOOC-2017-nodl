package luola;

public class Sijainti {

	private int y, x;
	
	public Sijainti(int y, int x){
		this.y = y;
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void siirra(int dy, int dx){
		this.y = this.y + dy;
		this.x = this.x + dx;
	}
	
	public String toString(){
		return this.x + " " + this.y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Sijainti))
			return false;
		Sijainti other = (Sijainti) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
