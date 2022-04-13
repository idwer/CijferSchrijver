import React, { useEffect, useState } from 'react';

import 'bootstrap/dist/css/bootstrap.min.css'
import { Col, Container, Row } from "react-bootstrap";

import Semester from "./orm/Semester";

export default function GetSemesters() {
    const [Semesters, fetchSemesters] = useState([])

    const getSemesters = () => {
        fetch('/api/semesters')
            .then((res) => res.json())
            .then((res) => {
                fetchSemesters(res)
            })
    }

    useEffect(() => {
        getSemesters()
    }, [])

    return (
        <div>
            <Container>
                <b>
                    <Row>
                        <Col>ID:</Col>
                        <Col>Name</Col>
                    </Row>
                </b>

                {Semesters.map((semester) => {
                    return (
                        <Semester
                            id = {semester.id}
                            name = {semester.name}
                        />
                    );
                })}
            </Container>
        </div>
    );
}