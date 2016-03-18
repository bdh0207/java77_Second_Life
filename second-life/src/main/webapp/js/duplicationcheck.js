/**
 * 
 */

var mysql = require('mysql');
// 웹서버 생성
$('#inputId').keyup(function() {
	var client = mysql.createConnection({
		user : 'java77',
		password : '1111'
	});
	client.query('USE java77db');
	client.query('SELECT COUNT(*) FROM MEMBER WHERE ID='+$('#inputId').val(),function(error, result, fields){
		if(error){
			console.log('쿼리 문장에 오류가 있습니다.');
		}
		else{
			$('#idCheckText').text(result);
		}
	});
});
