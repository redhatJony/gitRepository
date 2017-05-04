<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>js demo</title>
</head>
<body>

<script type="text/javascript">
	
	 /* function showDate(){
		alert(Date());
	}  */
	
	//防止不能识别js的浏览器将脚本当成字符串显示
	<!-- 
		document.write("hello,javascript!"); document.write('<BR>'); 
		document.write(100.01-20.087);document.write('<BR>'); 
		document.write(0xfa45-0x62);document.write('<BR>');//16进制
		document.write(5E7-8E2); document.write('<BR>');//指数
		document.write(1e-2); document.write('<BR>');
		document.write(-4e-3);document.write('<BR>');//负小数
		document.write(.73);document.write('<BR>');//小数
		document.write(true*100+false*100+true*1);document.write('<BR>');//true、false与数值进行计算的时候自动转换成1、0
	//-->
	//字符串 是用'或者" 包括起来的字符串  ,用 \ 表示转义 \' 表示单引号 \n 表示换行
	/* var str = "mystr";
	var num = 1;
	var a = 34;
	document.write(num*str);
	document.write(a*num); */
	var num = 1;
	
	/* document.write(num++);document.write('<BR>');
	document.write(++num);
	var num2; */
	num=num++;
	document.write(num+" :num=num++中num值并没有增加！");document.write('<BR>');
	
	/* var num = 0;
    outPoint://标号
    for (var i = 0 ; i < 10 ; i++){
    	for (var j = 0 ; j < 10 ; j++){
           if( i == 5 && j == 5 ){
                 break outPoint;
           }
      	num++;
      	}
    }
    alert(num);  */// 循环在 i 为5，j 为5的时候跳出双循环，返回到outPoint层继续执行，输出 55
    
    <!-- 
    
   /*  function displayArguments(){
    	var i;
        for(i=0;i<arguments.length;i++){
        	document.write(arguments[i]);//可以用arguments数组访问调用函数时所有参数，
        	//每次调用函数书js会自动生成argument数组
        }
        document.write('<BR>');
    } */
  //后声明函数如果与先声明的函数重名则，后声明的覆盖先声明的，
  //不论参数类型及个数是否相同，只看函数名称
   /*  function displayArguments(s,w,j){
    	var i;
        for(i=0;i<arguments.length;i++){
        	document.write(arguments[i]+"2");//可以用arguments数组访问调用函数时所有参数，
        	//每次调用函数书js会自动生成argument数组
        }
        document.write('<BR>');
    }
    displayArguments("调用函数：","qwe","erer","tut");//调用无返回值函数
    displayArguments("调用函数：","qwe","erer");//调用无返回值函数 */
    function add(a,b){
    	return (a+b);
    }
    document.write('a+b='+add(2.1,8));document.write('<BR>');//调用有返回值函数
    var str = escape("jony bang bang");//非母字符被XX%代替
    document.write(str+'\n');document.write('<BR>');
    //eval() 执行字符串拼接的js脚本
    //isFinite(a)确定变量是否有边界，有，返回true，无，返回false.
    document.write(isFinite(12)+'<BR>');
    document.write(isFinite('a')+'<BR>');
    document.write(isFinite(true)+'<BR>');
    //isNaN(a)确定变量是否是NaN
    //parseFloat()将字符串中数字开头的部分转成浮点型数字
    //parseInt()将字符串中数字开头的部分转成整型数字
    //unescape()将字符串中的16进制码转成ASCII码
    document.write(isNaN('a')+'<BR>');
    document.write(parseFloat('123.2349asg')+'<BR>');
    document.write(parseInt('123.2349asg')+'<BR>');//123
    //JS 定义对象并使用
    function show_book(){
    	document.write("<h1>书名："+this.title+"</h1>");
    	document.write("<h1>作者："+this.authour+"</h1>");
    	document.write("<h1>出版社："+this.publisher+"</h1>");
    }
    function Book(x,y,z){
    	this.title = x;
    	this.authour = y;
    	this.publisher = z;
    	this.show_book = show_book;
    }
    MyBook = new Book("JS入门","ss","chubanshe");
    MyBook.show_book();
    document.write("作者："+MyBook.authour);document.write("<BR>");
    //数组  声明数组的方法  ，下标从0开始
	var myArr = new Array(4);//js会自定扩充数组大小，数组中可以放置不同类型的元素
	myArr = [1,2,3,4,5,5.6];
	document.write("myArr:"+myArr +" 长度："+myArr.length);document.write("<BR>");
    myArray = new Array(1,2,3,4,5,6,7,8);
    document.write(myArray +" 长度："+myArray.length);document.write("<BR>");
    delete myArray[2];document.write("<BR>");
    document.write(myArray);document.write("<BR>");
    //with 语句
    with(document){
    	document.write("文档的前景色是："+fgColor+"<BR>");
    	document.write("文档的背景色是："+bgColor+"<BR>");
    }
    //for in
   /*  document.write("<H2> document的属性如下：</H2>");
    for(var i in document){
    	document.write(i+"<BR>");
    }
     */
     //concat连接两个数组成一个
     document.write(myArray.concat('yewllo','red','orange'));document.write("<BR>");
     document.write(myArray.join(":"));document.write("<BR>");
     document.write(myArray.reverse());document.write("<BR>");
     document.write(myArray.slice(2,5));document.write("<BR>");
     document.write(myArray.sort());document.write("<BR>");
     document.write(myArray.toString());document.write("<BR>");
     
     //Boolean
     function letter(){
    	 if(this==true){
    		 return ("T");
    	 }else{
    		 return ("F");
    	 }
     }
     Boolean.prototype.letter = this.letter;//使用prototype指定新方法
     bool1 = new Boolean(2);
     bool2 = new Boolean(null);
     document.write("<h3>bool1.toString():"+bool1.toString()+"</h3>");
     document.write("<h3>bool2.toString():"+bool2.toString()+"</h3>");
     document.write("<h3>bool2.valueof():"+bool2.valueOf()+"</h3>");
     document.write("<h3>bool1.letter():"+bool1.letter()+"</h3>");
     document.write("<h3>bool2.letter():"+bool2.letter()+"</h3>");
     //date()
      document.write("<h4>Date对象</h4>");
     var date1 = new Date();
     var date2 = new Date(800000000000);
     var date3 = new Date(2016,03,03,23,12);
     /* document.write(date1+"<BR>");
     document.write(date2+"<BR>");
     document.write(date3+"<BR>"); */
     for(i=1;i<4;i++){
    	 document.write(eval("date"+i)+"<BR>");//eval函数将传入的js语句字符串当做js代码来执行，返回代码执行后的值
     }
     //Math对象
     document.write("<h4>Math对象</h4>");
     document.write("欧拉常数，Math.E = "+Math.E+"<BR>");
     document.write("根号2，Math.SQRT2 = "+Math.SQRT2+"<BR>");
     //Number对象
     document.write("<h4>Number对象</h4>");
     document.write("最大值，Number.MAX_VALUE="+Number.MAX_VALUE+"<BR>");
     document.write("最小值，Number.MIN_VALUE="+Number.MIN_VALUE+"<BR>");
     document.write("负无穷大，Number.NEGATIVE_INFINITY="+Number.NEGATIVE_INFINITY+"<BR>");
     document.write("正无穷大，Number.POSITIVE_INFINITY="+Number.POSITIVE_INFINITY+"<BR>");
     myNum = new Number(10903);
     document.write("转成字符串，myNum.toString()="+myNum.toString()+"<BR>");
     //RegExp对象
	 document.write("<h4>模式匹配RegExp对象</h4>");
	 var reCat = new RegExp("cat");
	 var reCat = new RegExp("cat","g"); 
	 var sToMatch = "cat";
     var reCat = /cat/g;
     document.write( "RegExp.test()测试:"+reCat.test(sToMatch)+"<BR>");
     var someText= "web2.0 .net2.0";
     var pattern = new RegExp("web","g");
     pattern=/[(web)*\d]/g;
     var outCome_exec=pattern.exec(someText);
     var outCome_matc=someText.match(pattern);
     document.write("RegExp示例："+outCome_exec+"<BR>");
     document.write("String.match示例："+outCome_matc+"<BR>");
	 //String对象
	 document.write("<h4>字符串String对象</h4>");
     var str="WREdsfsgs2543";
     document.write(str.fontcolor('#00ff00')+"<BR>");//设置字符串颜色
     document.write(str.fontcolor('blue')+"<BR>");//设置字符串颜色
     document.write(str.toLowerCase()+"<BR>");
     document.write(str.toUpperCase()+"<BR>");
     document.write(4+str.sub()+"<BR>");//下标显示
     document.write(3+str.sup()+"<BR>");//上标显示
     myStr = "www.baidu.com";
     linkStr = "请单击此处";
     document.write(linkStr.anchor('Hi')+'<p>');//设置锚点
     document.write(linkStr.link("#Hi"));
  //-->
	</script>
	<script language="javascript" type="text/javascript">
	var count=0;
	/* function eventHandler(){
		   alert("鼠标移动到了此超链接上！");
		} */
		 var basePath = '<%=basePath%>';
		 var path = '<%=path%>';
		 function showPath(){
			 alert("basepath="+basePath+"\n path= "+path);
		 }
	</script>
	<form>
		<input type="button" onClick="showDate();" value="显示时间">
		<input type="button" onClick="alert(Date());" value="显示时间2">
		<input type="button" onClick="displayArguments('batuns','sdsd');" value="函数参数">
		<input type="button" onClick="showPath();" value="显示路径">
	</form>
	<A href="www.baidu.com" onMouseOver="count++;alert('鼠标移动到这里'+count+'次了！')">请将鼠标移动到这里!</A>
	<br>
	<A href="hello.jsp" onMouseOver="eventHandler1();">鼠标移动到这里了!</A>

<script  type="text/javascript"  src="javascgrammars.js" charset=UTF-8>
</script>
</body>

</html>