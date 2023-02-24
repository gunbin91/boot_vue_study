import { tests } from ".";

export function getTests(){
    return tests.get('/');
}

export function getTestById(id){
    return tests.get(`/${id}`);
}

export function createTest(data){
    return tests.post(`/`, data);
}

export function updateTest(id, data){
    return tests.put(`/`, data);
}

export function deleteTest(id){
    return tests.delete(`/${id}`);
}