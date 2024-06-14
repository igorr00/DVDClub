import { Country } from "./country";

export class Actor{
    id: number;
    name: string;
    surname: string;
    age: number;
    country: Country;

    constructor(){
        this.id = 0;
        this.name = '';
        this.surname = '';
        this.age = 0;
        this.country = new Country();
    }
}