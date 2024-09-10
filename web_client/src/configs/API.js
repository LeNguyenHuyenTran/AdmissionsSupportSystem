import axios from "axios";
import cookie from "react-cookies";

export const BASE_URL = "http://localhost:8080/HTTSWebApplication/"; 

export const endpoints = {
  "faculties": "/api/faculties/",
  "register": "/api/users/",
  "login": "/api/login/",
  "current-user": "/api/current-user/",
  "news": "/api/news/",
  "newdetails": (newId) => "/api/news/${newId}/",
  "comments": (newId) => "/api/news/${newId}/comments/",
  "add-comment": "/api/comments/"
}

export const authApi = () => {
  return axios.create({
    baseURL: BASE_URL,
    headers: {
      Authorization: `${cookie.load('token')}`,
    },
  });
};

export default axios.create({
  baseURL: BASE_URL,
});
