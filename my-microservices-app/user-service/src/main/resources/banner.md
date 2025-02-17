
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

+ http://${server.instance.hostname}:${server.port}/
+ http://${server.instance.hostname}:${server.port}/actuator/
+ http://${server.instance.hostname}:${server.port}/swagger-ui.html
+ http://${server.instance.hostname}:${server.port}/v3/api-docs
+ http://${server.instance.hostname}:${server.port}/h2-console
+ http://${server.instance.hostname}:${server.port}/api/users
+ http://${server.instance.hostname}:${server.port}/api/users/{id}
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles/{roleId}
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/permissions
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/permissions/{permissionId}
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles/{roleId}/permissions
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles/{roleId}/permissions/{permissionId}
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles/{roleId}/permissions/{permissionId}/granted
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles/{roleId}/permissions/{permissionId}/revoked
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles/{roleId}/permissions/{permissionId}/granted/{granted}
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles/{roleId}/permissions/{permissionId}/revoked/{revoked}
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles/{roleId}/permissions/{permissionId}/granted/{granted}/revoked/{revoked}
+ http://${server.instance.hostname}:${server.port}/api/users/{id}/roles/{roleId}/permissions/{permissionId}/granted/{granted}/revoked/{revoked}/granted