package AdventurGm;

public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player,"Safe House");
	}
    
	public boolean getLocation() {
		player.setHealthy(player.getRhealthy());
		System.out.println("You are healed !!");
		System.out.println("You are in the safe house now");
		return true;
	}
}
