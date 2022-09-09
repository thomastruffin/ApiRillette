package data.bo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Role", discriminatorType = DiscriminatorType.INTEGER)
public abstract class PersonneBO {
@Id  @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
@Size(min=3 , max =50)
@NotBlank
private String nom;
@Size(min=3 , max =50)
@NotBlank
private String prenom;
@OneToOne
@JoinColumn(name = "favoriteCinema")
private CinemaBO cinema;
@Column(nullable = false , unique = true)
private String email;
@NotBlank
@Column(length = 800)
private String password;
}
