import { Country } from "./country";

export class City{
    constructor(
        public id: number = 0,
        public name: string = '',
        public country: Country
    ) {}
}