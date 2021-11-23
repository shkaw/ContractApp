# ContractApp
 * .csvファイルを受け取り、任意の出力単位で集計し、標準出力、またはファイル出力をおこなう

# Requirement
 * 使用言語:Java
 * 必要なクラスファイル
	bin
	  |
	   -ContractApp.class
	   
	common
	  |
	   -CheckArgs.class
	   -CheckData.class
	   -Customer.class
	   -Import.class
	   -Export.class
	   
	lib
	  |
	   -ContractProcess.class
	   -ContractLib.class
	   
	exception
	  |
	   -NotSupportedArgsException.class
	
# Usage
 * 実行時コマンド例：
	ConstractApp直下にて4種類の実行方法が可能
	インプットしたい"申込.csv"は"申込"フォルダ直下に配置
	//日次で集計後、標準出力
	java bin/ContractApp 申込/申込_20210501.csv day
	//週次で集計後、標準出力
	java bin/ContractApp 申込/申込_20210501.csv week
	//日次で集計後、ファイル出力
	java bin/ContractApp 申込/申込_20210501.csv day output.csv
	//週次で集計後、ファイル出力
	java bin/ContractApp 申込/申込_20210501.csv week output.csv
 
 * コンパイル時：
	srcファイルに変更があった際のコンパイル方法
	javac -encoding utf8 -d ./ ./src/*.java
 
# Note
 * 集計方法(日次や週次)に追加(月次など)があった際は
 	toCompareDate()
 	addHeader()
 	aggregateDicide()
 	に追加をし、集計方法のメソッド(月次なら月初日を算出するメソッド)と連携させれば集計方法を追加可能
 	CheckArgsクラスのCheckUnit()で例外処理のメッセージを書いているのでそれも集計方法を追加をする
 
# Author
 * 川村 彰
 
