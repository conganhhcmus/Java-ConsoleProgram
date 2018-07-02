package conganh.hcmus;

import java.io.Serializable;

public class Staff implements Serializable {
    Person person;
    int fixedSalary;
    int bonus;
    int fine;
    int salaryReceived;

    public Staff(Person person, int fixedSalary, int bonus, int fine) {
        this.person = person;
        this.fixedSalary = fixedSalary;
        this.bonus = bonus;
        this.fine = fine;
        this.salaryReceived = fixedSalary + bonus - fine;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getSalaryReceived() {
        return salaryReceived;
    }

    @Override
    public String toString() {
        return person.toString() +
                "\nFixed Salary : " + fixedSalary +
                "\nBonus : " + bonus +
                "\nFine : " + fine +
                "\nSalary Received : " + salaryReceived;
    }
}
