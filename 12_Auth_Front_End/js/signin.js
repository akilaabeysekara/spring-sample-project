async function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const response = await apiRequest("/auth/signin", "POST", {
        username,
        password
    });

    if (response.data && response.data.access_token) {
        saveToken(response.data.access_token);

        const token = response.data.access_token;
        const payload = JSON.parse(atob(token.split('.')[1]));

        if (payload.role === "ADMIN") {
            window.location.href = "adminPage.html";
        } else {
            window.location.href = "userPage.html";
        }

    } else {
        alert(response.message);
    }
}