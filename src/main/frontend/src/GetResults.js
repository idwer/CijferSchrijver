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
                        <table border="1">
                            <tr align="right">
                                <th>Timestamp:</th>
                                <th>Grade:</th>
                                <th>Student ID:</th>
                                <th colSpan="2">Student Name:</th>
                                <th>Module ID:</th>
                                <th>Module name:</th>
                                <th>Semester ID:</th>
                                <th>Semester name:</th>
                            </tr>
                        {results.map((result) => (
                                <tr align="right">
                                    <td>{result.timestamp}</td>
                                    <td>{result.grade}</td>
                                    <td>{result.student.id}</td>
                                    <td>{result.student.name}</td>
                                    <td>{result.student.surname}</td>
                                    <td>{result.module.id}</td>
                                    <td>{result.module.name}</td>
                                    <td>{result.module.semester.id}</td>
                                    <td>{result.module.semester.name}</td>
                                </tr>
                            ))}
                        </table>
                    </div>
                </header>
            </div>
        );
    }
}

export default App;
