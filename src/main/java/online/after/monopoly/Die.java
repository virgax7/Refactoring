package online.after.monopoly;

class Die {
	public int getRoll() {
		return (int)(Math.random() * 6) + 1;
	}
}
