export class RentDTO{
    userId: any;
    dvdId: any;
    date: Date;

    constructor(){
        this.userId = 0;
        this.dvdId = 0;
        this.date = new Date();
    }
}