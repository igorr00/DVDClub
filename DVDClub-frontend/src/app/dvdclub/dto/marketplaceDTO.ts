export class MarketplaceDTO{
    constructor(
        public name: string = '',
        public street: string = '',
        public number: string = '',
        public city: string = '',
        public country: string = '',
        public manager: string = ''
    ) {}
}