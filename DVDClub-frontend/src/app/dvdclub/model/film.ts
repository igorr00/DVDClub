import { Country } from "./country";
import { FilmStudio } from "./filmstudio";
import { Genre } from "./genre";
import { Director } from "./director";
import { Actor } from "./actor";

export class Film{
    constructor(
        public id: number = 0,
        public name: string = '',
        public year: number = 0,
        public country: Country,
        public filmStudio: FilmStudio,
        public genres: Genre[] = [],
        public director: Director,
        public actors: Actor[] = [],
        public image: string = ''
    ) {}
}