import React, { useEffect, useState } from 'react';

import 'bootstrap/dist/css/bootstrap.min.css'
import { Col, Container, Row } from "react-bootstrap";

import Student from "./orm/Student";

export default function GetStudents() {
    const [Students, fetchStudents] = useState([])

    const getStudents = () => {
        fetch('/api/students')
            .then((res) => res.json())
            .then((res) => {
                fetchStudents(res)
        })
    }

    useEffect(() => {
        getStudents()
    }, [])

    return (
        <div>
            <Container>
                <b>
                <Row>
                    <Col>ID:</Col>
                    <Col>Name:</Col>
                    <Col>Last name:</Col>
                </Row>
                </b>

                {Students.map((student) => {
                    return (
                        <Student
                            id = {student.id}
                            name = {student.name}
                            surname = {student.surname}
                        />
                    );
                })}
            </Container>
        </div>
    );
}