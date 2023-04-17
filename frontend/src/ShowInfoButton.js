import {Component} from "react";

class ShowInfoButton extends Component {

    constructor(props) {
        super(props);
        this.state = {
            showInfo: false,
            currency: "$"
        };
        // this.replaceInfo = this.replaceInfo.bind(this);
    }

    replaceInfo() {
        console.log(this);
        this.setState({showInfo: true});
    }

    render() {
        const slave = this.props.slave;

        // Способ 1
        // if (!this.state.showInfo) {
        //     return (
        //         <button onClick={() => this.replaceInfo(slave)}>ShowInfo</button>
        //     )
        // } else {
        //     return (
        //         <span> {slave.gender} {slave.age} y.o. Price {slave.price}$`</span>
        //     );
        // }

        // Способ 2
        return (
            this.state.showInfo ?
                <span> {slave.gender} {slave.age} y.o. Price {slave.price}{this.state.currency}</span> :
                <button onClick={() => this.replaceInfo(slave)}>ShowInfo</button>
        );
    }
}
export default ShowInfoButton;