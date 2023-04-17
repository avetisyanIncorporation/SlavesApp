import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Time from "./Time";
import ClickButton from "./ClickButton";
import {FancyBorder} from "./FancyBorder";
import {WelcomeDialog} from "./WelcomeDialog";

const root = ReactDOM.createRoot(
    document.getElementById('root')
);

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

const header = ReactDOM.createRoot(document.getElementById("header"));
function tick() {
    header
        .render(
            <Time />
        );
}
setInterval(tick, 1000);

ReactDOM.createRoot(document.getElementById("container"))
    .render(
        <div>
            <h2>Начальное время {new Date().toLocaleTimeString()}.</h2>
        </div>
    );

ReactDOM.createRoot(document.getElementById("clickButton"))
    .render(
        <ClickButton />
    );

ReactDOM.createRoot(document.getElementById("fancyBorder"))
    .render(
        <WelcomeDialog />
    );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
