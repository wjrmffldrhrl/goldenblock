import React, {Component} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import AuthenticatedRoute from '../../config/AuthenticatedRoute.jsx'
import LoginComponent from './LoginComponent.jsx'
import ErrorComponent from '../error/Error.jsx'
import HeaderComponent from '../HeaderComponent.jsx'
import FooterComponent from '../FooterComponent.jsx'
import LogoutComponent from './LogoutComponent.jsx'
import WelcomeComponent from './WelcomeComponent.jsx'
import AuthenticationService from '../../services/AuthenticationService';
import MainComponent from './MainComponent.jsx';
import { withRouter } from 'react-router'
import RegisterForm from './RegisterForm';

class LoginApp extends Component {

    constructor(props) {
        super(props);

        this.handleUserState = this.handleUserState.bind(this);
        this.state = {isLoggedIn: AuthenticationService.isUserLoggedIn()};

    }

    handleUserState(userState) {
        this.setState({isLoggedIn: userState});
    }


    render() {
        const HeaderWithRouter = withRouter(HeaderComponent);
        const isLoggedIn = this.state.isLoggedIn;

        return (
            <div className="TodoApp">
                <Router>
                    <div>
                        <HeaderWithRouter isLoggedIn={isLoggedIn}
                            userStateChange={this.handleUserState}/>
                        <Switch>
                            <Route exact path="/"  component={MainComponent}/>
                            {/* <Route path="/login" component={LoginComponent}/> */}
                            <Route path="/login" render={
                                (props) => <LoginComponent {...props} userStateChange={this.handleUserState}/>}/>
                            <Route path="/register" component={RegisterForm}/>
                            <AuthenticatedRoute path="/welcome/:name" component={WelcomeComponent}/>
                            <AuthenticatedRoute path="/logout" component={LogoutComponent}/>
                            
                            <Route component={ErrorComponent}/>
                        </Switch>
                        <FooterComponent/>
                    </div>
                </Router>
            </div>
        )
    }
}

export default LoginApp