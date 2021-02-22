package ru.dsoshnev.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //DemoBean bean = context.getBean(DemoBean.class);
        //System.out.format("%s",bean);

        ProductService productService = context.getBean(ProductService.class);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(">");
            String cmd = sc.nextLine();
            args = cmd.split(" ");
            String str = "";
            if(args.length > 0 ) {
                switch (args[0]) {
                    case "/avg":
                        str += productService.calculateAverageCost();
                        break;
                    case "/count":
                        str += productService.calculateCount();
                        break;
                    case "/save":
                        productService.save(
                                new Product(
                                        Long.valueOf(args[1]),
                                        args[2],
                                        Double.valueOf(args[3])));
                        break;
                    case "/findAll":
                        str += productService.findAll();
                        break;
                    case "/findById":
                        Optional<Product> product = productService.findById(Long.valueOf(args[1]));
                        if(product.isEmpty()) {
                            str += "product not found";
                        } else {
                            str += product.get();
                        }
                        break;
                    case "/findAllById":
                        str += productService.findAllById(Stream.of(args)
                                .skip(1)
                                .map(Long::valueOf)
                                .collect(Collectors.toList()));
                        break;
                    case "/exit":
                        context.close();
                        System.exit(0);
                    default:
                        str += "wrong command";
                }
                System.out.println(str);
            }
        }

    }
}
