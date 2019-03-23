angular.module('worldRestaurant').component('homestate', {
 	
 template:  '<div class="container-fluid">'+
			'<center><h3>WorldRestaurants</h3>'+
			'<div id="grid1" ui-grid="$ctrl.gridOptions" class="grid"></div></center>'+
			'</div>',
           
  controller: function($http,$interval,$scope) {
	  this.gridOptions = {
			  data: '$ctrl.myJobsData',
			  enableRowSelection: true,
			  multiSelect: false,
			  enableColumnResize: true,
			  columnDefs: [
			  { field: 'jobName', displayName: 'Job Name'},
			  { field: 'jobType', displayName: 'Job Type'},
			  { field: 'tenantName', displayName: 'Tenant Name'},
			  { field: 'jobRegistrationTimestamp', displayName: 'Started',type: 'date', cellFilter: 'date:"dd MMM yyyy hh:mm"' },
			  { field: 'jobStatus', displayName: 'Status'},
			  { field: 'jobStatusComment', displayName: 'Status Comment' }
			  ]};
	  
	  var  $ctrl=this;
	  $ctrl.lastIndex=0;
	  var output;
	  $ctrl.fetchPodId=function()
	  {
		  $http({
				method: 'GET',
				url: 'http://localhost:8080/central/jobs/fetchlivepod',
			}).then(function successCallback(response) {
				  $ctrl.scopePODid=response.data[0].podid;
			}, function errorCallback(response) {
				console.log("Error while fetching tenants in pod"+response.data);
			});
	  }
	  $ctrl.loadPodid=$ctrl.fetchPodId();
	  $ctrl.myCallback=function(data)
	  {
		  $ctrl.tenantsInPodJSON=data;
		  console.log("Tenants in pod"+$ctrl.tenantsInPodJSON);
		  $ctrl.tenantNames=[];
		  for(var i=0;i<$ctrl.tenantsInPodJSON.length;i++)
			  {
			  	$ctrl.tenantNames.push($ctrl.tenantsInPodJSON[i].name);
			  }
		  console.log("Tenant Names"+$ctrl.tenantNames);
		  $ctrl.mrUrl=$ctrl.tenantsInPodJSON[0].mrConfiguration.componentInstance.url;
		  console.log($ctrl.mrUrl);
		  $ctrl.jobTypes=" ";
		  $ctrl.jobTypes=$ctrl.jobTypes.replace(/\s+/g, "");
		  $ctrl.jobTypesArray=$ctrl.jobTypes.split(',');
		  $http({
			method: 'GET',
			url: 'http://localhost:8080/central/jobs/currentsnapshot',
			params: { tenantNames: $ctrl.tenantNames.join(','), jobTypes: $ctrl.jobTypesArray.join(','), MRUrl:  $ctrl.mrUrl,snapshotName:  "HomePage"}
  
		}).then(function successCallback(response) {
			$ctrl.myJobsData=[];
			if($ctrl.lastIndex==0)
			{
				$ctrl.myJobsData=response.data;
				$ctrl.lastIndex=response.data.length - 1;

			}
			else
			{
				var counter=0;
				for(var i=0;i<response.data.length;i++)
					{
					counter++;
					if(counter>$ctrl.lastIndex)
						$ctrl.myJobsData.push(response.data[i]);
					}
				$ctrl.lastIndex=response.data.length-1;
			}
			console.log("Response from get Snapshot"+response);
			
		}, function errorCallback(response) {
			console.log("Error while fetching Job Snapshot"+response);
		});
		  
	  }
	 
	  $ctrl.loadTenants=function(podId,callback) {
		  $http({
				method: 'GET',
				url: 'http://localhost:8080/central/jobs/tenantsinpod',
				params:{ podId : podId }
			}).then(function successCallback(response) {
				console.log(response);
				callback(response.data);
				response=[];
			}, function errorCallback(response) {
				console.log("Error while fetching tenants in pod"+response.data);
			});
		  return output;
	  }
	  
	  $ctrl.loadGridData=function(){
		  console.log($ctrl.scopePODid);
		  $ctrl.loadTenants($ctrl.scopePODid,$ctrl.myCallback);
			
		   
	  }

	  $ctrl.Timer=$interval($ctrl.loadGridData,150000);
	  	

  }
})


