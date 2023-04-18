import { ITraining } from 'app/shared/model/training.model';
import { IRequirents } from 'app/shared/model/requirents.model';
import { IJob } from 'app/shared/model/job.model';
import { TypeCourse } from 'app/shared/model/enumerations/type-course.model';

export interface ICourse {
  id?: number;
  jobId?: number | null;
  code?: string;
  name?: string;
  expirationInMonth?: number | null;
  typeCourse?: TypeCourse | null;
  autorizationBy?: string | null;
  durationAuthorizationInMonth?: number | null;
  description?: string | null;
  link?: string | null;
  trainings?: ITraining[] | null;
  requirents?: IRequirents[] | null;
  reqCourses?: ICourse[] | null;
  job?: IJob | null;
  course?: ICourse | null;
}

export const defaultValue: Readonly<ICourse> = {};
