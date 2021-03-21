package me.andreraimundo.belarosa_backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.andreraimundo.belarosa_backend.domain.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    @RequestMapping(method = RequestMethod.GET)
    public List <Cliente> list (){
        Cliente cli1 = new Cliente (1,"Joao Paulo", 122333, 13041, 99955);
        Cliente cli2 = new Cliente (2,"Henrique Santos", 223344, 140997, 9645);

        List<Cliente> list = new ArrayList<>();
        list.add(cli1);
        list.add(cli2);
        return list;
    }
}