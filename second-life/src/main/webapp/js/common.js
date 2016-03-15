var contextRoot = 'http://localhost:8008/second-life';;
// 'http://192.168.0.33:8008/second-life';
// 'http://localhost:8008/second-life';

function logout() {
	$.post(contextRoot+'/cosmetic/ajax/logout.do',function(resultObj){
		var ajaxResult = resultObj.ajaxResult;
		var status = ajaxResult.status;
		if(status == 'success'){
			alert('로그아웃 성공');
			top.document.location.reload();
		}
	},"json");
}