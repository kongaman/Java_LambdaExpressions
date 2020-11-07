import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        // Task:
        // sort employees by name in ascending order and print result to console

        // without lambda:
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });
//

        // lambdaStyle:
//        Collections.sort(employees, (Employee emp1, Employee emp2) ->
//                emp1.getName().compareTo(emp2.getName()));

        // lambda can determine the types, we can leave them out
        // lambdaStyle:
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));

        //Printing
        for (Employee employee : employees){
            System.out.println(employee.getName());
        }

        //Non-Lambda
//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//
//        System.out.println(sillyString);

        // Lambda 1 line
//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase(); //LE saved in variable uc so it can be reused.
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
        // Lambda multiple lines
        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        // more than 1 statement -> curly brackets needed
        // when curly brackets are used -> return keyword is needed EVEN if there is only 1 statement
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        //294 Nested Blocks
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }



    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat (String s1, String s2);
}

//294 Nested Blocks
class AnotherClass {
    public String doSomething() {
//        //Non Lambda
//        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//        return Main2.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");

        //Lambda
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expressions class's name is: " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main2.doStringStuff(uc,"String1","String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r  = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };
        new Thread(r).start();
    }

    // Variables inside the lambda have the same scope as if enclosed in {}.
    // Variables used from outside the lambda expression have to be declared final of have to be effectivly final
    // (which means that their value never changes). These variables are set when the lambda is processed by the
    // runtime and because they have to be final the runtime can do this.
}

