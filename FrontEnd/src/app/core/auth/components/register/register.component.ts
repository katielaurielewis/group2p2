import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  public registerForm!: FormGroup;
  user!: User;
  constructor(private formBuilder: FormBuilder, private router : Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email, Validators.minLength(3)]],
      fName:['', [Validators.required, Validators.minLength(3)]],
      lName:['', Validators.required],
      username:['', Validators.required],
      password:['', Validators.required, Validators.minLength(3)]
    })
  }

  register(){
    this.user = this.registerForm.value;

    this.authService
      .register(this.user)
      .subscribe(res => {
        alert("User registered");
        console.log(res)
        this.registerForm.reset();
        this.router.navigate(['login']);
      }, err=>{
        alert("Something went wrong")
      })
     
  }
}
