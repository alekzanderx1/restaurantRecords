
<!doctype html>
<html>
<head>
<title>World Restaurants</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.9/angular-material.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-animate.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-aria.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-messages.min.js"></script>
<script src="https://cdn.rawgit.com/angular-ui/bower-ui-grid/master/ui-grid.min.js"></script>
<link rel="stylesheet" href= "https://cdn.rawgit.com/angular-ui/bower-ui-grid/master/ui-grid.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.19/angular-ui-router.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/2.5.0/ui-bootstrap-tpls.js"></script>
<!--include jquery only when using bootstrap jquery plugins-->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/styling.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-spinner/0.8.1/angular-spinner.js"></script>
</head>
<body ng-app="worldRestaurant">
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span> 
				</button>
				<a class="navbar-brand" ui-sref="home"><strong>World Restaurants</strong></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a ui-sref="home">Restaurants</a></li>
					<li><a ui-sref="Upload CSV Data">Upload Restaurant Data</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="row" style="margin-top:70px">
	<div class="col-sm-1">
	<!--just for margin-->
	</div>
	<div  class="col-sm-10 col-xs-12" style="border:solid 1px #8ab2f4;">
	<ui-view><md-progress-circular md-mode="indeterminate" ng-show="$ctrl.isLoading"></md-progress-circular>
	</ui-view>
	</div>
	<div class="col-sm-1">
	<!--just for margin-->
	</div>
	</div>

<script src="resources/app.js"></script>
<script src="resources/papaparse.min.js"></script>
<script src="resources/home.js"></script>
<script src="resources/uploadcsv.js"></script>
</body>
</html>