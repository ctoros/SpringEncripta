package cl.hites.pruebaencripta.demo.web;

import cl.hites.pruebaencripta.demo.Config.Config;
import cl.hites.pruebaencripta.demo.Security.RSA;
import cl.hites.pruebaencripta.demo.vo.RequestVO;
import cl.hites.pruebaencripta.demo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/hites/")
public class EncriptaController {
    static org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getFormatterLogger(EncriptaController.class);

    @Autowired
    Config config;

    @RequestMapping(value = "/encripta",method = RequestMethod.POST)
    public ResponseEntity<ResultVO> encriptaDatos(@RequestBody RequestVO entrada){

        ResultVO response = new ResultVO();
        RSA rsa = new RSA();

        String file_private = config.getString("KeysUrl")+"server.crt";
        String file_public = config.getString("KeysUrl")+"client.p12";
       // response.setCodComercio("Hola");
       // response.setMonto("Hola");
       // response.setURL("Hola");
        try {
            rsa.openFromDiskPrivateKey(file_private);
            rsa.openFromDiskPrivateKey(file_public);
            String montoEncript = rsa.Encrypt(entrada.getMonto());
            String url = rsa.Encrypt(entrada.getURL());
            response.setMonto(montoEncript);
            response.setURL(url);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<ResultVO>(response, HttpStatus.OK);

    }


}
