export class SpecialOfferDTO{
    name: string;
    discount: number;
    startDate: Date;
    endDate: Date;
    dvdIds: number[];
    marketplaceId: number;

    constructor(){
        this.name = '',
        this.discount = 0,
        this.startDate = new Date(),
        this.endDate = new Date(),
        this.dvdIds = [],
        this.marketplaceId = 0
    }
}