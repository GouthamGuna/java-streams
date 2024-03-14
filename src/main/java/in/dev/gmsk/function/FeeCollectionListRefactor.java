package in.dev.gmsk.function;

import in.dev.gmsk.model.Fee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FeeCollectionListRefactor {

    public static Fee getFee(){

        Fee returnObj = new Fee();
        List<Fee> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){

            Fee fee = new Fee();
            fee.setTotalAmount( "2000" );
            fee.setTotalBalance( "100" );
            fee.setTotalFeeAmount( "2000" );

            list.add( fee );
        }

        returnObj.setTotalFeeAmount( "3000" );
        returnObj.setFeeList(list );

        return returnObj;
    }

    public static void runner(){

        Fee noOfObj = getFee();

        double totalBalance = 0.0;

        for(Fee obj: noOfObj.getFeeList()){
            totalBalance += Double.parseDouble( obj.getTotalBalance() );
        }

        if(totalBalance != 0.0){
            System.out.println(noOfObj.getFeeList());
        }
    }

    public static void main(String[] args) {
        runner();
    }
}
