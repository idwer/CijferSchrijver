import React, { Component } from 'react';

import './App.css';

class App extends Component {
    state = {
        isLoading: true,
        semesters: []
    };

    async componentDidMount() {
        const response = await fetch('/api/semesters');
        const body = await response.json();
        this.setState({ semesters: body, isLoading: false });
    }

    render() {
        const {semesters, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div className="App">
                <header className="App-Header">
                    <div className="App-intro">
                        <h2>List of semesters</h2>
                        <table border="1">
                            <tr align="right">
                                <th>ID:</th>
                                <th>Name:</th>
                            </tr>
                        {semesters.map((semester) => (
                            <tr align="right">
                                <td>{semester.id}</td>
                                <td>{semester.name}</td>
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
