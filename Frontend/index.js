async function validateLogin(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const role = document.getElementById('role').value;

    try {
        const response = await fetch(`http://localhost:8080/login/check?username=${username}&password=${password}`);
        
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const result = await response.json();
        
        if (result === true) {
            // Redirect to the corresponding role page
            window.location.href = `${role}.html`;
        } else {
            alert('Invalid username or password.');
        }
    } catch (error) {
        console.error('Error fetching API:', error);
        alert('Login failed.');
    }
}
