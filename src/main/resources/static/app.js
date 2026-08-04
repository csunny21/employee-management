const API_URL = "http://localhost:8081/employees";

document.addEventListener("DOMContentLoaded", () => {
    loadEmployees();
});

async function loadEmployees() {

const response = await fetch(API_URL);
const employees = await response.json();

renderEmployees(employees);
updateDashboard(employees);

}

function renderEmployees(employees) {
const tableBody = document.getElementById("employeeTableBody");

tableBody.innerHTML = "";

employees.forEach(employee => {
const row = document.createElement("tr");

row.innerHTML = `
    <td>${employee.id}</td>
    <td>${employee.name}</td>
    <td>${employee.department}</td>
<td>
    <button onclick="editEmployee(${employee.id})">
        Edit
    </button>
</td>
<td>
    <button onclick="deleteEmployee(${employee.id})">
       Delete
    </button>
</td>
`;
tableBody.appendChild(row);
    });
}

function updateDashboard(employees) {

    document.getElementById("totalEmployees")
        .textContent = employees.length;


    const techCount =
        employees.filter(
            emp => emp.department === "TECH"
        ).length;

    const hrCount =
         employees.filter(
             emp => emp.department === "HR"
    ).length;

    const financeCount =
             employees.filter(
                 emp => emp.department === "FINANCE"
        ).length;


    const supportCount =
             employees.filter(
                 emp => emp.department === "SUPPORT"
        ).length;


    const salesCount =
            employees.filter(
                 emp => emp.department === "SALES"
      ).length;

        const operationsCount =
                 employees.filter(
                     emp => emp.department === "OPERATIONS"
            ).length;

      document.getElementById("techEmployees")
        .textContent = techCount;

        document.getElementById("hrEmployees")
                .textContent = hrCount;

       document.getElementById("supportEmployees")
               .textContent = supportCount;

       document.getElementById("salesEmployees")
            .textContent = salesCount;

       document.getElementById("financeEmployees")
            .textContent = financeCount;

        document.getElementById("operationsEmployees")
             .textContent = operationsCount;

    }


    document.getElementById("employeeForm")
        .addEventListener("submit", createEmployee);

    async function createEmployee(event) {

    event.preventDefault();

    const employee = {

        name:
            document.getElementById("name").value,

        department:
            document.getElementById("department").value

    };

    await fetch(API_URL, {

    method: "POST",

    headers: {
        "Content-Type": "application/json"

    },

    body: JSON.stringify(employee)

    });

    document.getElementById("employeeForm").reset();

    loadEmployees();
}

async function deleteEmployee() {
    await fetch(`${API_URL}/${id}`, {

        method: "DELETE"
    });

    loadEmployees();

}

async function editEmployee() {

    const newName = prompt("Enter new employee name");

    if(!newName) {
        return;
    }

    const response =
        await fetch(`${API_URL}/${id}`);

    const employee = await response.json();

    employee.name = newName;

    await fetch(`${API_URL}/${id}`, {

        method: "PUT",

        headers: {
            "Content-Type": "application/json"

        },

        body: JSON.stringify(employee)

    });

    loadEmployees();

}

document.getElementById("searchInput")
    .addEventListener("keyup", filterEmployees);

    async function filterEmployees() {

    const search = document.getElementById("searchInput")
        .value
        .toLowerCase();

    const response = await fetch(API_URL);

    const employees = await response.json();

    const filtered = employees.filter(employee =>
        employee.name.toLowerCase()
            .includes(search)
    );

    renderEmployees(filtered);

    }
