
package fatec.poo.model;

/**
 *
 * @author Anderson, Giovana, Christian
 */
public class Pessoa {
 
    private String cpf;
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public String getDdd() {
        return ddd;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public static boolean validarCPF(String cpf){
        int resultadoSomatoriaDigito1 = 0;
        int resultadoSomatoriaDigito2 = 0;
        int digitoVerificador1 = 0;
        int digitoVerificador2 = 0;
        String cpfGeradoPelosCalculos;
        boolean isValid = false;       
       	
        if(cpf.length() != 11 || cpf.equals("           ")){
            isValid = false;
            return isValid;
        }
        
        // 1º Dígito verificador - 1 Somatoria
	for(int indiceCpfNumerico = 0; indiceCpfNumerico < 9; indiceCpfNumerico++)
	{
            char arrayCaracter[] = new char[1];
            arrayCaracter[0] = cpf.charAt(indiceCpfNumerico);
            String algarismo = new String(arrayCaracter);
            
            resultadoSomatoriaDigito1 += (indiceCpfNumerico + 1) * Integer.parseInt(algarismo);   
	}
        
        // 1º Dígito verificador - 2 resto divisão | somatoria = 278 | digito = 3
	digitoVerificador1 = resultadoSomatoriaDigito1 % 11;

	if(digitoVerificador1 == 10)
            digitoVerificador1 = 0;


        // 2º Dígito verificador - 1 - multiplicar pelo maior a esquerda
        
	for(int indiceCpfNumerico = 0; indiceCpfNumerico < 10; indiceCpfNumerico++)
	{
            char arrayCaracter[] = new char[1];
            arrayCaracter[0] = cpf.charAt(indiceCpfNumerico);
            String algarismo = new String(arrayCaracter);
            
            resultadoSomatoriaDigito2 += (11 - indiceCpfNumerico) * Integer.parseInt(algarismo);
	}

        // 2º Dígito verificador - 2 - resto divisão
        
	digitoVerificador2 = (resultadoSomatoriaDigito2 * 10) % 11;

	if(digitoVerificador2 == 10)
		digitoVerificador2 = 0;

        cpfGeradoPelosCalculos = new String(cpf.substring(0,9) + Integer.toString(digitoVerificador1) + Integer.toString(digitoVerificador2));
        
        isValid = cpf.equals(cpfGeradoPelosCalculos);
        
        return isValid;
    }
}