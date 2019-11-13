package TestNGData;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProps {
    static Properties props;

    static FileInputStream inputStream;

    public String getProperty(String key) {
        props = new Properties();
        try{
            inputStream =new FileInputStream("src\\test\\java\\TestData\\New Microsoft Office Excel Worksheet.xlsx");
            props.load(inputStream);
            inputStream.close();}

        catch (FileNotFoundException e) {
            e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(key);
    }
    @Test
    public void openBrowser () {
        System.out.println(getProperty("url")); }

}
