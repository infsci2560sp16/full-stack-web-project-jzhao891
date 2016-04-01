function bt_submit_onclick(){
  var destination=document.getElementById("destination").value;
  $.get("/letgo",{"destination":destination},function(data){
    console.log(data);
    var e=data;//
    alert(e);
  });
}
