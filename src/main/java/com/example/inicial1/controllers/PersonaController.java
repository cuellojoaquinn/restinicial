package com.example.inicial1.controllers;

import com.example.inicial1.dtos.PersonaDto;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.PersonaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController //Esto va a ser un controlador
@RequestMapping("/personas") //Permite derivarme para el verbo GET, POST, PUT, DELETE
public class PersonaController {
 //  @Autowired
//PersonaServices servicio;
    //Toma como solicitud /personas. El protocolo presume que es un GET
    @GetMapping("")
    //ResponseEntity analiza el tipo de peticion.
    public ResponseEntity<?> getAll(){ //La ResponseEntity es de cualquier tipo por generics
        try{
            return ResponseEntity.status(HttpStatus.OK). //EL OK con POSTMAN devuelve un 200
                    body("Busqué todos los datos"); //El servidor muestra todo los daots pero es mentira esta jugando con los datos
        }
        catch (Exception e){
            //Retorna Body de HTTP
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }



    @GetMapping("/{id}") //PathVariable toma el valor de URL
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            //ResponseEntity clase de Spring Boot. Transforma las peticiones en Java y viceversa
            return ResponseEntity.status(HttpStatus.OK).body("Busqué esta persona por Id:" + id);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Persona entity){

        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Nombre :" + entity.getNombre());
        System.out.println("Nombre :" + entity.getApellido());



        try{
            return ResponseEntity.status(HttpStatus.OK).body("Grabé los datos anteriores");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PutMapping("/{id}")
    //RequestBody es el cuerpo del formulario
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona entity){
        System.out.println("EL ID LO TOMO DE LA URL");
        System.out.println("Nombre :" + entity.getId());
        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Nombre :" + entity.getNombre());
        System.out.println("Apellido :" + entity.getApellido());
        try{
            return ResponseEntity.status(HttpStatus.OK).body("Actualicé los datos anteriores");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    //Lo mismo que un GET pero atrapo al Id
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminé el registro" + id);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}