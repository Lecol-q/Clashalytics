
import { Link } from "react-router-dom";
import "./Auth.css";

function Register() {
    return (
        <div className="authPage">
            <h1>Create an Account</h1>
            <p>Join Clashalytics.</p>

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
