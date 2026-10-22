
import { Link } from "react-router-dom";
import "./Auth.css";

function Login() {
    return (
        <div className="authPage">
            <h1>Welcome Back</h1>
            <p>Login to your Clashalytics account.</p>

            <form>
                <input
                    type="text"
                    placeholder="Username"
                    required
                />

                <input
                    type="password"
                    placeholder="Password"
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
