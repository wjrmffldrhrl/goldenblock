import React, {Component} from 'react'

import AuthenticationService from '../../services/AuthenticationService.js'

class MypageComponent extends Component {
    
    constructor(props) {
        super(props)
        this.retrieveWelcomeMessage = this.retrieveWelcomeMessage.bind(this)
        this.state = {
            welcomeMessage : '',
            loggedInUser : AuthenticationService.getLoggedInUserEmail()
        }
        this.handleSuccessfulResponse = this.handleSuccessfulResponse.bind(this)
        this.handleError = this.handleError.bind(this)
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
        return (
            <>
                <h1>My Page</h1>
                <div className="container">
                    Welcome {this.state.loggedInUser}.
                </div>
                <div className="container">
                    
                    Check if axiosInterceptors is working well!<br></br>
                    <button onClick={this.retrieveWelcomeMessage} 
                        className="btn btn-success">Get Message</button>
                </div>
                <div className="container">
                    {this.state.welcomeMessage}
                </div>
                
            </>
        )        
    }
}


export default MypageComponent