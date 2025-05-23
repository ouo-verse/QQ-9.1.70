package th4;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfoConstant;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$TimiPkgEmoticonData;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a>\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/image/URLImageView;", "", "fromWhere", "Ltrpc/yes/common/MessageOuterClass$TimiPkgEmoticonData;", "emoData", "Lcom/tencent/image/URLDrawable;", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Lcom/tencent/mobileqq/data/Emoticon;", "emoticon", "Ljava/net/URL;", "url", "Lcom/tencent/mobileqq/data/EmoticonPackage;", "ep", "", "useApng", "", "c", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class s {
    @Nullable
    public static final URLDrawable b(@NotNull URLImageView uRLImageView, @NotNull String fromWhere, @NotNull MessageOuterClass$TimiPkgEmoticonData emoData) {
        URL url;
        BaseQQAppInterface baseQQAppInterface;
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(fromWhere, "fromWhere");
        Intrinsics.checkNotNullParameter(emoData, "emoData");
        Emoticon d16 = xg4.l.d(emoData);
        EmoticonPackage emoticonPackage = null;
        try {
            url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, fromWhere, PicEmoticonInfoConstant.getFictionPath(d16));
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("URLImageViewEx", 2, "getDrawable ,", e16);
            }
            url = null;
        }
        if (url == null) {
            return null;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) waitAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        Drawable drawable = uRLImageView.getContext().getResources().getDrawable(R.drawable.o77);
        Drawable drawable2 = uRLImageView.getContext().getResources().getDrawable(R.drawable.o77);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable2;
        obtain.mPlayGifImage = true;
        boolean z16 = false;
        if (baseQQAppInterface != null) {
            IRuntimeService runtimeService = baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IE\u2026nagerService::class.java)");
            emoticonPackage = ((IEmoticonManagerService) runtimeService).syncFindEmoticonPackageInCache(d16.epId, 0);
        }
        EmoticonPackage emoticonPackage2 = emoticonPackage;
        if ((emoticonPackage2 != null && emoticonPackage2.isAPNG == 2) || d16.isAPNG) {
            if (QLog.isColorLevel()) {
                QLog.d("URLImageViewEx", 2, "getBigDrawable: APNG so loaded use apng image");
            }
            obtain.mUseApngImage = true;
            obtain.mPlayGifImage = false;
            obtain.mMemoryCacheKeySuffix = "useAPNG";
            z16 = true;
        }
        obtain.mRequestWidth = d16.extensionWidth;
        obtain.mRequestHeight = d16.extensionHeight;
        URLDrawable drawable3 = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable3, "getDrawable(specialUrl, options)");
        String B = ((ll4.a) mm4.b.b(ll4.a.class)).B();
        if (drawable3.getStatus() != 1) {
            drawable3.setTag(d16);
            drawable3.addHeader("my_uin", B);
            drawable3.addHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_TYPE, String.valueOf(emoData.imageType.get()));
            if (drawable3.getStatus() == 2 || drawable3.getStatus() == 3) {
                drawable3.restartDownload();
            }
        } else {
            c(baseQQAppInterface, d16, url, emoticonPackage2, z16, drawable3);
        }
        uRLImageView.setImageDrawable(drawable3);
        return drawable3;
    }

    private static final void c(BaseQQAppInterface baseQQAppInterface, Emoticon emoticon, URL url, EmoticonPackage emoticonPackage, boolean z16, URLDrawable uRLDrawable) {
        if (baseQQAppInterface != null) {
            IRuntimeService runtimeService = baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ice::class.java\n        )");
            IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) runtimeService;
            if (emoticonPackage == null && !z16 && emoticon != null && !(uRLDrawable.getCurrDrawable() instanceof ApngDrawable)) {
                final String url2 = url.toString();
                Intrinsics.checkNotNullExpressionValue(url2, "url.toString()");
                iEmoticonManagerService.asyncFindEmoticonPackage(emoticon.epId, new QueryCallback() { // from class: th4.r
                    @Override // com.tencent.mobileqq.emoticonview.QueryCallback
                    public final void postQuery(Object obj) {
                        s.d(url2, (EmoticonPackage) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String key, EmoticonPackage emoticonPackage) {
        Intrinsics.checkNotNullParameter(key, "$key");
        if (emoticonPackage != null && emoticonPackage.isAPNG == 2) {
            URLDrawable.removeMemoryCacheByUrl(key);
        }
    }
}
