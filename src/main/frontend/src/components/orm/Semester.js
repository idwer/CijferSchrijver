import React from "react";
import { Col, Row } from 'react-bootstrap';

import 'bootstrap/dist/css/bootstrap.min.css';

export default function Semester(props) {
    return (
        <Row>
            <Col>{props.id}</Col>
            <Col>{props.name}</Col>
        </Row>
    );
}