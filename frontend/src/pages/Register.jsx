import {Link} from "react-router-dom";
import "./Auth.css";
import {useState} from "react";

function Register() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    return (
        <div className="authPage">
            <h1>Create an Account</h1>
            <p>Join Clashalytics.</p>

            <form onSubmit={(e) => {
                e.preventDefault();

                if (username.trim() === "" || password.trim() === "") {
                    alert("Enter a valid username")
                    return;
                }

                const url = "http://localhost:8080/register";
                fetch(url, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    body: new URLSearchParams({
                        username: username,
                        password: password
                    })
                })
                    .then((response) => {
                        if (!response.ok) {
                            throw new Error(`HTTP error: ${response.status}`);
                        }
                    })
            }}>
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={e => setUsername(e.target.value)}
                    required
                />

                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                    required
                />

                <button type="submit">Register</button>
            </form>

            <p>
                Already have an account? <Link to="/login">Login</Link>
            </p>

            <Link to="/">Back to dashboard</Link>
        </div>
    );
}

export default Register;
