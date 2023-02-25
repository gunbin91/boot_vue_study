import { posts } from ".";

// const posts = [
//     { id: 1, title: '제목1', contents: '내용1', createdAt: '2023-01-23'},
//     { id: 2, title: '제목2', contents: '내용2', createdAt: '2023-02-25'},
//     { id: 3, title: '제목3', contents: '내용3', createdAt: '2023-07-26'},
//     { id: 4, title: '제목4', contents: '내용4', createdAt: '2023-01-23'},
//     { id: 5, title: '제목5', contents: '내용5', createdAt: '2023-02-21'},
//     { id: 6, title: '제목6', contents: '내용6', createdAt: '2023-07-22'},
//     { id: 7, title: '제목7', contents: '내용7', createdAt: '2023-03-26'},
// ];

export function getPosts(){
    return posts.get('/');
}

export function getPostById(id){
    return posts.get(`/${id}`);
}

export function createPost(data){
    return posts.post('/', data);
}

export function updatePost(id, data){
    return posts.put(`/`, data);
}

export function deletePost(id){
    return posts.delete(`/${id}`);
}