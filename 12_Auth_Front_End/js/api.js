const BASE_URL = "http://localhost:8080/api/v1";

async function apiRequest(endpoint, method, body = null, auth = false) {

    const headers = {
        "Content-Type": "application/json"
    };

    if (auth) {
        const token = localStorage.getItem("token");
        headers["Authorization"] = "Bearer " + token;
    }

    try {
        const response = await fetch(BASE_URL + endpoint, {
            method: method,
            headers: headers,
            body: body ? JSON.stringify(body) : null
        });

        return response.json();
    } catch (error) {
        alert("Server error occurred");
        console.error("API Request failed:", error);
        throw error;
    }
}