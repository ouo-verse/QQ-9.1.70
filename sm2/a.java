package sm2;

import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.mobileqq.richmedia.CommonPreviewLayerFragment;
import com.tencent.mobileqq.richmedia.depend.c;
import com.tencent.mobileqq.richmedia.e;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u0012"}, d2 = {"Lsm2/a;", "", "", "videoPath", "thumbPath", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "b", "imagePath", "a", "Landroid/widget/ImageView;", "imageView", "", "c", "mCurrentSelectedItem", "", "d", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f433978a = new a();

    a() {
    }

    @NotNull
    public final RFWLayerItemMediaInfo a(@NotNull String imagePath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setLocalPath(imagePath);
        rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
        rFWLayerPicInfo.setBigPicInfo(rFWLayerPicInfo.getSmallPicInfo());
        RFWLayerPicInfo.RFWPicInfo smallPicInfo = rFWLayerPicInfo.getSmallPicInfo();
        Intrinsics.checkNotNull(smallPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
        rFWLayerPicInfo.setCurrentPicInfo(smallPicInfo);
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        rFWLayerItemMediaInfo.setMediaId(imagePath);
        return rFWLayerItemMediaInfo;
    }

    @NotNull
    public final RFWLayerItemMediaInfo b(@NotNull String videoPath, @Nullable String thumbPath) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        rFWLayerVideoInfo.setFileId(videoPath);
        rFWLayerVideoInfo.setLocalPath(videoPath);
        rFWLayerVideoInfo.setCurrentVideoUrl(videoPath);
        rFWLayerItemMediaInfo.setMediaId(videoPath);
        if (thumbPath != null) {
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setLocalPath(thumbPath);
            rFWPicInfo.setUrl(rFWPicInfo.getLocalPath());
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        }
        rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
        return rFWLayerItemMediaInfo;
    }

    public final void c(@NotNull String imagePath, @Nullable ImageView imageView) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(imagePath));
        e eVar = e.f281568a;
        eVar.j(arrayList);
        eVar.i(0);
        RFWLayerLaunchUtil.jumpToGallery$default(imageView, arrayList, 0, QQGalleryActivity.class, CommonPreviewLayerFragment.class, new Bundle(), 0, 64, null);
    }

    public final boolean d(@Nullable RFWLayerItemMediaInfo mCurrentSelectedItem) {
        com.tencent.mobileqq.richmedia.depend.e eVar;
        e eVar2 = e.f281568a;
        String name = com.tencent.mobileqq.richmedia.depend.e.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IRichMediaShareDepend::class.java.name");
        c d16 = eVar2.d(name);
        if (d16 instanceof com.tencent.mobileqq.richmedia.depend.e) {
            eVar = (com.tencent.mobileqq.richmedia.depend.e) d16;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            return eVar.C6(mCurrentSelectedItem);
        }
        return true;
    }
}
