import React, {Component} from 'react'
import AuthenticationService from '../../services/AuthenticationService.js'


class RegisterForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            email: '',
            school: '',
            password: '',
            passwordChecker: ''
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleChange(e) {
        this.setState(
            {
                [e.target.name]
                  :e.target.value
            }
        )
    }

    handleSubmit(e) {
        
        if(this.passwordIsSame()){
            AuthenticationService
            // get email, password at the form
            .executeStudentRegister(this.state.email, this.state.password, 
                this.state.name, this.state.school)
            .then((response) => {
                console.log("register response: " + response.status);
                
                this.props.history.push(`/login`);
                
            }).catch( () =>{
                
                console.log('register fail');
            });

        } else {
            alert("password didn't match!");
        }

       

        e.preventDefault();
    }

    passwordIsSame() {
        if(this.state.password === this.state.passwordChecker) return true;
        else return false;
    }
    render() {
        let passwordCheckerColor;

        if(this.state.passwordChecker === '') 
            passwordCheckerColor =  {}
        else if(this.state.password === this.state.passwordChecker)
            passwordCheckerColor = {backgroundColor: '#33FF66'};
        else passwordCheckerColor = {backgroundColor: '#FF0000'};

        return(
            <div>
                <h1>Register</h1>
                <form>
                    <label>
                        email: 
                        <input type="email" name="email" value={this.state.email} 
                            onChange={this.handleChange}/>
                    </label>
                    <label>
                        name: 
                        <input type="text" name="name" value={this.state.name} 
                            onChange={this.handleChange}/>
                    </label>
                    <label>
                        school: 
                        <input type="text" name="school" value={this.state.school} 
                            onChange={this.handleChange}/>
                    </label>
                    <label>
                        password
                        <input type="password" name="password" value={this.state.password} 
                            onChange={this.handleChange}/>
                    </label>
                    <label>
                        password check
                        <input type="password" name="passwordChecker" value={this.state.passwordChecker}
                            onChange={this.handleChange} style={passwordCheckerColor}></input>
                    </label>
                    <input type="button" value="Submit" onClick={this.handleSubmit}/>
                </form>
            </div>
        );
    }
}

export default RegisterForm;