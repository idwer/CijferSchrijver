import React from "react";
import { Col, Row } from 'react-bootstrap';

import 'bootstrap/dist/css/bootstrap.min.css';

export default function Student(props) {
    return (
        <Row>
            <Col>{props.id}</Col>
            <Col>{props.name}</Col>
            <Col>{props.surname}</Col>
        </Row>
    );
}