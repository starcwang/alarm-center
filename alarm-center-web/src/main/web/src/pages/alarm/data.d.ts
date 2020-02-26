export interface TableListItem {
  id: number;
  groups: string;
  code: string;
  name: string;
  description: string;
  expression: string;
  rule: string;
  status: number;
  gmtCreate: Date;
  gmtModified: Date;
  intervalSeconds: number;
}

export interface TableListPagination {
  total: number;
  pageSize: number;
  current: number;
  pageNum: number;
}

export interface TableListData {
  list: TableListItem[];
  pagination: Partial<TableListPagination>;
}

export interface TableListParams {
  sorter?: string;
  status?: string;
  name?: string;
  desc?: string;
  key?: number;
  pageSize?: number;
  currentPage?: number;
}
