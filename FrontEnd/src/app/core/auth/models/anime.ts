import { Genre } from "./genre";
import { Studio } from "./studio";

export class Anime {
    id!: number;
    title!: string;
    rating!: string;
    score!: number;
    synopsis!: string;
    image!: string;
    themes!: Genre;
    studios!: Studio;
}
