package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.StateRequest;
import jaspertechShoppingCentre.dto.response.StateResponse;

import java.util.List;

public interface StateService {
    StateResponse addNewState(StateRequest stateRequest);

    List<StateResponse> viewAllState();

    StateResponse viewState(Long stateId);

    StateResponse editState(StateRequest request, Long stateId);

    String deleteState(Long stateId);
}
