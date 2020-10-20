package madacan.app.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ApplicantDetails {
    private int id;
    private String firstname;
    private String lastname;
    private Date birthdate;
}
