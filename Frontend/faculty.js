// This function displays the faculty data on the page
function renderFacultyData(facultyData) {
    const facultyInfoDiv = document.getElementById('faculty-info');

    // Create HTML structure to display faculty data
    const htmlContent = `
        <h2>Faculty Details</h2>
        <p><strong>Teacher ID:</strong> ${facultyData.teacher_id || 'N/A'}</p>
        <p><strong>Name:</strong> ${facultyData.name || 'N/A'}</p>
        <p><strong>Phone Number:</strong> ${facultyData.phone_number || 'N/A'}</p>
        <p><strong>Email:</strong> ${facultyData.email || 'N/A'}</p>
        <p><strong>Address:</strong> ${facultyData.address || 'N/A'}</p>
        <p><strong>Classes Teaches:</strong> ${facultyData.classes_teaches || 'N/A'}</p>
    `;

    facultyInfoDiv.innerHTML = htmlContent;
}

// Function to fetch faculty data based on the provided ID
async function fetchFacultyData(facultyId) {
    try {
        const response = await fetch(`http://localhost:8080/teacher/getTeacher/${facultyId}`);
        
        if (!response.ok) {
            throw new Error('Error fetching faculty data.');
        }

        const facultyData = await response.json();
        console.log(facultyData); // Log the data for debugging
        renderFacultyData(facultyData);
    } catch (error) {
        console.error('Error fetching faculty data:', error);
        alert('Failed to fetch faculty data.');
    }
}

// Function to initialize the page
function init() {
    // Clear local storage to ensure the prompt appears every time the page is loaded
    localStorage.removeItem('facultyId');

    // Prompt for ID
    const id = prompt("Please enter your Faculty ID:");
    if (id) {
        localStorage.setItem('facultyId', id); // Store the ID for future use
        fetchFacultyData(id);
    } else {
        alert("No Faculty ID provided.");
    }
}

// Initialize the page when it loads
window.onload = init;
