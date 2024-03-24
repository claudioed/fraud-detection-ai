package tech.claudioed.adapter.http;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestQuery;
import tech.claudioed.domain.Transaction;
import tech.claudioed.domain.repositories.TransactionRepository;
import tech.claudioed.domain.services.FraudDetectionAiService;

import java.util.List;

@Path("/fraud-detection")
public class FraudDetectionResource {
    private final TransactionRepository transactionRepository;
    private final FraudDetectionAiService fraudDetectionAiService;
    public FraudDetectionResource(TransactionRepository transactionRepository, FraudDetectionAiService fraudDetectionAiService) {
        this.transactionRepository = transactionRepository;
        this.fraudDetectionAiService = fraudDetectionAiService;
    }
    @GET
    @Path("/distance")
    public String detectBasedOnDistance(@RestQuery long customerId) {
        return fraudDetectionAiService.detectDistanceFraudForCustomer(customerId);
    }
    @GET
    @Path("/amount")
    public String detectBaseOnAmount(@RestQuery long customerId) {
        return fraudDetectionAiService.detectAmountFraudForCustomer(customerId);
    }
    @GET
    @Path("/transactions")
    public List<Transaction> list(@RestQuery long customerId) {
        return transactionRepository.getTransactionsForCustomer(customerId);
    }
    @GET
    @Path("/verification")
    public double verify(@RestQuery long customerId) {
        return transactionRepository.getAmountForCustomer(customerId);
    }

}
