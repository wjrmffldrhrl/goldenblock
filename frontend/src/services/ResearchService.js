import axios from 'axios';
import AuthenticationService from './AuthenticationService';

class ResearchService {
    getResearchList() {
        AuthenticationService.setupAxiosInterceptors();
        return axios.get('/research');
    }

    getResearchDetails(id) {
        AuthenticationService.setupAxiosInterceptors();
        return axios.get('/research/' + id);
    }

    executeResearchRegister(title, content, deadLine, prizeMoney) {
        AuthenticationService.setupAxiosInterceptors();
        return axios.post('/research', {
            title, content, deadLine, prizeMoney
            }
        )
    }
    
    executeSubmit(researchId, fileName, data) {
        AuthenticationService.setupAxiosInterceptors();
        return axios.post('/fileupload', {
            researchId, fileName, data
        });
    }
}

export default new ResearchService();