import { Country } from "./country";

export class Director{
    constructor(
        public id: number = 0,
        public name: string = '',
        public surname: string = '',
        public age: number = 0,
        public country: Country
    ) {}
}