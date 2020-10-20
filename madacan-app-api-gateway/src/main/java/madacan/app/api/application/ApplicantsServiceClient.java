package madacan.app.api.application;

import lombok.RequiredArgsConstructor;
import madacan.app.api.dto.ApplicantDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Rico Fauchard
 */
@Component
@RequiredArgsConstructor
public class ApplicantsServiceClient {
    private final WebClient.Builder webClientBuilder;

    public Mono<ApplicantDetails> getApplicat(final int applicantId) {
        return webClientBuilder.build().get()
            .uri("http://applicants-service/applicants/{applicantId}", applicantId)
            .retrieve()
            .bodyToMono(ApplicantDetails.class);
    }
}
