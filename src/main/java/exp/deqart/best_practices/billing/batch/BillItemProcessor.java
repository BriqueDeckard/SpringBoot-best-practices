package exp.deqart.best_practices.billing.batch;

import exp.deqart.best_practices.billing.domain.Bill;
import org.springframework.batch.item.ItemProcessor;

public class BillItemProcessor implements ItemProcessor<Bill, Bill> {
    @Override
    public Bill process(Bill item) throws Exception {
        final String name = item.getName().toUpperCase();
        item.setName(name);
        return item;
    }
}
