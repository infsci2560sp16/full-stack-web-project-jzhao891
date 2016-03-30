<!DOCTYPE HTML>
<html>
<head>
<title>ALLTOUR-HOME</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="stylesheets/mystyle.css" rel="stylesheet">
<!--[if lt IE 7]>
<link href="css/fontello-ie7.css" type="text/css" rel="stylesheet">
<![endif]-->
<link href='http://fonts.googleapis.com/css?family=Quattrocento:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Patua+One' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<style type="text/css">
</style>
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.scrollTo-1.4.2-min.js"></script>
<script src="js/jquery.localscroll-1.2.7-min.js"></script>
<script>

</script>
</head>
<body style="background-image:url(img/top-bg.jpg);">
<div class="container">
<div class="container-head">
 <div>
      <table><tr>
        <td class="td-1" style="text-align:center;"><a href="Index.html"><img src="img/wowtour.jpg" alt="wowtour" width="120"></a>
        </td>
        <td class="td-3"></td>

        <td class="td-5" style="vertical-align:bottom; text-align:right;"><nav class="nav-menu">
          <ul>
          <li><a title="Destination" href="Index.html">Hello World!</a></li>
            <li><a title="services" href="Services.html">Services</a></li>
            <li><a title="news" href="Blogs.html">Blogs</a></li>
            <li><a title="team" href="UserMag.html">User Management</a></li>
            <li><a title="contact" href="About.html">About Us</a></li>
            <li><a title="SignIn" class="li-Sign" href="LogIn.html">LogIn</a></li>
          <#list date as detail>
          <#if detail_index==3>
          	<#if detail=="morning">
          		<li class="time"><img src="img/morning.png" alt="morning" width="45"><li>
          	<#elseif detail=="afternoon">
          		<li class="time"><img src="img/afternoon.png" alt="afternoon" width="45"><li>
          	<#else>
          		<li class="time"><img src="img/nignt.png" alt="nignt" width="45"><li>
          	</#if>
          </#if>
          </#list> 
          <#list date as detail>
          <#if detail_index==1>
          <li class="timetext">${detail}</li>
          <#elseif detail_index==2>
          <li class="timetext">/${detail}</li>
          <#elseif detail_index==5>
          <li class="timetext">/${detail}</li>
          </#if>
          </#list>
            
         
           
          </ul>
        </nav></td></tr>
        </table>
      </div>

</div>

<div class="container-content" >
<div class="header">
<h1><span style="color:#FF8C00">WOW TOUR! </span>Say Hello to The World.</h1>
</div>
  <div class="row">
        <div class="center">
          <h2>Search your destination</h2>
          <input type="text" name="your-destination" placeholder="New York" class="c-text" size="50" title="your destination">
          <input type="submit" value="Let's Go" class="c-submit" onClick="bt_submit_onclick()">
        </div>
      </div>






</div>
</div>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/site.js"></script>
</body>
</html>
