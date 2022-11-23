
import axios from "axios";

export const GetUserTransactions = () => {
    const currentUser = JSON.parse(localStorage.getItem("usuario_actual"));
    return axios.get(`http://localhost:8080/transaction/${currentUser.id}`)  
};