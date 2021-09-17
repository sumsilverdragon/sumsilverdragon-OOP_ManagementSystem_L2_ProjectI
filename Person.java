public class Person {

    // Attributes
    String name;
    String telephone;
    String email;
    String address;

    //Constructor
    public Person(String name, String telephone, String email, String address) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    //toString method to return data
    public String toString() {
        String personData = "";
        personData = "\nName: " + name;
        personData += "\nTelephone Number: " + telephone;
        personData += "\nEmail Address: " + email;
        personData += "\nPhysical Address: " + address;

        return personData;
    }

}
