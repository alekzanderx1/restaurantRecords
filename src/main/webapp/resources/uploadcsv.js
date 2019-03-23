angular.module('worldRestaurant').component('uploadcsv',{
	template:  	'<div class="container-fluid">'+
				'<h3><center>Upload Restaurant Data in CSV Format</center></h3><br/>'+
				'<form><table class="table table-bordered table-responsive" border=1><tr><td>Select File</td> <td><input type="file" id="files"></td></tr>'+
				'</table>'+
				'<input type="submit" class="btn btn-primary" value="Upload File" id="csv-file" ng-click="$ctrl.uploadFileCallback()"></form></div>',
	
	controller: function($http) {
		var $ctrl=this;
		$ctrl.file = "";
		
		this.uploadFileCallback = function() {
			const input = document.getElementById('files');
			const reader = new FileReader();

			input.onchange = function() {
			const file = input.files[0];
			reader.readAsArrayBuffer(file);
			};

			reader.onload = function() {
			const resultArray = new Int8Array(reader.result);
			 $ctrl.uploadCsvFile(resultArray);
			};
		}

		this.uploadCsvFile = function (fileData) {
				Papa.parse(fileData, {
					quotes: false,
					quoteChar: '"',
					escapeChar: '"',
					delimiter: ",",
					header: true,
					newline: "\r\n",
					dynamicTyping: true,
					skipEmptyLines: true,
					complete: function(results) {
									$ctrl.uploadDataCallback(results);
						}
					});
		 }
		 
		this.uploadDataCallback = function (results) {
			var data = results.data;
			$http.post("http://localhost:8080/world/restaurants/uploadcsvdata",JSON.stringify(data)
				).then(function successCallback(response) {
					alert("Data Succesfully Uploaded");
				}, function errorCallback(response) {
					alert("Error in data Upload, Please try again!");
					console.log("Error"+response.data);
				});
			
		}
	}
})
