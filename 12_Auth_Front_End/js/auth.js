function saveToken(token) {
    localStorage.setItem("token", token);
}

function logout() {
    localStorage.removeItem("token");
    window.location.href = "signIn.html";
}

function getToken() {
    return localStorage.getItem("token");
}