package pe.edu.cibertec.app_hoteles_reserva_pena.service;

import org.springframework.stereotype.Service;

@Service
public class ReservacionService {

    //Revisa si el hotel se encuentra disponible para realizar una reserva.
    public String verificaDisponibilidad(){
        if (Math.random() > 0.5){
            throw new RuntimeException("Servicio de consulta no disponible");
        }
        return "Disponibilidad confirmada para el hotel seleccionado";
    }

}
