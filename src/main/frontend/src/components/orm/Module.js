import React from "react";
import { Col, Row } from 'react-bootstrap';

import 'bootstrap/dist/css/bootstrap.min.css';

export default function Module(props) {
    return (
        <Row>
            <Col>{props.id}</Col>
            <Col>{props.name}</Col>
            <Col>{props.id_semester}</Col>
            <Col>{props.submodule}</Col>
        </Row>
    );
}