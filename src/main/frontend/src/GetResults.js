import React, { useEffect, useState } from 'react';

import 'bootstrap/dist/css/bootstrap.min.css'
import { Col, Container, Row } from "react-bootstrap";

import Result from "./components/orm/Result";

export default function GetResults() {
    const [Results, fetchResults] = useState([])

    const getResults = () => {
        fetch('/api/results')
            .then((res) => res.json())
            .then((res) => {
                fetchResults(res)
            })
    }

    useEffect(() => {
        getResults()
    }, [])

    return (
        <div>
            <Container>
                <b>
                    <Row>
                        <Col>Timestamp:</Col>
                        <Col>Grade:</Col>
                        <Col>Student ID:</Col>
                        <Col>sname:</Col>
                        <Col>lname:</Col>
                        <Col>Module ID:</Col>
                        <Col>Module name:</Col>
                        <Col>Semester ID:</Col>
                        <Col>Semester name:</Col>
                    </Row>
                </b>

                {Results.map((result) => {
                    return (
                        <Result
                            timestamp = {result.timestamp}
                            grade = {result.grade}
                            student_id = {result.student.id}
                            student_name = {result.student.name}
                            student_surname = {result.student.surname}
                            module_id = {result.module.id}
                            module_name = {result.module.name}
                            semester_id = {result.module.semester.id}
                            semester_name = {result.module.semester.name}
                        />
                    );
                })}
            </Container>
        </div>
    );
}