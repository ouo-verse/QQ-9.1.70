package wt1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.guild.message.base.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends ClickableSpan {
    private static String C = "GuildHighlightClickableSpan";
    private static List<n> D = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<AppRuntime> f446485d;

    /* renamed from: e, reason: collision with root package name */
    int f446486e;

    /* renamed from: f, reason: collision with root package name */
    private Context f446487f;

    /* renamed from: h, reason: collision with root package name */
    private GrayTipsMessageConstants$HighlightItem f446488h;

    /* renamed from: i, reason: collision with root package name */
    private Bundle f446489i;

    /* renamed from: m, reason: collision with root package name */
    private int f446490m = 2;

    static {
        try {
            ArrayList<Class<? extends n>> arrayList = vt1.a.f443343e;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Class<? extends n>> it = vt1.a.f443343e.iterator();
                while (it.hasNext()) {
                    D.add(it.next().newInstance());
                }
            }
        } catch (Exception e16) {
            QLog.e(C, 1, "[static] ", e16);
        }
    }

    public c(AppRuntime appRuntime, int i3, Context context, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem, Bundle bundle) {
        this.f446486e = -1;
        this.f446485d = new WeakReference<>(appRuntime);
        this.f446487f = context;
        this.f446486e = i3;
        this.f446488h = grayTipsMessageConstants$HighlightItem;
        this.f446489i = bundle;
    }

    private void a(View view) {
        String str;
        if (!TextUtils.isEmpty(this.f446488h.mMsgActionData) && !TextUtils.equals("null", this.f446488h.mMsgActionData)) {
            str = this.f446488h.mMsgActionData;
        } else {
            str = this.f446488h.mMsgAActionData;
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("mqqapi://channel")) {
            HashMap hashMap = new HashMap();
            hashMap.put("aio_graytext_type", Integer.valueOf(this.f446490m));
            VideoReport.reportEvent("dt_clck", view, hashMap);
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        WeakReference<AppRuntime> weakReference;
        if (this.f446488h != null && (weakReference = this.f446485d) != null && weakReference.get() != null) {
            for (n nVar : D) {
                if (nVar.a(this.f446485d.get(), this.f446487f, this.f446488h, this.f446489i)) {
                    a(view);
                    QLog.i(C, 1, "onClick. handled. handler: " + nVar.getClass());
                    return;
                }
            }
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i3 = this.f446486e;
        if (i3 == -1) {
            textPaint.setColor(textPaint.linkColor);
        } else {
            textPaint.setColor(i3);
        }
        textPaint.setUnderlineText(false);
    }
}
