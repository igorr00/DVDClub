export class Country{
    id: number;
    name: string;

    constructor(id?: number, name?: string) {
        this.id = id || 0;
        this.name = name || '';
    }
}