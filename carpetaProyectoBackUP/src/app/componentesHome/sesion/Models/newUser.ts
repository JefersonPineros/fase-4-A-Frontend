export class NewUser {
    constructor(
        public firstName: string,
        public lastName: string,
        public email: string,
        public pass: string,
        public confirmPass: string
    ) {

    }
}