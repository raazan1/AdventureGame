public class Inventory {
    private boolean water;
    private boolean food;
    private boolean firewoord;
    private int damage;
    private int armor;

    private String weponName;
    private String armorName;



    public Inventory() {
        this.water = false;
        this.food = false;
        this.firewoord = false;
        this.damage = 0;
        this.armor = 0;
        this.weponName = null;
        this.armorName = null;

    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewoord() {
        return firewoord;
    }

    public void setFirewoord(boolean firewoord) {
        this.firewoord = firewoord;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getWeponName() {
        return weponName;
    }

    public void setWeponName(String weponName) {
        this.weponName = weponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }
}
