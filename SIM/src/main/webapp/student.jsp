<%--
  Created by IntelliJ IDEA.
  User: Laimande
  Date: 2022-11-09
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理</title>
    <style>
        #container{
            background-color:ghostwhite;
            width: 80%;
            height: 800px;
            margin: 0px auto;
        }

        #dataTable{
            width: 100%;
        }

        th{
            background-color: aquamarine;
            color: white;
        }
        .oddStyle{
            background-color: blanchedalmond;
        }
        .evenStyle{
            background-color: darksalmon;
        }


        .InputDialog{
            width: 400px;
            height: 300px;

            position: absolute;
            top: 100px;
            left: calc(50% - 150px);
            z-index: 10;
            background-color: darksalmon;
            box-shadow:red 0px 0px 10px
        }


        /* 外面盒子样式---自己定义 */
        .page_div{margin:20px 10px 20px 0;color:#666}
        /* 页数按钮样式 */
        .page_div button{display:inline-block;min-width:30px;height:28px;cursor:pointer;color:#666;font-size:13px;line-height:28px;background-color:#f9f9f9;border:1px solid #dce0e0;text-align:center;margin:0 4px;-webkit-appearance: none;-moz-appearance: none;appearance: none;}
        #firstPage,#lastPage,#nextPage,#prePage{width:50px;color:#0073A9;border:1px solid #0073A9}
        #nextPage,#prePage{width:70px}
        .page_div .current{background-color:#0073A9;border-color:#0073A9;color:#FFF}
        /* 页面数量 */
        .totalPages{margin:0 10px}
        .totalPages span,.totalSize span{color:#0073A9;margin:0 5px}
        /*button禁用*/
        .page_div button:disabled{opacity:.5;cursor:no-drop}
    </style>


    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/pageMe.js"></script>
    <script type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
    <script>
        var pagesize = 10;

        $(function (){
            $("#createDialog").hide();
            $("#updateDialog").hide();
           // alert("hello");
            initDataTable();
        });

        function initDataTable(){

            $.get(
                "student",
                {"op":"list","pageNum":1,pageSize:10},
                function(result){
                   loadData(result)
                },
                "JSON"
            );
        }
        function save(){
           console.info($("#saveForm").serialize());
           $.get(
               "student?op=save&"+$("#saveForm").serialize(),
               {},
               function(result){
                   if(result=="true"){
                       alert("保存成功");
                       $(".oddStyle").remove();
                       $(".evenStyle").remove();
                       $("#createDialog").hide();
                       $("#saveForm")[0].reset();
                       initDataTable();
                   }else{
                       alert("保存失败");
                   }
               }
               ,"text"
           );
        }
        //update
        function update(){
            $.get(
                "student?op=update&"+$("#updateForm").serialize(),
                {},
                function(result){
                    if(result=="true"){
                        alert("修改成功");
                        $(".oddStyle").remove();
                        $(".evenStyle").remove();
                        $("#updateDialog").hide();
                        $("#updateForm")[0].reset();
                        initDataTable();
                    }else{
                        alert("保存失败");
                    }
                }
                ,"text"
            );
        }


        function toUpdate(id){
            $.get(
                "student?op=get&id="+id,
                {},
                function(stu){
                    ///
                    $("#name").val(stu.name);
                    $("#birthday").val(stu.birthday);
                    $("#address").val(stu.address);
                    $("#phone").val(stu.phone);
                    $("#id").val(stu.id);
                    $("#updateDialog").show();

                }
                ,"json"
            );
        }


        function showSaveDialog(){
            $("#createDialog").show();
        }

        function query(pageNum, pageSize){
            let qstr = $("#queryForm").serialize();
            $(".oddStyle").remove();
            $(".evenStyle").remove();
            $.get(
                "student?op=list&"+qstr+"&pageNum="+pageNum+"&pageSize="+pageSize,
                {},
                function(result){
                  loadData(result);
                },
                "JSON"
            );
        }



        function queryAll(pageNum,pageSize){
            $("#queryForm")[0].reset();
            let qstr = $("#queryForm").serialize();
            $(".oddStyle").remove();
            $(".evenStyle").remove();
            $.get(
                "student?op=list&"+qstr+"&pageNum="+1+"&pageSize="+pageSize,
                {},
                function(result){
                    loadData(result);
                },
                "JSON"
            );
        }

        function deleteStudent(id){
            if(confirm("确定删除此数据吗？")){
                $.get(
                    "student?op=delete&id="+id,
                    {},
                    function(result){
                        //
                        if(result ==="true"){
                            alert("删除成功");
                            query(1,10);
                        }else{
                            alert("删除失败");
                        }
                    },
                    "text"
                );
            }

        }


        function loadData(result) {

            $("#page").paging({
                pageNum: result.pageNum, // 当前页面
                totalNum: result.count, // 总页码
                totalList: result.total, // 记录总数量
                callback: function (num) { //回调函数
                    //console.log(num);
                    query(num, pagesize);
                }
            });
            if (result.data.length == 0) {
                $("#dataTable").append("<tr style='oddStyle'><td colspan='6'>暂无数据</td></tr>");
            } else {
                for (let i = 0; i < result.data.length; i++) {
                    let stu = result.data[i];
                    let styleName = "oddStyle";
                    if (i % 2 == 0) {
                        styleName = "oddStyle";
                    } else {
                        styleName = "evenStyle";
                    }
                    $("#dataTable").append("<tr class='" + styleName + "'><td>" + stu.id + "</td><td>" + stu.name + "</td><td>" + stu.address + "</td><td>" + stu.phone + "</td><td>" + stu.birthday + "</td><td><a href='javascript:void(0);' onclick='toUpdate("+stu.id+")'>修改</a> <a href='javascript:void(0);' onclick='deleteStudent("+stu.id+")'>删除</a></td></tr>");
                }
            }
        }

        function cancel(dig){
            $("#saveForm")[0].reset();
            $(".inputDialog").hide();
        }

    </script>

</head>
<body>
   <div id="container">
        <h3>学生信息管理</h3>
       <hr>
       <span style="float: right"><a href="javascript:void(0)" onclick="showSaveDialog()">添加</a></span>
       <form id="queryForm">
           姓名:<input type="text" name="name">
           地址:<input type="text" name="address">
           电话:<input type="text" name="phone">
           <br>
           生日:<input type="text" name="birthdayStart" readonly="readonly"  onClick="WdatePicker({el:this})">-<input type="text" name="birthdayEnd" readonly="readonly"  onClick="WdatePicker({el:this})">
       </form> <button onclick="query(1,10)">查询</button><button onclick="queryAll(1,10)">清除条件</button>
       <table id="dataTable">
           <tr>
               <th>学号</th>
               <th>姓名</th>
               <th>地址</th>
               <th>电话</th>
               <th>生日</th>
               <th>操作</th>
           </tr>
       </table>
       <div id="page" class="page_div"></div>
   </div>

<div id="createDialog" class="InputDialog">

   <table width="100%">
       <form id="saveForm">
       <tr>
           <td>姓名：</td>
           <td>
               <input type="text" name="name"/>
           </td>
       </tr>
       <tr>
           <td>生日：</td>
           <td>
               <input type="text" name="birthday" readonly="readonly"  onClick="WdatePicker({el:this})"/>
           </td>
       </tr>
       <tr>
           <td>地址：</td>
           <td>
               <input type="text" name="address"/>
           </td>
       </tr>
       <tr>
           <td>电话：</td>
           <td>
               <input type="text" name="phone"/>
           </td>
       </tr>
    </form>
       <tr>
           <td>
               <button onclick="save()">提交</button>
               <button onclick="cancel()">取消</button>
           </td>
       </tr>
   </table>

</div>

<div id="updateDialog"  class="InputDialog">
    <table width="100%">
        <form id="updateForm">
            <tr>
                <td>姓名：</td>
                <td>
                    <input type="text" id="name" name="name"/>
                </td>
            </tr>
            <tr>
                <td>生日：</td>
                <td>
                    <input type="text"  id="birthday" name="birthday" readonly="readonly"  onClick="WdatePicker({el:this})"/>
                </td>
            </tr>
            <tr>
                <td>地址：</td>
                <td>
                    <input type="text" id="address" name="address"/>
                </td>
            </tr>
            <tr>
                <td>电话：</td>
                <td>
                    <input type="text" id="phone" name="phone"/>
                </td>
            </tr>
            <input type="hidden" id="id" name="id"/>
        </form>
        <tr>
            <td>
                <button onclick="update()">修改</button>
                <button onclick="cancel()">取消</button>
            </td>
        </tr>
    </table>

</div>

</body>
</html>
