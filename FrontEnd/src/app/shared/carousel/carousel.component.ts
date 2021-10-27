import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/core/auth/models/user';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {

  reviewEndpoint = 'http://localhost:8090/anilib/review'

  @Input()
  anime: any;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {}

  submitReview(score: number, review: string) {
    this.http.post<any>(this.reviewEndpoint, this.buildReviewBody(score, review))
      .subscribe((res: any) => {
        console.log("submitted!")
      })
  }

  buildReviewBody(score: number, review: string) {
    let active = document.querySelectorAll('[active="true"]')[0]
    return {
      "userId": (JSON.parse(localStorage.getItem('user')!) as User).id,
      "animeId": parseInt(active.getAttribute('anime-id')!),
      "score": score,
      "review": review
    }
  }

}
