export class RatingDTO{
    score: number;
    comment: string;
    userId: number;
    filmId: number;

    constructor(){
        this.score = 0;
        this.comment = '';
        this.userId = 0;
        this.filmId = 0;
    }
}