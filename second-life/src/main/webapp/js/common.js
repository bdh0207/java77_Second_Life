var contextRoot = 'http://192.168.0.8:8008/second-life';
var contextNode = 'http://localhost:8008';
// 'http://192.168.0.8:8008/second-life';
// 'http://localhost:8008/second-life';

function logout() {
	$.post(contextRoot+'/cosmetic/ajax/logout.do',function(resultObj){
		var ajaxResult = resultObj.ajaxResult;
		var status = ajaxResult.status;
		if(status == 'success'){
			top.document.location.reload();
		}
	},"json");
}
