/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.view;

import fatec.poo.control.Conexao;
import fatec.poo.control.DaoVendedor;
import fatec.poo.model.Pessoa;
import fatec.poo.model.Vendedor;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovana, Anderson, Christian
 */
public class GuiVendedor extends javax.swing.JFrame {

    private DaoVendedor daoVendedor;
    private Conexao conexao;
    
    /**
     * Creates new form GuiVendedor
     */
    public GuiVendedor() {
        initComponents();
    }

    private Vendedor getVendedorByGui(){
        Vendedor vendedor = null;
        
        String cpf = this.ftxtCpf.getText();
        String nome = this.txtNome.getText();
        String endereco = this.txtEndereco.getText();
        String cidade = this.txtCidade.getText();
        String cep = this.txtCep.getText();
        String uf = this.cbxUf.getItemAt(this.cbxUf.getSelectedIndex());
        String telefoneddd = this.txtDdd.getText(); 
        String telefonenumero = this.txtTelefone.getText();

        double salariobase = Double.parseDouble(this.txtSalarioBase.getText());
        double comissao = Double.parseDouble(this.txtTaxaComissao.getText());        
        
        while(cpf.indexOf(".") > 0)
            cpf = cpf.replace(".", "");
        
        cpf = cpf.replace("-", "");
        
        vendedor = new Vendedor(cpf, nome, salariobase);
        vendedor.setEndereco(endereco);
        vendedor.setCidade(cidade);
        vendedor.setCep(cep);
        vendedor.setUf(uf);
        vendedor.setDdd(telefoneddd);
        vendedor.setTelefone(telefonenumero);
        vendedor.setTaxaComissao(comissao);
        
        return vendedor;
    }
    
    private void ableTxtAfterConult(){
        this.btnIncluir.setEnabled(true);
        this.btnConsultar.setEnabled(false);

        this.ftxtCpf.setEnabled(false);

        this.txtNome.setEnabled(true);
        this.txtEndereco.setEnabled(true);
        this.txtCidade.setEnabled(true);
        this.cbxUf.setEnabled(true);
        this.txtCep.setEnabled(true);
        this.txtDdd.setEnabled(true);
        this.txtTelefone.setEnabled(true);
        this.txtSalarioBase.setEnabled(true);
        this.txtTaxaComissao.setEnabled(true);

        this.txtNome.grabFocus();
    }
    
    private void disableTxtAfterAction(){
        this.ftxtCpf.setEnabled(true);

        this.txtNome.setEnabled(false);
        this.txtEndereco.setEnabled(false);
        this.txtCidade.setEnabled(false);
        this.cbxUf.setEnabled(false);
        this.txtCep.setEnabled(false);
        this.txtDdd.setEnabled(false);
        this.txtTelefone.setEnabled(false);
        this.txtSalarioBase.setEnabled(false);
        this.txtTaxaComissao.setEnabled(false);
        
        this.txtNome.setText("");
        this.txtEndereco.setText("");
        this.txtCidade.setText("");
        this.cbxUf.setSelectedIndex(19);
        this.txtCep.setText("");
        this.txtDdd.setText("");
        this.txtTelefone.setText("");
        this.txtSalarioBase.setText("");
        this.txtTaxaComissao.setText("");
        
        this.ftxtCpf.grabFocus();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ftxtCpf = new javax.swing.JFormattedTextField();
        lblNome = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblUf = new javax.swing.JLabel();
        cbxUf = new javax.swing.JComboBox<>();
        lblEndereco = new javax.swing.JLabel();
        txtTaxaComissao = new javax.swing.JTextField();
        lblTaxaComissao = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        lblCidade = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        lblTelefone = new javax.swing.JLabel();
        btnIncluir = new javax.swing.JButton();
        lblCep = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        txtSalarioBase = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        txtDdd = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblSalarioBase = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Vendedor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        try {
            ftxtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setText("Nome");

        txtCidade.setEnabled(false);

        lblUf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUf.setText("UF");

        cbxUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF", " " }));
        cbxUf.setSelectedIndex(19);
        cbxUf.setEnabled(false);

        lblEndereco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEndereco.setText("Endereço");

        txtTaxaComissao.setEnabled(false);

        lblTaxaComissao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTaxaComissao.setText("Taxa de Comissão");

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/pesq.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCidade.setText("Cidade");

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Alterar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        lblTelefone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTelefone.setText("Telefone");

        btnIncluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/add.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.setEnabled(false);
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        lblCep.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCep.setText("CEP");

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Eraser.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtSalarioBase.setEnabled(false);

        txtNome.setEnabled(false);

        btnSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/exit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        txtDdd.setEnabled(false);

        txtCep.setEnabled(false);

        lblCpf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCpf.setText("CPF");

        txtEndereco.setEnabled(false);

        lblSalarioBase.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSalarioBase.setText("Salário Base");

        txtTelefone.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNome))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCpf)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ftxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEndereco)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEndereco))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCidade)
                                        .addComponent(lblCep))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblUf)
                                            .addGap(10, 10, 10)
                                            .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSalarioBase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSalarioBase, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(lblTaxaComissao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTaxaComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblCep, lblCidade, lblCpf, lblEndereco, lblNome, lblSalarioBase});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnConsultar, btnExcluir, btnIncluir, btnSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(ftxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUf)
                    .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCep)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(txtDdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSalarioBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTaxaComissao)
                        .addComponent(txtTaxaComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSalarioBase, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCep, lblCidade, lblCpf, lblEndereco, lblNome, lblSalarioBase, lblTelefone, txtCep, txtDdd, txtTaxaComissao});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAlterar, btnConsultar, btnExcluir, btnIncluir, btnSair});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
      
        
        String cpf = ftxtCpf.getText();
                
        while(cpf.indexOf(".") > 0)
            cpf = cpf.replace(".", "");
        
        cpf = cpf.replace("-", "");
        
        if(!Pessoa.validarCPF(cpf)){
            JOptionPane.showMessageDialog(this, "CPF inválido", "Erro", 2);
             this.ftxtCpf.grabFocus();
        }else{
            Vendedor vendedor = this.daoVendedor.consultar(cpf);

            if(vendedor == null)
                this.ableTxtAfterConult();
            else{
                
                this.btnConsultar.setEnabled(false);
                this.btnAlterar.setEnabled(true);
                this.btnExcluir.setEnabled(true);
                
                this.ftxtCpf.setEnabled(false);

                this.txtNome.setEnabled(true);
                this.txtEndereco.setEnabled(true);
                this.txtCidade.setEnabled(true);
                this.cbxUf.setEnabled(true);
                this.txtCep.setEnabled(true);
                this.txtDdd.setEnabled(true);
                this.txtTelefone.setEnabled(true);
                this.txtSalarioBase.setEnabled(true);
                this.txtTaxaComissao.setEnabled(true);
                
                this.txtNome.setText(vendedor.getNome());
                this.txtEndereco.setText(vendedor.getEndereco());
                this.txtCidade.setText(vendedor.getCidade());
                this.cbxUf.setSelectedItem(vendedor.getUf());
                this.txtCep.setText(vendedor.getCep());
                this.txtDdd.setText(vendedor.getDdd());
                this.txtTelefone.setText(vendedor.getTelefone());
                this.txtSalarioBase.setText(Double.toString(vendedor.getSalarioBase()));
                this.txtTaxaComissao.setText(Double.toString(vendedor.getTaxaComissao()));
                
                
                
        
                this.txtNome.grabFocus();
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        conexao = new Conexao("BD2121007","BD2121007");//usuario e senha FATEC(BD2121036, BD2121036) | LOCAL:(SYSTEM, root)
        conexao.setDriver("oracle.jdbc.driver.OracleDriver");
        conexao.setConnectionString("jdbc:oracle:thin:@192.168.1.6:1521:xe"); //FATEC: jdbc:oracle:thin:@192.168.1.6:1521:xe | LOCAL: jdbc:oracle:thin:@127.0.0.1:1521:xe
        daoVendedor = new DaoVendedor(conexao.conectar());
    }//GEN-LAST:event_formWindowOpened

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        Vendedor vendedor = this.getVendedorByGui();
        this.daoVendedor.inserir(vendedor);
        
        this.disableTxtAfterAction();
        this.btnIncluir.setEnabled(false);
        this.btnConsultar.setEnabled(true);
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Vendedor vendedor = this.getVendedorByGui();
        this.daoVendedor.excluir(vendedor);
        
        this.disableTxtAfterAction();
        this.btnConsultar.setEnabled(true);
        this.btnAlterar.setEnabled(false);
        this.btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        Vendedor vendedor = this.getVendedorByGui();
        this.daoVendedor.alterar(vendedor);
        
        this.disableTxtAfterAction();
        this.btnConsultar.setEnabled(true);
        this.btnAlterar.setEnabled(false);
        this.btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnAlterarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbxUf;
    private javax.swing.JFormattedTextField ftxtCpf;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalarioBase;
    private javax.swing.JLabel lblTaxaComissao;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblUf;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtDdd;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSalarioBase;
    private javax.swing.JTextField txtTaxaComissao;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
