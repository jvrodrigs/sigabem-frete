package cd2tec.javatest.sigabem.Utils;

import cd2tec.javatest.sigabem.Models.Cep;
import org.springframework.web.client.RestTemplate;


public class RequestCEP {

    public static Cep cep(String cep)  {
        cep = cep.replace("-", "");
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        RestTemplate rest = new RestTemplate();

        Cep res = rest.getForObject(url, Cep.class);

        return res;
    }
}
