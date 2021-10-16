import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  endpoint: string = "http://localhost:8090/login"
  public loginForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private http : HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: [''],
      password: ['']
    })
  }

  login(){
    this.http.post<any>(this.endpoint, this.loginForm)
      .subscribe((res: any) => {
        localStorage.setItem('access_token', res.access_token)
        this.loginForm.reset();
      }, err=>{
        alert("Something went wrong");
      }) 
  }
}