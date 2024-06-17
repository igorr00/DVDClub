export class DvdDTO{
    constructor(
        public format: string = '',
        public priceBuy: number = 0,
        public priceRent: number = 0,
        public filmId: number = 0,
        public marketplaceId: number = 0
    ) {}
}