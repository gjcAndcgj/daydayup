---
layout: post
title: bootstrap栅格布局
category: 工具
tags: css
---

## 默认基本模板  

	<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>bootstrap</title>
	    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	
	    <!-- Bootstrap -->
	    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	
	
	
	    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</body>
	</html>
   

## 布局容器   

`.container`类用于固定宽度并支持响应式布局的容器。   

`.container-fluid` 类用于 100% 宽度，占据全部视口（viewport）的容器。


## 栅格系统   


`.row` 元素 设置负值 `margin` 从而抵消掉为 `.container` 元素设置的 `padding`，也就间接为“行（row）”所包含的“列（column）”抵消掉了`padding`   

### 栅格参数   

超小屏幕 手机 (<768px)    类前缀：`.col-xs-`

小屏幕 平板 (≥768px)  类前缀：`.col-sm-`

中等屏幕 桌面显示器 (≥992px)   类前缀：`.col-md-`

大屏幕 大桌面显示器 (≥1200px)  类前缀：`.col-lg-`  


### 流式布局容器   
 
	将固定宽度的栅格布局转换为 100% 宽度的布局  container-fluid
	<div class="container-fluid">
	  <div class="row">
	    ...
	  </div>
	</div>   

### 移动设备布局   

需要添加各种不同的设备的类前缀   


	<div class="row">
	  <div class="col-xs-12 col-sm-6 col-md-8">.col-xs-12 .col-sm-6 .col-md-8</div>
	  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
	</div>
	<div class="row">
	  <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
	  <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
	  <!-- Optional: clear the XS cols if their content doesn't match in height -->
	  <div class="clearfix visible-xs-block"></div>
	  <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
	</div>   

### 多余的行会将另起一行排列   

当row内包含的列超过12个，则那个就另起一行 

	<div class="row">
	  <div class="col-xs-9">.col-xs-9</div>
	  <div class="col-xs-4">.col-xs-4<br>Since 9 + 4 = 13 &gt; 12, this 4-column-wide div gets wrapped onto a new line as one contiguous unit.</div>
	  <div class="col-xs-6">.col-xs-6<br>Subsequent columns continue along the new line.</div>
	</div>     

### 响应式列重置   

	
在某些阈值时，某些列可能会出现比别的列高的情况。建议联合使用 .clearfix   


	<div class="row">
	  <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
	  <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
	
	  <!-- Add the extra clearfix for only the required viewport -->
	  <div class="clearfix visible-xs-block"></div>
	
	  <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
	  <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
	</div>   


### 列偏移   

使用 .col-md-offset-* 类可以将列向右侧偏移。这些类实际是通过使用 * 选择器为当前元素增加了左侧的边距（margin）。例如，.col-md-offset-4 类将 .col-md-4 元素向右侧偏移了4个列（column）的宽度。   

	<div class="row">
	  <div class="col-md-4">.col-md-4</div>
	  <div class="col-md-4 col-md-offset-4">.col-md-4 .col-md-offset-4</div>
	</div>
	<div class="row">
	  <div class="col-md-3 col-md-offset-3">.col-md-3 .col-md-offset-3</div>
	  <div class="col-md-3 col-md-offset-3">.col-md-3 .col-md-offset-3</div>
	</div>
	<div class="row">
	  <div class="col-md-6 col-md-offset-3">.col-md-6 .col-md-offset-3</div>
	</div>   

### 嵌套列   

为了使用内置的栅格系统将内容再次嵌套，可以通过添加一个新的 .row 元素和一系列 .col-sm-* 元素到已经存在的 .col-sm-* 元素内。被嵌套的行（row）所包含的列（column）的个数不能超过12（其实，没有要求你必须占满12列）。  

	<div class="row">
	  <div class="col-sm-9">
	    Level 1: .col-sm-9
	    <div class="row">
	      <div class="col-xs-8 col-sm-6">
	        Level 2: .col-xs-8 .col-sm-6
	      </div>
	      <div class="col-xs-4 col-sm-6">
	        Level 2: .col-xs-4 .col-sm-6
	      </div>
	    </div>
	  </div>
	</div>   




### 列排序   

通过使用 .col-md-push-* 和 .col-md-pull-* 类就可以很容易的改变列（column）的顺序。   

	<div class="row">
	  <div class="col-md-9 col-md-push-3">.col-md-9 .col-md-push-3</div>
	  <div class="col-md-3 col-md-pull-9">.col-md-3 .col-md-pull-9</div>
	</div>   







 




	
	






 