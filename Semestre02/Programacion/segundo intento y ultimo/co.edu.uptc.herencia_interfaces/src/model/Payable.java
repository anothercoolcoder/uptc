package model;

import java.text.DecimalFormat;

public interface Payable {

    DecimalFormat df = new DecimalFormat("$#,###.00");
      double salaryMin = 1423500;
      double auxTrans = 200000;
     double calculateSalary();
     double calculateAuxTrans();
     double calculateSalaryFinal();
     double calculateHealth();
     double calculateRetirement();
     double calculateLateHours();
     double calculateNigthHours();
     double calculateSundayHours();
}
