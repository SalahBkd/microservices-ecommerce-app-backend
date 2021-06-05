package me.salahbkd.eurekadiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscoveryApplication.class, args);
    }

    /*
    * Par défaut les micro-services s'enregistrent chez eurêka server avec  le nom de la machine et
    * non pas l'adresse IP. Ce qui fait que quand vous être en réseaux et si le nom de votre machine
    * contient des caractères non admis par la convention des noms de domaine. ce qui est souvent le vas,
    * le service Gateway n'arrive pas à contacter le micro-service avec le nom du host. Pour éviter ce problème,
    *  il est très recommandé d'ajouter la proporiété : eureka.instance.preferIpAddress=true
    *  dans les tous les fichiers application.properties de tous les micro-services.
    * c'est pour demander à Eureka client discovery d'enregistrer le micro-services chez eureka server
    * avec l'adresse IP et non pas le nom de la machine
    *
    * */
}
