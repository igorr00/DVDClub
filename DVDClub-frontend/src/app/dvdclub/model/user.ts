export class User{
    constructor(
        public id: number = 0,
        public name: string = '',
        public surname: string = '',
        public email: string = '',
        public password: string = '',
        public phone: string = '',
        public gender: number = 0,
        public type: number = 0,
        public enabled: boolean = false,
        public verificationCode: string = ''
    ) {}
}