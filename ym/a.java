package ym;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.reborn.base.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tl.h;
import zm.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends k {

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<HashMap<String, Object>> f450647d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<HashMap<String, Object>> f450648e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private Boolean f450649f = null;

    public String C9() {
        return c.f452770a.f(this.f450648e);
    }

    public String D9() {
        Boolean bool = this.f450649f;
        if (bool != null) {
            if (bool.booleanValue()) {
                return "0";
            }
            return "1";
        }
        return "";
    }

    public String E9() {
        return c.f452770a.f(this.f450647d);
    }

    public void F9(Intent intent) {
        c cVar = c.f452770a;
        cVar.g(intent, this.f450647d, false);
        cVar.g(intent, this.f450648e, true);
        G9(intent);
    }

    public void H9(List<String> list) {
        if (this.f450647d.isEmpty()) {
            return;
        }
        ((IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class)).updateMagicStudioPublishHistory(list);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if (TextUtils.equals(str, "get_publisher_game_play_record")) {
            h hVar = (h) getViewModel(h.class);
            if (hVar != null && hVar.P1().getValue() != null) {
                H9(hVar.P1().getValue());
            }
            return E9();
        }
        if (TextUtils.equals(str, "get_publisher_editor_game_play_record")) {
            return C9();
        }
        if (TextUtils.equals(str, "get_is_share_original_picture")) {
            return D9();
        }
        return super.getMessage(str, obj);
    }

    private void G9(Intent intent) {
        if (intent == null || !intent.hasExtra(QQWinkConstants.QZONE_MAGIC_STUDIO_SHARE_ORIGIN_IMAGE)) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(QQWinkConstants.QZONE_MAGIC_STUDIO_SHARE_ORIGIN_IMAGE, false);
        if (this.f450649f == null) {
            this.f450649f = Boolean.valueOf(booleanExtra);
        } else if (booleanExtra) {
            this.f450649f = Boolean.TRUE;
        }
    }
}
