import React, {useState} from 'react'
import {useNavigate} from "react-router-dom";

function AddResult() {
    // backend code handles generating and storing a timestamp
    const [grade, setGrade] = useState('');
    const [id_module, setIdModule] = useState('');
    const [id_student, setIdStudent] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const result = { grade, id_module, id_student };

        fetch('http://localhost:8080/api/result/add',
            {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(result)
            }
        );
        redirectAfterClick()
    }

    let navigate = useNavigate();
    function redirectAfterClick() {
        navigate("/get/results")
    }

    return (
        <div>
            <h2>Add result</h2>
            <form onSubmit={handleSubmit}>
                <label>Grade:</label>
                <input
                    type="number"
                    required
                    value={grade}
                    onChange={(e) => setGrade(e.target.value)}
                />
                <label>Module ID:</label>
                <input
                    type="number"
                    required
                    value={id_module}
                    onChange={(e) => setIdModule(e.target.value)}
                />
                <label>Student ID:</label>
                <input
                    type="number"
                    required
                    value={id_student}
                    onChange={(e) => setIdStudent(e.target.value)}
                />
                <button type="submit">Add result</button>
            </form>
        </div>
    );
}

export default AddResult