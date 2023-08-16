package jaspertechShoppingCentre.serviceImpl;

import jaspertechShoppingCentre.dto.request.StateRequest;
import jaspertechShoppingCentre.dto.response.StateResponse;
import jaspertechShoppingCentre.entity.State;
import jaspertechShoppingCentre.exceptions.StateNotFoundException;
import jaspertechShoppingCentre.repositories.StateRepository;
import jaspertechShoppingCentre.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;
    @Override
    public StateResponse addNewState(StateRequest stateRequest) {
        State state = mapToState(stateRequest);
        var  addState = stateRepository.save(state);
        return mapToResponse(addState);
    }

    @Override
    public List<StateResponse> viewAllState() {
        List<State> states = stateRepository.findAll();
        return states.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public StateResponse viewState(Long stateId) {
        State state = stateRepository.findById(stateId)
                .orElseThrow(()-> new StateNotFoundException("State not found"));
        return mapToResponse(state);
    }

    @Override
    public StateResponse editState(StateRequest request, Long stateId) {
        State state = stateRepository.findById(stateId)
                .orElseThrow(()-> new StateNotFoundException("State not found"));
        state.setName(request.getStateName());
        stateRepository.save(state);
        return mapToResponse(state);
    }

    @Override
    public String deleteState(Long stateId) {
        State state = stateRepository.findById(stateId)
                .orElseThrow(()-> new StateNotFoundException("State not found"));
        stateRepository.delete(state);

        return "state deleted successfully ";
    }


    private StateResponse mapToResponse(State addState) {
        return  StateResponse.builder()
                .id(addState.getId())
                .stateName(addState.getName())
                .build();

    }

    private State mapToState(StateRequest stateRequest) {
        return  State.builder()
                .id(stateRequest.getStateId())
                .name(stateRequest.getStateName())
                .build();
    }
}