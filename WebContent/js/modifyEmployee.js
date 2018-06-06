/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function showDiv(div_id)
{
    document.getElementById('login').style.display = 'none';
    document.getElementById('registration').style.display = 'none';
    document.getElementById('add').style.display = 'none';
    document.getElementById('search').style.display = 'none';
    document.getElementById('list').style.display = 'none';
    document.getElementById('showemp').style.display = 'none';
    document.getElementById('addtask').style.display = 'none';
    document.getElementById('assigntask').style.display = 'none';
    document.getElementById('showassigntask').style.display = 'none';
//                alert(document.getElementById(div_id).style);
    document.getElementById(div_id).style.display = 'block';
    if (div_id === 'showemp')
    {
        alert("showemployyeee");
        var formdata = "xyz";
        $.ajax({
            type: "post",
            data: formdata,
            url: "ShowEmployee", //?accid=" + accessid,
            success: function (data) {//data is holoding response from serlvet
                $('#showemp').html(data);
            },
            error: function (xhr, status, strErr) {
                //alert(status);
            }
        });
    }
    if (div_id === 'add')
    {
        var formdata = "xyz";
        $.ajax({
            type: "post",
            data: formdata,
            url: "FetchCountry", //?accid=" + accessid,
            success: function (data) {//data is holoding response from serlvet
                $('#divcountry').html(data);
            },
            error: function (xhr, status, strErr) {
                //alert(status);
            }
        });
    }



}
/*function editEmpl(eid)
 {
 
 $("#" + eid).append("<td> <button id='updatebtn' type='button' class='btn btn-default'>update</button></td>");
 var tdFname = $("#" + eid).children("td:nth-child(2)");
 //                alert(tdFname.html());
 var tdLname = $("#" + eid).children("td:nth-child(3)");
 
 var tdSalary = $("#" + eid).children("td:nth-child(4)");
 var tdDob = $("#" + eid).children("td:nth-child(5)");
 
 tdFname.html("<input type='text' id='txtfname' value='" + tdFname.html() + "'/>");
 tdLname.html("<input type='text' id='txtlname' value='" + tdLname.html() + "'/>");
 tdSalary.html("<input type='text' id='txtsalary' value='" + tdSalary.html() + "'/>");
 tdDob.html("<input type='text' id='txtdob' value='" + tdDob.html() + "'/>");
 
 
 $("#updatebtn").click(function ()
 {
 var empid = eid;
 //                    alert(eid);
 var fname = document.getElementById('txtfname').value;
 var lname = document.getElementById('txtlname').value;
 var salary = document.getElementById('txtsalary').value;
 var dob = document.getElementById('txtdob').value;
 
 //                    alert(lname);
 
 var paramlist = "?empid=" + empid + "&fname=" + fname + "&lname=" + lname + "&dob=" + dob + "&salary=" + salary;
 //                    alert(paramlist);
 var formdata = "xyz";
 $.ajax({
 type: "post",
 data: formdata,
 url: "UpdateEmployee" + paramlist, //?accid=" + accessid,
 success: function (data) {//data is holoding response from serlvet
 $('#showemp').html(data);
 },
 error: function (xhr, status, strErr) {
 //alert(status);
 }
 });
 });
 }*/
function insertEmp()
{
    var formdata = "xyz";
    var fname = document.getElementById('fname').value;
    var lname = document.getElementById('lname').value;
    var dob = document.getElementById('dob').value;
    var salary = document.getElementById('salary').value;
//    var country = document.getElementById('Country').value;
//    var state = document.getElementById('State').value;
//    var city = document.getElementById('City').value;
    var countryId = document.getElementById("Country");
    var country = countryId.options[countryId.selectedIndex].text;
    var stateId = document.getElementById("State");
    var state = stateId.options[stateId.selectedIndex].text;
    var cityId = document.getElementById("City");
    var city = cityId.options[cityId.selectedIndex].text;
    var flag = 1;
    alert(country);
    var paramlist = "?fname=" + fname + "&lname=" + lname + "&dob=" + dob +
            "&salary=" + salary + "&country=" + country + "&state=" + state + "&city=" + city + "&flag=" + flag;
    // alert(paramlist);
    $.ajax({
        type: "post",
        data: formdata,
        url: "AddEmployee" + paramlist,
        success: function (data) {//data is holoding response from serlvet
            $('#showemp').html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
    document.getElementById('add').style.display = 'none';
    document.getElementById('showemp').style.display = 'block';

}

function updateEmp(eid)
{
    var empid = eid;
    var fname = document.getElementById('txtfname').value;
    var lname = document.getElementById('txtlname').value;
    var salary = document.getElementById('txtsalary').value;
    var dob = document.getElementById('txtdob').value;
    var countryId = document.getElementById("txtcountry");
    var country = countryId.options[countryId.selectedIndex].text;
    var stateId = document.getElementById("txtstate");
    var state = stateId.options[stateId.selectedIndex].text;
    var cityId = document.getElementById("txtcity");
    var city = cityId.options[cityId.selectedIndex].text;


    //var state = document.getElementById('State').value;
    var paramlist = "?empid=" + empid + "&fname=" + fname + "&lname=" + lname + "&dob=" + dob +
            "&salary=" + salary + "&country=" + country + "&state=" + state + "&city=" + city;
    alert(paramlist);
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "UpdateEmployee" + paramlist, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#showemp').html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
}
function editEmp(eid)
{
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "FetchEmployee?empid=" + eid, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#row' + eid).html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
}
function inactiveEmp(eid)
{
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "InactiveEmployee?empid=" + eid, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#showemp').html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
}

function fetchState(cid)
{
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "FetchState?country_id=" + cid, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#divstate').html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
    //alert(cid);
}
function fetchCity(sid)
{
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "FetchCity?state_id=" + sid, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#divcity').html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
    //alert(cid);
}
function login()
{
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var paramlist = "?email=" + email + "&password=" + password;
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "Login" + paramlist, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#showemp').html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
    document.getElementById('login').style.display = 'none';
    document.getElementById('showemp').style.display = 'block';

}
function showLogin()
{

    document.getElementById('applicationErr').style.display = 'none';
    document.getElementById('login').style.display = 'block';
}
function logout()
{
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "Logout", //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet

            document.getElementById('login').style.display = 'none';
            document.getElementById('registration').style.display = 'none';
            document.getElementById('add').style.display = 'none';
            document.getElementById('search').style.display = 'none';
            document.getElementById('list').style.display = 'none';
            document.getElementById('showemp').style.display = 'none';
            document.getElementById('login').style.display = 'block';
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
}
function fetchCountry2(eid)
{
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "FetchCountry2", //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#tdcountry').html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
}
function fetchState2(cid)
{
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "FetchState2?country_id=" + cid, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#tdstate').html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
    //alert(cid);
}
function fetchCity2(sid)
{
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "FetchCity2?state_id=" + sid, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#tdcity').html(data);
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
    //alert(cid);
}
function applyTask()
{
    document.getElementById('login').style.display = 'none';
    document.getElementById('registration').style.display = 'none';
    document.getElementById('add').style.display = 'none';
    document.getElementById('search').style.display = 'none';
    document.getElementById('list').style.display = 'none';
    document.getElementById('showemp').style.display = 'none';
//                alert(document.getElementById(div_id).style);

    var val = document.getElementById('task').value;
    if (val === '1')
    {
        document.getElementById('addtask').style.display = 'block';
    } else if (val === '2')
    {
        document.getElementById('addtask').style.display = 'none';
        // alert("assigntask");
        var formdata = "xyz";
        $.ajax({
            type: "post",
            data: formdata,
            url: "AssignTask", //?accid=" + accessid,
            success: function (data) {//data is holoding response from serlvet
                $('#assigntask').html(data);

                document.getElementById('assigntask').style.display = 'block';
            },
            error: function (xhr, status, strErr) {
                //alert(status);
            }
        });
    } else if (val === '3')
    {
        document.getElementById('addtask').style.display = 'none';
        document.getElementById('assigntask').style.display = 'none';
        // alert("assigntask");
        var formdata = "xyz";
        $.ajax({
            type: "post",
            data: formdata,
            url: "ShowAssignTask", //?accid=" + accessid,
            success: function (data) {//data is holoding response from serlvet
                $('#showassigntask').html(data);

                document.getElementById('showassigntask').style.display = 'block';
            },
            error: function (xhr, status, strErr) {
                //alert(status);
            }
        });
    }
}
function addTask()
{
    var task_name = document.getElementById('taskname').value;
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "AddTask?task_name=" + task_name, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#showemp').html(data);
            document.getElementById('addtask').style.display = 'none';
            document.getElementById('showemp').style.display = 'block';
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
}
function fetchTask()
{
    var formdata = "xyz";
    $.ajax({
        type: "post",
        data: formdata,
        url: "SelectTask", //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#empTaskList').html(data);

            document.getElementById('assigntask').style.display = 'block';
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
}
function assignTask()
{
    var task_id_arr = [];
    var empid = document.getElementById('employeeList').value;
    var formdata = "xyz";

    $("input[name='chk1']:checked").each(function ()
    {
        task_id_arr.push($(this).val());
        //task_id_arr.push(,);
    });
    var paramlist = "?empid=" + empid + "&task_id_arr=" + task_id_arr;
    alert(paramlist);
    $.ajax({
        type: "post",
        data: formdata,
        url: "AfterAssignTask" + paramlist, //?accid=" + accessid,
        success: function (data) {//data is holoding response from serlvet
            $('#assigntask').html(data);

            document.getElementById('assigntask').style.display = 'block';
        },
        error: function (xhr, status, strErr) {
            //alert(status);
        }
    });
}
function showAppliedTask()
{
    var empid = document.getElementById('selectEmployee').value;
    alert(empid);
    var formdata = "xyz";
        $.ajax({
            type: "post",
            data: formdata,
            url: "ShowAppliedTask?empid=" +empid, //?accid=" + accessid,
            success: function (data) {//data is holoding response from serlvet
                $('#showAppliedTaskList').html(data);

                document.getElementById('showassigntask').style.display = 'block';
            },
            error: function (xhr, status, strErr) {
                //alert(status);
            }
        });
}