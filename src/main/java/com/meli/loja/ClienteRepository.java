package com.meli.loja;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClienteRepository {

    private static final File FILE = new File("clientes.json");
    @Autowired
    private ObjectMapper mapper;

    public List<Cliente> getList(){
        List<Cliente> clientes = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {};
            clientes = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public boolean add(Cliente cliente) {
        try {
            List<Cliente> clientes = getList();
            clientes.add(cliente);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, clientes);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean alterPedido(Cliente cliente){
        try {
            List<Cliente> clientes = getList();
            clientes = clientes.stream().filter(cli -> cli.getId() != cliente.getId()).collect(Collectors.toList());
            clientes.add(cliente);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, clientes);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
