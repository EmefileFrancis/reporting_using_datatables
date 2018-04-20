/**
 * Created by SP on 9/20/2017.
 */


$(function(){
    var $table = $('#tableId');

//Execute the below code only where we have this table
    if($table.length){
        var jsonUrl = '';
        if(window.btnClicked == ''){
                jsonUrl = window.contextRoot + "/searchFRequestBasedOnCriteria" + "/" + window.transIDVar + "/" + window.card_noVar + "/" + window.refNOVar + "/" + window.statusVar;
        }else{
            jsonUrl = window.contextRoot + "/searchAllFRequest";
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
                    data: 'firstName'
                },
                {
                    data: 'lastName'
                },
                {
                    data: 'phoneNumber'
                },
                {
                    data: 'email'
                },
                {
                    data: 'card_no'
                },
                {
                    data: 'amount'
                },
                {
                    data: 'refNO'
                },
                {
                    data: 'status'
                }
            ]
        });
    }
});
