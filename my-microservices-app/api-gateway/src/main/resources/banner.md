
Link banner.txt file to the Spring Boot application
link: https://patorjk.com/software/taag/#p=display&h=1&v=0&f=ANSI%20Shadow&t=API%20GATEWAY
${AnsiColor.BRIGHT_BLUE}
${AnsiStyle.BOLD}
${AnsiStyle.FAINT}

 █████╗ ██████╗ ██╗     ██████╗  █████╗ ████████╗███████╗██╗    ██╗ █████╗ ██╗   ██╗
██╔══██╗██╔══██╗██║    ██╔════╝ ██╔══██╗╚══██╔══╝██╔════╝██║    ██║██╔══██╗╚██╗ ██╔╝
███████║██████╔╝██║    ██║  ███╗███████║   ██║   █████╗  ██║ █╗ ██║███████║ ╚████╔╝
██╔══██║██╔═══╝ ██║    ██║   ██║██╔══██║   ██║   ██╔══╝  ██║███╗██║██╔══██║  ╚██╔╝
██║  ██║██║     ██║    ╚██████╔╝██║  ██║   ██║   ███████╗╚███╔███╔╝██║  ██║   ██║
╚═╝  ╚═╝╚═╝     ╚═╝     ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚══════╝ ╚══╝╚══╝ ╚═╝  ╚═╝   ╚═╝

${AnsiColor.BRIGHT_BLUE}
MODULE ${application.title} ${application.version}
Powered by Spring Boot ${spring-boot.version}
Profile : ${spring.profiles.active}
Porta   : ${server.port}
${application.title} URL : http://${server.instance.hostname}:${server.port}
+ http://${server.instance.hostname}:${server.port}/swagger-ui.html
+ http://${server.instance.hostname}:${server.port}/actuator/
+ http://${server.instance.hostname}:${server.port}/actuator/info
+ http://${server.instance.hostname}:${server.port}/actuator/health
+ http://${server.instance.hostname}:${server.port}/v2/api-docs