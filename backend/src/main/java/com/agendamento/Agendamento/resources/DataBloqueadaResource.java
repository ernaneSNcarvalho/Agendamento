package com.agendamento.Agendamento.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.Agendamento.entities.DataBloqueada;
import com.agendamento.Agendamento.service.DataBloqueadaService;

@RestController
@RequestMapping("/datas-bloqueadas")
public class DataBloqueadaResource {

    @Autowired
    private DataBloqueadaService service;

    // Buscar todas as datas bloqueadas
    @GetMapping
    public ResponseEntity<List<DataBloqueada>> findAll() {
        List<DataBloqueada> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Buscar uma data específica
    @GetMapping("/{data}")
    public ResponseEntity<Boolean> isDataBloqueada(@PathVariable String data) {
        LocalDate dataConvertida = LocalDate.parse(data);
        boolean bloqueada = service.isDataBloqueada(dataConvertida);
        return ResponseEntity.ok().body(bloqueada);
    }

    // Cadastrar nova data bloqueada
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody DataBloqueada obj) {
        service.inserirDataBloqueada(obj.getDataBloqueada(), obj.getMotivo());
        return ResponseEntity.noContent().build();
    }

    // Deletar uma data bloqueada
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

