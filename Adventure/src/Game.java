import java.util.Locale;
import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner input = new Scanner(System.in);
    public void Start(){
        System.out.println("!!! Welcome Adventure Game !!!");
        System.out.println(" Please Character Name Create : ");
        String characterName = input.next();
        player = new Player(characterName);
        player.selectCharacter();
        locationSelect();
    }
    public void locationSelect(){
        boolean drm = true;
        while(drm){
            System.out.println("\n********************************");
            System.out.println("Doğmak İstediğiniz Haritayı Seçiniz:\n");
            System.out.println("1-> (Ev) Güvenli Alan \n" +
                    "2-> (Mağara)--(Ödül Food) Zombi Çıkabilir \n " +
                    "3-> (Orman)--(Ödül FireWood) Vampir çıkabilir \n " +
                    "4-> (Nehir)--(Water) Ayı çıkabilir    \n " +
                    "5-> (Mağaza) Silah veya Zırh Alabilirsin \n" +
                    "6-> (Maden)--(Ödül Random Silah-Zırh-Para) Yılan Çıkabliri \n"+
                    "Bir Harita Seç : "
            );
            int slctMap = input.nextInt();
            boolean tf = false;
            do{
                switch (slctMap){
                    case 1:
                        tf = true;
                        location = new SafeHouse(player);
                        break;
                    case 2:
                        tf = true;
                        location = new Cave(player);
                        break;
                    case 3:
                        tf = true;
                        location = new Forest(player);
                        break;
                    case 4:
                        tf = true;
                        location = new River(player);
                        break;
                    case 5:
                        tf = true;
                        location = new ToolStore(player);
                        break;
                    case 6:
                        tf = true;
                        location = new Coal(player);
                        break;
                    default:
                        System.out.println("Geçerli Bir Harita Seçiniz: ");
                        slctMap = input.nextInt();
                }
                if (location.getName().equals("Güvenli Ev")) {
                    if(player.getInventory().isFirewoord() && player.getInventory().isWater() && player.getInventory().isFood()){
                        System.out.println("!*!*!* Tüm İtemleri Toplayarak Oyunu Kazandın  Tebrikler !*!*!*");
                        TheEnd();
                        drm = false;
                        break;

                    }
                }
                if(!location.getLocation()){
                    System.out.println("Oyun Bitti");
                }
            }while (!tf);
        }

    }
    public boolean TheEnd() {

        return false;
    }
}
