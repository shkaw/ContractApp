package common;
import common.Customer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.Calendar;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.util.ArrayList;

/**
* クラス:Import
* 機能:ファイルインポートクラス
*/
public class Import{

    /**
     * 
     * importFile(String fileName):void ファイルを読み込みArrayList<Customer>に格納し戻す
     * @param fileName:String importするファイル名
     * @return ArrayList<Customer>
     */
    public ArrayList<Customer> importFile(String fileName){
        ArrayList<Customer> importRequest = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String customerData;
            String tmp = br.readLine(); //見出しを読み飛ばし
            CheckData chd = new CheckData();
            while((customerData = br.readLine()) != null){
                String cd[] = customerData.split(",");
                chd.checkDate(cd[0]);
                String calArray[] = cd[0].split("/");
                Calendar cal = Calendar.getInstance();
                cal.set(Integer.parseInt(calArray[0]),Integer.parseInt(calArray[1])-1,Integer.parseInt(calArray[2])); //CalendarクラスのためcalArray[1](Month)に-1
                importRequest.add(new Customer(cal,cd[1],cd[2],cd[3]));
            }
            br.close();
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }catch(IOException o){
            o.printStackTrace();
        }
        return importRequest;
    }
}