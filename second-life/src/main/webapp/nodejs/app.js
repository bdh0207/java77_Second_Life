var express = require('express');
var mysql = require('mysql');

var app = express();

var pool = mysql.createPool({
  host :'localhost',
  port : 3306,
  user : 'java77',
  password : '1111',
  database:'java77db',
  connectionLimit:20,
  waitForConnections:false
});

app.get('/idCheck',function(req, res){
   var chk = req.param('uid');
   var callback = req.param('callback');
   pool.getConnection(function(err,connection){

     var query = connection.query("select count(*) cnt from member where id='"+chk+"'",function(err,rows){
       if (err) {
         console.log('에러발생');
         connection.release();
       }

       var chkResult = rows[0].cnt;
       res.send(callback+'({msg : "success", data : '+ chkResult +'})');

       connection.release();
     });
   });
});

app.listen(3001, function(){
  console.log('3001번 연결됨');
})
