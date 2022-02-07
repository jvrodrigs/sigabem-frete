package cd2tec.javatest.sigabem.Service;

import cd2tec.javatest.sigabem.Error.CustomException;
import cd2tec.javatest.sigabem.Models.Cep;
import cd2tec.javatest.sigabem.Models.Frete;
import cd2tec.javatest.sigabem.Repository.FreteRepository;
import cd2tec.javatest.sigabem.Utils.RequestCEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FreteService {

    @Autowired
    private FreteRepository repository;

    public List<Frete> get(){
        return repository.findAll();
    }

    public Frete consultarFrete(Map<String, String> infos) throws Exception {
        Double valorTotal = Double.parseDouble(infos.get("peso"));
        int kg = 1;
        Date dataFinal = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataFinal);

        Cep modelOrigem = RequestCEP.cep(infos.get("cepOrigem"));
        Cep modelDestino = RequestCEP.cep(infos.get("cepDestino"));

        if (modelDestino.getCep() == null || modelOrigem.getCep() == null){
            throw new CustomException("Existe um CEP Incorreto", 404);
        }

        valorTotal = (valorTotal * kg);

        if (modelDestino.getDdd().equals(modelOrigem.getDdd())){
            valorTotal -= valorDesconto(valorTotal, (0.5));
            cal.add(Calendar.DATE, 1);
        } else if (modelDestino.getUf().equals(modelOrigem.getUf())){
            valorTotal -= valorDesconto(valorTotal, (0.75));
            cal.add(Calendar.DATE, 3);
        } else {
            cal.add(Calendar.DATE, 10);
        }

        dataFinal = cal.getTime();
        Frete frete = new Frete(Double.parseDouble(infos.get("peso")),infos.get("cepOrigem"), infos.get("cepDestino"), infos.get("nomeDestinatario"), valorTotal, dataFinal);

        repository.save(frete);
        return frete;
    }

    public Double valorDesconto(Double valorTotal, Double desconto){
        return (valorTotal * desconto);
    }
}
