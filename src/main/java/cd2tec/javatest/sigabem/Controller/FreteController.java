package cd2tec.javatest.sigabem.Controller;

import cd2tec.javatest.sigabem.Models.Frete;
import cd2tec.javatest.sigabem.Service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/frete")
public class FreteController {

    @Autowired
    private FreteService service;

    @GetMapping
    public ResponseEntity<Object> consultaFrete(@RequestBody Map<String, String> info) throws Exception {
        var frete = this.service.consultarFrete(info);
        Map<Object, Object> res = new LinkedHashMap<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        res.put("vlTotalFrete", frete.getVlTotalFrete());
        res.put("cepOrigem", frete.getCepOrigem());
        res.put("cepDestino", frete.getCepDestino());
        res.put("dataPrevistaEntrega", df.format(frete.getDataPrevistaEntrega()));
        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("/list")
    public ResponseEntity<Object> get(){
        return ResponseEntity.status(200).body(this.service.get());
    }
}
