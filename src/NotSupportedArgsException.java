package exception;

/**
* クラス:NotSupportedArgsException
* Exceptionメソッドを持つ
*/
/**
 * 実行時引数の例外処理
 * 指定した実行方法でなければ例外処理のメッセージを出力する
 * @param msg:String 例外時メッセージ
 */
public class NotSupportedArgsException extends Exception{
    public NotSupportedArgsException(String msg) {
        super(msg);
    }
}
