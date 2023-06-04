/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.control;

import fatec.poo.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ander
 */
public class DaoProduto {
        private Connection conn;
    
    public DaoProduto(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO produto(CODIGOPRODUTO, DESCRICAO, QTDEDISPONIVEL, UNIDADEMEDIDA, PRECOUNIT, ESTOQUEMINIMO)"
                    + " VALUES(?, ?, ?, ?, ?, ?)");
            
            ps.setString(1, produto.getCodigo());
            ps.setString(2, produto.getDescricao());
                        
            ps.setDouble(3, produto.getQtdeEstoque());
            ps.setString(4, produto.getUnidadeMedida());
            ps.setDouble(5, produto.getPreco());
            ps.setDouble(6, produto.getEstoqueMinimo());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
    
    public Produto consultar(String codigo){
        Produto produto = null;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * FROM produto where CODIGOPRODUTO = ?");
            ps.setString(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true){
                String descricao = rs.getString("DESCRICAO");
                String unidademedida = rs.getString("UNIDADEMEDIDA");
                
                double qtdeDisponivel = rs.getDouble("QTDEDISPONIVEL");
                double precoUnitario = rs.getDouble("PRECOUNIT");
                double estoqueMinimo = rs.getDouble("ESTOQUEMINIMO");
                
                produto = new Produto(codigo, descricao);
                produto.setQtdeEstoque(qtdeDisponivel);
                produto.setUnidadeMedida(unidademedida);
                produto.setPreco(precoUnitario);
                produto.setEstoqueMinimo(estoqueMinimo);
                                
                return produto;
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        
        return produto;
    }
    
    public void alterar(Produto produto) {
        PreparedStatement ps = null;
        try {
            //CODIGOPRODUTO, DESCRICAO, QTDEDISPONIVEL, PRECOUNIT, ESTOQUEMINIMO
            ps = conn.prepareStatement("UPDATE produto set " + 
                                                "DESCRICAO = ?, " +
                                                "QTDEDISPONIVEL = ?, " +
                                                "PRECOUNIT = ?, " +
                                                "ESTOQUEMINIMO = ?, " +
                                                "UNIDADEMEDIDA = ? " +
                                                "where CODIGOPRODUTO = ?");
                        
            ps.setString(1, produto.getDescricao());
            
            ps.setDouble(2, produto.getQtdeEstoque());
            ps.setDouble(3, produto.getPreco());
            ps.setDouble(4, produto.getEstoqueMinimo());
            
            ps.setString(5, produto.getUnidadeMedida());
            ps.setString(6, produto.getCodigo());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Produto produto){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement( "delete from produto where CODIGOPRODUTO = ?");
            
            ps.setString(1, produto.getCodigo());
            
            ps.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
}
