
import './transactions.css';
import { ToastContainer, toast } from 'react-toastify';
import {GetUserTransactions} from '../../service/TransactionService';

const Transactions = () => {

    let transactions;

    GetUserTransactions().
        then(function(response){ 
            if(response.status == 200){
                transactions = response.data;
            }

        })
        .catch( function(error){
            toast.error('Not found', {
                position: toast.POSITION.TOP_RIGHT
            });
            console.log(error)
        });

    return(
        <ul className="list-group">
            <li className="list-group-item">1</li>
            <li className="list-group-item">2</li>
            <li className="list-group-item">3</li>
            <li className="list-group-item">4</li>
            <li className="list-group-item">5</li>
        </ul>
    );
}

export default Transactions;