package com.delivery_api.Projeto.Delivery.API.service;

import com.delivery_api.Projeto.Delivery.API.entity.Pedido;
import com.delivery_api.Projeto.Delivery.API.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setNumero_pedido(pedidoAtualizado.getNumero_pedido());
            pedido.setStatus(pedidoAtualizado.getStatus());
            pedido.setValor_total(pedidoAtualizado.getValor_total());
            pedido.setObservacoes(pedidoAtualizado.getObservacoes());
            pedido.setCliente_id(pedidoAtualizado.getCliente_id());
            pedido.setRestaurante_id(pedidoAtualizado.getRestaurante_id());
            pedido.setItens(pedidoAtualizado.getItens());
            pedido.setData_pedido(pedidoAtualizado.getData_pedido());
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}