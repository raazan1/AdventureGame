public abstract class normalLoc extends Location {
    normalLoc(Player player,String name) {
        super(player);
        this.name = name;

    }
    @Override
    public boolean getLocation() {
        return true;
    }
}
