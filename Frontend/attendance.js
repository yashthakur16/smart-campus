document.addEventListener("DOMContentLoaded", function () {
    // Get student ID from localStorage
    const studentId = localStorage.getItem('studentId'); // Retrieves the student ID from localStorage

    // Check if studentId exists
    if (!studentId) {
        alert("No Student ID found. Please return to the previous page and enter your Student ID.");
        return; // Stop execution if no ID is found
    }

    // Fetch attendance data using the retrieved student ID
    fetch(`http://localhost:8080/attendance/getById/${studentId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            renderAttendanceData(data);
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
});

function renderAttendanceData(data) {
    // Display student info
    const studentInfoDiv = document.getElementById("student-info");
    studentInfoDiv.innerHTML = `
        <h2>${data.student.full_name}</h2>
        <p><strong>Student ID:</strong> ${data.student.student_id}</p>
        <p><strong>Phone:</strong> ${data.student.phone_no}</p>
        <p><strong>Email:</strong> ${data.student.email}</p>
        <p><strong>Department:</strong> ${data.student.department}</p>
        <p><strong>Division:</strong> ${data.student.division}</p>
    `;

    // Display attendance chart
    const ctx = document.getElementById('attendanceChart').getContext('2d');
    const chartData = {
        labels: ['AI', 'DBMS', 'CN', 'WT'],
        datasets: [{
            label: 'Attendance',
            data: [
                data.ai_attended,
                data.dbms_attended,
                data.cn_attended,
                data.wt_attended
            ],
            backgroundColor: ['#36a2eb', '#ff6384', '#ffce56', '#4bc0c0'],
            borderColor: '#fff',
            borderWidth: 1
        }]
    };

    const attendanceChart = new Chart(ctx, {
        type: 'bar',
        data: chartData,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
    // Display overall attendance percentage
    const attendancePercentageDiv = document.getElementById("attendance-percentage");
    attendancePercentageDiv.innerHTML = `Overall Attendance Percentage: ${data.overallAttendancePercentage}%`;
}
