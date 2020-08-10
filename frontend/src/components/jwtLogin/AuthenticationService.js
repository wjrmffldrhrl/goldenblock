import axios from 'axios'




class AuthenticationService {

    
    
    // send username, password to the SERVER
    executeJwtAuthenticationService(email, password) {
        

        return axios.post('/authenticate', {
            email,
            password
        })
    }

    //send get method to /hello
    executeHelloService() {
        console.log("===executeHelloService===")

        this.setupAxiosInterceptors();
        return axios.get('/hello');
    }


    //save token with email
    registerSuccessfulLoginForJwt(email, token) {
        console.log("===registerSuccessfulLoginForJwt===")
        localStorage.setItem('token', token);
        localStorage.setItem('authenticatedUser', email);

        // axios.defaults.headers = {
        //     'Authorization' : 'Bearer ' + token,
        // };

        this.setupAxiosInterceptors();
    }




    setupAxiosInterceptors() {
        axios.interceptors.request.use(
            config => {
                const token = localStorage.getItem('token');
                console.log('token in the interceptors : ' + token);
                if (token) {
                    config.headers['Authorization'] = 'Bearer ' + token;
                }

                return config;
            },
            error => {
                Promise.reject(error)
            });
    }

    logout() {

        localStorage.removeItem("authenticatedUser");
        localStorage.removeItem("token");
        // axios.defaults.headers = {
        //     'Authorization' : '',
        // };
    }


    // check loggedin user
    isUserLoggedIn() {


        const token = localStorage.getItem('token');
        console.log("===UserloggedInCheck===");
        console.log(token);

        if (token) {
            return true;
        }

        return false;
    }

    getLoggedInUserEmail() {

        let user = localStorage.getItem('authenticatedUser');
        if (user === null) return '';
        return user;
    }


}

export default new AuthenticationService()