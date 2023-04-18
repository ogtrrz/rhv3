import { ICourse } from 'app/shared/model/course.model';
import { Kind } from 'app/shared/model/enumerations/kind.model';

export interface IRequirents {
  id?: number;
  courseId?: number | null;
  code?: string;
  expirationInMonth?: number | null;
  kind?: Kind | null;
  description?: string | null;
  course?: ICourse | null;
}

export const defaultValue: Readonly<IRequirents> = {};
