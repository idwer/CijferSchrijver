import React, { Component } from 'react';

import './App.css';

class App extends Component {
    state = {
        isLoading: true,
        results: []
    };

    async componentDidMount() {
        const response = await fetch('/api/results');
        const body = await response.json();
        this.setState({ results: body, isLoading: false });
    }

    render() {
        const {results, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div className="App">
                <header className="App-Header">
                    <div className="App-intro">
                        <h2>List of results</h2>
                        Timestamp: Grade: Student ID: Student Name: Module ID: Module name: Semester ID: Semester name:
                        {results.map(result =>
                            <div key={result.timestamp}>
                                {result.timestamp} {result.grade} {result.student.id} {result.student.name} {result.student.surname} {result.module.id} {result.module.name}
                                {result.module.semester.id} {result.module.semester.name}
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default App;
