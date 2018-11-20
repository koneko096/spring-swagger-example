package id.koneko096.swagger.data.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Citizen
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-20T18:37:09.423+07:00")
@Entity
@Table(name = "citizens")
public class Citizen   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("birthday")
  private LocalDate birthday = null;

  public Citizen id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Citizen firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * Citizen First Name
   * @return firstName
  **/
  @ApiModelProperty(value = "Citizen First Name")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Citizen lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Citizen Last Name
   * @return lastName
  **/
  @ApiModelProperty(value = "Citizen Last Name")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Citizen birthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

   /**
   * Citizen Birthday
   * @return birthday
  **/
  @ApiModelProperty(value = "Citizen Birthday")

  @Valid

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Citizen citizen = (Citizen) o;
    return Objects.equals(this.id, citizen.id) &&
        Objects.equals(this.firstName, citizen.firstName) &&
        Objects.equals(this.lastName, citizen.lastName) &&
        Objects.equals(this.birthday, citizen.birthday);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, birthday);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Citizen {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

