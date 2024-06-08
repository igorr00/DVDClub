import { Film } from "./film";

export class Dvd{
    constructor(
        public id: number = 0,
        public format: string = '',
        public priceBuy: number = 0,
        public priceRent: number = 0,
        public film: Film
    ) {}
}