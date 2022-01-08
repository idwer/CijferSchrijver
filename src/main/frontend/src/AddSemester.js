import React, {useState} from 'react'
import {useNavigate} from "react-router-dom";

function AddSemester() {
    const [name, setName] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const semester = { name };

        fetch('http://localhost:8080/api/semester/add',
            {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(semester)
            }
        );
        redirectAfterClick()
    }

    let navigate = useNavigate();
    function redirectAfterClick() {
        navigate("/get/semesters")
    }

    return (
        <div>
            <h2>Add Semester</h2>
            <form onSubmit={handleSubmit}>
                <label>Name:</label>
                <input
                    type="text"
                    required
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <button type="submit">Add semester</button>
            </form>
        </div>
    );
}

export default AddSemester