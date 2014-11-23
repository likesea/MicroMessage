/**
 * 单条删除
 */
 var deleteOne = function(id,basePath)
          	 {
          		var form =document.getElementById("mainForm");
          		var hidden = document.createElement("input");
          		hidden.value=id;
          		hidden.name="oneId";
          		form.appendChild(hidden);
          		form.action=basePath+"deleteOne.action";
          		form.submit();
          	 }
 var deleteBatch = function(basePath)
 {
	 var form =document.getElementById("mainForm");
	form.action=basePath+"deleteBatch.action";
	form.submit();
 }