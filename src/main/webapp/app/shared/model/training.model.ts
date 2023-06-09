import dayjs from 'dayjs';
import { IEvidence } from 'app/shared/model/evidence.model';
import { ICourse } from 'app/shared/model/course.model';
import { IEmployee } from 'app/shared/model/employee.model';

export interface ITraining {
  id?: number;
  courseId?: number | null;
  employeeId?: number | null;
  code?: string;
  date?: string | null;
  expiry?: string | null;
  evidences?: IEvidence[] | null;
  course?: ICourse | null;
  employee?: IEmployee | null;
}

export const defaultValue: Readonly<ITraining> = {};
