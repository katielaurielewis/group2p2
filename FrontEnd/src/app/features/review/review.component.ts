import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { User } from 'src/app/core/auth/models/user';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  user = JSON.parse(localStorage.getItem('user')!) as User

  @Input()
  anime: any

  url = "http://localhost:8090/anilib/user/"

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  // submitReview(){
  //   let review = {
  //     starRating:"",
  //     textReview:""
  //   }
  //   this.http.post(url, review).toPromise()
  // }

}
