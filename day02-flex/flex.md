---
layout: post
title: flex布局
category: 工具
tags: css
---

## flex
	
指定任何一个容器为Flex布局    

	.box{
	  display: flex;
	}    


## 容器属性   

### flex-direction属性（指定主轴指向）
   

	.box {
	  flex-direction: row | row-reverse | column | column-reverse;
	}  

### flex-wrap属性（一条线排不下如何换行）

	.box{
	  flex-wrap: nowrap（不换行默认） | wrap （第一行在上面）| wrap-reverse（第一行下面）;
	}    


### flex-flow（同时声明主轴和换行方式）   


	.box {
	  flex-flow: <flex-direction> || <flex-wrap>;
	}  


### justify-content属性（主轴排序方式）   

	.box {
	  justify-content: flex-start（靠左对齐） | flex-end（靠最右对齐） | center（居中对齐） | space-between（两端对齐，项目之间的间隔都相等） | space-around(每个项目两侧的间隔相等);
	}   


### align-items属性（定义交叉轴方向排序）   

	.box {
	  align-items: flex-start（起点对齐） | flex-end（终点对齐） | center（中点对齐） | baseline（第一行文字基线对齐） | stretch（自动撑满）;
	}  


### align-content属性（定义多条轴对齐方式）


	.box {
	  align-content: flex-start（与交叉轴的起点对齐） | flex-end（与交叉轴的终点对齐） | center（与交叉轴的中点对齐） | space-between（与交叉轴两端对齐） | space-around（每根轴线两侧的间隔都相等） | stretch（轴线占满整个交叉轴默认）;
	}


## 项目属性   


### order属性    

定义项目的排列顺序。数值越小，排列越靠前，默认为0。  

	.item {
	  order: <integer>;
	}  


### flex-grow属性   

属性定义项目的放大比例，默认为0，即如果存在剩余空间，也不放大  

	
	.item {
	  flex-grow: <number>; /* default 0 */
	}  


### flex-shrink属性

定义了项目的缩小比例，默认为1，即如果空间不足，该项目将缩小  


如果所有项目的flex-shrink属性都为1，当空间不足时，都将等比例缩小。如果一个项目的flex-shrink属性为0，其他项目都为1，则空间不足时，前者不缩小。   


	.item {
	  flex-shrink: <number>; /* default 1 */
	}  



### flex-basis属性  

属性定义了在分配多余空间之前，项目占据的主轴空间（main size）。浏览器根据这个属性，计算主轴是否有多余空间。它的默认值为auto，即项目的本来大小。  


	.item {
	  flex-basis: <length> | auto; /* default auto */
	}   


### flex属性  
flex属性是flex-grow, flex-shrink 和 flex-basis的简写，默认值为0 1 auto。后两个属性可选。  

该属性有两个快捷值：auto (1 1 auto) 和 none (0 0 auto)。   




	.item {
	  flex: none | [ <'flex-grow'> <'flex-shrink'>? || <'flex-basis'> ]
	}   

### align-self属性  

允许单个项目有与其他项目不一样的对齐方式，可覆盖align-items属性。默认值为auto，表示继承父元素的align-items属性，如果没有父元素，则等同于stretch。

	.item {
	  align-self: auto | flex-start | flex-end | center | baseline | stretch;
	}    












	
	






 