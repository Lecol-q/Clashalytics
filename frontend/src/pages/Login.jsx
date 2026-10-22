import { Link } from "react-router-dom";
import "./Auth.css";
import {useState} from "react";


function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    return (
        <div className="authPage">
            <h1>Welcome Back</h1>
            <p>Login to your Clashalytics account.</p>

            <form onSubmit={(e) => {
                e.preventDefault();

                    if(username.trim() === "" || password.trim() === "") {
                        alert("Enter a valid username")
                        return;
                    }

                    const url="http://localhost:8080/login";
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
                            if(!response.ok) {
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

                <button type="submit">Login</button>
            </form>

            <p>
                Don't have an account? <Link to="/register">Register</Link>
            </p>

            <Link to="/">Back to dashboard</Link>
        </div>
    );
}

export default Login;
