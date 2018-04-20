/**
 * Created by SP on 9/20/2017.
 */


$(function(){
    var $table = $('#tableId');

//Execute the below code only where we have this table
    if($table.length){
        var jsonUrl = '';
        if(window.btnClicked == ''){
            jsonUrl = window.contextRoot + "/searchWamsLogBasedOnCriteria" + "/" + window.idVar + "/" + window.paycomVar + "/" + window.wamsRespVar + "/" + window.wamsResponseIDVar + "/" + window.fRequest_IDVar;
        }else{
            jsonUrl = window.contextRoot + "/searchAllWamsLog";
        }
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
                    data: 'paycomNO'
                },
                {
                    data: 'wamsResp'
                },
                {
                    data: 'wamsRespID'
                },
                {
                    data: 'amount'
                },
                {
                    data: 'fRequest_ID'
                }
            ]
        });
    }
});
