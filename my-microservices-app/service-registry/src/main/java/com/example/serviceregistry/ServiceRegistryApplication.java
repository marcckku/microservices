package com.example.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//@EnableCircuitBreaker
public class ServiceRegistryApplication{

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);

//         SpringApplication app = new SpringApplication(ServiceRegistryApplication.class);
//         app.setBanner((environment, sourceClass, out) -> {
//             out.println(AnsiColor.BRIGHT_BLUE);
//             out.println(
//                     "███████╗███████╗██████╗ ██╗   ██╗██╗ ██████╗███████╗    ██████╗ ███████╗ ██████╗ ██╗███████╗████████╗██████╗ ██╗   ██╗  \n" +
//                     "██╔════╝██╔════╝██╔══██╗██║   ██║██║██╔════╝██╔════╝    ██╔══██╗██╔════╝██╔════╝ ██║██╔════╝╚══██╔══╝██╔══██╗╚██╗ ██╔╝  \n" +
//                     "███████╗█████╗  ██████╔╝██║   ██║██║██║     █████╗      ██████╔╝█████╗  ██║  ███╗██║███████╗   ██║   ██████╔╝ ╚████╔╝   \n" +
//                     "╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██║██║     ██╔══╝      ██╔══██╗██╔══╝  ██║   ██║██║╚════██║   ██║   ██╔══██╗  ╚██╔╝    \n" +
//                     "███████║███████╗██║  ██║ ╚████╔╝ ██║╚██████╗███████╗    ██║  ██║███████╗╚██████╔╝██║███████║   ██║   ██║  ██║   ██║     \n" +
//                     "╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚═╝ ╚═════╝╚══════╝    ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═╝     \n");
//
//             out.println("${AnsiColor.BRIGHT_BLUE}");
//             out.println( environment.getProperty("application.title") + " " + environment.getProperty("application.version"));
//             out.println("Powered by Spring Boot " + environment.getProperty("spring-boot.version"));
//             out.println("Profile - " + environment.getProperty("spring.profiles.active"));
//             out.println("Port - " + environment.getProperty("server.port"));
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/eureka/");
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/swagger-ui/");
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/actuator/");
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/actuator/health");
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/actuator/info");
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/actuator/prometheus");
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/actuator/metrics");
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/actuator/httptrace");
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/actuator/loggers");
//             out.println("http://" + environment.getProperty("server.instance.hostname") + ":" + environment.getProperty("server.port") + "/actuator/threaddump");
//         });
//         app.run(args);

    }



}