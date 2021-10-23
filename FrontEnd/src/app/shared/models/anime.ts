export class Anime {

    constructor(
        public _id:number,
        public title:string,
        public mRating:string,
        public uRating: number,
        public synopsis:string,
        public genre:object[],
        public studios:object[],
        public imageURL:string
    ){}
}
