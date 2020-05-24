package persons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class to represent a person.
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue
    private int userID;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String userName;

    private String password;

    private String seats;

    private boolean isAdmin;

}
