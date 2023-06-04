/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 0030482121007
 */
public class DaoVendedor {
    private Connection conn;
    
    public DaoVendedor(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO vendedor(cpf, nome, endereco, cidade, cep, uf,"
                    + " telefoneddd, telefonenumero, salariobase, comissao)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, vendedor.getCpf());
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getEndereco());
            ps.setString(4, vendedor.getCidade());
            ps.setString(5, vendedor.getCep());
            ps.setString(6, vendedor.getUf());
            ps.setString(7, vendedor.getDdd());
            ps.setString(8, vendedor.getTelefone());
            
            ps.setDouble(9, vendedor.getSalarioBase());
            ps.setDouble(10, vendedor.getTaxaComissao());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
    
    public Vendedor consultar(String cpf){
        Vendedor vendedor = null;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * FROM vendedor where cpf = ?");
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
                
                double salariobase = rs.getDouble("salariobase");
                double comissao = rs.getDouble("comissao");
                
                vendedor = new Vendedor(cpf, nome, salariobase);
                vendedor.setEndereco(endereco);
                vendedor.setCidade(cidade);
                vendedor.setCep(cep);
                vendedor.setUf(uf);
                vendedor.setDdd(telefoneddd);
                
                vendedor.setTelefone(telefonenumero);
                vendedor.setSalarioBase(salariobase);
                vendedor.setTaxaComissao(comissao);
                
                return vendedor;
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        
        return vendedor;
    }
    
    public void alterar(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE vendedor set " + 
                                                "nome = ?, " +
                                                "endereco = ?, " +
                                                "cidade = ?, " +
                                                "cep = ?, " +
                                                "uf = ?, " +
                                                "telefoneddd = ?, " +
                                                "telefonenumero = ?, " +
                                                "salariobase = ?, " +
                                                "comissao = ? " +
                                                "where cpf = ?");
                        
            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getEndereco());
            ps.setString(3, vendedor.getCidade());
            ps.setString(4, vendedor.getCep());
            ps.setString(5, vendedor.getUf());
            ps.setString(6, vendedor.getDdd());
            ps.setString(7, vendedor.getTelefone());
            
            ps.setDouble(8, vendedor.getSalarioBase());
            ps.setDouble(9, vendedor.getTaxaComissao());
            
            ps.setString(10, vendedor.getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Vendedor vendedor){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement( "delete from vendedor where cpf = ?");
            
            ps.setString(1, vendedor.getCpf());
            
            ps.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
}
