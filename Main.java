/* this program is Phase 1 of the Poised Management System Project, that:
    -creates a Project class and a Person class
    -creates one Project Object
    -creates 3 Person Objects
    -allows a user to input data to create these objects
    -and to edit the due date of a project, the total amount of the fee paid to date, update a contractor's contact details
    -finalise the project by printing an invoice for the outstanding fee*/

import java.util.Scanner;

public class Main {

    //update object menu method
    static String menuUpdate() {
        //declare scanner object for user input
        Scanner input = new Scanner(System.in);
        //display menu options
        System.out.println("\n");
        System.out.println("""
                Choose an option by typing the code:
                due - change project due date
                pai - change fee paid to date
                con - update contractor's contact details
                fin - finalise project""");
        //store user input
        return input.next();
    }

    public static void main(String[] args) {
        //declare counter to loop user input when creating Person objects
        int count = 0;

        //declare variables to store user input and pass as parameters to create objects
        String projectName;
        int projectNum;
        String buildingType;
        String projectAddress;
        int erf;
        double totalFee;
        double totalPaid;
        String deadline;

        String personName;
        String telephone;
        String email;
        String personAddress;

        //declare scanner object for all user input
        Scanner input = new Scanner(System.in);


        //get user input to create Project object
        System.out.println("Let's capture your PROJECT details below:");
        System.out.println("Enter Project Name:");
        projectName = input.nextLine();
        System.out.println("Enter Project Number:");
        projectNum = input.nextInt();
        input.nextLine(); // This consumes the \n character because nextInt only consumes the int
        System.out.println("Enter Building Type:");
        buildingType = input.nextLine();
        System.out.println("Enter Project Address:");
        projectAddress = input.nextLine();
        System.out.println("Enter ERF Number:");
        erf = input.nextInt();
        input.nextLine();
        System.out.println("Enter Total Fee of Project:");
        totalFee = input.nextDouble();
        System.out.println("Enter Total Paid, to date:");
        totalPaid = input.nextDouble();
        input.nextLine(); // This consumes the \n character because nextDouble only consumes the double
        System.out.println("Enter due date:");
        deadline = input.nextLine();

        //initiate new project object;
        Project testProject = new Project(projectName, projectNum, buildingType, projectAddress, erf, totalFee, totalPaid, deadline);

        //display Project info for testing toString method in class
        System.out.println(testProject);

        //initiate empty Person objects
        Person architect = null;
        Person contractor = null;
        Person customer = null;

        //loop user input 3 times to assign to each person object
        while (count < 3) {
            count++;

            //get user input to create 3 Person objects (architect,contractor,customer)
            if (count == 1)
                System.out.println("\nLet's capture your Architect details below:");
            if (count == 2)
                System.out.println("\nLet's capture your Contractor details below:");
            if (count == 3)
                System.out.println("\nLet's capture your Customer details below:");

            System.out.println("Enter Person Name:");
            personName = input.nextLine();
            System.out.println("Enter Telephone Number:");
            telephone = input.nextLine();
            System.out.println("Enter Email Address:");
            email = input.nextLine();
            System.out.println("Enter Physical Address:");
            personAddress = input.nextLine();

            //update new person object;
            if (count == 1) {
                architect = new Person(personName, telephone, email, personAddress);
            }
            if (count == 2) {
                contractor = new Person(personName, telephone, email, personAddress);
            }
            if (count == 3) {
                customer = new Person(personName, telephone, email, personAddress);
            }
        }

        //display Person info for testing toString method in class
        System.out.println(architect);
        System.out.println(contractor);
        System.out.println(customer);

        //display update menu
        String choiceUpdate = menuUpdate();

        if (choiceUpdate.equals("due")) {
            System.out.println("Enter due date:");
            String newDeadline = input.nextLine();

            //set new value
            testProject.deadline = newDeadline;

            //display updated info
            System.out.println("\nThe details have been updated:");
            System.out.println(testProject);
        }

        else if (choiceUpdate.equals("pai")) {
            System.out.println("Enter Total Paid, to date:");
            double newTotalPaid = input.nextDouble();

            //set new value
            testProject.totalPaid = newTotalPaid;

            //display updated info
            System.out.println("\nThe details have been updated:");
            System.out.println(testProject);
        }

        else if (choiceUpdate.equals("con")) {
            System.out.println("Enter Telephone Number:");
            String newTelephone = input.nextLine();

            //set new tel num
            contractor.telephone = newTelephone;

            //display updated info
            System.out.println("\nThe details have been updated:");
            System.out.println(contractor);
        }

        else if (choiceUpdate.equals("fin")) {
            if (testProject.totalFee - testProject.totalPaid == 0) {
                System.out.println("This project has been fully paid and finalised.");
            }

            else {
                System.out.println("INVOICE FOR:" + customer.name);
                System.out.println("");
                System.out.println("Telephone: " + customer.telephone);
                System.out.println("Total amount payable: R" + (testProject.totalFee - testProject.totalPaid));
            }
        }

    }
}
