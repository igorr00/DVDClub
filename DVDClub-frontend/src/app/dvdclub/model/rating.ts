import { User } from "./user";
import { Film } from "./film";

export class Rating{
    id: number;
    score: number;
    comment: string;
    date: Date;
    time: Date;
    user: User;
    film: Film;

    constructor(){
        this.id = 0;
        this.score = 0;
        this.comment = '';
        this.date = new Date();
        this.time = new Date();
        this.user = new User();
        this.film = new Film();
    }
}