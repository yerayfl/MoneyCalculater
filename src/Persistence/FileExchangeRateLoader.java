package Persistence;

import Model.Currency;
import Model.ExchangeRate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileExchangeRateLoader implements ExchangeRateLoader {

    private final String file;

    public FileExchangeRateLoader(String file) {
        this.file = file;
    }

    @Override
    public ExchangeRate load(Currency to) {
        BufferedReader exchangereader = null;
        try {
            exchangereader = new BufferedReader(new FileReader(file));
            String line;
            while((line = exchangereader.readLine()) != null){
                String[] rateLine = line.split("=");
                if(rateLine[1].equalsIgnoreCase(to.getCode())){
                    return new ExchangeRate(to,Double.valueOf(rateLine[0]));
                }
            }
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileExchangeRateLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileExchangeRateLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                exchangereader.close();
            } catch (IOException ex) {
                Logger.getLogger(FileExchangeRateLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
