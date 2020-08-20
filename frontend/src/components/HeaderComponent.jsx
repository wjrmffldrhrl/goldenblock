import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import AuthenticationService from '../services/AuthenticationService.js'


class HeaderComponent extends Component {
    constructor(props) {
        super(props);
        this.handleLogout = this.handleLogout.bind(this);
   
    }


    handleLogout(e) {
        AuthenticationService.logout();
        this.props.userStateChange(AuthenticationService.isUserLoggedIn());
    }

    render() {
        // const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        // const userEmail = AuthenticationService.getLoggedInUserEmail();
        
        console.log("===HeaderomponeuserEmailnt===");
        console.log(this.props.isLoggedIn);
        const isLoggedIn = this.props.isLoggedIn;
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        
                    <div className="navbar-brand"><h1>Golden Block</h1></div>
                        <ul className="navbar-nav">
                            <li><Link className="nav-link" to="/">Home</Link></li>
                        </ul>
                    {
                        this.props.isLoggedIn && <div>
                            <ul className="navbar-nav">
                                <li><Link className="nav-link" to="/mypage">My page</Link></li>
                            </ul>
                            <ul className="navbar-nav navbar-collapse justify-content-end">
                                <li><Link className="nav-link" to="/logout" onClick={this.handleLogout}>Logout</Link></li>
                            </ul>
                        </div>
                    }
                    {
                        !this.props.isLoggedIn && <div>
                            <ul className="navbar-nav">
                                
                            </ul>
                            <ul className="navbar-nav navbar-collapse justify-content-end">
                                <li><Link className="nav-link" to="/login">Login</Link></li>
                                <li><Link className="nav-link" to="/register">Sign Up</Link></li>
                            </ul>
                        </div>
                    }
                    {/* <ul className="navbar-nav">
                        {this.state.isUserLoggedIn && <li><Link className="nav-link" to="/welcome/user_id">Home</Link></li>}
                    </ul>

                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!this.state.isUserLoggedIn && <li><Link className="nav-link" to="/login">Login</Link></li>}
                        {!this.state.isUserLoggedIn && <li><Link className="nav-link" to="/register">Sign Up</Link></li>}
                        {this.state.isUserLoggedIn && <li><Link className="nav-link" to="/logout" onClick={AuthenticationService.logout}>Logout</Link></li>}
                    </ul> */}
                </nav>
            </header>
        )
    }
}

export default HeaderComponent