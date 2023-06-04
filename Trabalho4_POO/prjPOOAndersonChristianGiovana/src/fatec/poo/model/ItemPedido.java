
package fatec.poo.model;

/**
 *
 * @author Anderson, Giovana, Christian
 */
public class ItemPedido {
    private int sequencia;
    private double qtdeVendida;
    private Produto produto;
    private Pedido pedido;

    public ItemPedido(int sequencia, double qtdeVendida, Produto produto) {
        this.sequencia = sequencia;
        this.qtdeVendida = qtdeVendida;
        this.produto = produto;
        produto.setQtdeEstoque(produto.getQtdeEstoque() - qtdeVendida);
    }
    
    public void setQtdeVendida(double qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
        this.produto.setQtdeEstoque(this.produto.getQtdeEstoque() - qtdeVendida);
    }

    public int getSequencia() {
        return sequencia;
    }

    public double getQtdeVendida() {
        return qtdeVendida;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
 
    
    
}
