package cl.hites.pruebaencripta.demo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO {
    private String codComercio;
    private String monto;
    private String URL;

    public ResultVO() {
    }

    public ResultVO(String codComercio, String monto, String URL) {
        this.codComercio = codComercio;
        this.monto = monto;
        this.URL = URL;
    }

    public String getCodComercio() {
        return codComercio;
    }

    public void setCodComercio(String codComercio) {
        this.codComercio = codComercio;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
