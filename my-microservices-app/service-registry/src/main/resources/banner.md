
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
${application.title} URL Eureka Dashboard:
+ http://${server.instance.hostname}:${server.port}/
+ http://${server.instance.hostname}:${server.port}/actuator/
+ http://${server.instance.hostname}:${server.port}/actuator/health
+ http://${server.instance.hostname}:${server.port}/actuator/info
+ http://${server.instance.hostname}:${server.port}/v3/api-docs