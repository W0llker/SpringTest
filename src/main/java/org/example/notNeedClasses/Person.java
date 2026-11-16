package org.example.notNeedClasses;

//@Component("person")
public class Person {
    //    @Autowired
//    @Qualifier("car")
    private Vehicle vehicle;
    private Dog dog;


    public Person(Vehicle vehicle, Dog dog) {
        this.vehicle = vehicle;
        this.dog = dog;
        System.out.println("Person bean create");
    }

//    @Autowired
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    public void startVehicleEngine() {
        System.out.println("Person is starting vehicle engine");
        vehicle.startEngine();
    }

    public void callPet() {
        System.out.println("Person call pet");
        System.out.println(dog.getName());
    }
}
