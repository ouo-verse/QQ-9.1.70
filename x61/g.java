package x61;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.net.URL;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends com.tencent.mobileqq.activity.aio.stickerrecommended.b {

    /* renamed from: b, reason: collision with root package name */
    d f447295b;

    /* renamed from: c, reason: collision with root package name */
    p f447296c;

    /* renamed from: d, reason: collision with root package name */
    String f447297d;

    /* renamed from: e, reason: collision with root package name */
    int f447298e;

    public g(d dVar, p pVar, String str) {
        this.f447295b = dVar;
        this.f447296c = pVar;
        this.f447297d = str;
    }

    @NotNull
    public Intent a(p pVar, String str) {
        Intent intent = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra("PicContants.NEED_COMPRESS", false);
        intent.putExtra("uin", pVar.f179557e);
        intent.putExtra("uintype", pVar.f179555d);
        intent.putExtra("troop_uin", pVar.f179559f);
        intent.putExtra(ConfessInfo.KEY_CONFESS_TOPICID, pVar.S);
        intent.putExtra(PeakConstants.SEND_SIZE_SPEC, 0);
        intent.putExtra(PeakConstants.SEND_IN_BACKGROUND, true);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList);
        intent.putExtra("PicContants.NEED_COMPRESS", false);
        intent.putExtra(IPicBus.ORIGINAL_MD5, this.f447295b.f447287b);
        intent.putExtra(IPicBus.ORIGINAL_SIZE, this.f447295b.f447288c);
        intent.putExtra(IPicBus.THUMB_MD5, this.f447295b.f447287b);
        intent.putExtra(IPicBus.IS_AD_EMO, true);
        intent.putExtra(IPicBus.AD_EMO_JUMP_URL, this.f447295b.f447291f);
        intent.putExtra(IPicBus.AD_EMO_DESC_STR, this.f447295b.f447292g);
        intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1047);
        intent.putExtra(HotPicData.HOT_PIC_HAS_EXTRA, true);
        return intent;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getBusinessType() {
        return 5;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getClickNum() {
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getExposeNum() {
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgMd5() {
        d dVar = this.f447295b;
        if (dVar != null) {
            return dVar.f447287b;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getImgUrl() {
        d dVar = this.f447295b;
        if (dVar != null) {
            return dVar.f447286a;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public URL getProtocolURL() {
        URL url;
        d dVar;
        try {
            dVar = this.f447295b;
        } catch (Exception e16) {
            QLog.e("StickerRecAdData", 1, "getProtocolURL error ", e16);
        }
        if (dVar != null && !TextUtils.isEmpty(dVar.f447287b)) {
            url = new URL("sticker_recommended_pic", EmotionConstants.FROM_AIO, this.f447295b.f447287b);
            if (url != null) {
                QLog.e("StickerRecAdData", 1, "getURL url = null");
                return null;
            }
            return url;
        }
        url = null;
        if (url != null) {
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getReportEventPrefix() {
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getThumbUrl() {
        d dVar = this.f447295b;
        if (dVar != null) {
            return dVar.f447286a;
        }
        return null;
    }

    public String getURL() {
        d dVar = this.f447295b;
        if (dVar != null) {
            return dVar.f447286a;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (url == null) {
            return null;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, uRLDrawableOptions);
        drawable.setTag(new int[]{0, 0, (int) uRLDrawableOptions.mGifRoundCorner});
        return drawable;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = this;
        return obtain;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecAdData", 2, "onEmoticonWillShow, index = " + i3);
        }
        this.f447298e = i3;
        new e().f(baseQQAppInterface, this.f447296c, getImgUrl(), i3, this.f447295b.f447287b, this.f447297d);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.b, com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void sendEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, p pVar) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecAdData", 2, "sendEmoticon");
        }
        if (this.f447295b == null) {
            return;
        }
        new e().e(baseQQAppInterface, pVar, getImgUrl(), this.f447298e, this.f447295b.f447287b, this.f447297d);
        ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmoPic(context, a(pVar, com.tencent.mobileqq.activity.aio.stickerrecommended.h.a(getURL())));
        MqqHandler handler = baseQQAppInterface.getHandler(getClass());
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(94));
        }
    }
}
