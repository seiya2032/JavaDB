package app;

import app.service.ProductService;

public class Main {

    public static void main(String[] args) {
        var userService = new ProductService();
        var userList = userService.findByid();
        userList.stream().forEach(System.out::println);
    }
}
