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
        if (indice >= 0 && indice < listaCliente.size()) {
            return listaCliente.get(indice);
        }
        return null;
    }

    @Override
    public void atualizar(int indice, Cliente objeto) {
        if (indice >= 0 && indice < listaCliente.size()) {
            listaCliente.set(indice, objeto);
        }
    }

    @Override
    public void deletar(int indice) {
        if (indice >= 0 && indice < listaCliente.size()) {
            listaCliente.remove(indice);
        }
    }
}
