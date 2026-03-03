async function register() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;

    const response = await apiRequest("/auth/signup", "POST", {
        username,
        password,
        role
    });

    alert(response.message);
    window.location.href = "signIn.html";
}