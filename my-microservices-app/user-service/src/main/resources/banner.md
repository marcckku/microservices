
Link banner.md file to the Spring Boot application
Link: https://patorjk.com/software/taag/#p=display&h=1&v=0&f=ANSI%20Shadow&t=USER%20SERVICE

██╗   ██╗███████╗███████╗██████╗     ███████╗███████╗██████╗ ██╗   ██╗██╗ ██████╗███████╗
██║   ██║██╔════╝██╔════╝██╔══██╗    ██╔════╝██╔════╝██╔══██╗██║   ██║██║██╔════╝██╔════╝
██║   ██║███████╗█████╗  ██████╔╝    ███████╗█████╗  ██████╔╝██║   ██║██║██║     █████╗
██║   ██║╚════██║██╔══╝  ██╔══██╗    ╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██║██║     ██╔══╝
╚██████╔╝███████║███████╗██║  ██║    ███████║███████╗██║  ██║ ╚████╔╝ ██║╚██████╗███████╗
 ╚═════╝ ╚══════╝╚══════╝╚═╝  ╚═╝    ╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚═╝ ╚═════╝╚══════╝

${AnsiColor.BRIGHT_BLUE}
MODULE ${application.title} ${application.version}
Powered by Spring Boot ${spring-boot.version}
Profile : ${spring.profiles.active}
Port    : ${server.port}

${application.title} URL USER SERVICE :
+ http://${server.instance.hostname}:${server.port}/
+ http://${server.instance.hostname}:${server.port}/api/users
+ http://${server.instance.hostname}:${server.port}/actuator
+ http://${server.instance.hostname}:${server.port}/actuator/health
+ http://${server.instance.hostname}:${server.port}/actuator/info
+ http://${server.instance.hostname}:${server.port}/swagger-ui.html
+ http://${server.instance.hostname}:${server.port}/v3/api-docs
