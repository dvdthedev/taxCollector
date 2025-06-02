package model;

public class Company extends TaxPayer{
    private int numberOfEmployees;

    public Company(String name, Double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
        this.totalTaxes = 0;
        this.tax();
    }

    @Override
    public void tax(){
        int taxRatio = 16;
        if(this.numberOfEmployees >= 10){
            taxRatio = 14;
        }
        double result = (this.anualIncome * taxRatio / 100);
        if(result > 0.0){
            this.totalTaxes = result;
        }
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
