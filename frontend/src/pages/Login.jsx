import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import "./Auth.css";
import {useState} from "react";


function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loggedInUser, setLoggedUser] = useState(null);
    const navigate = useNavigate();

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

                    const url="https://clashalytics.pntr.dev/login";
                    fetch(url, {
                        method: 'POST',
                        credentials: "include",
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
                            return response.json();
                        })
                        .then((user) => {
                            setLoggedUser(user);
                            console.log(user)
                            navigate("/");
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
