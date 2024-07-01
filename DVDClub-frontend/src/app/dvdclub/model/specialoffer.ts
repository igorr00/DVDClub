import { Dvd } from "./dvd";

export class SpecialOffer{
    id: number;
    name: string;
    discount: number;
    price: number;
    startDate: Date;
    endDate: Date;
    dvds: Dvd[];

    constructor(){
        this.id = 0,
        this.name = '',
        this.discount = 0,
        this.price = 0,
        this.startDate = new Date(),
        this.endDate = new Date(),
        this.dvds = []
    }
}