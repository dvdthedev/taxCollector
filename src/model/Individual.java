package model;

public class Individual extends TaxPayer{
    private double healthExpenditures;
    public Individual(String name, Double anualIncome,  double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
        this.totalTaxes = 0;
        tax();
    }

    @Override
    public void tax(){
        int taxRatio = 15;
        if(this.anualIncome > 20000.00){
            taxRatio = 25;
        }
        double result = (anualIncome * taxRatio / 100) - (healthExpenditures / 2);
        if (result > 0.0){
            this.totalTaxes = result;
        }
    }
}
