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
                        ID: Name:
                        {semesters.map(semester =>
                            <div key={semester.id}>
                                {semester.id} {semester.name}
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default App;
