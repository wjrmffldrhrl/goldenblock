import axios from 'axios';
import AuthenticationService from './AuthenticationService';

class ResearchService {
    getResearchList() {
        AuthenticationService.setupAxiosInterceptors();
        return axios.get('https://jsonplaceholder.typicode.com/posts');
    }
}

export default new ResearchService();