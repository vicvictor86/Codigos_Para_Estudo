import { startOfHour } from "date-fns";
import Appointment from "../models/Appointment";
import AppointmentsRepository from "../repositories/AppointmentsRepository";

interface Request {
    provider: string;
    date: Date;
}

class CreateAppointmentService {
    private appointmentsRepository: AppointmentsRepository;

    constructor(appointmentsRepository: AppointmentsRepository){
        this.appointmentsRepository = appointmentsRepository;
    }

    public execute({ provider, date }: Request) : Appointment{
        const appointmentDate = startOfHour(date);

        const findAppointmentsInSameDate = this.appointmentsRepository.findByDate(appointmentDate);

        if(findAppointmentsInSameDate){
            throw new Error("This appointmente is already boooked");
        }

        const appointment = this.appointmentsRepository.create({ 
            provider,
            date: appointmentDate
        });

        return appointment;
    }
}

export default CreateAppointmentService;