import {Component} from "react";

class ShowInfoButton extends Component {

    constructor(props) {
        super(props);
        this.showInfo = this.showInfo.bind(this);
    }

    showInfo(slave) {
        // console.log(this);
        console.log("Name:", slave.name, slave.gender, "Age:", slave.age, "Price:", slave.price, "$");
    }

    render() {
        return(
            <button onClick={() => this.showInfo(this.props.slave)}>ShowInfo</button>
        );
    }
}
export default ShowInfoButton;