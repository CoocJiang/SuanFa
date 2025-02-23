package A_leetcode.笔试;

import java.util.ArrayList;
import java.util.List;


//author：江也扬
public class 江也扬神州笔试 {
    public static class EmployeeSalary {
        Long id;
        String employeeName;
        String salary;
        String salaryAfterTax;

        public EmployeeSalary(Long id, String employeeName, String salary) {
            this.id = id;
            this.employeeName = employeeName;
            this.salary = salary;
        }
        //补充的get和set函数，方便数据存取
        public void setId(Long id) {
            this.id = id;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public void setSalaryAfterTax(String salaryAfterTax) {
            this.salaryAfterTax = salaryAfterTax;
        }

        public Long getId() {
            return id;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public String getSalary() {
            return salary;
        }

        public String getSalaryAfterTax() {
            return salaryAfterTax;
        }
    }
    public static class TaxTable {
        private int lowSalary; //工资下界
        private int upSalary; //工资上界
        private double taxRate; //税率

        public TaxTable(int lowSalary, int upSalary, double taxRate) {
            this.lowSalary = lowSalary;
            this.upSalary = upSalary;
            this.taxRate = taxRate;
        }

        public int getLowSalary() {
            return lowSalary;
        }

        public int getUpSalary() {
            return upSalary;
        }

        public double getTaxRate() {
            return taxRate;
        }
    }



    public static class SalaryCalculator {
        public void calSalaryAfterTax(List<EmployeeSalary> salaryList, List<TaxTable> taxTable) {
            // 请填写计算方法，将税后工资计算结果放到salaryAfterTax字段中
            for (EmployeeSalary employee : salaryList) {
                //这里有精度要求的话还可以使用bigdecimal包装
                double salary = Double.parseDouble(employee.getSalary());
                double tax = calculateTax(salary, taxTable);
                //工资减去税金得到员工的税后工资
                double salaryAfterTax = salary - tax;
                //更新税后工资
                employee.setSalaryAfterTax(String.valueOf(salaryAfterTax));
            }
        }

        //根据工资计算某个员工的税金
        private double calculateTax(double salary, List<TaxTable> taxTable) {
            double tax = 0;
            //循环taxtable根据税率表计算税金
            for (TaxTable taxBracket : taxTable) {
                if (salary > taxBracket.getUpSalary()) {
                    tax += (taxBracket.getUpSalary() - taxBracket.getLowSalary()) * taxBracket.getTaxRate();
                } else {
                    tax += (salary - taxBracket.getLowSalary()) * taxBracket.getTaxRate();
                    break;
                }
            }
            return tax;
        }
    }
    public static void main(String[] args) {
        //根据题目数据创建税率表
        //这部分税率手动生成仅为了测试方便
        List<TaxTable> taxTable = new ArrayList<>();
        taxTable.add(new TaxTable(0, 1000, 0));
        taxTable.add(new TaxTable(1000, 10000, 0.1));
        taxTable.add(new TaxTable(10000, 20000, 0.2));
        taxTable.add(new TaxTable(20000, Integer.MAX_VALUE, 0.3));

        //根据题目数据创建员工数据
        List<EmployeeSalary> employees = new ArrayList<>();
        employees.add(new EmployeeSalary(1L, "Tony", "15000"));
        employees.add(new EmployeeSalary(2L, "Pronub", "21300"));
        employees.add(new EmployeeSalary(3L, "Tyrrox", "10800"));
        employees.add(new EmployeeSalary(4L, "Pam", "300"));
        employees.add(new EmployeeSalary(5L, "Bassem", "450"));
        employees.add(new EmployeeSalary(6L, "Hermione", "700"));
        employees.add(new EmployeeSalary(7L, "Bocaben", "100"));
        employees.add(new EmployeeSalary(8L, "Ognjen", "2200"));
        employees.add(new EmployeeSalary(9L, "Nyancat", "3300"));
        employees.add(new EmployeeSalary(10L, "Morninngcat", "7777"));
        //传入手动生成的数据计算税后工资
        SalaryCalculator calculator = new SalaryCalculator();
        //根据实际情况传入需要的员工表和税率表
        calculator.calSalaryAfterTax(employees, taxTable);
        //打印计算结果
        for (EmployeeSalary employee : employees) {
            System.out.print(employee.getEmployeeName());
            System.out.print("税后工资：");
            System.out.print(employee.salaryAfterTax);
            System.out.print("税前工资：");
            System.out.println(employee.salary);
        }
    }
}
