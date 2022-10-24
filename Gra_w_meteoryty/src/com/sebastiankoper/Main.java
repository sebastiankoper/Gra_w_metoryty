package com.sebastiankoper;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;


class MyJFrame extends JFrame implements MouseMotionListener,KeyListener,MouseListener {



    MyJFrame() {
        addMouseMotionListener(this);
        addKeyListener(this);
        addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int klikx = e.getX();
        int kliky = e.getY();
        if (klikx >= 450 && klikx <= 560 && kliky >= 70 && kliky <=185 && Main.lives<=0){
            Main.lives=3;
            Main.time=0;
            Main.kropkax = 500;
            Main.kropkay = 250;
            for (int i = 0; i < Main.tabX.length; i++){
                Main.tabX[i] = 0;
                Main.tabY[i] = 0;
                }
            }
        }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }


    @Override
    public void mouseMoved(MouseEvent e) {
        Main.kropkay = e.getY()-60;
        Main.kropkax = e.getX()-30;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'b'){
            Main.score_help = Main.score;
            Main.Sklep();
        }

        if(e.getKeyChar() == 's'){
            Main.ZapiszSave();
        }

        if(e.getKeyChar() == 'k'){
            Main.WczytajSave();
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
//////////////////////////////////////////                       Druga ramka               //////////////////////////////////////////////////////////////////////////////

class MyJFrame2 extends JFrame implements MouseListener{
    MyJFrame2(){
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int y = e.getY();
        int x = e.getX();
        if (x>=300 && x<=465 && y>=220 && y<=380){
            if (Main.score_help>=10){
                System.out.println("Ustawiłeś nowy wygląd Statku");
                Main.nr_statku =1;
                Main.score_help= Main.score_help-10;
                Main.score = Main.score_help;
                Main.sklep = 0;
                dispose();
            }else{
                System.out.println("nie masz wystarczającej ilosść pkt.");
                Main.sklep = 0;
                dispose();
            }

        }else if(x>=550 && x<=715 && y>=220 && y<=380){
            if (Main.score_help>=5){
                System.out.println("Ustawiłeś nowy wygląd Meteoru");
                Main.nr_meteoru =1;
                Main.score_help= Main.score_help-5;
                Main.score = Main.score_help;
                Main.sklep = 0;
                dispose();
            }else{
                System.out.println("nie masz wystarczającej ilosść pkt.");
                Main.sklep = 0;
                dispose();
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

class MyPanel2 extends JPanel{
    Image Spaceship2 = null;
    Image Meteor2 = null;

    public MyPanel2(){
        try{

            File spaceship2 = new File("C:\\Users\\Sebastian\\IdeaProjects\\Gra_w_meteoryty\\spaceship.png");
            Spaceship2 = ImageIO.read(spaceship2);
            File meteor = new File("C:\\Users\\Sebastian\\IdeaProjects\\Gra_w_meteoryty\\meteor2.png");
            Meteor2 = ImageIO.read(meteor);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Dimension getPreferredSize(){return new Dimension(1000,500);}

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("SKLEP",500,20);
        g.drawString("Kliknij aby kupic przedmiot",450,40);
        g.drawString("Koszt statku to 10 monet",300,180);
        g.drawString("Koszt meteorytu to 5 monet",550,180);
        g.drawImage(Spaceship2,300,200,150,150,null);
        g.drawImage(Meteor2,550,200,150,150,null);
    }

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Main extends JPanel {
    static int pierwszy_wynik;
    static int drugi_wynik;
    static int trzeci_wynik;
    static String  pierwszy_imie;
    static String  drugi_imie;
    static String  trzeci_imie;
    static String username;
    static String pierwszy = "";
    static String drugi = "";
    static String trzeci = "";
    static int score = 0;
    static int score_help = 0;
    static int lives = 3;
    static int time = 0;
    static int kropkax = 500;
    static int kropkay = 250;
    static int sklep = 0;
    static int nr_statku = 0;
    static int nr_meteoru = 0;
    Image Spaceship2 = null;
    Image Meteor2 = null;
    Image Image = null;
    Image Xwing = null;
    Image Serce = null;
    Image GamerOver = null;
    Image StartGame = null;
    Color kolor = Color.RED;
    static int liczba = 10;
    static int predkosc1 = 1;
    static int predkosc2 = 3;
    static int predkosc3 = 5;
    static int predkosc4 = 7;
    static int tabX[] = new int[liczba];
    static int tabY[] = new int[liczba];
    static int srednica[] = new int[liczba];
    static int W_ktora_strone[] = new int[liczba];
    static int ktora_sciana[] = new int[liczba];
    static int predkosc[] = new int[liczba];
    static int[] predkosc_liczby_pierwsze = {2,3,5,7};
    static int[] srednica_liczby_opcje = {20,25,35,40};
    static Main me;

    public Main(){





        try {
            me = this;
            File image = new File("C:\\Users\\Sebastian\\IdeaProjects\\Gra_w_meteoryty\\meteor.png");
            Image = ImageIO.read(image);
            File xwing = new File("C:\\Users\\Sebastian\\IdeaProjects\\Gra_w_meteoryty\\xwing.png");
            Xwing = ImageIO.read(xwing);
            File serce = new File("C:\\Users\\Sebastian\\IdeaProjects\\Gra_w_meteoryty\\heart.png");
            Serce = ImageIO.read(serce);
            File gameover = new File("C:\\Users\\Sebastian\\IdeaProjects\\Gra_w_meteoryty\\game-over.png");
            GamerOver = ImageIO.read(gameover);
            File startgame = new File("C:\\Users\\Sebastian\\IdeaProjects\\Gra_w_meteoryty\\start_game.png");
            StartGame = ImageIO.read(startgame);
            File spaceship2 = new File("C:\\Users\\Sebastian\\IdeaProjects\\Gra_w_meteoryty\\spaceship.png");
            Spaceship2 = ImageIO.read(spaceship2);
            File meteor = new File("C:\\Users\\Sebastian\\IdeaProjects\\Gra_w_meteoryty\\meteor2.png");
            Meteor2 = ImageIO.read(meteor);

        }catch (Exception e){
        }


        for (int i = 0; i<liczba;i++){
        W_ktora_strone[i] =  (int) (Math.random()*3);
        ktora_sciana[i] =  (int) (Math.random()*4);
        predkosc[i] = predkosc_liczby_pierwsze[(int) (Math.random()*4)];
        srednica[i] = srednica_liczby_opcje[(int) (Math.random()*4)];
    }
        for (int i = 0; i<liczba;i++){
            if (ktora_sciana[i] == 0){
                tabX[i] = -20;
                tabY[i] = (int) (Math.random()*500);
            }else if (ktora_sciana[i] == 1){
                tabY[i] = -20;
                tabX[i] = (int) (Math.random()*1000);
            }else if (ktora_sciana[i] == 2){
                tabX[i] = 1020;
                tabY[i] = (int) (Math.random()*500);
            }else if (ktora_sciana[i] == 3){
                tabY[i] = 520;
                tabX[i] = (int) (Math.random()*1000);
            }
        }
    }


    public static void Sklep() {
        if (Main.sklep == 0){
            Main.sklep = 1;
            Main.ZapiszSave();
            MyJFrame2 myFrame = new MyJFrame2();
            MyPanel2 myJpanel = new MyPanel2();
            myFrame.add(myJpanel);
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setVisible(true);
            myFrame.pack();
        }
    }


    public Dimension getPreferredSize() {
        return new Dimension(1000, 500);
    }



    public void Kolizja(int y, int x,int i){
        if (lives>=1){
            if (x >= kropkax-20 && x<= kropkax+50 && y >= kropkay-20 && y <= kropkay+30){
                lives--;
                tabX[i] = -100;
                tabY[i] = -100;
                if (lives<1){
                    try {
                        String tekst = "";

                        Scanner odczyt_best_score = new Scanner(new File("Best_score.txt"));

                        odczyt_best_score.hasNextLine();
                        tekst = odczyt_best_score.nextLine();
                        trzeci = tekst;
                        trzeci_wynik = Integer.parseInt(tekst);

                        odczyt_best_score.hasNextLine();
                        tekst = odczyt_best_score.nextLine();
                        trzeci = tekst+" "+trzeci;
                        trzeci_imie = tekst;

                        odczyt_best_score.hasNextLine();
                        tekst = odczyt_best_score.nextLine();
                        drugi = tekst;
                        drugi_wynik = Integer.parseInt(tekst);

                        odczyt_best_score.hasNextLine();
                        tekst = odczyt_best_score.nextLine();
                        drugi = tekst+" "+drugi;
                        drugi_imie = tekst;

                        odczyt_best_score.hasNextLine();
                        tekst = odczyt_best_score.nextLine();
                        pierwszy = tekst;
                        pierwszy_wynik = Integer.parseInt(tekst);

                        odczyt_best_score.hasNextLine();
                        tekst = odczyt_best_score.nextLine();
                        pierwszy = tekst+" "+pierwszy;
                        pierwszy_imie = tekst;

                        System.out.println(drugi_imie);

                        System.out.println(time/500);

                        if (time/500>trzeci_wynik && time/500>drugi_wynik && time/500>pierwszy_wynik){
                            if (drugi_imie.equals(username)){
                                drugi_wynik = pierwszy_wynik;
                                pierwszy_wynik = time/500;
                                drugi_imie = pierwszy_imie;
                                pierwszy_imie = username;
                                drugi = pierwszy;
                                pierwszy=username+" "+time/500;
                            }else{
                                if (pierwszy_imie.equals(username)) {
                                    pierwszy_wynik = time/500;
                                }else{
                                    trzeci_wynik = drugi_wynik;
                                    drugi_wynik = pierwszy_wynik;
                                    pierwszy_wynik = time/500;
                                    trzeci_imie = drugi_imie;
                                    drugi_imie = pierwszy_imie;
                                    pierwszy_imie = username;
                                    trzeci = drugi;
                                    drugi = pierwszy;
                                    pierwszy=username+" "+time/500;
                                }
                            }
                        } else if (time / 500 > trzeci_wynik && time / 500 > drugi_wynik && !pierwszy_imie.equals(username)) {
                            trzeci_wynik = drugi_wynik;
                            drugi_wynik = time/500;
                            trzeci_imie = drugi_imie;
                            drugi_imie = username;
                            trzeci = drugi;
                            drugi=username+" "+time/500;

                        }else if (time / 500 > trzeci_wynik && !pierwszy_imie.equals(username) && !drugi_imie.equals(username)){
                            trzeci_imie = username;
                            trzeci_wynik = time/500;
                            trzeci=username+" "+time/500;
                        }



                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    score = 0;
                    time = 0;

                    PrintWriter zapis = null;
                    try {
                        zapis = new PrintWriter("Best_score.txt");
                        zapis.println(trzeci_wynik);
                        zapis.println(trzeci_imie);
                        zapis.println(drugi_wynik);
                        zapis.println(drugi_imie);
                        zapis.println(pierwszy_wynik);
                        zapis.println(pierwszy_imie);
                        zapis.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                }

            }
            repaint();
        }


    }

    public static void ZapiszSave(){
        System.out.println("Zrobiłęs Save");
        try {
            PrintWriter zapis = new PrintWriter("Save.txt");
            zapis.println(Main.kropkay);
            zapis.println(Main.kropkax);
            zapis.println(Main.lives);
            zapis.println(Main.time);
            zapis.println(Main.predkosc1);
            zapis.println(Main.predkosc2);
            zapis.println(Main.predkosc3);
            zapis.println(Main.predkosc4);
            for (int i=0; i<Main.liczba;i++){

                zapis.print(Main.tabX[i]+" ");


            }
            zapis.println();
            for (int i=0; i<Main.liczba;i++){

                if (i==Main.liczba-1){
                    zapis.print(Main.tabY[i]);
                }else{
                    zapis.print(Main.tabY[i]+" ");
                }
            }
            zapis.println();
            for (int i=0; i<Main.liczba;i++){

                if (i==Main.liczba-1){
                    zapis.print(Main.srednica[i]);
                }else{
                    zapis.print(Main.srednica[i]+" ");
                }

            }
            zapis.println();
            for (int i=0; i<Main.liczba;i++){

                if (i==Main.liczba-1){
                    zapis.print(Main.W_ktora_strone[i]);
                }else{
                    zapis.print(Main.W_ktora_strone[i]+" ");
                }
            }
            zapis.println();
            for (int i=0; i<Main.liczba;i++){

                if (i==Main.liczba-1){
                    zapis.print(Main.ktora_sciana[i]);
                }else{
                    zapis.print(Main.ktora_sciana[i]+" ");
                }
            }
            zapis.println();
            for (int i=0; i<Main.liczba;i++){

                if (i==Main.liczba-1){
                    zapis.print(Main.predkosc[i]);
                }else{
                    zapis.print(Main.predkosc[i]+" ");
                }
            }
            zapis.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("nie ma pliku do zapisu");
        }
    }

    public static void WczytajSave(){
        System.out.println("Wczytałeś Save");
        try {
            String tekst="";
            Scanner odczyt = new Scanner(new File("Save.txt"));
            odczyt.hasNextLine();
            tekst = odczyt.nextLine();
            Main.kropkay = Integer.parseInt(tekst);

            odczyt.hasNextLine();
            tekst = odczyt.nextLine();
            Main.kropkax = Integer.parseInt(tekst);

            odczyt.hasNextLine();
            tekst = odczyt.nextLine();
            Main.lives = Integer.parseInt(tekst);

            odczyt.hasNextLine();
            tekst = odczyt.nextLine();
            Main.time = Integer.parseInt(tekst);

            odczyt.hasNextLine();
            tekst = odczyt.nextLine();
            Main.predkosc1 = Integer.parseInt(tekst);

            odczyt.hasNextLine();
            tekst = odczyt.nextLine();
            Main.predkosc2 = Integer.parseInt(tekst);

            odczyt.hasNextLine();
            tekst = odczyt.nextLine();
            Main.predkosc3 = Integer.parseInt(tekst);

            odczyt.hasNextLine();
            tekst = odczyt.nextLine();
            Main.predkosc4 = Integer.parseInt(tekst);
            tekst="";
            String tekstPomoc="";


            for (int i = 0; i < Main.tabX.length; i++) {
                odczyt.hasNext();
                tekstPomoc = odczyt.next();
                Main.tabX[i] = Integer.parseInt(tekstPomoc);
            }




            for (int i = 0; i < Main.tabY.length; i++) {
                odczyt.hasNext();
                tekstPomoc = odczyt.next();
                Main.tabY[i] = Integer.parseInt(tekstPomoc);
            }

            for (int i = 0; i < Main.srednica.length; i++) {
                odczyt.hasNext();
                tekstPomoc = odczyt.next();
                Main.srednica[i] = Integer.parseInt(tekstPomoc);
            }

            for (int i = 0; i < Main.W_ktora_strone.length; i++) {
                odczyt.hasNext();
                tekstPomoc = odczyt.next();
                Main.W_ktora_strone[i] = Integer.parseInt(tekstPomoc);
            }

            for (int i = 0; i < Main.ktora_sciana.length; i++) {
                odczyt.hasNext();
                tekstPomoc = odczyt.next();
                Main.ktora_sciana[i] = Integer.parseInt(tekstPomoc);
            }

            for (int i = 0; i < Main.predkosc.length; i++) {
                odczyt.hasNext();
                tekstPomoc = odczyt.next();
                Main.predkosc[i] = Integer.parseInt(tekstPomoc);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        me.repaint();
    }

    public void W_ktora_strone(int i){
        if (ktora_sciana[i] == 0) {
            if (W_ktora_strone[i] == 0) {
                if (predkosc[i]%2 == 0){
                    tabX[i]+=predkosc1;
                    Kolizja(tabY[i],tabX[i],i);

                }else if (predkosc[i]%3 == 0){
                    tabX[i]+=predkosc2;
                    Kolizja(tabY[i],tabX[i],i);
                }else if (predkosc[i]%5 == 0){
                    tabX[i]+=predkosc3;
                    Kolizja(tabY[i],tabX[i],i);
                }else if (predkosc[i]%7 == 0){
                    tabX[i]+=predkosc4;
                    Kolizja(tabY[i],tabX[i],i);
                }
                if (tabX[i] > 1050) {
                    tabX[i] = -20;
                    tabY[i] = (int) (Math.random() * 500);
                }
                predkosc[i] = predkosc_liczby_pierwsze[(int) (Math.random()*4)];
            } else if (W_ktora_strone[i] == 1) {
                tabX[i]+=predkosc1;
                tabY[i]+=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabY[i] > 550) {
                    tabX[i] = -20;
                    tabY[i] = (int) (Math.random() * 500);
                }
            } else if (W_ktora_strone[i] == 2) {
                tabX[i]+=predkosc1;
                tabY[i]-=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabY[i] < -50) {
                    tabX[i] = -20;
                    tabY[i] = (int) (Math.random() * 500);
                }
            }
        }
        //sciana góra
        if (ktora_sciana[i] == 1) {
            if (W_ktora_strone[i] == 0) {
                tabY[i]+=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabY[i] > 550) {
                    tabY[i] = -20;
                    tabX[i] = (int) (Math.random()*1000);
                }
            } else if (W_ktora_strone[i] == 1) {
                tabY[i]+=predkosc1;
                tabX[i]-=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabX[i] < -20) {
                    tabY[i] = -20;
                    tabX[i] = (int) (Math.random() * 1000);
                }
            } else if (W_ktora_strone[i] == 2) {
                tabY[i]+=predkosc1;
                tabX[i]+=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabX[i] > 1020) {
                    tabY[i] = -20;
                    tabX[i] = (int) (Math.random() * 1000);
                }
            }
        }
        // prawa strona
        if (ktora_sciana[i] == 2) {
            if (W_ktora_strone[i] == 0) {
                tabX[i]-=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabX[i] < 0) {
                    tabX[i] = 1020;
                    tabY[i] = (int) (Math.random()*500);
                }
            } else if (W_ktora_strone[i] == 1) {
                tabX[i]-=predkosc1;
                tabY[i]-=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabY[i] < 0) {
                    tabX[i] = 1020;
                    tabY[i] = (int) (Math.random() * 500);
                }
            } else if (W_ktora_strone[i] == 2) {
                tabX[i]-=predkosc1;
                tabY[i]+=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabY[i] > 500) {
                    tabX[i] = 1020;
                    tabY[i] = (int) (Math.random() * 500);
                }
            }
        }

        if (ktora_sciana[i] == 3) {
            if (W_ktora_strone[i] == 0) {
                tabY[i]-=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabY[i] < 0) {
                    tabY[i] = 520;
                    tabX[i] = (int) (Math.random()*1000);
                }
            } else if (W_ktora_strone[i] == 1) {
                tabX[i]-=predkosc1;
                tabY[i]-=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabX[i] < 0) {
                    tabY[i] = 520;
                    tabX[i] = (int) (Math.random() * 1000);
                }
            } else if (W_ktora_strone[i] == 2) {
                tabX[i]+=predkosc1;
                tabY[i]-=predkosc1;
                Kolizja(tabY[i],tabX[i],i);
                if (tabX[i] > 1000) {
                    tabY[i] = 520;
                    tabX[i] = (int) (Math.random() * 1000);
                }
            }
        }
    }


    public void animacja(){
        username = (String)JOptionPane.showInputDialog("podaj swój Nick");
        if (lives>=1){
            for (int j = 0; j<1001; j--){
                for (int i = 0; i<liczba; i++){
                    //sciana lewa
                    W_ktora_strone(i);

                    if (time >10000){
                        predkosc1 = 5;
                        predkosc2 = 5;
                        predkosc3 = 5;
                        predkosc4 = 5;
                    }else{
                        predkosc1 = 1;
                        predkosc2 = 2;
                        predkosc3 = 3;
                        predkosc4 = 4;
                    }
                    try {
                        Thread.sleep(1);
                    }catch (Exception e){}
                    time++;
                    if (time % 5000 == 0){
                        score+=5;
                    }
                    repaint();
                }
            }
        }else{

        }


    }



    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (lives > 0 && sklep == 0){
            for (int i = 0; i<liczba; i++){
                if (nr_meteoru == 0){
                    g.drawImage(Image,tabX[i],tabY[i],srednica[i],srednica[i],null );
                }else if (nr_meteoru == 1){
                    g.drawImage(Meteor2,tabX[i],tabY[i],srednica[i],srednica[i],null );
                }
            }
            if (nr_statku == 0){
                g.drawImage(Xwing,kropkax,kropkay,50,50,null);
            }else if (nr_statku == 1){
                g.drawImage(Spaceship2,kropkax,kropkay,50,50,null);
            }
            g.drawString("Czas: "+time/500,10,10);
            g.drawString("score: "+score,10,25);
//            g.drawString("Najlepszy czas: "+time/500,10,20);

            if (lives == 3){
                g.drawImage(Serce,880,10,30,30,null);
                g.drawImage(Serce,920,10,30,30,null);
                g.drawImage(Serce,960,10,30,30,null);
            }else if (lives == 2){
                g.drawImage(Serce,920,10,30,30,null);
                g.drawImage(Serce,960,10,30,30,null);
            }else if (lives == 1){
                g.drawImage(Serce,960,10,30,30,null);
            }

        }
        if (lives <= 0 && sklep == 0) {
            g.drawImage(GamerOver, 350, 150, 300, 200, null);
            g.drawImage(StartGame, 450, 50, 110, 100, null);
            g.drawString("TOP 3 wyników",470,380);
            g.drawString("1. "+pierwszy,450,400);
            g.drawString("2. "+drugi,450,430);
            g.drawString("3. "+trzeci,450,460);
        }





    }


    public static void main(String[] args) {
        MyJFrame window = new MyJFrame(); // ranka programu
        Main myJpanel = new Main();
        window.add(myJpanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // minimalizja, zamykanie, powieksznie
        Main pilka = new Main();
        window.add(pilka); // dodawa panelu
        window.setVisible(true); // ustawienie zeby ramka była widoczna
        window.pack();// dostosownie rozmiaru ramki do naszgo okna
        pilka.animacja();

    }
}