
Link banner.md file to the Spring Boot application
Link Banner: https://patorjk.com/software/taag/#p=display&h=1&v=0&f=ANSI%20Shadow&t=SERVICE%20REGISTRY
${AnsiColor.GREEN}

███████╗███████╗██████╗ ██╗   ██╗██╗ ██████╗███████╗    ██████╗ ███████╗ ██████╗ ██╗███████╗████████╗██████╗ ██╗   ██╗
██╔════╝██╔════╝██╔══██╗██║   ██║██║██╔════╝██╔════╝    ██╔══██╗██╔════╝██╔════╝ ██║██╔════╝╚══██╔══╝██╔══██╗╚██╗ ██╔╝
███████╗█████╗  ██████╔╝██║   ██║██║██║     █████╗      ██████╔╝█████╗  ██║  ███╗██║███████╗   ██║   ██████╔╝ ╚████╔╝
╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██║██║     ██╔══╝      ██╔══██╗██╔══╝  ██║   ██║██║╚════██║   ██║   ██╔══██╗  ╚██╔╝  
███████║███████╗██║  ██║ ╚████╔╝ ██║╚██████╗███████╗    ██║  ██║███████╗╚██████╔╝██║███████║   ██║   ██║  ██║   ██║   
╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚═╝ ╚═════╝╚══════╝    ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═╝

${AnsiColor.DEFAULT}
MODULE ${application.title} ${application.version}
Powered by Spring Boot ${spring-boot.version}
Profile : ${spring.profiles.active}
Porta   : ${server.port}

${AnsiColor.BRIGHT_BLUE} 
${application.title} URL Eureka Dashboard: + http://${server.instance.hostname}:${server.port}
+ http://${server.instance.hostname}:${server.port}/eureka/
+ http://${server.instance.hostname}:${server.port}/actuator/
+ http://${server.instance.hostname}:${server.port}/swagger-ui.html
+ http://${server.instance.hostname}:${server.port}/v2/api-docs
+ http://${server.instance.hostname}:${server.port}/h2-console
+ http://${server.instance.hostname}:${server.port}/favicon.ico
+ http://${server.instance.hostname}:${server.port}/health
+ http://${server.instance.hostname}:${server.port}/info
+ http://${server.instance.hostname}:${server.port}/metrics
+ http://${server.instance.hostname}:${server.port}/loggers
+ http://${server.instance.hostname}:${server.port}/heapdump
+ http://${server.instance.hostname}:${server.port}/threaddump
+ http://${server.instance.hostname}:${server.port}/env
+ http://${server.instance.hostname}:${server.port}/configprops
+ http://${server.instance.hostname}:${server.port}/mappings
+ http://${server.instance.hostname}:${server.port}/beans
+ http://${server.instance.hostname}:${server.port}/auditevents
+ http://${server.instance.hostname}:${server.port}/jolokia
+ http://${server.instance.hostname}:${server.port}/liquibase
+ http://${server.instance.hostname}:${server.port}/flyway

