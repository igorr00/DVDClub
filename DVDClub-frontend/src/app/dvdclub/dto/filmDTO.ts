import { FilmStudio } from "../model/filmstudio";
import { Genre } from "../model/genre";
import { Director } from "../model/director";
import { Actor } from "../model/actor";

export class FilmDTO{
    constructor(
        public name: string = '',
        public year: number = 0,
        public country: string = '',
        public filmStudio: FilmStudio,
        public genres: Genre[] = [],
        public director: Director,
        public actors: Actor[] = [],
        public image: string = ''
    ) {}
}