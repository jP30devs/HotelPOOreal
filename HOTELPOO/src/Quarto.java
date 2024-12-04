public class Quarto extends Hospedagem implements Reservavel {

    private boolean reservado;

    public Quarto(int numero, int capacidade) {
        super(numero, capacidade);
        this.reservado = false;
    }

    @Override
    public void reservar(String idHospede) throws CapacidadeExcedidaException {
        if (reservado) {
            throw new CapacidadeExcedidaException("Quarto já está reservado!");
        }
        reservado = true;
        System.out.println("Quarto reservado para o hóspede " + idHospede);
    }

    @Override
    public String toString() {
        return super.toString() + ", reservado=" + reservado;
    }
}