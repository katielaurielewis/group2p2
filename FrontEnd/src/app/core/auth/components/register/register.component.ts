import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  endpoint: string = "http://localhost:4200/register"
  public registerForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private http : HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: [''],
      firstName:[''],
      lastName:[''],
      username:[''],
      password:['']
    })
  }

  register(){
    this.http.post<any>(this.endpoint, this.registerForm)
    .subscribe(res=>{
      alert("Registration Complete");
      this.registerForm.reset();
      this.router.navigate(['login']);
    },err=>{
      alert("Something went wrong")
    })
  }

}
