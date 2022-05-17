"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.helloWorld = void 0;
const CreateUser_1 = __importDefault(require("./services/CreateUser"));
function helloWorld(request, response) {
    const user = (0, CreateUser_1.default)({
        email: 'teste@gmail.com',
        password: '123456',
        techs: [
            'NodeJS',
            'ReactJS',
            'React Native',
            { title: 'Javascript', experience: 100 },
        ]
    });
    return response.json({ message: 'hello world' });
}
exports.helloWorld = helloWorld;
