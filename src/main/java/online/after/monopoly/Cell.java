package online.after.monopoly;

public abstract class Cell {
	private boolean available = true;
	private String name;
	Player owner;

	public String getName() {
		return name;
	}

	public Player getOwner() {
		return owner;
	}
	
	public int getPrice() {
		return 0;
	}

	public boolean isAvailable() {
		return available;
	}

	public abstract void playAction();

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
    
    public String toString() {
        return name;
    }
}
