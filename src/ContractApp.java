package bin;
import lib.ContractProcess;

/**
*クラス:ContractApp
*アプリケーションクラス
*機能:
*   "申請日,申請種別,姓,名"の書式のcsvファイルをimportし、集計結果を標準出力、またはファイルをexportする
*実行コマンド例:
*   ContractAppディレクトリ直下にて
*標準出力:
*   java bin/ContractApp 申込/申込_20210501.csv day
*   java bin/ContractApp 申込/申込_20210501.csv week
*ファイル出力:
*   java bin/ContractApp 申込/申込_20210501.csv day output.csv
*   java bin/ContractApp 申込/申込_20210501.csv week output.csv
*引数:コマンドラインから
*   第一引数にデータ
*   第二引数にdayまたはweekで集計方法
*   第三引数には出力するファイル名を指定する 第三引数にファイル名がない場合は標準出力される
*/

public class ContractApp {
	public static void main(String[] args) {
        ContractProcess cp = new ContractProcess();
        cp.execution(args);
    }
}