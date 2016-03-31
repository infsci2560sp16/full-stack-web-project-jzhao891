function logsuccess(){
	 window.location.replace( "Index.html" );
	 //change the login to "Hello, username!"
}
function signup(){
  var username=document.getElementById("usernamesignup").value;
  var email=document.getElementById("emailsignup").value;
  var password=document.getElementById("passwordsignup").value;
  var newuser=null;
  var maxcount=0;//used to assign the value of id
  var getlistreq=new AjaxRequest();
  getlistreq.onreadystatechange=function(){
    if(getlistreq.readyState==4){
      if(getlistreq.status==200||window.location.href.indexOf("http")==-1){
        var jsondata=eval("("+getlistreq.responseText+")");
        var userlist=jsondata.users;
        newuser=jsondata.users[0].user1;
        maxcount=userlist.lenght;
      }
      else{
        alert("An error has occured!");
      }
    }
  }
  getlistreq.open("GET","/data/users.json",false);
  getlistreq.send(null);
  var addreq=new AjaxRequest();
  addreq.onreadystatechange=function(){
    if(addreq.readyState==4){
      if(addreq.status==200||window.location.href.indexOf("http")==-1){
        alert("Sign up successfully ! ");
      }
      else{
        alert("An error has occured!");
      }
    }
  }
  newuser.name=username;
  newuser.passward=passward;
  newuser.email=email;
  newuser.id=maxcount+1;
  addreq.open("POST","/data/users.json",true);
  addreq.setRequestHeader("Content-type","application/json");
  addreq.send('{"users":'+JSON.stringify(userlist)+',"user'+newuser.id+'":'+JSON.stringify(newuser));
  logsuccess();
}
