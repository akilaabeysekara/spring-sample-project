async function register() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;

    // Check if all fields are complete
    if (!username || !password || !role) {
        alert("Please fill in all fields");
        return;
    }

    // Trim empty whitespace
    if (username.trim() === "" || password.trim() === "") {
        alert("Username and password cannot be empty");
        return;
    }

    const response = await apiRequest("/auth/signup", "POST", {
        username,
        password,
        role
    });

    alert(response.message);
    window.location.href = "signIn.html";
}