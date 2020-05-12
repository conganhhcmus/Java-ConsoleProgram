public class Prince {
    private int money;
    private int power;
    private int knowledge;

    /**
     * @return the knowledge
     */
    public int getKnowledge() {
        return knowledge;
    }

    /**
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * @param knowledge the knowledge to set
     */
    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }
    
    /**
     * @param power the power to set
     */
    public void setPower(int power) {
        this.power = power;
    }

    public Prince() {
        this.money = 0;
        this.power = 0;
        this.knowledge = 0;
    }

    public Prince(int money, int power, int knowledge) {
        this.money = money;
        this.power = power;
        this.knowledge = knowledge;
    }

}