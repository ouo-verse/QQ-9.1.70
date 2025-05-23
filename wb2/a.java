package wb2;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.now.netchannel.websso.e;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    public static FaceDrawable a(BaseActivity baseActivity) {
        String g16 = e.g();
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        return FaceDrawable.getFaceDrawable(baseActivity.app, 1, g16, 3, defaultDrawable, defaultDrawable, null);
    }

    public static String b() {
        return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + e.g());
    }
}
