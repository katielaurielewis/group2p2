import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { CredentialsService } from 'src/app/credentials.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  user!: User;
  


  endpoint: string = "http://localhost:8090/anilib/login"

  public loginForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private http : HttpClient, private router : Router, private credentialsService: CredentialsService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: [''],
      password: ['']
    })
  }

  login(){
    /*
    this.http.post<any>(this.endpoint, this.loginForm.getRawValue())
      .subscribe((res: any) => {
        localStorage.setItem('access_token', res.access_token)
        this.credentialsService.setUsername(this.loginForm.get('username')!.value);
        this.loginForm.reset();
        this.router.navigate([`/library`]);
      }, err=>{
        alert("Something went wrong");
      }) */
      this.router.navigate([`/dashboard`]);
  }
}
