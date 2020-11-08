import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main3 {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        System.out.println("Employees over 30");
        System.out.println("=================");
        //lambda
        System.out.println("Lambda:");
        employees.forEach(employee -> {
            if (employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });
        System.out.println("");
        //Enhanced for-loop
        System.out.println("Enhanced for-loop:");
        for (Employee employee : employees) {
            if (employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        }
        System.out.println("");
        //using printEmployeesByAge method
        System.out.println("using printEmployeesByAge method:");
        // using lambda that matches Predictae criteria
        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        // using anonymous class
        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        System.out.println("IntPredicates");
        IntPredicate greaterThan15 = i -> i>15;
        IntPredicate lessThan100 = i -> i <100;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a+5));
        //chaining Predicates
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

    }

    private static void printEmployeesByAge (List<Employee> employees,
                                             String ageText,
                                             Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("=================");
        for (Employee employee : employees) {
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}

