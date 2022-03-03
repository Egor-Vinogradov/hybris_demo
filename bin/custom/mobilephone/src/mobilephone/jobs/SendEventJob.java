package mobilephone.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import mobilephone.model.EventCreatOrderModel;
import mobilephone.service.EventCreatOrderService;

import java.util.Date;
import java.util.List;

public class SendEventJob extends AbstractJobPerformable<CronJobModel> {

    private EventCreatOrderService eventCreatOrderService;

    public void setEventCreatOrderService(EventCreatOrderService eventCreatOrderService) {
        this.eventCreatOrderService = eventCreatOrderService;
    }

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
        List<EventCreatOrderModel> listEvent = this.eventCreatOrderService.findEventByData(new Date());

        if (listEvent.isEmpty()) {
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        }

        // Building e-mail


        try {

            // Sending e-mail

            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        } catch (Exception e) {
            return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
        }
    }
}
