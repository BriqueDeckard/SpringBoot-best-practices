package exp.deqart.best_practices.billing.config;

import exp.deqart.best_practices.billing.domain.Bill;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class BillBatchConfig {

    @Bean
    public FlatFileItemReader<Bill> billItemReader() {
        return new FlatFileItemReaderBuilder<Bill>()
                .name("billItemReader")
                .resource(new FileSystemResource("resources/samples/bills/bill_000.csv"))
                .delimited()
                .names(new String[] {"id", "name", "ht", "ttc"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Bill.class);
                }})
                .build();
    }

    @Bean
    public Job billJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        return jobBuilderFactory.get("billJob")
                .incrementer(new RunIdIncrementer())
                .start(billStep(stepBuilderFactory))
                .build();
    }

    @Bean
    public Step billStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("billStep")
                .<Bill, Bill>chunk(10)  // Lire et traiter par lots de 10
                .reader(billItemReader())
                .processor(billProcessor())
                .writer(billWriter())
                .build();
    }

    @Bean
    public ItemProcessor<Bill, Bill> billProcessor() {
        return bill -> {
            // Ajout d'une validation ou d'une logique ici, par exemple
            if (bill.getName().isBlank()) {
                System.out.println("Nom invalide.");
                return null;  // Ignorer
            }
            return bill;
        };
    }

    @Bean
    public ItemWriter<Bill> billWriter() {
        return invoices -> invoices.forEach(System.out::println);  // Écrire les factures traitées dans la console
    }
}
