getAllEmployee();
function saveEmployee() {
    let id = $('#exampleInputEmployeeID').val();
    let name = $('#exampleInputEmployeeName').val();
    let address = $('#exampleInputEmpAddress').val();
    let cont = $('#exampleInputEmpCont').val();

    $.ajax({
        method: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/employee/saveEmpl",
        async: "true",
        data: JSON.stringify({
            "empId": id,
            "employeeName": name,
            "employeeAddress": address,
            "employeeCont": cont
        }),
        success: function (data) {
            alert("saved");
            getAllEmployee();
        },
        error: function (xhr, exception) {
            alert("error");
        }
    })
}

function updateEmployee() {
    let id = $('#exampleInputEmployeeID').val();
    let name = $('#exampleInputEmployeeName').val();
    let address = $('#exampleInputEmpAddress').val();
    let cont = $('#exampleInputEmpCont').val();

    $.ajax({
        method: "PUT",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/employee/updateEmpl",
        async: "true",
        data: JSON.stringify({
            "empId": id,
            "employeeName": name,
            "employeeAddress": address,
            "employeeCont": cont
        }),
        success: function (data) {
            alert("updated");
            getAllEmployee();
        },
        error: function (xhr, exception) {
            alert("error");
        }
    })
}

function deleteEmployee() {
    let id = $('#exampleInputEmployeeID').val();


    $.ajax({
        method: "DELETE",
        // contentType:"application/json",
        url: "http://localhost:8080/api/v1/employee/deleteEmployee/" + id,
        async: "true",

        success: function (data) {
            alert("deleted");
            getAllEmployee();
        },
        error: function (xhr, exception) {
            alert("error");
        }
    })
}

function getAllEmployee(){

    $.ajax({
        method:"GET",
        url:"http://localhost:8080/api/v1/employee/getAllEmployee",
        async:true,
        success: function (data) {
            if (data.code==="00"){
                $('#employeeTable').empty();
                for (let emp of data.content){
                    let id=emp.empId
                    let name=emp.employeeName
                    let address=emp.employeeAddress
                    let cont=emp. employeeCont

                    var row=`<tr><td>${id}</td><td>${name}</td><td>${address}</td><td>${cont}</td></tr>`;
                    $('#employeeTable').append(row);
                }
            }
        },
        error: function (xhr, exception) {
            alert("Error")
        }
    })

}



