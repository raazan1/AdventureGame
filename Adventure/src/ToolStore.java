import java.util.Scanner;
public class ToolStore extends normalLoc{
    Scanner input = new Scanner(System.in);
    ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean getLocation() {
        System.out.println("Paran : " + player.getMoney() +
                "\n1-> Silahlar\n" +
                "2-> Zırhlar\n" +
                "3->Çıkış\n" +
                "Seçim Yapınız : "
        );
        int sMagaza = input.nextInt();
        int selectId;
            switch (sMagaza){
                case 1:
                    selectId = weaponMenu();
                    buyWeapon(selectId);
                    break;
                case 2:
                    selectId = armorMenu();
                    buyArmor(selectId);
                    break;

                case 3:
                    break;
                default:

            }
        return true;
    }
    public int weaponMenu(){
        System.out.println("1->(Tabanca)\tHasar:2\tPara:25\n"+
                "2->(Kılıç)\tHasar:3\tPara:35\n" +
                "3->(Tüfek)\tHasar:7\tPara:45\n" +
                "4->(Çıkış)\n"+
                "Seçiminiz : ");
        int weaponSId = input.nextInt();
        return weaponSId;
    }
    public void buyWeapon(int weaponId){
        int damage = 0;
        int price = 0;
        String wName = null;

            switch (weaponId){
                case 1:
                    damage = 2;
                    wName = "Tabanca";
                    price = 25;
                    break;
                case 2:
                    damage = 3;
                    wName = "Kılıç";
                    price = 5;
                    break;
                case 3:
                    damage = 7;
                    wName = "Tüfek";
                    price = 45;
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Geçerli Bir Seçim Yapınız:");
                    break;
            }
            if(price>0){
                if(player.getMoney()>price){
                    player.getInventory().setDamage(damage);
                    player.getInventory().setWeponName(wName);
                    player.setMoney(player.getMoney()-price);
                    System.out.println(wName + " Adlı Silah Satın Aldınız --Güncel Hasar-- " + player.gettotalDamage() + "\n" +
                            "Hasar +" + (damage) + " Arttırıldı");
                }
                else{
                    System.out.println("Paran Yetersiz !!!");
                    weaponMenu();
                }
            }
    }

    public int armorMenu(){
        System.out.println("1->(Hafif)\tEngelleme:2\tPara:15\n"+
                "2->(Orta)\tEngelleme:3\tPara:25\n" +
                "3->(Ağır)\tEngelleme:7\tPara:40\n" +
                "4->(Çıkış)\n"+
                "Seçiminiz : ");
        int armorSId = input.nextInt();
        return armorSId;
    }
    public void buyArmor(int weaponId){
        int engelleme = 0;
        int price = 0;
        String aName = null;

        switch (weaponId){
            case 1:
                engelleme = 1;
                aName = "Hafif Zırh";
                price = 1;
                break;
            case 2:
                engelleme = 3;
                aName = "Orta Zırh";
                price = 25;
                break;
            case 3:
                engelleme = 5;
                aName = "Ağır Zırh";
                price = 40;
                break;
            case 4:
                break;
            default:
                System.out.println("Geçerli Bir Seçim Yapınız:");
                break;
        }
        if(price>0){
            if(player.getMoney()>price){
                player.getInventory().setArmor(engelleme);
                player.getInventory().setArmorName(aName);
                player.setMoney(player.getMoney()-price);
                System.out.println(aName + " Adlı Armoru Satın Aldınız --Engellenen Hasar-- " + player.getInventory().getArmor() + "\n" +
                        "Hasar +" + (engelleme) + " Arttırıldı");
            }
            else{
                System.out.println("Paran Yetersiz !!!");
                weaponMenu();
            }
        }
    }
}
