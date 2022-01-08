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
                        ID: Name:
                        {modules.map(module =>
                            <div key={module.id}>
                                {module.id} {module.name} {module.semester.id} {module.semester.name}
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default App;
