import { User } from "./user";
import { Dvd } from "./dvd";
import { SpecialOffer } from "./specialoffer";

export class Purchase{
    id: number;
    date: Date;
    time: Date;
    user: User;
    dvd: Dvd;
    specialOffer: SpecialOffer;

    constructor(){
        this.id = 0;
        this.date = new Date();
        this.time = new Date();
        this.user = new User();
        this.dvd = new Dvd();
        this.specialOffer = new SpecialOffer();
    }
}