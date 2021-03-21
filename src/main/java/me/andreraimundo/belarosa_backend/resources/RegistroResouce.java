package me.andreraimundo.belarosa_backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.andreraimundo.belarosa_backend.domain.Registro;

@RestController
@RequestMapping(value = "/registros")
public class RegistroResouce {
    @RequestMapping(method = RequestMethod.GET)
    public List <Registro> list (){
        Registro reg1 = new Registro(1,"email1@email.com", "minhasenhaum");
        Registro reg2 = new Registro(2,"email2@email.com", "minhasenhadois");

        List<Registro> list = new ArrayList<>();
        list.add(reg1);
        list.add(reg2);
        return list;
    }
}
