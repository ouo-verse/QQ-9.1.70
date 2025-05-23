package uv2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.ArrayList;
import java.util.List;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    @NonNull
    public static ArrayList<Intent> a(@NonNull String str, @NonNull List<String> list, boolean z16) {
        ArrayList<Intent> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str) && !list.isEmpty()) {
            Uri parse = Uri.parse(str);
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
                    intent.addFlags(268435456);
                    intent.setPackage(str2);
                    arrayList.add(intent);
                }
            }
        }
        return arrayList;
    }

    public static boolean b(@Nullable Context context, @Nullable Intent intent) {
        boolean z16;
        if (!(context instanceof Activity)) {
            context = ev2.a.a();
        }
        boolean z17 = true;
        if (context != null && intent != null) {
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                n.e("QAdOpenMarketUtil", "\u6ca1\u6709\u8be5\u5305\u540d\u7684\u5e94\u7528" + context.getPackageManager());
                return false;
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                n.d("QAdOpenMarketUtil", e16, "\u6253\u5f00\u5931\u8d25");
                return false;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("context==null:");
        if (context == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", appstoreIntent==null");
        if (intent != null) {
            z17 = false;
        }
        sb5.append(z17);
        n.e("QAdOpenMarketUtil", sb5.toString());
        return false;
    }
}
