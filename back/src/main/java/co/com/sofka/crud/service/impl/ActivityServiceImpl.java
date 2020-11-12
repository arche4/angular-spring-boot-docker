package co.com.sofka.crud.service.impl;

import co.com.sofka.crud.model.entity.Activity;
import co.com.sofka.crud.repository.ActivityRepository;
import co.com.sofka.crud.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity getActivity(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    @Override
    public Activity creaActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity upActivity(Activity activity) {
        Activity updateActivity = getActivity(activity.getId());
        if(getActivity(activity.getId())==null){
            return null;
        }else{
            updateActivity.setName(activity.getName());
            updateActivity.setCompleted(activity.isCompleted());
        }
        return activityRepository.save(updateActivity);
    }

    @Override
    public Activity delActivity(Long id) {
        Activity activity = getActivity(id);
        if(activity==null){
            return null;
        }else{
            activityRepository.delete(activity);
        }
        return activity;
    }
}
