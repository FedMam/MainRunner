package com.company;

public class Main1 {

    public static void main(String[] args)
    {
        System.out.println("Main1 executed");
        Main1 main1;
        if (args.length > 0)
            main1 = new Main1(args[0]);
        else main1 = new Main1(Main2.sayHello());
        System.out.println(main1);
    }

    public String name;

    public Main1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Main1{" +
                "name='" + name + '\'' +
                '}';
    }
}
