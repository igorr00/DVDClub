import { Country } from "./country";
import { FilmStudio } from "./filmstudio";
import { Genre } from "./genre";
import { Director } from "./director";
import { Actor } from "./actor";

export class Film{
    id: number;
    name: string;
    year: number;
    country: Country;
    filmStudio: FilmStudio;
    genres: Genre[];
    director: Director;
    actors: Actor[];
    image: string;
    
    constructor(){
        this.id = 0;
        this.name = '';
        this.year = 0;
        this.country = new Country();
        this.filmStudio = new FilmStudio();
        this.genres = [],
        this.director = new Director(),
        this.actors = [],
        this.image = '';
    }
}