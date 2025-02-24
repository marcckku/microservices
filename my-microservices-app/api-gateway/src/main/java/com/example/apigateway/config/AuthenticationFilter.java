package com.example.apigateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthenticationFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        // verifico se l'endpoint richiede il token
        if(routeValidator(request)) {
            exchange.getResponse().setStatusCode(HttpStatus.OK);
        }
        return chain.filter(exchange);
    }





    //Se nella ServerRequest troviamo : v0 -> token non è ok
    //Se nella ServerRequest troviamo : v1 -> token  è ok -> [ADMIN]
    //Se nella ServerRequest troviamo : v2 -> token  è ok -> [WRITER]
    //Se nella ServerRequest troviamo : v3 -> token  è ok -> [MEMBER]
    //Se nella ServerRequest troviamo : v4 -> token  è ok -> [MODERATOR]
    //ETC...

    /**
     * Controlla che l'URL stratto da {@link ServerHttpRequest} inviato dai Microservizi
     * abbiano un Ruolo specifico per poter fare qualche operazione.
     *
     *  (v0 || ms-auth) -> endPoint non è ok
     *  //RUOLI AMMESSI
     *  v1              -> endPoint  è ok -> [ADMIN]
     *  v2              -> endPoint  è ok -> [WRITER] //WRITER è il Ruolo che puo' fare operazioni sul POST.
     *  v3              -> endPoint  è ok -> [MEMBER]
     *  v4              -> endPoint  è ok -> [MODERATOR]
     *
     * che un User sia un WRITTER attraverso l'url che arriva dovra contenere
     *
     *
     * @param httpRequest contiene l'Url inviato dal Microservizio corrente
     * @return true se nel URL viene trovato un Ruolo ammesso false altriemnti.
     */

    /**
     * Se è vero allora l'url passato non ha bisogno di un Token ad esempio quando si vuole
     * fare la Registrazione User.
     *
     * @param httpRequest contiene l'url
     * @return true se l'Url passato è libero a tutti gli Utenti anonimo false se invece si tratta di un User con Ruolo
     */
    public boolean routeValidator(ServerHttpRequest httpRequest){
        return httpRequest.getURI().getPath().contains("v0")
                || httpRequest.getURI().getPath().contains("user-service")
                || httpRequest.getURI().getPath().contains("actuator");
    }
}
