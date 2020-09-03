
import React, {Component} from 'react';

import MyPageComponent from './MyPageComponent.jsx';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import AuthenticationService from '../../services/AuthenticationService';
import MainComponent from './MainComponent.jsx';
import { withRouter } from 'react-router';
import RegisterForm from './RegisterForm';
import ResearchListComponent from '../research/ResearchListComponent';
import ResearchDetailsComponent from '../research/ResearchDetailsComponent';
import LogoutComponent from '../../components/login/LoginComponent';
import AuthenticatedRoute from '../../config/AuthenticatedRoute';
import ErrorComponent from '../error/Error';
import HeaderComponent from '../HeaderComponent';
import LoginComponent from '../../components/login/LoginComponent';
import FooterComponent from '../FooterComponent';


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
                            <AuthenticatedRoute path="/mypage" component={MyPageComponent}/>
                            <AuthenticatedRoute path="/logout" component={LogoutComponent}/>
                            <AuthenticatedRoute path="/researches" component={ResearchListComponent}/>
                            <AuthenticatedRoute path="/research/:id" component={ResearchDetailsComponent}/>
                            <Route component={ErrorComponent}/>
                        </Switch>
                        <FooterComponent/>
                    </div>
                </Router>
            </div>
        )
    }
}

export default LoginApp;