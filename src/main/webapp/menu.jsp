<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>

 <!-- CSS Test Zone -->
  <style>
    
  /**
   * Base styles for horizontal navigation
   */
  .horizontal-nav {
    background: #efefef;
    border-radius: 6px;
  }
  .horizontal-nav ul {
    background: #128F9A;
    float: left;
    text-align: center;
    border-radius: 6px;
    border: 1px solid #0e7079;
  }
  .horizontal-nav ul li {
    float: left;
    border-left: 1px solid #0e7079;
  }
  .horizontal-nav ul li:first-child {
    border-left: 0 none;
  }
  .horizontal-nav ul li a {
    display: block;
    padding: 10px 20px;
    color: #fff;
    border-top: 1px solid rgba(255,255,255, 0.25);
    border-left: 1px solid rgba(255,255,255, 0.25);
  }
  .horizontal-nav ul li:first-child a {
    border-left: 0 none;
  }
  .horizontal-nav ul li a:hover {
    background: #12808a;
  }
  .horizontal-nav ul li:first-child a {
    border-top-left-radius: 6px;
    border-bottom-left-radius: 6px;
  }
  .horizontal-nav ul li:last-child a {
    border-top-right-radius: 6px;
    border-bottom-right-radius: 6px;
  }
    
  </style>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.horizontalNav.js"></script>

<script type="text/javascript">
	// When document is ready...
	$(document).ready(function() {
		// Call horizontalNav on the navigations wrapping element
		$('.full-width').horizontalNav({});
	});
</script>
</head>
<body>
	<nav class="horizontal-nav full-width horizontalNav-notprocessed">
	  <ul>
	    <li><a href="#">Navigation Item</a></li>
	    <li><a href="#">Work</a></li>
	    <li><a href="#">Blog</a></li>
	    <li><a href="#">About</a></li>
	    <li><a href="#">Contact</a></li>
	  </ul>
	</nav>
</body>
</html>