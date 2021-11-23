package common;
import java.text.DateFormat;

/**
* クラス:CheckData
* 機能:日付の妥当性を確認するcheckData()を持つ
*/
class CheckData{
    /**
     * checkDate(String strDate):boolean 日付の妥当性チェック 存在する日付ならtrueを戻す
     * 日付の妥当性チェック
     * 指定した日付文字列(yyyy/MM/dd)が
     * カレンダーに存在するかをbooleanで返却
     * @param strDate:String チェック対象の日付文字列
     * @return 存在する日付の場合true
     */
    public boolean checkDate(String strDate) {
        if (strDate == null || strDate.length() != 10) {
            throw new IllegalArgumentException("引数の文字列["+ strDate +"]" + "は不正です。");
        }
        DateFormat format = DateFormat.getDateInstance();
        //日付解析を厳密に行うか設定
        format.setLenient(false);
        try {
            format.parse(strDate);
            return true;
        } catch (Exception e) {
            System.out.println("存在しない日付が入力されています。");
            return false;
        }
    }
}