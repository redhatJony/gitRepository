
//不论参数类型及个数是否相同，只看函数名称
function displayArguments(){
	var i;
    for(i=0;i<arguments.length;i++){
    	document.write(arguments[i]+"2");//可以用arguments数组访问调用函数时所有参数，
    	//每次调用函数书js会自动生成argument数组
    }
    document.write('<BR>');
}

function eventHandler1(){
	 alert("wewe");
}
