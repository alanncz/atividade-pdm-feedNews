package ifpb.ads.pdm.atividadecolaborativa.servicos;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Calendar;

import ifpb.ads.pdm.atividadecolaborativa.rotinas.RequestRSS;

public class ServiceRequest extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Serviço", "Serviço iniciado !!");
        task();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Serviço", "Serviço finalizado !!");
    }

    public void task(){
        Thread th = new Thread(new RequestRSS(this));
        th.start();
    }

    public void agendaAbertura(){

        Calendar calender = Calendar.getInstance();
        calender.setTimeInMillis(System.currentTimeMillis());
        calender.add(Calendar.SECOND, 5);

        Intent intent = new Intent(ServiceRequest.this, ReiceverInitService.class);
        PendingIntent pi = PendingIntent.getBroadcast(ServiceRequest.this, 1010, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager reabrir = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        reabrir.set(AlarmManager.RTC_WAKEUP,getTimeMillis(),pi);
        Log.d("Serviço", "Serviço agendado para");
    }

    private Long  getTimeMillis(){
        Calendar calender = Calendar.getInstance();
        calender.setTimeInMillis(System.currentTimeMillis());
        calender.add(Calendar.SECOND, 10);
        return calender.getTimeInMillis();
    }

}
