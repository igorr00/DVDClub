import { Country } from "./country";

export class FilmStudio{
    id: number;
    public name: string;
    public country: Country;

    constructor(){
        this.id = 0,
        this.name = '',
        this.country = new Country();
    }
}