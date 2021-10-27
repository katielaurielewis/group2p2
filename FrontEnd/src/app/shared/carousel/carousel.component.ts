import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/core/auth/models/user';
import { Anime } from '../models/anime';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {

  @Input()
  anime!: Anime[];

  @Input()
  unwatched!: boolean;

  constructor(private http: HttpClient, private changeDetector: ChangeDetectorRef) {}

  ngOnInit(): void {}

  setToWatched() {
    let active = document.querySelectorAll('.carousel-item.active')[0]
    let animeId = parseInt(active.getAttribute('anime-id')!)
    this.http.post<any>(this.buildSetWatchedURI(animeId), {})
      .subscribe((res: any) => {
        console.log("set to watched")
        let removeIndex = -1;
        this.anime.find((it, index) => {
          if(it.id == parseInt(active.getAttribute('anime-id')!)) {
            removeIndex = index;
          }
        })
        if(removeIndex != -1) {
          this.anime.splice(removeIndex, 1);
          this.changeDetector.detectChanges();
          if(document.querySelectorAll('.carousel-item.active').length == 0) {
            // occasionally, removing the anime due to status change results in no active carousel item left
            // set the first carousel item to active in this case
            document.querySelectorAll('.carousel-item')[0].classList.add('active')
          }
        }
      })
  }

  buildSetWatchedURI(animeId: number) {
    let userId = (JSON.parse(localStorage.getItem('user')!) as User).id
    return "http://localhost:8090/anilib/library/" + userId + "/" + animeId + "/setWatched"
  }
}
