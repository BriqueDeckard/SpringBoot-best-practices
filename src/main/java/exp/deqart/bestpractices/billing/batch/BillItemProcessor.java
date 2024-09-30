package exp.deqart.bestpractices.billing.batch;

import exp.deqart.bestpractices.billing.domain.Bill;
import org.springframework.batch.item.ItemProcessor;

public class BillItemProcessor implements ItemProcessor<Bill, Bill> {
    @Override
    public Bill process(Bill item) throws Exception {
        final String name = item.getName().toUpperCase();
        item.setName(name);
        return item;
    }
}
