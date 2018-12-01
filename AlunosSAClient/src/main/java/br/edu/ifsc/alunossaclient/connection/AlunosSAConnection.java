/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.alunossaclient.connection;

import br.edu.ifsc.alunossaclient.model.Banco;
import br.edu.ifsc.alunossaclient.model.EmpresaCerta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Lucas
 */
public class AlunosSAConnection {
    
    private static EmpresaCerta empresaCerta;
    private static Banco banco;
    
    public static EmpresaCerta getEmpresaCerta() {
        String httpUrl = "http://localhost:8080/api/empresas";
        URL url;
        String inputLine;
        StringBuffer response = new StringBuffer();
        try {
            url = new URL(httpUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            if (con.getResponseCode() == 200) {
                // get response stream
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "UTF-8"));
                // feed response into the StringBuilder
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Start parsing
                JSONObject obj = new JSONObject(response.toString());
                String nome = obj.getString("nome");
                double preco = obj.getDouble("preco");
                empresaCerta = new EmpresaCerta(nome, preco);
                return empresaCerta;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static Banco getBanco() {
        String httpUrl = "http://localhost:8080/api/bancos";
        URL url;
        String inputLine;
        StringBuffer response = new StringBuffer();
        try {
            url = new URL(httpUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            if (con.getResponseCode() == 200) {
                // get response stream
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "UTF-8"));
                // feed response into the StringBuilder
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Start parsing
                JSONObject obj = new JSONObject(response.toString());
                int numero = obj.getInt("numeroConta");
                double saldo = obj.getDouble("saldo");
                banco = new Banco(numero, saldo);
                return banco;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
