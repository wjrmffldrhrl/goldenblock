import React, {Component} from 'react'
import AuthenticationService from '../../services/AuthenticationService.js'

class LoginComponent extends Component {
    
    constructor(props) {
        super(props)
        
        this.state = {
            email: localStorage.getItem("authenticatedUser") || '',
            password: '',
            token: localStorage.getItem("token") || '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }
        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]
                  :event.target.value
            }
        )
    }

    loginClicked() {
        AuthenticationService
        // get email, password at the form
        .executeJwtAuthenticationService(this.state.email, this.state.password)
        .then((response) => {
            console.log("login response: " + response.status);
            this.setState({
                token: response.data.token
            });
            AuthenticationService.registerSuccessfulLoginForJwt(this.state.email,this.state.token);
            this.props.history.push(`/`);
            this.props.userStateChange(AuthenticationService.isUserLoggedIn());
        }).catch( () =>{
            this.setState({showSuccessMessage:false})
            this.setState({hasLoginFailed:true})
        });

        
    }

    render() {
        return (
            <div>
                <h1>Login</h1>
                <div className="container">
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.showSuccessMessage && <div>Login Sucessful</div>}
                    User Name: <input type="email" name="email" value={this.state.email} onChange={this.handleChange}/>
                    Password: <input type="password" name="password" value={this.state.password}  onChange={this.handleChange}/>
                    <button className="btn btn-success" onClick={this.loginClicked}>Login</button>
                </div>
            </div>
        )
    }
}

export default LoginComponent