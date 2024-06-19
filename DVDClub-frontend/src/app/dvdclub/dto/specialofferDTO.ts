export class SpecialOfferDTO{
    name: string;
    price: number;
    startDate: Date;
    endDate: Date;
    dvdIds: number[];
    marketplaceId: number;

    constructor(){
        this.name = '',
        this.price = 0,
        this.startDate = new Date(),
        this.endDate = new Date(),
        this.dvdIds = [],
        this.marketplaceId = 0
    }
}