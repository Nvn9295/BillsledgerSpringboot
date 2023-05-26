package com.example.billsledger.totalfunds.service;

import com.example.billsledger.constants.SourceConstants;
import com.example.billsledger.totalfunds.model.dto.TotalFundsDto;
import com.example.billsledger.totalfunds.model.entity.TotalFunds;
import com.example.billsledger.totalfunds.repository.TotalFundsRepository;
import com.example.billsledger.totalfunds.transformer.TotalFundsEntityToDtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class TotalFundsService {

    private final TotalFundsRepository totalFundsRepository;
    private final TotalFundsEntityToDtoConverter totalFundsEntityToDto;


    public TotalFundsDto saveTotalFund(TotalFunds totalFunds) {
        List<TotalFunds> totalFund = totalFundsRepository.findLastValue(PageRequest.of(0, 1));
        List<TotalFunds> lastSourceFunds = totalFundsRepository.findLastSource(totalFunds.getSource());
        TotalFunds totalFundsToSave = new TotalFunds();
        if (totalFunds.getSource() != null) {
            totalFundsToSave.setSource(totalFunds.getSource());
        }
        if (totalFunds.getExpenses() != null &&  totalFunds.getExpenses() <= totalFund.get(0).getBankBalance() && totalFunds.getSource().equals("HDFC")) {
            Double funds = totalFund.get(0).getBankBalance();
            Double expenses = totalFunds.getExpenses();
            totalFundsToSave.setExpenses(expenses);
            Double transferFunds = totalFund.get(0).getWalletBalance();
            totalFundsToSave.setWalletBalance(transferFunds);
            Double remainingFunds = funds - expenses + transferFunds;
            totalFundsToSave.setBankBalance(funds - expenses);
            totalFundsToSave.setTotalBalance(remainingFunds);
        } else if (totalFunds.getExpenses() != null && totalFunds.getExpenses() > totalFund.get(0).getBankBalance()) {
            totalFundsToSave.setTotalBalance(totalFund.get(0).getTotalBalance());
            totalFundsToSave.setBankBalance(totalFund.get(0).getBankBalance());
            totalFundsToSave.setWalletBalance(totalFund.get(0).getWalletBalance());
        }

        if (totalFunds.getExpenses() != null && totalFunds.getSource().equals(SourceConstants.SOURCE)) {
            Double transferFunds = totalFund.get(0).getWalletBalance();
            Double expenses = totalFunds.getExpenses();
            totalFundsToSave.setExpenses(expenses);
            Double funds = totalFund.get(0).getBankBalance();
            totalFundsToSave.setBankBalance(funds);
            Double remainingFunds = transferFunds - expenses + funds;
            totalFundsToSave.setWalletBalance(transferFunds - expenses);
            totalFundsToSave.setTotalBalance(remainingFunds);

        }
        if (totalFunds.getBankBalance() != null) {
            totalFundsToSave.setBankBalance(totalFund.get(0).getBankBalance() + totalFunds.getBankBalance());
            totalFundsToSave.setTotalBalance(totalFund.get(0).getTotalBalance() + totalFunds.getBankBalance());
            totalFundsToSave.setWalletBalance(totalFund.get(0).getWalletBalance());
        }
        if (totalFunds.getWalletBalance() != null) {
            Double totalTransferFunds = totalFunds.getWalletBalance() + totalFund.get(0).getWalletBalance();
            totalFundsToSave.setBankBalance(totalFund.get(0).getBankBalance() - totalFunds.getWalletBalance());
            totalFundsToSave.setWalletBalance(totalTransferFunds);
            totalFundsToSave.setTotalBalance(totalFundsToSave.getBankBalance() + totalFundsToSave.getWalletBalance());
        }
        TotalFunds totalFunds1 = totalFundsRepository.save(totalFundsToSave);
        return totalFundsEntityToDto.entityToDto(totalFunds1);
    }

    public TotalFundsDto getAvailableFunds() {
        List<TotalFunds> totalFunds = totalFundsRepository.findLastValue(PageRequest.of(0, 1));
        TotalFunds totalFunds1 = totalFunds.get(0);
        return totalFundsEntityToDto.entityToDto(totalFunds1);
    }

    public List<TotalFunds> getLastAvailableFunds() {
        List<TotalFunds> totalFunds = totalFundsRepository.findLastValue(PageRequest.of(0, 1));
        return totalFunds;
    }

    public List<TotalFunds> getLastSourceFunds(TotalFunds totalFunds) {
        List<TotalFunds> lastSourceFunds = totalFundsRepository.findLastSource(totalFunds.getSource());
        return lastSourceFunds;
    }

}

