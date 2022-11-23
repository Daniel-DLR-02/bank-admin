import "./Login.css";
import logo from "../../resources/Bank.png";
import {LoginUser} from "../../service/LoginService";

const Login = () => {

    const doLogin = (event) => {
        event.preventDefault();

        const {username,password} =event.target;

        LoginUser(username.value,password.value)
        .then();

    }

    return (
        <div className="login">
            <img src={logo} alt="Logo" width={250} />
            <form onSubmit={doLogin}>
                <div className="form-outline mb-4">
                <label className="form-label">
                        Username
                    </label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        className="form-control"
                    />
                </div>

                <div className="form-outline mb-4">
                <label className="form-label">
                        Password
                    </label>
                    <input
                        type="password"
                        name="password"
                        id="password"
                        className="form-control"
                    />
                </div>


                <button type="submit" className="btn btn-primary btn-block mb-4">
                    Sign in
                </button>

            </form>
        </div>
    );
};

export default Login;
