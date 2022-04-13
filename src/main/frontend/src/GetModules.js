import React, { useEffect, useState } from 'react';

import 'bootstrap/dist/css/bootstrap.min.css'
import { Col, Container, Row } from "react-bootstrap";

import Module from "./components/orm/Module";

export default function GetModules() {
    const [Modules, fetchModules] = useState([])

    const getModules = () => {
        fetch('/api/modules')
            .then((res) => res.json())
            .then((res) => {
                fetchModules(res)
            })
    }

    useEffect(() => {
        getModules()
    }, [])

    return (
        <div>
            <Container>
                <b>
                    <Row>
                        <Col>ID:</Col>
                        <Col>Name:</Col>
                        <Col>Semester ID:</Col>
                        <Col>Semester name:</Col>
                    </Row>
                </b>

                {Modules.map((module) => {
                    return (
                        <Module
                            id = {module.id}
                            name = {module.name}
                            id_semester = {module.semester.id}
                            submodule = {module.semester.name}
                        />
                    );
                })}
            </Container>
        </div>
    );
}