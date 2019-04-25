package com.company;

public class Main {

    public static void main(String[] args) {
        // Station dfm = new Radio2();
        // Radio radio = new Radio();
        // radio.setStation(dfm);
        // for (int i=0;i<10;i++){
        // radio.play();
        // radio.nextStation();
        //}
        Human human = new Human();
        human.setState(new Work());
        for (int i =0;i<10;i++){
            human.doSomething();
        }
    }
    static class Human{
        private Activity state;
        public void setState(Activity s){this.state=s;}
        public void doSomething(){
            state.doSomething(this);
        }
    }
    interface Activity{
        void doSomething(Human context);
    }
    static class Work implements Activity{
        public void doSomething(Human context){
            System.out.print("Работаем");
            context.setState(new WeekEnd());
        }
    }
    static class WeekEnd implements Activity{
        private int count =0;
        public void doSomething(Human context){
            if (count<3){
                System.out.println("отдыхаем");
                count++;
            }
            else {
                context.setState(new Work());
            }
        }
    }
    interface Station{
        void play();
    }
    static class Radio1 implements Station {
        public void play() {
            System.out.println("Радио 1...");
        }
    }  static class Radio2 implements Station {
        public void play() {
            System.out.println("Радио 2...");
        }
    }
    static class Radio3 implements Station {
        public void play() {
            System.out.println("Радио 3...");
        }
    }
    static class Radio{
        Station station;
        void setStation(Station st){station = st;}
        void nextStation(){
            if (station instanceof Radio1) {
                setStation(new Radio2());
            }
            else if (station instanceof Radio2) {
                setStation(new Radio3());
            }
            else if (station instanceof Radio3) {
                setStation(new Radio1());
            }
        }
        void play() {
            station.play();
        }



    }
}

