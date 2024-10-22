package pe.edu.cibertec.app_hoteles_reserva_pena.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.app_hoteles_reserva_pena.service.ReservacionService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/reservacion")
public class ReservacionController {

    private final ReservacionService reservacionService;

    @GetMapping
    @CircuitBreaker(name = "myService", fallbackMethod = "fallBackMethod")
    public String verificarDisponibilidad(){

        return reservacionService.verificaDisponibilidad();
    }

    public String fallBackMethod(Throwable throwable){
        return "El servicio de disponibilidad no está disponible en este momento. Por favor, inténtelo más tarde.";
    }

    @GetMapping("/publico")
    public String privateApi(){
        return "Servicio protegido. Ingresa tus datos para acceder al servicio.";
    }
    @GetMapping("/privado")
    public String publicApi(){

        return "Bienvenido al servicio de reserva de hoteles.";
    }

}
