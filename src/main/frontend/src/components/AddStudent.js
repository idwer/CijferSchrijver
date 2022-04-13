import React, {useState} from 'react'
import { useNavigate } from "react-router-dom";

function AddStudent() {
    const [name, setName] = useState('');
    const [surname, setSurName] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const student = { name, surname };

        fetch('http://localhost:8080/api/student/add',
            {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(student)
            }
            );
        redirectAfterClick()
    }

    let navigate = useNavigate();
    function redirectAfterClick() {
        navigate("/get/students")
    }

    return (
        <div>
        <h2>Add Student</h2>
        <form onSubmit={handleSubmit}>
            <label>Name:</label>
            <input
                type="text"
                required
                value={name}
                onChange={(e) => setName(e.target.value)}
            />
            <label>Last Name:</label>
            <input
                type="text"
                required
                value={surname}
                onChange={(e) => setSurName(e.target.value)}
            />
            <button type="submit">Add student</button>
        </form>
        </div>
    );
}

export default AddStudent