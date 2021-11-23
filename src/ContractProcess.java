package lib;

import lib.ContractLib;
import common.Import;
import common.Export;
import common.CheckArgs;
import common.Customer;
import java.util.ArrayList;

/**
*クラス:ConstractProcess
*機能:契約の順序を管理するクラス
*入力、集計、出力をおこなうクラスを呼び出すexecution()を持つ
*/
public class ContractProcess {
	public void execution(String[] args) {
		ArrayList<Customer> importRequest = new ArrayList<>();
		ArrayList<String> exportRequest = new ArrayList<>();

		CheckArgs ca = new CheckArgs();
		ca.CheckUnit(args);

		Import im = new Import();
		importRequest = im.importFile(args[0]);

		ContractLib cl = new ContractLib();
		exportRequest = cl.procedure(importRequest,args[1]);

		Export ex = new Export();
		if(args.length == 2){
			ex.aggregatePrint(exportRequest);
		}else if(args.length == 3){
			ex.writeToFile(exportRequest,args[2]);
		}

	}

}
