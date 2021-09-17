public class Project {

    // Attributes
    String name;
    int projectNum;
    String buildingType;
    String address;
    int erf;
    double totalFee;
    double totalPaid;
    String deadline;

    //Constructor
    public Project(String name, int projectNum, String buildingType, String address,
                   int erf, double totalFee, double totalPaid, String deadline) {
        this.name = name;
        this.projectNum = projectNum;
        this.buildingType = buildingType;
        this.address = address;
        this.erf = erf;
        this.totalFee = totalFee;
        this.totalPaid = totalPaid;
        this.deadline = deadline;
    }

    //toString method to return data
    public String toString() {
        String projectData = "";
        projectData = "\nProject Name: " + name;
        projectData += "\nProject Number: " + projectNum;
        projectData += "\nBuilding Type: " + buildingType;
        projectData += "\nProject Address: " + address;
        projectData += "\nProject ERF number: " + erf;
        projectData += "\nTotal Fee: R " + totalFee;
        projectData += "\nTotal Paid: R " + totalPaid;
        projectData += "\nProject Deadline: " + deadline;

        return projectData;
    }

}