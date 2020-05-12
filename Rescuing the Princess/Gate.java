import javax.annotation.Generated;

import jdk.nashorn.internal.objects.annotations.Getter;

public class Gate {
    public boolean defeated(Prince prince) {
        return false;
    }
}

class Gate1 extends Gate {
    private int numb;
    private int cost;

    public Gate1(){
        this.numb = 0;
        this.cost = 0;
    }

    public Gate1(int numb, int cost){
        this.numb = numb;
        this.cost = cost;
    }

    @Override
    public boolean defeated(Prince prince) {
        prince.setMoney(prince.getMoney() - numb*cost);
        return prince.getMoney() > 0;
    }
}

class Gate2 extends Gate {
    private int power;

    public Gate2(){
        this.power = 0;
    }
    
    public Gate2(int power) {
        this.power = power;
    }

    @Override
    public boolean defeated(Prince prince) {
        prince.setPower(prince.getPower() - power);
        return prince.getPower() > 0;
    }
}


class Gate3 extends Gate {
    private int knowledge;

    public Gate3(){
        this.knowledge = 0;
    }
    
    public Gate3(int knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public boolean defeated(Prince prince) {
        return prince.getKnowledge() > knowledge;
    }
}