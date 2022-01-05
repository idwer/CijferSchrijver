import React from 'react';
import {Link, BrowserRouter, Routes, Route} from "react-router-dom";

import './App.css';
import GetStudents from "./GetStudents";
import AddStudent from "./AddStudent";

function App() {
    return (
        <div className="App">
          <header className="App-Header">
              <h1 className="App-title">CijferSchrijver</h1>
          </header>
            <BrowserRouter>
                <h1>Navigation</h1>
                <nav>
                    <Link to="/get/students"> List of Students</Link><br/>
                    <Link to="/add/student"> Add Student</Link><br/>
                </nav>
            <Routes>
                <Route path="/get/students" element={<GetStudents />} />
                <Route path="/add/student" element={<AddStudent />} />
            </Routes>
            </BrowserRouter>
        </div>
    );
  }

export default App;
