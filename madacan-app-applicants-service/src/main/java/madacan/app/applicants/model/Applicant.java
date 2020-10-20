package madacan.app.applicants.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "applicants")
@Builder(builderMethodName = "applicant")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", nullable = true)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Builder.Default
    @Column(name = "birthdate")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate = new Date();
}
