package cl.hites.pruebaencripta.demo.vo;

public class RequestVO {
    private String codComercio;
    private String monto;
    private String URL;

    public RequestVO() {
    }

    public RequestVO(String codComercio, String monto, String URL) {
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
