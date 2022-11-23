import userImg from '../../resources/userlogo.png';
import './home.css';
import Transactions from '../../components/transactions/transactions';
const Home = () => {

    const userActual = JSON.parse(localStorage.getItem("usuario_actual"));

    return (<div>
        <div className="card">
          <img className="userLogo" src={userImg} alt="User image"/>
          <div className="card-body">
            <h4 className="card-title">{userActual.name}</h4>
            <p className="card-text">{userActual.userName}</p>
          </div>
        </div>
        <div>
            <Transactions />
        </div>
    </div>)
}

export default Home;