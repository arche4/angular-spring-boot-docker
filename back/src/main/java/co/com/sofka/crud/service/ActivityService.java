package co.com.sofka.crud.service;

import co.com.sofka.crud.model.entity.Activity;

public interface ActivityService {

    public Activity getActivity(Long id);
    public Activity creaActivity(Activity activityresquest);
    public Activity upActivity(Activity activityresquest);
    public Activity delActivity(Long id);
}
