package tech.claudioed.domain.repositories;

import dev.langchain4j.agent.tool.Tool;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.Customer;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer>{

    @Tool("get the customer name for the given id")
    public String customerName(Long id){
        return this.findById(id).name;
    }

}
