import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // CREATE
    @PostMapping
    public Restaurant criar(@RequestBody Restaurant restaurant) {
        return restaurantService.criar(restaurant);
    }

    // READ ALL
    @GetMapping
    public List<Restaurant> listarTodos() {
        return restaurantService.listarTodos();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Restaurant buscarPorId(@PathVariable Long id) {
        return restaurantService.buscarPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Restaurant atualizar(@PathVariable Long id, @RequestBody Restaurant novosDados) {
        return restaurantService.atualizar(id, novosDados);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        restaurantService.deletar(id);
    }
}
