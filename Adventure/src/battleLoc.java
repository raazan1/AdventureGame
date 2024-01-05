import java.util.Random;

public abstract class battleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;
    battleLoc(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }

    public boolean getLocation() {
        int obsCount = obstacle.obstacleCount();
        System.out.println("*********************** OBS COUNT" + obsCount);
        System.out.println(obstacle.getName() + " Haritasında " + obsCount + " Tane Yaratık var\n" + "Savaşmak İçin => (s)\nKaçmak İçin => (k)" );
        String select = input.next();
        select = select.toUpperCase();
        if(select.equals("S")){
            if(combat(obsCount)){
                System.out.println(this.getName()+" Haritasında Kazandın !!!");

                afterHit();

                if(this.award.equals("Food") && player.getInventory().isFood() == false){
                    System.out.println(this.award + " Kazandınız !!!");
                    player.getInventory().setFood(true);
                }
                else if(this.award.equals("Water") && player.getInventory().isWater() == false){
                    System.out.println(this.award + " Kazandınız !!!");
                    player.getInventory().setWater(true);
                }
                else if(this.award.equals("Firewood") && player.getInventory().isFirewoord() == false){
                    System.out.println(this.award + " Kazandınız !!!");
                    player.getInventory().setFirewoord(true);
                } else if (this.award.equals("Random")) {
                    System.out.println("Rastgele Bir Ödül Kazandınız Ödülünüz :");
                    setRandItem();
                }
                return true;
            }
            if(player.getHealth() <= 0){
                System.out.println(this.getName()+" Haritasında Kaybettin !!!");
                afterHit();
                return false;
            }
        }
        return true;
    }
    public boolean combat(int obsCount){
        for (int i = 0; i < obsCount; i++) {
            int defaultOHealt = obstacle.getHealt();
            playerStats();
            enemyStats();
            while(player.getHealth()>0 && obstacle.getHealt()>0){
                System.out.println("Saldır (S) \n Kaç(K) ");
                String slct = input.nextLine();
                slct = slct.toUpperCase();
                if(slct.equals("S")){
                    System.out.println("Vurdunuz : ");
                    obstacle.setHealt(obstacle.getHealt()-player.gettotalDamage());
                    afterHit();
                    System.out.println("***********");
                    if(obstacle.getHealt()>0){
                        System.out.println();
                        System.out.println(obstacle.getName() + " Size Vurdu");
                        player.setHealth(player.getHealth()-(obstacle.getDamage()-player.getInventory().getArmor()));
                        afterHit();
                    }

                }
                else {
                    break;
                }
                if(obstacle.getHealt() < player.getHealth()){
                    System.out.println(obstacle.getName() + " Öldü Kazandınız !!!");
                    player.setMoney(player.getMoney()+obstacle.getAward());
                    System.out.println("Güncel Paranız : " + player.getMoney());
                    obstacle.setHealt(defaultOHealt);
                }
                else{
                    return false;
                }
                System.out.println("|||||||||||||||||||||");
            }
        }
        return true;
    }
    public void playerStats(){
        System.out.println("Oyuncu : "+ player.getCharacterName() +"\nCan : " + player.getHealth() + "\nHasar : " + player.gettotalDamage() + "\nPara : " + player.getMoney());
        if(player.getInventory().getDamage()>0){
            System.out.println("Silah : " + player.getInventory().getWeponName());
        }
        if(player.getInventory().getArmor()>0){
            System.out.println("Armor : " + player.getInventory().getArmorName());
        }

    }

    public void enemyStats(){
        System.out.println("Yaratık İsmi : " + obstacle.getName() + "\n Can : " + obstacle.getDamage() + "\n Hasar : " + obstacle.getDamage() + "\nPara : " + obstacle.getAward());
    }
   public void afterHit(){
       System.out.println("Oyuncu : "+ player.getCharacterName() +"\nCan : " + player.getHealth() + "\nHasar : " + player.gettotalDamage() + "\nPara : " + player.getMoney());

   }
   public void setRandItem(){
        Random r = new Random();
        int mainR = r.nextInt(100);
        int gunR = r.nextInt(100);
        int armorR = r.nextInt(100);
        int monyR = r.nextInt(100);
        //Guns
        if(mainR<=15){
            if(gunR<=20){
                player.getInventory().setDamage(player.getInventory().getDamage()+7);
                System.out.println("Tüfek Kazandın Hasar +7");
                afterHit();
            }
            else if(gunR>20 && gunR<=30){
                player.getInventory().setDamage(player.getInventory().getDamage()+3);
                System.out.println("Kılıç Kazandın Hasar +3");
                afterHit();

            }
            else if(gunR>30 && gunR<=50){
                player.getInventory().setDamage(player.getInventory().getDamage()+2);
                System.out.println("Tabanca Kazandın Hasar +2");
                afterHit();

            }
        }
        //Guns
       else if (mainR>15 && mainR<=30) {
            if(armorR<=20){
                player.getInventory().setArmor(player.getInventory().getArmor()+5);
                System.out.println("Ağır Zırh Kazandın");
                afterHit();

            }
            else if(armorR>20 && armorR<=30){
                player.getInventory().setArmor(player.getInventory().getArmor()+3);
                System.out.println("Orta Zırh Kazandın");
                afterHit();


            }
            else if (armorR>30 && armorR<=50) {
                player.getInventory().setArmor(player.getInventory().getArmor()+1);
                System.out.println("Hafif Zırh Kazandın");
                afterHit();

            }
        }
       //Mony
       else if (mainR>30 && mainR<=55) {
           if(monyR<=50){
               this.player.setMoney(this.player.getMoney()+1);
               System.out.println("1 Altın Kazandın");
               afterHit();

           }
            else if(monyR>50 && monyR<=80){
                this.player.setMoney(this.player.getMoney()+5);
               System.out.println("5 Altın Kazandın");
               afterHit();

           }
            else {
                this.player.setMoney(this.player.getMoney()+10);
               System.out.println("10 Altın Kazandın");
               afterHit();

           }


        }
       else{
            System.out.println(":(( Şansına Küs İtem Düşmedi :((");
            afterHit();

        }


   }


}
