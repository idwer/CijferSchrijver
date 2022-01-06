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
                        ID: Name:
                        {students.map(student =>
                            <div key={student.id}>
                                {student.id} {student.name} {student.surname}
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default App;
