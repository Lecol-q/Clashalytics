import {Link} from "react-router-dom";
import "./Auth.css";
import {useState} from "react";

function Register() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

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

                const url = "https://clashalytics-backend.onrender.com/register";
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
                        if (response.status === 409) {
                            setError("Username Already Exists!")
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

                {error && <p className="error-message">{error}</p>}

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
