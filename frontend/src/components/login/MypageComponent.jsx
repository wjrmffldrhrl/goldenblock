import React, {Component} from 'react';

import AuthenticationService from '../../services/AuthenticationService';
import InfoService from '../../services/InfoService';
class MypageComponent extends Component {
    
    constructor(props) {
        super(props)
        this.retrieveWelcomeMessage = this.retrieveWelcomeMessage.bind(this)
        this.state = {
            welcomeMessage : '',
            loggedInUser : AuthenticationService.getLoggedInUserEmail(),
            info : ''
        }
        this.handleSuccessfulResponse = this.handleSuccessfulResponse.bind(this)
        this.handleError = this.handleError.bind(this)
    }

    componentDidMount() {
        InfoService.getStudentInfo(this.state.loggedInUser)
        .then(response => {
            console.log(response.data);
            this.setState({info : response.data});
        }).catch(error => {
            console.log(error);
        })
    }

    retrieveWelcomeMessage() {
        
        AuthenticationService.executeHelloService()
        .then( response => this.handleSuccessfulResponse(response) )
        .catch( error => this.handleError(error) )
    }

    handleSuccessfulResponse(response) {
        console.log(response)
        this.setState({welcomeMessage: response.data})
    }

    handleError(error) {
        console.log(error.response)
        let errorMessage = '';
        
        if(error.message) 
            errorMessage += error.message

        if(error.response && error.response.data) {
            errorMessage += error.response.data.message
        }

        this.setState({welcomeMessage: errorMessage})
    }

    
    render() {
        let userInfo = this.state.info;
        return (
            <div>
                <h1>My Page</h1>
                
                <div className="container">
                    {
                        userInfo && <div>
                            <p>name : {userInfo.name}</p>
                            <p>email : {userInfo.email}</p>
                            <p>school : {userInfo.school}</p>
                        </div>

                    }
                    {
                        !userInfo && <div>
                            Loading....
                        </div>
                    }
                    
                    
                   
                   
                    <button onClick={this.retrieveWelcomeMessage} 
                        className="btn btn-success">Get Message</button>
                </div>
                <div className="container">
                    {this.state.welcomeMessage}
                </div>
                
            </div>
        )        
    }
}


export default MypageComponent