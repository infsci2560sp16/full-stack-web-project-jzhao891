function logsuccess(name){
  alter("Hello,"+name+"!");
	 window.location.replace( "Index.html" );
	 //change the login to "Hello, username!"
}
function uniqueId() {
  return 'id-' + Math.random().toString(36).substr(2, 16);
}
function signup(){
  var name=document.getElementById("usernamesignup").value;
  var email=document.getElementById("emailsignup").value;
  var password=document.getElementById("passwordsignup").value;
  var newuser={
    "name":name,
    "email":email,
    "password":password,
    "id":uniqueId()
  };
  /*var maxcount=0;//used to assign the value of id

  var getlistreq=new AjaxRequest();
  getlistreq.onreadystatechange=function(){
    if(getlistreq.readyState==4){
      if(getlistreq.status==200||window.location.href.indexOf("http")==-1){
        var jsondata=JSON.parse(getlistreq.responseText);
        var userlist=jsondata.users;
        newuser=jsondata.users[0].user1;
        maxcount=userlist.lenght;
        newuser.name=username;
        newuser.passward=passward;
        newuser.email=email;
        newuser.id=maxcount+1;
      }
      else{
        alert("An error has occured!");
      }
    }
  }
  getlistreq.open("GET","/data/users.json",true);
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
*/
  /*addreq.open("POST","/data/users.json",true);
  addreq.setRequestHeader("Content-type","application/json");
  addreq.send('"user'+newuser.id+'":{'+JSON.stringify(newuser)+"}");*/
  $.post("/signup",newuser,function(data){
    //console.log(data);
    window.alert("Sign up successfully!");
    window.location.href="/Index" ;
  });

}
function signin(){
  var email=document.getElementById("email").value;
  var password=document.getElementById("password").value;
  $.get("/signin",{"email":email,"password":password},function(data){
	var d=JSON.parse(data);
    console.log(data);
    var e=data;//
    window.alert(e+":login in successfully!");
    window.location.href="/Index" ;
  });
}
