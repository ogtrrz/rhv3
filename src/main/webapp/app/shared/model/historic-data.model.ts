import { IEmployee } from 'app/shared/model/employee.model';

export interface IHistoricData {
  id?: number;
  employeeId?: number | null;
  name?: string;
  link?: string | null;
  employees?: IEmployee[] | null;
}

export const defaultValue: Readonly<IHistoricData> = {};
