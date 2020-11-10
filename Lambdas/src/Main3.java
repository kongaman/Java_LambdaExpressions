import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

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


        // Suppliers
        //===========
        System.out.println("\n\nSuppliers Demo Start");
        //without Lambda
        System.out.println("Without Supplier");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(1000));
        }
        //using Supplier
        System.out.println("With Supplier");
        Random random2 = new Random();
        Supplier<Integer> randomSupplier = () -> random2.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') +1);
            System.out.println("Last name is: " + lastName);
        });
        // use Function interface to do the above
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') +1);
        };
        // Function<1stType, 2ndType>
        // 1stType = argument Type (Employee)
        // 2ndType = return Type (String)

        String lastName = getLastName.apply((employees.get(1)));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0,employee.getName().indexOf(' '));
        };

        Random rand = new Random();
        // Print first or last name at random
        for(Employee employee : employees){
            if(rand.nextBoolean()){
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println((getAName(getLastName, employee)));
            }
        }

        // Chaining Functions
        System.out.println("\n\nChaining Functions");
        System.out.println("==================");
        // Turn employee name to uppercase and the get the first name only
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chainFunction = upperCase.andThen(firstName);
        System.out.println(chainFunction.apply(employees.get(1)));
        System.out.println("\n");

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName,employees.get(0)));

        // Unary Operators incl. chaining
        System.out.println("\n");
        System.out.println("IntUnaryOperator");
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        // Flatmap Example
        System.out.println("\nFlatMap");
        System.out.println("=======");
        Employee john1 = new Employee("John Doe", 30);
        Employee jane1 = new Employee("Jane Deer", 25);
        Employee jack1 = new Employee("Jack Hill", 40);
        Employee snow1 = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane1);
        hr.addEmployee(jack1);
        hr.addEmployee(snow1);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john1);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
            .flatMap(department -> department.getEmployees().stream())
            .forEach(System.out::println);

    }

    private static String getAName(Function<Employee,String> getname, Employee employee) {
        return getname.apply(employee);
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

