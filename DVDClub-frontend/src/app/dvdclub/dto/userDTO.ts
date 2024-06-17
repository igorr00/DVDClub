export class UserDTO{
    constructor(
        public name: string = '',
        public surname: string = '',
        public email: string = '',
        public password: string = '',
        public phone: string = '',
        public gender: number = 0,
        public type: number = 0
    ) {}
}