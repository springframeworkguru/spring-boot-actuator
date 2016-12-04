package guru.springframework.services;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.services.jms.JmsTextMessageService;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jt on 1/26/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private JmsTextMessageService jmsTextMessageService;
    private CounterService counterService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, JmsTextMessageService jmsTextMessageService,
                              CounterService counterService) {
        this.productRepository = productRepository;
        this.jmsTextMessageService = jmsTextMessageService;
        this.counterService = counterService;
    }

    @Override
    public Product getProduct(Integer id) {
        jmsTextMessageService.sendTextMessage("Fetching Product ID: " + id );
        counterService.increment("guru.springframework.services.getproduct");
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> listProducts() {
        jmsTextMessageService.sendTextMessage("Listing Products");
        return IteratorUtils.toList(productRepository.findAll().iterator());
    }

}
