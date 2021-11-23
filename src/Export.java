package common;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
* クラス:ConstractLib
* 機能:集計の本処理メソッドを持ったクラス
* 出力クラス
* 標準出力、ファイル書き込み、二つのメソッドを持つ
*/
public class Export{

    /**
     * 
     * exportRequest:List<String>に入っているデータをすべて標準出力する
     * @return void
     */
    public void aggregatePrint(ArrayList<String> exportRequest){
        for (int i = 0; i < exportRequest.size(); i++){
            System.out.println(exportRequest.get(i));
        }
    }

     /**
     * exportRequest:List<String>に入っていたデータをすべてファイル出力する
     * @param fileName 出力するファイルの名前
     * @return void
     */
    public void writeToFile(ArrayList<String> exportRequest,String fileName){
        try{
            PrintWriter pw = new PrintWriter(fileName);
            for (int i = 0; i < exportRequest.size(); i++){
                pw.format("%s\n",exportRequest.get(i));
            }
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}