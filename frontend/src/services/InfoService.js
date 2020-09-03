import axios from 'axios';
import AuthenticationService from './AuthenticationService';

class InfoService {

    getStudentInfo(email) {
        console.log(email);
        AuthenticationService.setupAxiosInterceptors();
        return axios.get('/info' + '?email=' + email);
    }
}

export default new InfoService();