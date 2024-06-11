import { City } from "./city";
import { Dvd } from "./dvd";
import { SpecialOffer } from "./specialoffer";
import { User } from "./user";

export class Marketplace{
    constructor(
        public id: number = 0,
        public name: string = '',
        public street: string = '',
        public number: string = '',
        public city: City,
        public dvds: Dvd[] = [],
        public specialOffers: SpecialOffer[] = [],
        public users: User[] = [],
        public manager: User
    ) {}
}