import {Component} from "react";

class ClickButton extends Component {

    constructor(props) {
        super(props);
        this.press = this.press.bind(this);
    }

    press(event) {
        console.log("this", this);
        console.log("event", event);
        alert("Fuck you")
    }

    render() {
        return <button
            style={{background: "red", color: "black", padding: 15}}
            onClick={this.press}
        >
            Click Me
        </button>;
    }
}
export default ClickButton;