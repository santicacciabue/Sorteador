import com.sorteador.sorteador.repositories.IntegranteRepository;

@Service
public class IntegranteServiceImpl implements IntegranteService {
    private final IntegranteRepository integranteRepository;

    public IntegranteServiceImpl(IntegranteRepository integranteRepository) {
        this.integranteRepository = integranteRepository;
    }

}
