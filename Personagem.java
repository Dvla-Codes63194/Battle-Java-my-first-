
import java.util.Random;
public class Personagem {
  private String nome;
  private int hp;
   private String golpe;
     private int dano;
   private int hpMaximo;
    private boolean defendendo;
   private Random random = new Random();

    public Personagem(String nome, int hp, String golpe,int dano) {
        this.nome = nome;
        this.hp = hp;
        this.hpMaximo = hp;
        this.golpe = golpe;
        this.dano = dano;
    }

    public void atacar(Personagem inimigo) {
        if (inimigo.hp > 0) {
            int sorte = random.nextInt(100);
            int danoAplicado = dano;
            if (sorte < 20) {
                System.out.println("💥 CRÍTICO!");
                danoAplicado = dano * 2;
            }
            System.out.println(nome + " usou " + golpe);
            inimigo.receberDano(danoAplicado);


        } else {
            System.out.println(inimigo.nome + " ja foi derrotada!");

        }
    }
        public void mostrarStatus() {
            System.out.println("Nome: " + nome);
            System.out.println("HP: " + hp);
            System.out.println("Golpe: " + golpe);
            System.out.println("Dano de ataque "+dano);
        }
    public void curar(){
hp=hp+20;
if (hp>hpMaximo){ hp=hpMaximo;}
        System.out.println(nome+ " se curou! HP atual: "+ hp);
    }

    public void receberDano(int dano) {
        if (defendendo) {
            dano = dano / 2;
            System.out.println(nome + " defendeu parte do ataque!");

        }
        hp = hp - dano;
        if (hp < 0) {
            hp = 0;
        }
        System.out.println(nome + " recebeu " + dano + " de dano");
        System.out.println("HP restante: " + hp);
        defendendo=false;

    }


    public int getHp() {
return  hp;
    }
    public String getNome(){
        return nome;
    }
    public String getGolpe() {
       return golpe;
    }
    public int getDano() {
        return dano;
    }

    public void defender() {
defendendo=true;
System.out.println(nome+" está defendendo!");
    }
    public void mostrarHp() {
        System.out.println(nome+" HP: "+hp+"/"+hpMaximo);
    }
    public void barraVida(){
        int barras = hp / 10;
        int barrasVazias=10- barras;
        System.out.print(nome + " HP: ");
        for (int i = 0; i < barras; i++) {
            System.out.print("█");
        }
        for (int i=0;i< barrasVazias;i++){
            System.out.print("░");
        }
        System.out.println(" " + hp + "/" + hpMaximo);
    }
    }











