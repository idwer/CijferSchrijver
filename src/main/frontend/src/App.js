import React from 'react';
import { Link, BrowserRouter, Route, Routes } from "react-router-dom";

import './App.css';

import GetStudents from "./components/GetStudents";
import AddStudent from "./components/AddStudent";
import GetModules from "./components/GetModules";
import AddModule from "./components/AddModule";
import GetSemesters from "./components/GetSemesters";
import AddSemester from "./components/AddSemester";
import GetResults from "./components/GetResults";
import AddResult from "./components/AddResult";

export default function App() {
    return (
        <div className="App">
          <header className="App-Header">
              <h1 className="App-title">CijferSchrijver</h1>
          </header>
            <BrowserRouter>
                <h1>Navigation</h1>
                <nav>
                    <Link to="/">Home </Link><br/>
                    <Link to="/get/students"> List of Students</Link><br/>
                    <Link to="/add/student"> Add Student</Link><br/>
                    <Link to="/get/modules"> List of Modules</Link><br/>
                    <Link to="/add/module"> Add Module</Link><br/>
                    <Link to="/get/semesters"> List of Semesters</Link><br/>
                    <Link to="/add/semester"> Add Semester</Link><br/>
                    <Link to="/get/results"> List of Results</Link><br/>
                    <Link to="/add/results"> Add Result</Link><br/>
                </nav>
            <Routes>
                <Route path="/get/students" element={<GetStudents />} />
                <Route path="/add/student" element={<AddStudent />} />
                <Route path="/get/modules" element={<GetModules />} />
                <Route path="/add/module" element={<AddModule />} />
                <Route path="/get/semesters" element={<GetSemesters />} />
                <Route path="/add/semester" element={<AddSemester />} />
                <Route path="/get/results" element={<GetResults />} />
                <Route path="/add/results" element={<AddResult />} />
            </Routes>
            </BrowserRouter>
        </div>
    );
}