// This function displays the student data on the page
function renderStudentData(studentData) {
    const studentInfoDiv = document.getElementById('student-info');

    // Create HTML structure to display student data
    const htmlContent = `
        <h2>Student Details</h2>
        <p><strong>Student ID:</strong> ${studentData.student_id || 'N/A'}</p>
        <p><strong>Full Name:</strong> ${studentData.full_name || 'N/A'}</p>
        <p><strong>Phone Number:</strong> ${studentData.phone_no || 'N/A'}</p>
        <p><strong>Email:</strong> ${studentData.email || 'N/A'}</p>
        <p><strong>Address:</strong> ${studentData.address || 'N/A'}</p>
        <p><strong>Birthday:</strong> ${studentData.birthday || 'N/A'}</p>
        <p><strong>Division:</strong> ${studentData.division || 'N/A'}</p>
        <p><strong>Department:</strong> ${studentData.department || 'N/A'}</p>
        <p><strong>Blood Group:</strong> ${studentData.blood_group || 'N/A'}</p>
    `;

    studentInfoDiv.innerHTML = htmlContent;
}

// Function to fetch student data based on the provided ID
async function fetchStudentData(studentId) {
    try {
        const response = await fetch(`http://localhost:8080/getStudent/${studentId}`);
        
        if (!response.ok) {
            throw new Error('Error fetching student data.');
        }

        const studentData = await response.json();
        console.log(studentData); // Log the data for debugging
        renderStudentData(studentData);
    } catch (error) {
        console.error('Error fetching student data:', error);
        alert('Failed to fetch student data.');
    }
}

// Function to initialize the page
function init() {
    // Clear local storage to ensure the prompt appears every time the page is loaded
    localStorage.removeItem('studentId');

    // Prompt for ID
    const id = prompt("Please enter your Student ID:");
    if (id) {
        localStorage.setItem('studentId', id); // Store the ID for future use
        fetchStudentData(id);
    } else {
        alert("No Student ID provided.");
    }
}

let b=document.getElementById("attendance");

b.addEventListener('click',()=>{
    window.location.href = "attendance.html";
    
})

// Initialize the page when it loads
window.onload = init;
