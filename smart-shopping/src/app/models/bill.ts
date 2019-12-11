import { TotalBillDetails } from './bill_details';

export interface Bill {
    userId: number;
    totalAmount: number;
    originalAmount: number;
    finalRewardPoints: number;
    productList : TotalBillDetails[];
    rewardPoints: number;
    purchaseDate: Date;
}