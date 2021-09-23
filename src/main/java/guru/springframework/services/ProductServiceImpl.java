package guru.springframework.services;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.services.jms.JmsTextMessageService;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jt on 1/26/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private JmsTextMessageService jmsTextMessageService;

    public ProductServiceImpl(ProductRepository productRepository, JmsTextMessageService jmsTextMessageService) {
        this.productRepository = productRepository;
        this.jmsTextMessageService = jmsTextMessageService;
    }

    @Override
    public Product getProduct(Integer id) {
        jmsTextMessageService.sendTextMessage("Fetching Product ID: " + id );
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> listProducts() {
        jmsTextMessageService.sendTextMessage("Listing Products");
        return IteratorUtils.toList(productRepository.findAll().iterator());
    }

}
