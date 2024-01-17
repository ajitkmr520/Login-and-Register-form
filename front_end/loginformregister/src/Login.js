import React, { useState } from "react";
import axios from "axios";

export const Login = (props) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    


    async function login(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8080/api/v1/employee/login", {
            email: email,
            password: password,
            }).then((res) => 
            {
             console.log(res.data);
             
             if (res.data.message === "Email not exits") 
             {
               alert("Email not exits");
             } 
             else if(res.data.message === "Login Success")
             { 
                alert("Succesfully Login")
                
             } 
              else 
             { 
                alert("Incorrect Email and Password not match");
             }
          }, fail => {
           console.error(fail); // Error!
  });
        }
  
         catch (err) {
          alert(err);
        }
      }
    

    return (
        <div className="auth-form-container">
            <h2>Login</h2>
            <form className="login-form" onSubmit={login}>
                <label htmlFor="email">email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="youremail@gmail.com" id="email" name="email" />
                <label htmlFor="password">password</label>
                <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" id="password" name="password" />
                <button type="submit">Log In</button>
            </form>
            <button className="link-btn" onClick={() => props.onFormSwitch('register')}>Don't have an account? Register.</button>
        </div>
    )
}