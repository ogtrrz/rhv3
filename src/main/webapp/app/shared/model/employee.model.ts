import dayjs from 'dayjs';
import { ITraining } from 'app/shared/model/training.model';
import { IToDo } from 'app/shared/model/to-do.model';
import { IHistoricData } from 'app/shared/model/historic-data.model';
import { IJob } from 'app/shared/model/job.model';

export interface IEmployee {
  id?: number;
  jobId?: number | null;
  user?: string;
  firstName?: string;
  lastName?: string;
  email?: string | null;
  phoneNumber?: string | null;
  hireDate?: string | null;
  emergencyContact?: string | null;
  emergencyPhone?: string | null;
  blodeType?: string | null;
  allergies?: string | null;
  birthDate?: string | null;
  note?: string | null;
  trainings?: ITraining[] | null;
  todos?: IToDo[] | null;
  historicData?: IHistoricData[] | null;
  managers?: IEmployee[] | null;
  job?: IJob | null;
  employee?: IEmployee | null;
}

export const defaultValue: Readonly<IEmployee> = {};
