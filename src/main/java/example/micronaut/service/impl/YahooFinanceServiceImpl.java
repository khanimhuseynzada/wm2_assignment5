package example.micronaut.service.impl;

import example.micronaut.service.FinancialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.inject.Singleton;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Singleton
public class YahooFinanceServiceImpl implements FinancialService{

    protected static final Logger logger = LoggerFactory.getLogger(YahooFinanceServiceImpl.class);


    @Override
    public Object getFinancialData(String stock_index) {

        List<Stock> stock = null;
        List <BigDecimal> price = (List<BigDecimal>) BigDecimal.ZERO;
        try {
            List<String> string = Arrays.asList(stock_index.split(",[ ]*"));
            for(int i=0; i<=string.size();i++){
                stock.set(i, YahooFinance.get(stock_index));
                price.set(i, stock.get(i).getQuote(true).getPrice());
            }
            return price;

        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return price;
    }

}

