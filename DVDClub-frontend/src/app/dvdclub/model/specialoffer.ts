import { Dvd } from "./dvd";

export class SpecialOffer{
    constructor(
        public id: number = 0,
        public name: string = '',
        public price: number = 0,
        public startDate: Date = new Date(),
        public endDate: Date = new Date(),
        public dvds: Dvd[] = []
    ) {}
}