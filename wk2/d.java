package wk2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends a {

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f445771b;

    /* renamed from: c, reason: collision with root package name */
    public String f445772c;

    public d(String str) {
        super(str);
    }

    @Override // wk2.c
    public void a(RedPacketInfo redPacketInfo) {
        if (redPacketInfo != null) {
            this.f445771b = redPacketInfo.icon;
            this.f445772c = redPacketInfo.resPath;
        }
    }

    @Override // wk2.c
    public boolean isValid() {
        if (this.f445771b != null && !TextUtils.isEmpty(this.f445772c)) {
            return true;
        }
        return false;
    }
}
