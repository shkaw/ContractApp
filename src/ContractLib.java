package lib;
import common.Customer;

import java.util.Calendar;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;

/**
*クラス:ContractLib
*機能:集計の本処理メソッドを持ったクラス
*/
class ContractLib{

    /**
     * 手続きメソッド
     * ArrayList<String>にデータを入れていく
     * aggregateDicide()を呼び出し集計方法を決め、
     * addHeader()で見出しを入れ、
     * aggregate()でデータを入力していく
     * @param importRequest:ArrayList<Customer> , requestTypeStr:String dayまたはweek
     * @return exportRequest:ArrayList<String> 出力データ
     */
    public ArrayList<String> procedure(ArrayList<Customer> importRequest,String requestTypeStr){
        int requestTypeInt = aggregateDicide(requestTypeStr);
        ArrayList<String> exportRequest = new ArrayList<>();
        exportRequest = addHeader(exportRequest,requestTypeInt);
        exportRequest = aggregate(importRequest, exportRequest,requestTypeInt);
        return exportRequest;
    }

    /**
     * 集計を振り分けるために日次か週次を判定、戻り値にはintを返す
     * @param writeType:String 日次または週次
     * @return dayなら 1 week 2
     */
    private int aggregateDicide(String writeType){
        if(writeType.equalsIgnoreCase("day")){
            return 1;
        }else if(writeType.equalsIgnoreCase("week")){
            return 2;
        }else{
            //エラー
            return 0;
        }
    }

    /**
     * 集計メソッド
     * importRequestをArrayList<String> exportRequestに格納 集計後exportRequestを戻す
     * フィールド:
     * newCus:int 新規
     * updkae:int 更新
     * unknown:int 不明
     * groupTotal:int 合計
     * compareDate:String 単位を分ける際に使用する日付の文字列
     * @param importRequest:ArrayList<Customer> importしたデータ
     * @param exportRequest:ArrayList<String> 出力するデータ
     * @param requestType:int 日次または週次 1:day,2:week
     * @return exportRequest
     */
    private ArrayList<String> aggregate(ArrayList<Customer> importRequest,ArrayList<String> exportRequest,int requestType){
        int newCus = 0;
        int updCus = 0;
        int unknown = 0;
        int groupTotal = 0;
        int i = 0;
        String compareDate = toCompareDate(importRequest,requestType,i);
        while(i < importRequest.size()){          
            while(i < importRequest.size() && compareDate.equals(toCompareDate(importRequest,requestType,i))){ //日付が同じ間
                if(importRequest.get(i).getRequestType().equals("新規")){
                    newCus++;
                }else if(importRequest.get(i).getRequestType().equals("更新")){
                    updCus++;
                }else{
                    unknown++;
                }
                groupTotal ++;
                i++;
            }
            //日付が変わったら
            exportRequest.add(compareDate + "," + newCus + "," + updCus + "," + unknown + "," + groupTotal);
            if(i < importRequest.size()){
                compareDate = toCompareDate(importRequest,requestType,i);
                newCus = 0;
                updCus = 0;
                unknown = 0;
                groupTotal  = 0;
            }
        }
        return exportRequest;
    }

    /**
     * 比較する日付を返すメソッド
     * 入力されたデータ、集計タイプ、インクリメントの位置を受け取り、日付を返す
     * @param importRequest:ArrayList<Customer> importしたデータ
     * @param requestType:int 日次または週次1:day,2:week
     * @param inc:int インクリメントの位置
     * @return 日付の文字列
     */
    private String toCompareDate(ArrayList<Customer> importRequest,int requestType,int inc){
        if(requestType == 1){
            return importRequest.get(inc).dateToString();
        }else if(requestType == 2){
            return dayOfWeekMonday(importRequest.get(inc));
        }
        return "";
    }

    /**
    * 週次のためのメソッド
    * 日付を受け取り、その日付の週の月曜日の日付を"yyyy/MM/dd形式の"Stringで返す
    * 例: 1/1(月曜) 1/2(火曜)... 1/7(日曜)　の場合、1/1と1/7どちらの場合でも1/1を返す
    * @return 月曜日の日付:String
    */
    private String dayOfWeekMonday(Customer customer){
        LocalDate oneday = LocalDate.of(customer.getRequestDate().get(Calendar.YEAR),(customer.getRequestDate().get(Calendar.MONTH) + 1),customer.getRequestDate().get(Calendar.DATE));
        LocalDate previousMonday = oneday.with(TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY));
        return previousMonday.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    /**
    * 見出しをつけるためのメソッド
    * heading:String 見出し "申請日(日次または週次),新規,更新,不明,(日次または週次)合計"
    */
    private ArrayList<String> addHeader(ArrayList<String> exportRequest,int requestType){
        String heading = "新規,更新,不明";
        switch(requestType){
            case   1:
                exportRequest.add("日次," + heading + ",日次合計");
                break;
            case 2:
                exportRequest.add("週次," + heading + ",週次合計");;
                break;
        }   
        return exportRequest;
    }

}