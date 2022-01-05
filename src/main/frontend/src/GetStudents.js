import React, { Component } from 'react';

import './App.css';

class App extends Component {
    state = {
        isLoading: true,
        students: []
    };

    async componentDidMount() {
        const response = await fetch('/api/students');
        const body = await response.json();
        this.setState({ students: body, isLoading: false });
    }

    render() {
        const {students, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div className="App">
                <header className="App-Header">
                    <div className="App-intro">
                        <h2>List of students</h2>
                        {students.map(student =>
                            <div key={student.id}>
                                <ul>
                                    <li>{student.id} {student.name} {student.surname}</li>
                                </ul>
                            </div>
                        )}
                        <td>ID</td><td></td><td>Name</td><td>Surname</td>
                        {students.map(student =>
                            <div key={student.id}>
                                <tr>
                                    <td>{student.id}</td>
                                    <a href="/student/{student.id}">hyperlink</a>
                                    <td>{student.name}</td>
                                    <td>{student.surname}</td>
                                </tr>
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default App;
