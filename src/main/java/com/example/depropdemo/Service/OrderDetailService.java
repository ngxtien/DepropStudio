package com.example.depropdemo.Service;

import com.example.depropdemo.Dao.CustomerOrderRepository;
import com.example.depropdemo.Dao.CustomerRepository;
import com.example.depropdemo.Dao.OrderDetailRepository;
import com.example.depropdemo.Dao.ProductsRepository;
import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.CustomerOrder;
import com.example.depropdemo.Model.DTO.CustomerDTO;
import com.example.depropdemo.Model.DTO.OrderDetailDTO;
import com.example.depropdemo.Model.DTO.OrderRequestDTO;
import com.example.depropdemo.Model.OrderDetail;
import com.example.depropdemo.Model.Products;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final ProductsRepository productsRepository;
    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository,
                              ProductsRepository productsRepository,
                              CustomerOrderRepository customerOrderRepository,
                              CustomerRepository customerRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.productsRepository = productsRepository;
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
    }

    public void processOrder(OrderRequestDTO orderRequestDTO) {
        // Lấy thông tin khách hàng từ DTO
        CustomerDTO customerDTO = orderRequestDTO.getCustomerData();

        // Tạo đối tượng Customer từ thông tin trong DTO
        Customer customer = new Customer();
        customer.setFirstname(customerDTO.getFirstname());
        customer.setLastname(customerDTO.getLastname());
        customer.setPhonenumber(customerDTO.getPhonenumber());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setCompany(customerDTO.getCompany());
        customer.setNote(customerDTO.getNote());
        customer.setVat(customerDTO.getVat());

        // Lưu thông tin khách hàng vào cơ sở dữ liệu
        customerRepository.save(customer);

        // Tạo một đơn hàng mới cho khách hàng
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder = customerOrderRepository.save(customerOrder);
        customerOrder.setCustomer(customer); // Gán khách hàng cho đơn hàng
        customerOrder.setOrderDate(new Date()); // Ngày đặt hàng
        customerOrder.setStatus("Pending"); // Trạng thái đơn hàng
        customerOrder.setTotalprice(customerDTO.getTotalprice());


        // Lưu đơn hàng vào cơ sở dữ liệu
        customerOrder = customerOrderRepository.save(customerOrder);

        double totalPrice = 0;

        // Xử lý từng sản phẩm trong giỏ hàng
        for (OrderDetailDTO dto : orderRequestDTO.getCartData()) {
            OrderDetail orderDetail = new OrderDetail();

            // Lấy thông tin sản phẩm từ ID
            Products product = productsRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy sản phẩm với ID: " + dto.getProductId()));

            // Thiết lập các thuộc tính của chi tiết đơn hàng
            orderDetail.setOrder(customerOrder);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(dto.getQuantity());
            orderDetail.setPrice(dto.getPrice());
            orderDetail.setStartDate(orderRequestDTO.getStartDate());
            orderDetail.setEndDate(orderRequestDTO.getEndDate());

//            totalPrice += dto.getPrice() * dto.getQuantity();


            // Lưu chi tiết đơn hàng vào cơ sở dữ liệu
            orderDetailRepository.save(orderDetail);
        }
    }
}

