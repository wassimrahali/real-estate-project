import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { log } from 'console';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  [x: string]: any;
  private baseUrl = 'http://localhost:8090/api/auth';
  private UrlPost='http://localhost:8090/post'
  constructor(private http: HttpClient) { }
  post:any[]=[]
  login(credentials: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/signin`, credentials);
  }

  signup(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/signup`, user);
  }
  createPost(post:any){
    console.log("pp" , post);

    return this.http.post(this.UrlPost,post);
  }
  getPost(){
    return this.http.get(this.UrlPost);
  }
    getPostById(id: number): Observable<any> {
    return this.http.get<any>(`${this.UrlPost}/${id}/images`);
  }
}
