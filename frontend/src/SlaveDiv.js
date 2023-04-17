import {Component} from "react";
import ShowInfoButton from "./ShowInfoButton";

class SlaveDiv extends Component {
    render() {
        const localSlavesList = this.props.slavesList;
        console.log(localSlavesList)
        return (
            <div className={"slavesList"}>
                <h2>Slaves</h2>
                {localSlavesList && localSlavesList.map(slave =>
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