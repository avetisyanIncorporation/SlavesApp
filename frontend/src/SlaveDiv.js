import {Component} from "react";
import ShowInfoButton from "./ShowInfoButton";

class SlaveDiv extends Component {
    render() {
        const localSlavesList = this.props.slavesList;
        return (
            <div className={"slavesList"}>
                <h2>Slaves</h2>
                {localSlavesList.map(slave =>
                    <div key={slave.id}>
                        Name: {slave.name}
                        <ShowInfoButton slave={slave}/>
                    </div>

                )}
            </div>
        );
    }
}
export default SlaveDiv;