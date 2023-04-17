import {Component} from "react";
import SlaveDiv from "./SlaveDiv";

class App extends Component {
  state = {
    slaves: [],
    loading: true,
    error: ''
  };

  async componentDidMount() {
    try {
      const response = await fetch('/slave/getAllSlaves?limit=10');
      const body = await response.json();
      this.setState({slaves: body, loading: false, error: ''});
    } catch (e) {
      console.log(e);
      this.setState({loading: false, error: e.message});
    }
  }

  render() {
    const slaves = this.state.slaves;
    const loading = this.state.loading;
    const error = this.state.error;
    return (
        <div className="App">
          {loading && <div>Loading...</div>}
          {error && <div style={{color: "red"}}>{error}</div>}
          <header className="App-header">
            <SlaveDiv slavesList={slaves} />
          </header>
        </div>
    );
  }
}
export default App;