package ifpb.ads.pdm.atividadecolaborativa.servicos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReiceverInitService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, ServiceRequest.class));
    }
}
