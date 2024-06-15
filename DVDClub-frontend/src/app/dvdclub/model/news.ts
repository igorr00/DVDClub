export class News{
    id: number;
    date: Date;
    title: string;
    text: string;

    constructor(){
        this.id = 0,
        this.date = new Date(),
        this.title = '',
        this.text = ''
    }
}