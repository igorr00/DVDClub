import { Country } from "./country";

export class City{
    id: number;
    name: string;
    country: Country;

    constructor(){
        this.id = 0,
        this.name = '',
        this.country = new Country();
    }
}