package br.lostpets.project.model;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.lostpets.project.service.ServiceGeral;

@Entity
@Table(name = "USUARIO")
public class Usuario{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, name = "ID_PESSOA")
	private int idPessoa;

	@Column(nullable = false, name = "NOME") private String nome;
	@Column(nullable = true, name = "TELEFONE_FIXO") private String telefoneFixo;
	@Column(nullable = true, name = "TELEFONE_CELULAR") private String telefoneCelular;
	@Column(nullable = false, name = "EMAIL") private String email;
	@Column(nullable = true, name = "SENHA") private String senha;
	@Column(nullable = true, name = "PATH_IMG") private String idImagem;
	@Column(nullable = true, name = "CEP") private String cep;
	@Column(nullable = true, name = "RUA") private String rua;
	@Column(nullable = true, name = "BAIRRO") private String bairro;
	@Column(nullable = true, name = "CIDADE") private String cidade;
	@Column(nullable = true, name = "UF") private String uf;
	@Column(nullable = true, name = "LATITUDE") private String latitude;
	@Column(nullable = true, name = "LONGITUDE") private String longitude;
	@Column(nullable = true, name = "ADD_CADASTRO") private String addCadastro;
	@Column(nullable = true, name = "ULTIMO_ACESSO") private String ultimoAcesso;

	private String dataHora() {
		return new ServiceGeral().getDateHour();
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setIdImagem(String idImagem) {
		this.idImagem = idImagem;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setAddCadastro(String addCadastro) {
		this.addCadastro = addCadastro;
	}

	public void setUltimoAcesso(String ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Usuario() {}
	
	public Usuario(String nome, String telefoneFixo, String telefoneCelular, String email, String senha,
			String idImagem, String cep, String rua, String bairro, String cidade, String uf, String latitude,
			String longitude) {
		this.nome = nome;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.email = email;
		this.senha = cripSenha(senha);
		this.idImagem = idImagem;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.latitude = latitude;
		this.longitude = longitude;
		this.addCadastro = dataHora();
	}
	
	public Usuario(String nome, String email)
	{
		this.nome = nome;
		this.email = email;	
		this.addCadastro = dataHora();
	}
	
	private String cripSenha(String senhaOriginal){
		String senhaSerializado = Base64.getEncoder().encodeToString(senhaOriginal.getBytes());
    	return senhaSerializado;
	}
	/*private String descripSenha(String senhaSerializado) {
		String senhaDeserializado;
	    senhaDeserializado = new String(Base64.getDecoder().decode(senhaSerializado));
	    return senhaDeserializado;
	}*/

	public int getIdPessoa() {
		return idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getIdImagem() {
		return idImagem;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getAddCadastro() {
		return addCadastro;
	}

	public String getUltimoAcesso() {
		return ultimoAcesso;
	}

	@Override
	public String toString() {
		return "Usuario [idPessoa=" + idPessoa + ", nome=" + nome + ", telefoneFixo=" + telefoneFixo
				+ ", telefoneCelular=" + telefoneCelular + ", email=" + email + ", senha=" + senha + ", idImagem="
				+ idImagem + ", cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", uf="
				+ uf + ", latitude=" + latitude + ", longitude=" + longitude + ", addCadastro=" + addCadastro
				+ ", ultimoAcesso=" + ultimoAcesso + "]";
	}
	
	
	
}
