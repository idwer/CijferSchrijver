import React, {useState} from 'react'
import {useNavigate} from "react-router-dom";

function AddModule() {
    const [name, setName] = useState('');
    const [id_semester, setIdSemester] = useState('');
    const [submodule, setSubmodule] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const module = { name, id_semester, submodule };

        fetch('http://localhost:8080/api/module/add',
            {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(module)
            }
        );
        redirectAfterClick()
    }

    let navigate = useNavigate();
    function redirectAfterClick() {
        navigate("/get/modules")
    }

    return (
        <div>
            <h2>Add module</h2>
            <form onSubmit={handleSubmit}>
                <label>Name:</label>
                <input
                    type="text"
                    required
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <label>Part of Semester:</label>
                <input
                    type="number"
                    required
                    value={id_semester}
                    onChange={(e) => setIdSemester(e.target.value)}
                />
                <label>submodule:</label>
                <input
                    type="number"
                    value={submodule}
                    onChange={(e) => setSubmodule(e.target.value)}
                />
                <button type="submit">Add module</button>
            </form>
        </div>
    );
}

export default AddModule