import { useState, useEffect } from "react";

import axios from "axios";

export const LoginUser = (login) => {
    return axios.post(`http://localhost:8080/user/login`,login)  
};