import {Component} from "react";

class Time extends Component {
    render() {
        return (
            <div>
                <h1>Сервис получения времени</h1>
                <h2>Текущее время {new Date().toLocaleTimeString()}.</h2>
            </div>
        );
    }
}
export default Time;