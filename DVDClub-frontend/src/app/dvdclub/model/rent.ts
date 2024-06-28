import { User } from "./user";
import { Dvd } from "./dvd";

export class Rent{
    id: number;
    date: Date;
    user: User;
    dvd: Dvd;
    due: Date;
    dateReturned: Date;
    status: number;

    constructor(){
        this.id = 0;
        this.date = new Date();
        this.user = new User();
        this.dvd = new Dvd();
        this.due = new Date();
        this.dateReturned = new Date();
        this.status = 0;
    }
}