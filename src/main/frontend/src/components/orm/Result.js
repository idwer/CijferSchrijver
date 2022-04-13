import React from "react";
import { Col, Row } from 'react-bootstrap';

import 'bootstrap/dist/css/bootstrap.min.css';

export default function Result(props) {
    return (
        <Row>
            <Col>{props.timestamp}</Col>
            <Col>{props.grade}</Col>
            <Col>{props.student_id}</Col>
            <Col>{props.student_name}</Col>
            <Col>{props.student_surname}</Col>
            <Col>{props.module_id}</Col>
            <Col>{props.module_name}</Col>
            <Col>{props.semester_id}</Col>
            <Col>{props.semester_name}</Col>
        </Row>
    );
}