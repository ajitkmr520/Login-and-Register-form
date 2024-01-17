import React, { useState } from "react";
//import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import './App.css';
import { Login } from "./Login";
import { Register } from "./Register";
import {Home} from "./Home";

function App() {
  const [currentForm, setCurrentForm] = useState('login');

  const toggleForm = (formName) => {
    setCurrentForm(formName);
  }

  return (
    <div className="App">
      {
        currentForm === "login" ? <Login onFormSwitch={toggleForm} /> : <Register onFormSwitch={toggleForm} />
      }
      <Home/>
    </div>
  );
}

export default App;
