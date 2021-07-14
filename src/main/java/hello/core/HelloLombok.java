package hello.core;

import lombok.Data;

@Data
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("minjae");
        helloLombok.setAge(10);


        String name = helloLombok.getName();
        int age = helloLombok.getAge();

        System.out.println(name);
        System.out.println(age);
    }
}
