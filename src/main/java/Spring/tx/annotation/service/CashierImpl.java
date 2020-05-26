package Spring.tx.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Override
    @Transactional
    public void checkOut(String username, List<String> isbns) {
        for(String isbn : isbns){
            bookShopService.buyBook(username,isbn);
        }
    }
}
