package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.WalletRequest;
import jaspertechShoppingCentre.dto.response.WalletBalanceResponse;
import jaspertechShoppingCentre.dto.response.WalletInfoResponse;
import jaspertechShoppingCentre.dto.response.WalletResponse;
import org.springframework.data.domain.Page;

public interface WalletService {
    WalletResponse fundCustomerWallet(WalletRequest walletRequest);

    WalletBalanceResponse getCustomerBalance();

    WalletInfoResponse viewCustomerWallet();

    Page<WalletResponse> viewCustomerWalletByPagination(Integer pageNo, Integer pageSize, String sortBy);
}
