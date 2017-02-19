package com.example;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by leesunghee on 2017. 2. 11..
 */
@EnableAutoConfiguration
//@Import(AppConfig.class)
@ComponentScan
public class App implements CommandLineRunner {

//    @Autowired
//    ArgumentResolver argumentResolver;
//
//    @Autowired
//    Calculator calculator;

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
//        try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
//            Frontend frontend = context.getBean(Frontend.class);
//            frontend.run();
//        }

        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Enter 2 numbers like 'a b' : ");
//        Argument argument = argumentResolver.resolve(System.in);
//        int result = calculator.calc(argument.getA(), argument.getB());
//        System.out.println("result = " + result);

//        customerService.save(new Customer(1, "Nobita", "Nobi"));
//        customerService.save(new Customer(2, "sunghee", "Lee"));
//        customerService.save(new Customer(3, "kyunghee", "Choi"));
//
//        customerService.findAll().forEach(System.out::println);


        String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", 1);
        Customer result = jdbcTemplate.queryForObject(sql, param, (rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name")));
        System.out.println("result = " + result);

    }
}
