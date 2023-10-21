package entities;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


import com.google.gson.Gson;

import lombok.Data;

@Data
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private int numero;

    public static Endereco getEnderecoByCep(String cep){
        Endereco endereco = new Endereco();
        HttpGet request = new HttpGet("http://viacep.com.br/ws/"+ cep + "/json/");
    
        try(CloseableHttpClient https = HttpClientBuilder.create().build();
            CloseableHttpResponse resposta = https.execute(request))
            {
                HttpEntity entidade = resposta.getEntity();
                String resultado = EntityUtils.toString(entidade);


                Gson gsonado = new Gson();
                endereco = gsonado.fromJson(resultado, Endereco.class);
            } catch (IOException abaa){
            abaa.printStackTrace();
        }

        return endereco;
}
}
// public class Endereco {

//     private String cep;
//     private String logradouro;
//     private String complemento;
//     private String bairro;
//     private String localidade;
//     private String uf;

//     public static Endereco getEnderecoByCep(String cep){
//         Endereco local = new Endereco();
//         /* mandar o cep pro via cep
//         tratar a resposta
//         montar o endereço
//          */
//         HttpGet request = new HttpGet("http://viacep.com.br/ws/"+ cep + "/json/");


//         try(CloseableHttpClient https = HttpClientBuilder.create().build();
//             CloseableHttpResponse resposta = https.execute(request))
//             {
//                 HttpEntity entidade = resposta.getEntity();
//                 String resultado = EntityUtils.toString(entidade);
//                 System.out.println(resultado);

//                 Gson gsonado = new Gson();
//                 local = gsonado.fromJson(resultado, Endereco.class);
//                 local.setComplemento(null);
//                 System.out.println(local);
//             } catch (IOException abaa){
//             abaa.printStackTrace();
//         }

//         return local;
//     }
// }