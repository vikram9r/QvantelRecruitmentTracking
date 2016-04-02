function validateAndSaveAdditionalInfo(){
	var addInfo = $j("#addInfo").val();
	addInfo = $j.trim(addInfo);
	var customerId = $j("#customerId").val();
	if(addInfo.length > 2000){
		jqDialog.alert("Additional Info cannot exceed 2000 charecters");
		stopLoading();
	}else if(addInfo.length == 0){
		hideTextArea();//defined in viewBillInfo.jsp to hide text area if no data or spaces are entered
		stopLoading();
	}else{
		
		$j.post('addCustomerAdditionalInfo', {
	        customerId: customerId,
	        addInfo: addInfo
	        }, function(data) {
	    	if (isError(data)){
				//redirect to login.jsp if session expired.
			}
	        $j('#addInfoView').html(data);//div content of viewBillInfo.jsp
	        stopLoading();
		    });
	}
	
}
function createNewContact() {
    $j.post('createCandidate',{
        source:'contact'
    }, function(data) {
        $j("#main_content").html(data);
    });
}