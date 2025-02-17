
Link banner.md file to the Spring Boot application
Link: https://patorjk.com/software/taag/#p=display&h=1&v=0&f=ANSI%20Shadow&t=ORDER%20SERVICE

 ██████╗ ██████╗ ██████╗ ███████╗██████╗     ███████╗███████╗██████╗ ██╗   ██╗██╗ ██████╗███████╗
██╔═══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗    ██╔════╝██╔════╝██╔══██╗██║   ██║██║██╔════╝██╔════╝
██║   ██║██████╔╝██║  ██║█████╗  ██████╔╝    ███████╗█████╗  ██████╔╝██║   ██║██║██║     █████╗
██║   ██║██╔══██╗██║  ██║██╔══╝  ██╔══██╗    ╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██║██║     ██╔══╝
╚██████╔╝██║  ██║██████╔╝███████╗██║  ██║    ███████║███████╗██║  ██║ ╚████╔╝ ██║╚██████╗███████╗
 ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═╝    ╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚═╝ ╚═════╝╚══════╝

${AnsiColor.BRIGHT_BLUE}
MODULE ${application.title} ${application.version}
Powered by Spring Boot ${spring-boot.version}
Profile : ${spring.profiles.active}
Port    : ${server.port}

${application.title} URL : http://${server.instance.hostname}:${server.port}/
+ http://${server.instance.hostname}:${server.port}/actuator/
+ http://${server.instance.hostname}:${server.port}/swagger-ui.html
+ http://${server.instance.hostname}:${server.port}/v3/api-docs
+ http://${server.instance.hostname}:${server.port}/h2-console
+ http://${server.instance.hostname}:${server.port}/health
+ http://${server.instance.hostname}:${server.port}/info
+ http://${server.instance.hostname}:${server.port}/metrics
+ http://${server.instance.hostname}:${server.port}/loggers
+ http://${server.instance.hostname}:${server.port}/heapdump
+ http://${server.instance.hostname}:${server.port}/threaddump
+ http://${server.instance.hostname}:${server.port}/flyway
+ http://${server.instance.hostname}:${server.port}/api/orders/
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/{userId}
+ http://${server.instance.hostname}:${server.port}/api/orders/exists/{id} 
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/cancel
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/complete
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/payment
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/payment/{paymentId}
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/payment/{paymentId}/cancel
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/payment/{paymentId}/complete
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/payment/{paymentId}/refund
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/payment/{paymentId}/refund/{refundId}
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/refund
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/refund/{refundId}
+ http://${server.instance.hostname}:${server.port}/api/orders/{id}/refund/{refundId}/cancel


instance-id: ${spring.application.name}:${spring.application.instance_id:${random.value}
