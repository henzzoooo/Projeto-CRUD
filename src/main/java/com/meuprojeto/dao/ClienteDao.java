package com.meuprojeto.dao;

import java.util.ArrayList;
import java.util.List;

import com.meuprojeto.dominio.Cliente;
import com.meuprojeto.interfaces.Crud;

public class ClienteDao implements Crud<Cliente> {

    private List<Cliente> listaCliente = new ArrayList<>();


    @Override
    public void salvar(Cliente objeto) {
        listaCliente.add(objeto);

    }

    @Override
    public List<Cliente> listar() {
        return listaCliente;
    }

    @Override
    public Cliente buscar(int indice) {
        return listaCliente.get(indice);
    }

    @Override
    public void atualizar(int indice, Cliente objeto) {

    }

    @Override
    public void deletar(int indice) {

    }
}
