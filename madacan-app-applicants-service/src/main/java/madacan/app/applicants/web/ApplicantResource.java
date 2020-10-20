package madacan.app.applicants.web;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import madacan.app.applicants.model.Applicant;
import madacan.app.applicants.model.ApplicantRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author Rico Fauchard
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@Timed("madacan.applicant")
public class ApplicantResource {

    private final ApplicantRepository applicantRepository;

    @GetMapping("applicants")
    public List<Applicant> applicants() {
        return applicantRepository.findAll();
    }

    @PostMapping("applicants")
    public Applicant create(
        @Valid @RequestBody Applicant applicant
    ) {
        log.info("Saving applicant {}", applicant);
        return applicantRepository.save(applicant);
    }

    @PutMapping("applicants/{applicantId}")
    public void update(
        @PathVariable("applicantId") Integer applicantId,
        @Valid @RequestBody Applicant applicantRequest
    ) {
        final Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> new ResourceNotFoundException("Applicant " + applicantId + " not found"));
        applicant.setFirstname(applicantRequest.getFirstname());
        applicant.setLastname(applicantRequest.getLastname());
        applicant.setBirthdate(applicantRequest.getBirthdate());
        log.info("Saving Applicant {}", applicant);
    }

    @Value
    static class Applicants {
        private final List<Applicant> items;
    }
}
