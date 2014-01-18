package Persistence;

import Model.ExchangeRate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileCurrencySetLoader implements CurrencySetLoader {

    private final String file;

    public FileCurrencySetLoader(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    @Override
    public String[] load() {
        BufferedReader currencyreader = null;
        String[] code = new String[33];
        try {

            String line;
            int count = 0;
            currencyreader = new BufferedReader(new FileReader(file));

            while ((line = currencyreader.readLine()) != null) {
                String[] currencyLine = line.split("=");
                code[count] = currencyLine[1];
                count++;
            }
            return code;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileCurrencySetLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileCurrencySetLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                currencyreader.close();
            } catch (IOException ex) {
                Logger.getLogger(FileCurrencySetLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return code;
    }
}
