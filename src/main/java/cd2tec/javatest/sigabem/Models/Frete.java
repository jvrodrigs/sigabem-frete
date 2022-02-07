package cd2tec.javatest.sigabem.Models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Entity
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double peso;

    private String cepOrigem;

    private String cepDestino;

    private String nomeDestinatario;

    private Double vlTotalFrete;

    @Temporal(DATE)
    private Date dataPrevistaEntrega;

    @CreationTimestamp
    @Column(name = "dataConsulta", nullable = false, updatable = false)
    private Date dataConsulta;
    public Frete(){ }
    public Frete(Double peso, String cepOrigem, String cepDestino, String nomeDestinatario, Double vlTotalFrete, Date dataPrevistaEntrega) {
        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.nomeDestinatario = nomeDestinatario;
        this.vlTotalFrete = vlTotalFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public Double getVlTotalFrete() {
        return vlTotalFrete;
    }

    public void setVlTotalFrete(Double vlTotalFrete) {
        this.vlTotalFrete = vlTotalFrete;
    }

    public Date getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(Date dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
