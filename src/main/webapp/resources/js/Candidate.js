function viewCandidates() {
	$.post( 
			"viewCandidates",
			{ showType: "view" },
			function(data) {
				$('#candidatesTab').html(data);
			}
	);
	$("#tabs").tabs("select", "#candidatesTab");
}

function viewJobs() {
	$.post( 
			"viewJobs",
			{ showType: "view" },
			function(data) {
//				$('#jobsTab').html(data);
			}
	);
//	$("#tabs").tabs("select", "#jobsTab");
}

function createJob() {
   $.post( 
      "newJob",
      function(data) {
         $('#jobsTab').html(data);
      }
   );
   $("#tabs").tabs("select", "#jobsTab");
}

function createCandidate() {
	$.post( 
			"newCandidate",
			function(data) {
				$('#candidatesTab').html(data);
			}
	);
	$("#tabs").tabs("select", "#candidatesTab");
}

function applyForJob(job_id){
	$.post( 
			"applyForJob",
			{ job_id: job_id },
			function(data) {
				$('#candidatesTab').html(data);
			}
	);
	$( "#tabs" ).tabs({ active: $('#tabs a[href="#candidatesTab"]').parent().index() });
}

function viewResume(candidate_id){
	$.post( 
			"viewResume",
			{ candidate_id: candidate_id },
			function(data) {
				$('#candidatesTab').html(data);
			}
	);
	$( "#tabs" ).tabs({ active: $('#tabs a[href="#candidatesTab"]').parent().index() });
}

function showLoading() {
	$.dimScreen(500,0.5, null, false, $(document).height());
	$.fancybox.showActivity();
}

function stopLoading() {
	$.fancybox.hideActivity();
    $.dimScreenStop();
}
