import {Component} from "react";
import SlaveDiv from "./SlaveDiv";

class App extends Component {
  state = {
    slaves: []
  };

  async componentDidMount() {
    const response = await fetch('/slave/getAllSlaves');
    const body = await response.json();
    this.setState({slaves: body});
  }

  render() {
    const {slaves} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <SlaveDiv slavesList={slaves} />
          </header>
        </div>
    );
  }
}
export default App;