
package com.delivery_api.Projeto.Delivery.API.service;

import com.delivery_api.Projeto.Delivery.API.entity.Restaurante;
import com.delivery_api.Projeto.Delivery.API.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> listarTodos() {
        return restauranteRepository.findAll();
    }

    public Optional<Restaurante> buscarPorId(Long id_restaurante) {
        return restauranteRepository.findById(id_restaurante);
    }

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Restaurante atualizar(Long id_restaurante, Restaurante restauranteAtualizado) {
        return restauranteRepository.findById(id_restaurante).map(restaurante -> {
            restaurante.setNome(restauranteAtualizado.getNome());
            restaurante.setCategoria(restauranteAtualizado.getCategoria());
            restaurante.setEndereco(restauranteAtualizado.getEndereco());
            restaurante.setTelefone(restauranteAtualizado.getTelefone());
            restaurante.setTaxa_entrega(restauranteAtualizado.getTaxa_entrega());
            restaurante.setAvaliacao(restauranteAtualizado.getAvaliacao());
            restaurante.setAtivo(restauranteAtualizado.getAtivo());
            return restauranteRepository.save(restaurante);
        }).orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
    }

    public void deletar(Long id_restaurante) {
        restauranteRepository.deleteById(id_restaurante);
    }

    public Restaurante inativar(Long id_restaurante) {
        Restaurante restaurante = restauranteRepository.findById(id_restaurante)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
        restaurante.inativar();
        return restauranteRepository.save(restaurante);
    }
}
