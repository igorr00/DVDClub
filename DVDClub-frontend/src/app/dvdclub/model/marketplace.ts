import { City } from "./city";
import { Dvd } from "./dvd";
import { SpecialOffer } from "./specialoffer";
import { User } from "./user";

export class Marketplace{
    id: number;
    name: string;
    street: string;
    number: string;
    city: City;
    dvds: Dvd[];
    specialOffers: SpecialOffer[];
    users: User[];
    manager: User;
   
    constructor(){
        this.id = 0;
        this.name = '';
        this.street = '',
        this.number = '',
        this.city = new City(),
        this.dvds = [],
        this.specialOffers = [],
        this.users = [],
        this.manager = new User();
    }
}