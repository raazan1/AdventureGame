public class SafeHouse extends normalLoc{
    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getRealHealt());
        System.out.println("Konum=>(Güvenli Ev)\n!!!Canının Yenilendi !!!");
        return true;
    }
}
