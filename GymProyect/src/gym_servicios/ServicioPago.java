package gym_servicios;

import gym_entidades.*;
import java.util.*;

public class ServicioPago {
    private List<Pago> pagos = new ArrayList<>();
    private int contadorId = 1;

    public void registrarPago(Subscriptor s, double monto) {
        pagos.add(new Pago(contadorId++, s, monto));
    }

    public List<Pago> pagosPorSubscriptor(Subscriptor s) {
        List<Pago> resultado = new ArrayList<>();
        for (Pago p : pagos) {
            if (p.getSubscriptor().equals(s)) resultado.add(p);
        }
        return resultado;
    }

    public double totalPagadoPor(Subscriptor s) {
        return pagos.stream()
            .filter(p -> p.getSubscriptor().equals(s))
            .mapToDouble(Pago::getMonto)
            .sum();
    }
}

