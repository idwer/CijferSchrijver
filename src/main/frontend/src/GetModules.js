import React, { Component } from 'react';

import './App.css';

class App extends Component {
    state = {
        isLoading: true,
        modules: []
    };

    async componentDidMount() {
        const response = await fetch('/api/modules');
        const body = await response.json();
        this.setState({ modules: body, isLoading: false });
    }

    render() {
        const {modules, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div className="App">
                <header className="App-Header">
                    <div className="App-intro">
                        <h2>List of modules</h2>
                        <table border="1">
                            <tr align="right">
                                <th>ID:</th>
                                <th>Name:</th>
                                <th>Semester ID:</th>
                                <th>Semester name:</th>
                            </tr>
                        {modules.map((module) => (
                            <tr align="right">
                                <td>{module.id}</td>
                                <td>{module.name}</td>
                                <td>{module.semester.id}</td>
                                <td>{module.semester.name}</td>
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
