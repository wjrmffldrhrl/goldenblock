import React, {Component} from 'react'


class RegisterForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: '',
            passwordChecker: ''
        }
        this.handleEmailChange = this.handleEmailChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handlePasswordCheckerChange = this.handlePasswordCheckerChange.bind(this);
    }

    handleEmailChange(e) {
        this.setState({email: e.target.value});
        console.log(this.state.email);
    }
    handlePasswordChange(e) {
        this.setState({password: e.target.value});
    }
    handlePasswordCheckerChange(e) {
        this.setState({passwordChecker: e.target.value});
    }

    handleSubmit(e) {
        alert(e.target.value);
        e.preventDefault();
    }

    render() {
        return(
            <div>
                <h1>Register</h1>
                <form>
                    <label>
                        email: 
                        <input type="email" name="email" value={this.state.email} 
                            onChange={this.handleEmailChange}/>
                    </label>
                    <label>
                        password
                        <input type="password" value={this.state.password} 
                            onChange={this.handlePasswordChange}/>
                    </label>
                    <label>
                        password check
                        <input type="password" value={this.state.passwordChecker}
                            onChange={this.handlePasswordCheckerChange}></input>
                    </label>
                    <input type="button" value="Submit" onClick={this.handleSubmit}/>
                </form>
            </div>
        );
    }
}

export default RegisterForm;