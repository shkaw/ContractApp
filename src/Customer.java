package common;

/**
*クラス:Customer
*機能:顧客情報クラス
*フィールド:
* requestDate : Calendar 日付
* requestType : String 契約種
* lastName : String 姓
* firstName : String 名
*メソッド:
* Customer(Calendar,String,String,String) コンストラクタがsetterとして働く
* 各フィールドを取り出せるgetter
* dateToString():String 日付をStringで返す
*/

import java.util.Calendar;

public class Customer{
    private Calendar requestDate;
    private String requestType;
    private String lastName;
    private String firstName;

    /**
    * 引数を持つコンストラクタ
    * @param requestDates : Calendar  
    * @param requestType : String 契約種
    * @param lastName : String
    * @param firstName : String
    */
    public Customer(Calendar requestDate,String requestType,String lastName,String firstName){
        this.requestDate = requestDate;
        this.requestType = requestType;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Calendar getRequestDate(){
        return this.requestDate;
    }

    public String getRequestType(){
        return this.requestType;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    /**
     * 日付をyyyyMMddのStringで返す
     * @return 日付 yyyyMMdd : String
     */
    public String dateToString(){
        return String.format("%d/%d/%d",getRequestDate().get(Calendar.YEAR),(getRequestDate().get(Calendar.MONTH) + 1) ,getRequestDate().get(Calendar.DATE));
    }
}