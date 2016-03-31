/**
 * init:function
 * - main initialization function
 **/
function init(){
 // Initializing the SLD list
 var sldgetrequest=new ajaxRequest();
 sldgetrequest.onreadystatechange=function(){
 if (sldgetrequest.readyState==4){
        if (sldgetrequest.status==200 || window.location.href.indexOf("http")==-1){
          var jsondata=eval("("+sldgetrequest.responseText+")") //retrieve result as an JavaScript object
          var rssentries=jsondata.styles.style;

          var sldSelect = document.getElementById('sldSelect');
                  sldSelect.options.length = 0; // clear out existing items
          for (var i=0; i<rssentries.length; i++){
                var entry = rssentries[i];
                sldSelect.options.add(new Option(entry.name, i))
          }
          document.getElementById('selectedSld').value=sldSelect.options[0].text;
        }
        else{
          alert("An error has occured making the request");
        }
   }
  }

  sldgetrequest.open("GET", "/geoserver/rest/styles.json", true);
  sldgetrequest.setRequestHeader('Authorization', make_base_auth(geoserverUsername, geoserverPassword));
  sldgetrequest.send(null);

 // Initializing the Layers list
 var lyrgetrequest=new ajaxRequest();
 lyrgetrequest.onreadystatechange=function(){
 if (lyrgetrequest.readyState==4){
        if (lyrgetrequest.status==200 || window.location.href.indexOf("http")==-1){
          var jsondata=eval("("+lyrgetrequest.responseText+")") //retrieve result as an JavaScript object
          var rssentries=jsondata.layers.layer;

          var lyrSelect = document.getElementById('lyrSelect');
                  lyrSelect.options.length = 0; // clear out existing items
          for (var i=0; i<rssentries.length; i++){
                var entry = rssentries[i];
                lyrSelect.options.add(new Option(entry.name, i))
          }
          document.getElementById('selectedLyr').value=lyrSelect.options[0].text;
        }
        else{
          alert("An error has occured making the request");
        }
   }
  }

  lyrgetrequest.open("GET", "/geoserver/rest/layers.json", true);
  lyrgetrequest.setRequestHeader('Authorization', make_base_auth(geoserverUsername, geoserverPassword));
  lyrgetrequest.send(null);
}
