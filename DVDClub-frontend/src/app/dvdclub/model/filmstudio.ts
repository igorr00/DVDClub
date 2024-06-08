import { Country } from "./country";

export class FilmStudio{
    constructor(
        public id: number = 0,
        public name: string = '',
        public country: Country
    ) {}
}