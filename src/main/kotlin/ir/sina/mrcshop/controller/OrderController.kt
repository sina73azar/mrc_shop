package ir.sina.mrcshop.controller

import ir.sina.mrcshop.entity.Order
import ir.sina.mrcshop.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping
    fun createOrder(@RequestBody order: Order): ResponseEntity<Order> {
        return ResponseEntity(orderService.createOrder(order), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: String): ResponseEntity<Order> {
        return ResponseEntity.ok(orderService.getOrderById(id))
    }

    @GetMapping
    fun getAllOrders(): ResponseEntity<List<Order>> {
        return ResponseEntity.ok(orderService.getAllOrders())
    }

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: String, @RequestBody order: Order): ResponseEntity<Order> {
        return ResponseEntity.ok(orderService.updateOrder(id, order))
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: String): ResponseEntity<Void> {
        orderService.deleteOrder(id)
        return ResponseEntity.noContent().build()
    }
}
