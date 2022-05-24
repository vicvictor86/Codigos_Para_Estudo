import { Router } from 'express';
import CreateUserService from '../services/CreateUserService';

const usersRouter = Router();

interface UserJson {
    name: string;
    email: string;
    password?: string;
    created_at: Date;
    updated_at: Date;
}

usersRouter.post('/', async (req, res) => {
    try {
        const { name, email, password } = req.body;

        const createUser = new CreateUserService();

        const user: UserJson = await createUser.execute({
            name,
            email,
            password,
        });

        delete user.password;

        return res.json(user);
    } catch(err) {
        return res.status(400).json({ error: (err as Error).message });
    }
});

export default usersRouter;