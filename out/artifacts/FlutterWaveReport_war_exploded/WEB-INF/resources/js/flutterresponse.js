/**
 * Created by SP on 9/20/2017.
 */


$(function(){
    var $table = $('#tableId');

//Execute the below code only where we have this table
    if($table.length){
        var jsonUrl = '';
        if(window.btnClicked == ''){
            jsonUrl = window.contextRoot + "/searchFlutterResponseBasedOnCriteria/" + "/" + window.idVar + "/" + window.responseCodeVar + "/" + window.transStatusVar + "/" + window.respIDVar;
        }else{
            jsonUrl = window.contextRoot + "/searchAllFlutterResponse";
        }
        console.log("Inside the table!");
        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'ALL']],
            pageLength: 10,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'id'
                },
                {
                    data: 'fRequest_ID'
                },
                {
                    data: 'responseCode'
                },
                {
                    data: 'transStatus'
                },
                {
                    data: 'responseMessage'
                },
                {
                    data: 'respID'
                }
            ]
        });
    }
});
