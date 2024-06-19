import { Film } from "./film";

export class Dvd{
    id: number;
    format: string;
    priceRent: number;
    film: Film;
    priceBuy: number;

    constructor(){
        this.id = 0,
        this.format = '',
        this.priceBuy = 0,
        this.priceRent = 0,
        this.film = new Film()
    }
}