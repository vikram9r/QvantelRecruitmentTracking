<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:url var="appContext" value="/" />
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 <div class="body">
	<div>
	 
	   <table id="list">
	                <tr>
	                        <td />
	                </tr>
	        </table>
	        <div id="pager"></div>
	        <div style="margin-top:10px;">
	        </div>
	        <input type="button" id="addCandidate" value="Add"/>
	        <!-- <input type="button" id="editCandidate" value="Edit"/> -->
	        <input type="button" id="deleteCandidate" value="Delete"/>
	        <input type="button" id="shareForScreening-button" value="Share For Screening"/>
	        <!-- <button id="shareForScreening-button" style="float: right;">Share for Screening</button> -->
	</div>
	
  <!-- Share for screening dialog box  start-->
  <div id="shareForScreening-dialog" title="Whom to share ?"></div>
 <!-- Share for screening dialog box  end-->
	<script>
	 $(document).ready(function(){
	  $("#list").jqGrid({
	                url : "loadData",
	                datatype : "json",
	                mtype : 'POST',
	                colNames : [ 'ID','Name','Email', 'Mobile', 'Status'],
	                colModel : [ {
                        name : 'id',
                        index : 'id',
                        width : 150
                    },{
                        name : 'name',
                        index : 'name',
                        width : 150
                    }, {
	                        name : 'email',
	                        index : 'email',
	                        width : 150,
	                        editable : false
	                },{
                        name : 'mobile',
                        index : 'mobile',
                        width : 150,
                        editable : false
                    }, {
	                        name : 'status',
	                        index : 'status',
	                        width : 550,
	                        editable : false
	                }],
	                postData: {},
	                rowNum : 3,
	                rowList : [ 3, 6, 10 ],
	                autowidth: true,
	                rownumbers: true,
	                pager : '#pager',
	                height: 'auto',
	                sortname : 'id',
	                sortorder : 'asc',
	                viewrecords : true,
	                gridview : true,
	                multiselect: true,
	                multiboxonly: false,
	                caption : 'Candidates List',
	                emptyrecords: "No data",
	                loadonce: false,
	                loadComplete: function() {
	                	$('input[type="text"], select').css('height','20px');
	                },
	                ondblClickRow: function(rowId) {
	                    var rowData = jQuery(this).getRowData(rowId); 
	                    var candidate_id = rowData['id'];
	                    window.location.replace("${appContext}candidate/new?candidate_id="+candidate_id);
	                },
	                jsonReader : {
	                	root: 'rows',
	                    page: 'page',
	                    total: 'total',
	                    records: 'records',
	                    repeatitems: false,
	                    id: 'id'
	                }
	               
	        });
			  /* $("#list").setGridParam({ datatype: 'json', page: 1, url: 'loadData', postData: JSON.stringify(selections) });
			  $("#list").trigger('reloadGrid'); */
			  
	          $("#list").setGridParam({datatype:'json', page:1}).trigger('reloadGrid'); 
	         $("#list").jqGrid('navGrid', '#pager', {edit:false, add:false, del:false, search:false});
	        
	        $('#editCandidate').on('click',function(){
	         
	         /* edit functionality by checking row
	         var selRowArr = $("#list").getGridParam('selarrrow');
	         if(selRowArr.length == 1){
		         var selectedAppIds = [];
		         for(var i=0;i<selRowArr.length;i++){
		          var celValue =  $('#list').jqGrid('getCell', selRowArr[i], 'id');
		          selectedAppIds.push(celValue);
		         }
		         window.location.replace("${appContext}candidate/new?candidate_id="+selectedAppIds[0]);
		         //$('#list').trigger( 'reloadGrid' );
	         }else if(selRowArr.length == 0){
	        	 alert('select the candidate to edit');
	         }else if(selRowArr.length > 1){
	        	 alert('select any one candidate at once');
	         } */
	   
	        });
	        
	        $('#addCandidate').on('click',function(){
	        	window.location.replace("${appContext}candidate/new");
	        });
	        $('#addCandidate').on('click',function(){
	        	window.location.replace("${appContext}candidate/new");
	        });
	        
	        
	        
	        $('#shareForScreening-dialog').dialog({
		        autoOpen: false,
		        title: 'Whom to share ?'
		    });
		    $('#shareForScreening-button').click(function() {
		    	var selRowArr = $("#list").getGridParam('selarrrow');
		         if(selRowArr.length >= 1){
			         var candidates = [];
			         for(var i=0;i<selRowArr.length;i++){
			          var celValue =  $('#list').jqGrid('getCell', selRowArr[i], 'id');
			          candidates.push(celValue);
				    	$.post( 
				    			"shareProfilesForScreening",
				    			{ candidate_ids: candidates },
				    			function(data) {
				    				$('#shareForScreening-dialog').html(data);
				    			}
				    	);
				    	$('#shareForScreening-dialog').dialog('open');
			         }
		         }else if(selRowArr.length == 0){
		        	 alert('select the candidate(s) to share for screening');
		         }
		    	
		        return false;
		    });
	        
	 });
	</script>
  </div>
 </tiles:putAttribute>
</tiles:insertDefinition>