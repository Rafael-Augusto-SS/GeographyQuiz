package br.edu.ifrn.GeographyQuiz.domain.usuario;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.ifrn.GeographyQuiz.domain.permissao.Permissao;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "usuario")
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String usuario;
  private String senha;
  private String email;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "usuario_permissao", 
  joinColumns = @JoinColumn(name = "usuario_id"), 
  inverseJoinColumns = @JoinColumn(name = "permissao_id"))
  private Set<Permissao> permissoes;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<? extends GrantedAuthority> authorities = this.permissoes.stream().map(
      permissao -> new SimpleGrantedAuthority(permissao.getNome())).
      collect(Collectors.toList());
      System.out.println(this.email + "  " + " " + authorities.toString());
      return authorities;
  }
  @Override
  public String getPassword() {
    return this.senha;
  }
  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @Override
  public boolean isEnabled() {
    return true;
  } 
}
