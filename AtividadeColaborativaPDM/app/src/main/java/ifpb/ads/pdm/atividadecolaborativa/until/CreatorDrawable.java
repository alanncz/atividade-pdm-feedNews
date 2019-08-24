package ifpb.ads.pdm.atividadecolaborativa.until;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class CreatorDrawable {

    public static  Drawable getImg(URL url) {
        InputStream is = null;
        try {
            System.out.println(url.toString());
            is = url.openConnection().getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap x = BitmapFactory.decodeStream(is);
        return new BitmapDrawable(Resources.getSystem(), x);

    }

}
