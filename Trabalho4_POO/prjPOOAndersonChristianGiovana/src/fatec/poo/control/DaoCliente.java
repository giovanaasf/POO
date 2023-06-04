/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Cliente;

/**
 *
 * @author 0030482121036
 */
public class DaoCliente {
    
    private Connection conn;
    
    public DaoCliente(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO cliente(cpf, nome, endereco, cidade, cep, uf,"
                    + " telefoneddd, telefonenumero, limitecredito, limitedisponivel)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getCep());
            ps.setString(6, cliente.getUf());
            ps.setString(7, cliente.getDdd());
            ps.setString(8, cliente.getTelefone());
            
            ps.setDouble(9, cliente.getLimiteCred());
            ps.setDouble(10, cliente.getLimiteDisp());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
    
    public Cliente consultar(String cpf){
        Cliente cliente = null;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * FROM cliente where cpf = ?");
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true){
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                String cep = rs.getString("cep");
                String uf = rs.getString("uf");
                String telefoneddd = rs.getString("telefoneddd");
                String telefonenumero = rs.getString("telefonenumero");
                
                double limitecredito = rs.getDouble("limitecredito");
                double limitedisponivel = rs.getDouble("limitedisponivel");
                
                cliente = new Cliente(cpf, nome, limitecredito);
                cliente.setEndereco(endereco);
                cliente.setCidade(cidade);
                cliente.setCep(cep);
                cliente.setUf(uf);
                cliente.setDdd(telefoneddd);
                
                cliente.setTelefone(telefonenumero);
                cliente.setLimiteDisp(limitedisponivel);
                
                return cliente;
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        
        return cliente;
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE cliente set " + 
                                                "nome = ?, " +
                                                "endereco = ?, " +
                                                "cidade = ?, " +
                                                "cep = ?, " +
                                                "uf = ?, " +
                                                "telefoneddd = ?, " +
                                                "telefonenumero = ?, " +
                                                "limitecredito = ?, " +
                                                "limitedisponivel = ? " +
                                                "where cpf = ?");
                        
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getUf());
            ps.setString(6, cliente.getDdd());
            ps.setString(7, cliente.getTelefone());
            
            ps.setDouble(8, cliente.getLimiteCred());
            ps.setDouble(9, cliente.getLimiteDisp());
            
            ps.setString(10, cliente.getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Cliente cliente){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement( "delete from cliente where cpf = ?");
            
            ps.setString(1, cliente.getCpf());
            
            ps.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    
}
