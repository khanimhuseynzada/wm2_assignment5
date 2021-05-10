package example.micronaut.controller;

public interface FinancialController {

    Object getFinancialData(String financial_data_provider, String stock_index);

}
