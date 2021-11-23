package common;
import exception.NotSupportedArgsException;

/**
* クラス:CheckArgs
* 機能:指定した実行方法でなければ例外処理のメッセージを出力するCheckUnit()を持つ
* @param args:String[] 実行時引数
*/
public class CheckArgs{
    public void CheckUnit(String[] args){
        try{
            if(args.length < 2 || args.length > 3){
                throw new NotSupportedArgsException("取り込むデータを実行時の第一引数に指定してください\n出力単位は\"day\" または \"week\" を第二引数に指定してください\nファイル出力する際は第三引数にファイル名を指定してください");
            }
            if(!args[1].equals("day") && !args[1].equals("week") ){
                throw new NotSupportedArgsException("出力単位名に誤りがあります\n\"day\" または \"week\" を第二引数にして出力単位を指定してください");
            }
        }catch(NotSupportedArgsException e){
            e.printStackTrace();
        }
    }
}
