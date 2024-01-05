import java.util.Scanner;

public class Player {
    private String characterName;
    private int realHealt;
    private int damage;
    private int health;
    private int money;
    private String characterType;
    private Inventory inventory;
    Scanner cha =new Scanner(System.in);


    public Player(String characterName) {
        this.characterName = characterName;
        this.inventory = new Inventory();

    }
    public void selectCharacter(){
        chaSelect();

    }

    public int chaSelect(){
        String cha1="1-Samuray \t Hasar:5 \t Sağlık:21 \t Para:15 \n";
        String cha2="2-Okçu    \t Hasar:7 \t Sağlık:18 \t Para:20 \n";
        String cha3="3-Şovalye \t Hasar:8 \t Sağlık:24 \t Para:5  \n";

        System.out.println("\n"+getCharacterName()+"\n");
        System.out.println("Listelenen Karakterlerden Birini Seçiniz: ");
        System.out.println(cha1+ cha2+ cha3+ "Seçiminiz : ");

        int chaId = cha.nextInt();
        boolean isTrue = false;
        do{
            switch (chaId){
                case 1:
                    initPlayer("Samuray",5,21,15);
                    isTrue = true;
                    break;
                case 2:
                    initPlayer("Okçu",7,18,20);
                    isTrue = true;
                    break;
                case 3:
                    initPlayer("Samuray",8,24,5);

                    isTrue = true;
                    break;
                default:
                    System.out.println("Geçerli Bir Karakter Seçiniz: ");
                    chaId = cha.nextInt();
            }
            System.out.println(getCharacterName() + " Nickli Karakter Oluşturuldu !!!\n" +
                    "Özellikleri => Hasar: " +getDamage() + "\tSağlık: " + getHealth() + "\tPara: " + getMoney());


        }while(!isTrue);
        return chaId;
    }
    public int gettotalDamage(){
        return this.damage + this.inventory.getDamage();
    }

    public void initPlayer(String characterType,int damage,int health,int money){
        setCharacterType(characterType);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setRealHealt(health);

    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getRealHealt() {
        return realHealt;
    }

    public void setRealHealt(int realHealt) {
        this.realHealt = realHealt;
    }


}
