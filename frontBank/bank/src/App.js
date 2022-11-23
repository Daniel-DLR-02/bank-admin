import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./pages/Login/Login";
import Home from "./pages/home/home";
function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Login />}></Route>
                    <Route path="/home" element={<Home />}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
