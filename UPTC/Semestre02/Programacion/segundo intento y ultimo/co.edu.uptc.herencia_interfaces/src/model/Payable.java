package model;

import java.text.DecimalFormat;

public interface Payable {

    DecimalFormat df = new DecimalFormat("$#,###.00");
    public final double salaryMin = 1423500;
    public final double auxTrans = 200000;
    public double calculateSalary();
    public double calculateAuxTrans();
    public double calculateSalaryFinal();
    public double calculateHealth();
    public double calculateRetirement();
    public double calculateLateHours();
    public double calculateNigthHours();
    public double calculateSundayHours();
}
