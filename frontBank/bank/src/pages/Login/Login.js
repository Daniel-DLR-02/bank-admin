import "./Login.css";
import logo from "../../resources/Bank.png";
import {LoginUser} from "../../service/LoginService";
import {LoginDto} from "../../model/LoginDto"
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Login = () => {

    const navigate = useNavigate();


    const doLogin = (event) => {
        event.preventDefault();

        const {username,password} =event.target;

        const login = new LoginDto(username.value,password.value);

        LoginUser(login).
        then(function(response){ 
            if(response.status == 200){
                window.localStorage.setItem("usuario_actual",JSON.stringify(response.data));
                navigate("/home");
            }

        })
        .catch( function(error){
            toast.error('Credenciales incorrectas', {
                position: toast.POSITION.TOP_RIGHT
            });
            console.log(error)
        });

        // localStorage.setItem('user',User)

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
                <ToastContainer />

            </form>
        </div>
    );
};

export default Login;
