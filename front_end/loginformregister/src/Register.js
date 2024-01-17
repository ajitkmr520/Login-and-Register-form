import React, { useState } from "react";
import axios from "axios";

export const Register = (props) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');

    async function signup(event) {
        event.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/api/v1/employee/save", {
                name: name,
                email: email,
                password: password,
                
            });
    
            console.log(response.data);
    
            if (response.status === 200) {
                alert("Registration successful");
                // Optionally, you can perform additional actions after successful registration.
            } else {
                console.error('Registration failed:', response.data.message);
                alert("Registration failed: " + response.data.message);
            }
        } catch (error) {
            console.error('Error during registration:', error);
            alert("An error occurred during registration");
        }
    }

    
    return (
        <div className="auth-form-container">
            <h2>Register</h2>
        <form className="register-form" onSubmit={signup}>
            <label htmlFor="name">Name</label>
            <input value={name} name="name" onChange={(e) => setName(e.target.value)} id="name" placeholder="Name" />
            <label htmlFor="email">email</label>
            <input value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="youremail@gmail.com" id="email" name="email" />
            <label htmlFor="password">password</label>
            <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" id="password" name="password" />
            <button type="submit">Sign Up</button>
        </form>
        <button className="link-btn" onClick={() => props.onFormSwitch('signup')}>Already have an account? Login here.</button>
    </div>
    )
}
