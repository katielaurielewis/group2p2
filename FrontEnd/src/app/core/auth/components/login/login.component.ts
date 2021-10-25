import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../models/user';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userEndpoint: string = "http://localhost:8090/anilib/user/";
  loginEndpoint: string = "http://localhost:8090/anilib/login"

  public loginForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private http : HttpClient, private router : Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: [''],
      password: ['']
    })
    this.authService.logout()
  }

  login(){
    this.http.post<any>(this.loginEndpoint, this.loginForm.getRawValue())
      .subscribe((res : any) => {
        this.authService.setToken(res.token).then(() => {
          this.http.get<User>(this.userEndpoint + this.loginForm.get('username')!.value).subscribe((res:User) => {
            localStorage.setItem('user', JSON.stringify(res))
            this.loginForm.reset();
            this.router.navigate([`/dashboard`]);
          });
        })
      })
  }

  register(){
    this.router.navigate([`/register`]);
  }
}
